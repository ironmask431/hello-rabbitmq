package kevin.hellorabbitmq.step4;

import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

// 웹소켓 메세지 수신 컨트롤러
@Controller
public class NewsController {
    private final NewsPublisher newsPublisher;

    public NewsController(NewsPublisher newsPublisher) {
        this.newsPublisher = newsPublisher;
    }

    // 웹 소켓을 통해 클라이언트로 부터 뉴스 타입 메세지를 받아 큐로 전송
    // "/app/subscribe"
    @MessageMapping("/subscribe")
    public void handleSubscribe(@Header("newsType") String newsType) {
        System.out.println("# NewsController - newsType: " + newsType);

        String newsMessage = newsPublisher.publish(newsType);
        System.out.println("# NewsController - newsMessage: " + newsMessage);

    }
}
