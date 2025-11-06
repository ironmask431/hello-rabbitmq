//package kevin.hellorabbitmq.step4;
//
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
//import org.springframework.stereotype.Component;
//
//@Component
//public class NewsSubscriber {
//    private final SimpMessagingTemplate messagingTemplate;
//
//    public NewsSubscriber(SimpMessagingTemplate messagingTemplate) {
//        this.messagingTemplate = messagingTemplate;
//    }
//
//    // 각 큐에서 메세제를 수신 받은 다음 웹소켓으로 메세지 발송
//    @RabbitListener(queues = RabbitMQConfig.JAVA_QUEUE)
//    public void javaNews(String message) {
//        System.out.println("NewsSubscriber - javaNews : " + message);
//        messagingTemplate.convertAndSend("/topic/java", message); // 뉴스 브로드캐스트
//    }
//
//    @RabbitListener(queues = RabbitMQConfig.SPRING_QUEUE)
//    public void springNews(String message) {
//        System.out.println("NewsSubscriber - springNews : " + message);
//        messagingTemplate.convertAndSend("/topic/spring", message); // 기술 뉴스 브로드캐스트
//    }
//
//    @RabbitListener(queues = RabbitMQConfig.VUE_QUEUE)
//    public void vueNews(String message) {
//        System.out.println("NewsSubscriber - vueNews : " + message);
//        messagingTemplate.convertAndSend("/topic/vue", message); // 일반 뉴스 브로드캐스트
//    }
//}
