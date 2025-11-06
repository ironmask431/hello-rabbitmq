//package kevin.hellorabbitmq.step6;
//
//import org.springframework.amqp.core.*;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class RabbitMQConfig {
//    // 각 큐 이름을 정의
//    public static final String ERROR_QUEUE = "error_queue";
//    public static final String WARN_QUEUE = "warn_queue";
//    public static final String INFO_QUEUE = "info_queue";
//    public static final String ALL_LOG_QUEUE = "all_log_queue";
//
//    // 익스체인지 명 정의
//    public static final String TOPIC_EXCHANGE = "topic_exchange";
//
//    // 익스체인지 빈등록
//    @Bean
//    public TopicExchange topicExchange() {
//        return new TopicExchange(TOPIC_EXCHANGE);
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
//    @Bean
//    public Queue allLogQueue() {
//        return new Queue(ALL_LOG_QUEUE, false);
//    }
//
//    // 익스체인지와 각 큐를 연결
//    // 익스체인지로 들어온 메세지는 "라우팅키" 에 따라 특정 큐로만 들어간다.
//    @Bean
//    public Binding errorBinding() {
//        return BindingBuilder.bind(errorQueue()).to(topicExchange()).with("log.error");
//    }
//    @Bean
//    public Binding warnBinding() {
//        return BindingBuilder.bind(warnQueue()).to(topicExchange()).with("log.warn");
//    }
//    @Bean
//    public Binding infoBinding() {
//        return BindingBuilder.bind(infoQueue()).to(topicExchange()).with("log.info");
//    }
//
//    // topic 패턴 활용 "log.*" 에 매칭되는 바인딩키일 경우 allLogQueue 에 발행된다.
//    @Bean
//    public Binding allLogBinding() {
//        return BindingBuilder.bind(allLogQueue()).to(topicExchange()).with("log.*");
//    }
//}
