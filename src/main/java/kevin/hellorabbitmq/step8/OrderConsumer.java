//package kevin.hellorabbitmq.step8;
//
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.retry.support.RetryTemplate;
//import org.springframework.stereotype.Component;
//
//@Component
//public class OrderConsumer {
//
//    private final RabbitTemplate rabbitTemplate;
//    private final RetryTemplate retryTemplate;
//
//    public OrderConsumer(RabbitTemplate rabbitTemplate, RetryTemplate retryTemplate) {
//        this.rabbitTemplate = rabbitTemplate;
//        this.retryTemplate = retryTemplate;
//    }
//
//    @RabbitListener(queues = RabbitMQConfig.ORDER_COMPLETED_QUEUE)
//    public void consume(String message) {
//        // RetryConfig 에서 빈으로 등록한 retryTemplate 을 사용.
//        retryTemplate.execute(context -> {
//            try {
//                System.out.println("[Order Consumer] 리시브 메시지 : " + message + " # retry : " + context.getRetryCount());
//                // 실패 조건 (message 에 fail 포함될 경우)
//                if ("fail".equalsIgnoreCase(message)) {
//                    // exception발생 -> catch로 이동
//                    throw new RuntimeException(message);
//                }
//                System.out.println("[Order Consumer] 메시지 처리 성공 " + message);
//            } catch (Exception e) {
//                if (context.getRetryCount() >= 2) {
//                    // 재시도 3회 이상일 시 DLQ로 메세지가 가게됨.
//                    System.out.println("[Order Consumer] DLQ로 메세지 보냄 " + message);
//                    rabbitTemplate.convertAndSend(RabbitMQConfig.ORDER_TOPIC_DLX, RabbitMQConfig.DEAD_LETTER_ROUTING_KEY, message);
//                } else {
//                    // retryTemplate 내부에서 재시도 3회 미만일 때  예외를 던지면 (throw e)
//                    // retryTemplate이 catch하여 내부적으로 다시 재시도한다.
//                    // Spring AMQP나 RabbitMQ에 nack을 보내는건 아님. 내부적으로만 처리. (3회 재시도 후 DLQ로 메세지 이동)
//                    System.out.println("[Order Consumer] throw e.");
//                    throw e;
//                }
//            }
//            return null;
//        });
//    }
//}
