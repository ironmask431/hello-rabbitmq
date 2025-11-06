//package kevin.hellorabbitmq.step1;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/message")
//@RequiredArgsConstructor
//public class MessageController {
//    private final Sender sender;
//
//    // api로 메세지를 받아서 큐로 메세지를 전달함.
//    @PostMapping("/send")
//    public String sendMessage(@RequestBody String message) {
//        sender.send(message);
//        return "[#] Controller Message sent successfully! " + message;
//    }
//}
