package kevin.hellorabbitmq.step6;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class LogConsumer {

    // 각 큐의 메세지를 수신
    @RabbitListener(queues = RabbitMQConfig.ERROR_QUEUE)
    public void consumeError(String message) {
        System.out.println("LogConsumer [ERROR 큐]에서 받음 : " + message);
    }

    @RabbitListener(queues = RabbitMQConfig.WARN_QUEUE)
    public void consumeWarn(String message) {
        System.out.println("LogConsumer [WARN 큐]에서 받음 : " + message);
    }

    @RabbitListener(queues = RabbitMQConfig.INFO_QUEUE)
    public void consumeInfo(String message) {
        System.out.println("LogConsumer [INFO 큐]에서 받음 : " + message);
    }

    @RabbitListener(queues = RabbitMQConfig.ALL_LOG_QUEUE)
    public void consumeAllLogs(String message) {
        System.out.println("LogConsumer [ALL_LOG_QUEUE 큐]에서 받음 : " + message);
    }
}
