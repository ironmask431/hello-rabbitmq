package kevin.hellorabbitmq.step8;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderConsumer2 {
    private int retryCount;

    @RabbitListener(queues = RabbitMQConfig.ORDER_COMPLETED_QUEUE)
    public void processMessage(String message) {
        System.out.println("[OrderConsumer2] Received message: "+ message + ", count : " + retryCount++);
        if ("fail".equals(message)) {
            // 컨슈머에서 exception이 발생하면 RabbitMQConfig 의 orderQueue 설정과 application.yaml의 retry속성과  의해 재처리 후 DLQ로 보내어짐.
            throw new RuntimeException("- Processing failed. Retry" );
        }
        System.out.println("[OrderConsumer2] Message processed successfully: " + message);
        retryCount = 0;
    }
}
