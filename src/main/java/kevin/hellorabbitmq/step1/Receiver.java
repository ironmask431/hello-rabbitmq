package kevin.hellorabbitmq.step1;

import org.springframework.stereotype.Component;

// 큐로부터 메세지를 가져와 메세지를 처리하는 컨슈머 역할.
@Component
public class Receiver {
    public void receiveMessage(String message) {
        System.out.println("[#] Received: " + message);
    }
}
