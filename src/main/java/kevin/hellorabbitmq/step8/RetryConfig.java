//package kevin.hellorabbitmq.step8;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.retry.backoff.FixedBackOffPolicy;
//import org.springframework.retry.policy.SimpleRetryPolicy;
//import org.springframework.retry.support.RetryTemplate;
//
///**
// * RetryTemplate 의 속성을 정의하고 bean으로 등록함.
// * RetryTemplate 은 execute() 내부에서 throw exception 발생 시 자체적으로 재시도하는 기능을 제공함.
// * 주의 : RetryTemplate은 RabbitMQ 브로커 수준의 재전송(NACK 기반) 과는 별개입니다.
// * → 즉, 컨슈머 코드 안에서 비즈니스 로직 재시도용입니다.
// */
//@Configuration
//public class RetryConfig {
//
//    @Bean
//    public RetryTemplate retryTemplate() {
//        RetryTemplate retryTemplate = new RetryTemplate();
//
//        // 재시도 정책 설정: 최대 3번 시도
//        SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy();
//        retryPolicy.setMaxAttempts(3);
//        // 백오프 정책 설정: 재시도 간격 1초
//        FixedBackOffPolicy backOffPolicy = new FixedBackOffPolicy();
//        backOffPolicy.setBackOffPeriod(1000L);
//
//        retryTemplate.setRetryPolicy(retryPolicy);
//        retryTemplate.setBackOffPolicy(backOffPolicy);
//
//        return retryTemplate;
//    }
//}
