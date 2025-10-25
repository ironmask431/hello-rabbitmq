//package kevin.hellorabbitmq.step5;
//
//import org.springframework.amqp.core.Binding;
//import org.springframework.amqp.core.BindingBuilder;
//import org.springframework.amqp.core.DirectExchange;
//import org.springframework.amqp.core.Queue;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class RabbitMQConfig {
//    // 각 큐 이름을 정의
//    public static final String ERROR_QUEUE = "error_queue";
//    public static final String WARN_QUEUE = "warn_queue";
//    public static final String INFO_QUEUE = "info_queue";
//
//    // 익스체인지 명 정의
//    public static final String DIRECT_EXCHANGE = "direct_exchange";
//
//    // 익스체인지 빈등록
//    @Bean
//    public DirectExchange directExchange() {
//        return new DirectExchange(DIRECT_EXCHANGE);
//    }
//
//    // 각 큐를 빈등록
//    @Bean
//    public Queue errorQueue() {
//        return new Queue(ERROR_QUEUE, false);
//    }
//
//    @Bean
//    public Queue warnQueue() {
//        return new Queue(WARN_QUEUE, false);
//    }
//    @Bean
//    public Queue infoQueue() {
//        return new Queue(INFO_QUEUE, false);
//    }
//
//    // 익스체인지와 각 큐를 연결
//    // 익스체인지로 들어온 메세지는 "라우팅키" 에 따라 특정 큐로만 들어간다.
//    @Bean
//    public Binding errorBinding() {
//        return BindingBuilder.bind(errorQueue()).to(directExchange()).with("error");
//    }
//    @Bean
//    public Binding warnBinding() {
//        return BindingBuilder.bind(warnQueue()).to(directExchange()).with("warn");
//    }
//    @Bean
//    public Binding infoBinding() {
//        return BindingBuilder.bind(infoQueue()).to(directExchange()).with("info");
//    }
//}
