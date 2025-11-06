//package kevin.hellorabbitmq.step2;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.stereotype.Component;
//
//@Component
//@RequiredArgsConstructor
//public class WorkQueueProducer {
//    private final RabbitTemplate rabbitTemplate;
//
//    public void sendWorkQueue(String workQueueMessage, int duration) {
//        // "workQueueMessage|duration" 형태로 메세지 발송
//        String message = workQueueMessage + "|" + duration;
//        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_NAME, message);
//        System.out.println("WorkQueueProducer - Sent workqueue " + message);
//    }
//}
