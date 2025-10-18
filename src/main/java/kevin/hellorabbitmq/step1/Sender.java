package kevin.hellorabbitmq.step1;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

// 메세지를 생성 -> 큐(hellorabbitmq)에 전달하는 프로듀서 역할
@Component
@RequiredArgsConstructor
public class Sender {
    private final RabbitTemplate rabbitTemplate;

    public void send(String message) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_NAME, message);
        System.out.println("[#] Sent : " + message);
    }
}
