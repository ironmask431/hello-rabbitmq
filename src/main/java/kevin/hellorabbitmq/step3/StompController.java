package kevin.hellorabbitmq.step3;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

// 클라이언트(웹)에서 웹소켓으로 서버로 보낸 메세지를 받는 컨트롤러
@Controller
@RequiredArgsConstructor
public class StompController {
    private final SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/send")
    public void sendMessage(NotificationMessage notificationMessage) {
        String message = notificationMessage.getMessage();
        System.out.println("[# StompController] get message = " + message);
        // 받은 메세지를 특정 url 웹소켓으로 다시 전파
        simpMessagingTemplate.convertAndSend("/topic/notifications", message);
    }
}
