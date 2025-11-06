//package kevin.hellorabbitmq.step3;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
//import org.springframework.stereotype.Component;
//
//// 큐에서 받은 메세지를 웹소켓으로 전송하는 역할
//@Component
//@RequiredArgsConstructor
//public class NotificationSubscriber {
//    // 웹소켓 경로
//    public static final String CLIENT_URL = "/topic/notifications";
//
//    //Spring WebSocket(STOMP 프로토콜 기반) 환경에서 서버 → 클라이언트로 메시지를 보내기 위한 클래스
//    private final SimpMessagingTemplate simpMessagingTemplate;
//
//    // QUEUE_NAME 큐의 메세지를 수신
//    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
//    public void subscriber(String message) {
//        // RabbitMQ Queue에서 메시지 수신
//
//        // @RabbitListener 를 지정하지 않으면 아래와 같은 방법으로 수신.
//        // String message = (String) rabbitTemplate.receiveAndConvert(RabbitMQConfig.QUEUE_NAME);
//
//        System.out.println("[#] NotificationSubscriber receive : " + message);
//        // convertAndSend 를 통해 웹소켓 특정 경로로 메시지를 전달함
//        simpMessagingTemplate.convertAndSend(CLIENT_URL, message); // 클라이언트에 브로드캐스트
//    }
//}
