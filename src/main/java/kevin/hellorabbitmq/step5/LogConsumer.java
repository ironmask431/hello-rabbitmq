//package kevin.hellorabbitmq.step5;
//
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//
//@Component
//public class LogConsumer {
//
//    // 각 큐의 메세지를 수신
//    @RabbitListener(queues = RabbitMQConfig.ERROR_QUEUE)
//    public void consumeError(String message) {
//        System.out.println("LogConsumer [ERROR]를 받음 : " + message);
//    }
//
//    @RabbitListener(queues = RabbitMQConfig.WARN_QUEUE)
//    public void consumeWarn(String message) {
//        System.out.println("LogConsumer [WARN]를 받음 : " + message);
//    }
//
//    @RabbitListener(queues = RabbitMQConfig.INFO_QUEUE)
//    public void consumeInfo(String message) {
//        System.out.println("LogConsumer [INFO]를 받음 : " + message);
//    }
//}
