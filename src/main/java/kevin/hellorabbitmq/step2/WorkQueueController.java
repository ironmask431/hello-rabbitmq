//package kevin.hellorabbitmq.step2;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/message")
//@RequiredArgsConstructor
//public class WorkQueueController {
//    private final WorkQueueProducer workQueueProducer;
//
//    @PostMapping("/workqueue")
//    public String sendWorkQueue(@RequestParam String message, @RequestParam int duration) {
//        String msg =  "api - Work queue sent = " + message + ", (" + duration + ")";
//        System.out.println(msg);
//        workQueueProducer.sendWorkQueue(message, duration);
//        return msg;
//    }
//}
