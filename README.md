### RabbitMQ를 이용한 비동기 아키텍처 구축

노션 링크 : 
https://dynamic-cent-685.notion.site/RabbitMQ-1b8ed6ed7f7c80c19492c0138c726f1f

### 전체 핵심 요약

- RabbitMQ 메세지 브로커의 기본 개념, 활용처
- EDA (이벤트 드리븐 아키텍처) 의 개념
- RabbitMq 구성요소들의 개념
- RabbitMq Admin 요소별 개념
- SpringBoot와 RabbitMq 연동, 기본적인 producer, consumer 구현
- 다수 consumer들의 메세지 병렬처리 구현
- Fanout(전체 발송), Direct, Topic (라우팅키와 매칭) 3가지 방식의 메세지 발행 구현
- 처리실패된 메세지는 DeadLetterQueue로 옮겨서, 재처리 하는 로직 구현 (retry 설정 활용)
- Rabbitmq 메세지 발송 처리로직에 트랜잭션 도입 구현 (비추천 방식)
- SAGA 패턴 vs TCC (Try-Confirm/Cancel) 패턴의 개념 비교.
