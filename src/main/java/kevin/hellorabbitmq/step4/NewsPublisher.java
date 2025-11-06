//package kevin.hellorabbitmq.step4;
//
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.stereotype.Component;
//
//@Component
//public class NewsPublisher {
//    private final RabbitTemplate rabbitTemplate;
//
//    public NewsPublisher(RabbitTemplate rabbitTemplate) {
//        this.rabbitTemplate = rabbitTemplate;
//    }
//
//    // news : 어떤 큐로 보낼지
//    // messageSuffix : 전달 메세지
//    private String publishMessage(String news, String messageSuffix) {
//        String message = news + messageSuffix;
//        // news 별로 라우팅키를 걸어서 어떤 큐로 전송할지 정한다.
//        rabbitTemplate.convertAndSend(RabbitMQConfig.FANOUT_EXCHANGE_FOR_NEWS, news, message);
//        System.out.println("NewsPublisher : " + message);
//        return message;
//    }
//
//    public String publish(String news) {
//        return publishMessage(news, " 관련 새 소식이 있어요!");
//    }
//
//    public String publishAPI(String news) {
//        return publishMessage(news, " - 관련 새 소식이 나왔습니다. (API)");
//    }
//}
