//package kevin.hellorabbitmq.step9;
//
//import org.springframework.amqp.core.Queue;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
//import org.springframework.amqp.support.converter.MessageConverter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class RabbitMQConfig {
//    @Bean
//    public Queue queue() {
//        return new Queue("transactionQueue", true);
//    }
//
//    // 객체를 json으로 변환하여 rabbitmq message로 보내기 위한 용도
//    @Bean
//    public MessageConverter messageConverter() {
//        return new Jackson2JsonMessageConverter();
//    }
//
//    @Bean
//    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, MessageConverter messageConverter) {
//        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
//        rabbitTemplate.setMessageConverter(messageConverter); // JSON 변환기 등록
//        rabbitTemplate.setChannelTransacted(true);  // 트랜잭션 활성화
//        return rabbitTemplate;
//    }
//}
