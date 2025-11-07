//package kevin.hellorabbitmq.step9;
//
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.time.LocalDateTime;
//
//@Component
//public class MessageProducer {
//    private final StockRepository stockRepository;
//    private final RabbitTemplate rabbitTemplate;
//
//    public MessageProducer(StockRepository stockRepository, RabbitTemplate rabbitTemplate) {
//        this.stockRepository = stockRepository;
//        this.rabbitTemplate = rabbitTemplate;
//    }
//
//    @Transactional
//    public void sendMessage(StockEntity stockEntity, String testCase) {
//        rabbitTemplate.execute(channel -> {
//            try {
//                channel.txSelect(); // rabbitmq 트랜잭션 시작
//                stockEntity.setProcessed(false);
//                stockEntity.setCreatedAt(LocalDateTime.now());
//                StockEntity stockEntitySaved = stockRepository.save(stockEntity);
//
//                System.out.println("[MessageProducer] Stock Saved : " + stockEntitySaved);
//
//                // 메시지 발행 -> 트랜잭션을 열어놓았기 때문에 즉시 전송 되지 않고 대기상태가 됨.
//                rabbitTemplate.convertAndSend("transactionQueue", stockEntitySaved);
//
//                if ("fail".equalsIgnoreCase(testCase)) {
//                    throw new RuntimeException("트랜잭션 작업중에 에러 발생");
//                }
//
//                channel.txCommit(); // rabbitmq 트랜잭션 commit; -> 이때 transactionQueue 로 메세지 발행 됨.
//                System.out.println("[MessageProducer] 트랜잭션이 정상적으로 처리 되었음!~");
//            } catch (Exception e) {
//                System.out.println("[MessageProducer] 트랜잭션 실패 : " + e.getMessage());
//                channel.txRollback(); // rabbitmq 트랜잭션 rollback; -> transactionQueue 로 발행대기중인 메세지 처리되지 않음.
//                throw new RuntimeException("트랜잭션 롤백 완료 ", e);
//                // 예외 발생하였으므로, stock DB 저장도 롤백된다.
//            } finally {
//                if (channel != null) {
//                    try {
//                        channel.close();
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//            return null;
//        });
//    }
//}
