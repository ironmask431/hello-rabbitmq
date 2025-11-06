//package kevin.hellorabbitmq.step2;
//
//import org.springframework.stereotype.Component;
//
//@Component
//public class WorkQueueConsumer {
//    public void workQueueTask(String message) {
//        String[] messageParts = message.split("\\|");
//        String originMessage = messageParts[0];
//        int duration = Integer.parseInt(messageParts[1].trim());
//        System.out.println("# WorkQueueConsumer Received message: " + message);
//        System.out.println("# WorkQueueConsumer Received originMessage: " + originMessage + " (duration: " + duration +" s)");
//
//        try {
//            for (int i = 0; i < duration; i++) {
//                Thread.sleep(1000); // 1초 대기
//                System.out.print("."); // 진행 상태 출력
//            }
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }
//        System.out.println("\n[X] " +originMessage +" Completed!!");
//    }
//}
