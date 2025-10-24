package kevin.hellorabbitmq.step3;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifications")
@RequiredArgsConstructor
public class NotificationController {
    private final NotificationPublisher notificationPublisher;

    @PostMapping
    public String sendNotification(@RequestBody String message) {
        notificationPublisher.publish(message);
        return "[#] NotificationController - send : " + message;
    }
}
