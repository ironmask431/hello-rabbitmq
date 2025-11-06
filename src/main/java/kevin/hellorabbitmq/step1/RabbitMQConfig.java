//package kevin.hellorabbitmq.step1;
//
//import org.springframework.amqp.core.Queue;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
//import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * 전체 동작 흐름
// * RabbitTemplate (Producer)
// *        ↓
// * Queue (hellorabbitmq)
// *        ↓
// * SimpleMessageListenerContainer (Consumer Container)
// *        ↓
// * MessageListenerAdapter → Receiver.receiveMessage()
// */
//
////@Configuration
//public class RabbitMQConfig {
//    // 큐 네임 설정.
//    public static final String QUEUE_NAME = "hellorabbitmq";
//
//    // 큐 선언
//    @Bean
//    public Queue queue() {
//        //boolean durable 옵션 - true : 영속성(서버가 종료되도 유지), false : 휘발성 (서버가 종료되면 사라짐)
//        return new Queue(QUEUE_NAME, false);
//    }
//
//    // 프로듀서 객체에서 메세지를 보낼때 사용할 RabbitTemplate 생성 .
//    // 아래와 같이 큐로 메세지를 전송함.
//    // rabbitTemplate.convertAndSend("hellorabbitmq", "Hello, RabbitMQ!");
//    // ConnectionFactory 를 통해 RabbitMQ 브로커와 연결됨.
//    @Bean
//    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
//        return new RabbitTemplate(connectionFactory);
//    }
//
//    // 큐로 부터 메세지를 지속적으로 수신하기 위한 리스너 컨테이너 생성.
//    // 컨슈머 프로세스를 실행하고 관리.
//    @Bean
//    public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
//                                                    MessageListenerAdapter listenerAdapter) {
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory);
//        container.setQueueNames(QUEUE_NAME); // 구독할 큐 설정.
//        container.setMessageListener(listenerAdapter);
//        return container;
//    }
//
//    // 수신 메서드를 컨슈머 클래스(Receiver)에 연결
//    @Bean
//    public MessageListenerAdapter listenerAdapter(Receiver receiver) {
//        // 큐에 메세지가 도착하면, receiver.receiveMessage(String message); 가 자동으로 호출된다.
//        return new MessageListenerAdapter(receiver, "receiveMessage");
//    }
//
//}
