package kevin.hellorabbitmq.step6;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class LogPublisher {
    private final RabbitTemplate rabbitTemplate;

    public LogPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    // 라우팅키 지정, 메세지를 실어서 익스체인지로 메세지 발행한다.
    public void publish(String routingKey, String message) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.TOPIC_EXCHANGE, routingKey, message);
        System.out.println("LogPublisher - routingKey : " + routingKey + " / message :" + message);
    }
}
