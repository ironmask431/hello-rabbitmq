//package kevin.hellorabbitmq.step9;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import lombok.*;
//
//import java.time.LocalDateTime;
//
//@Entity
//@ToString
//@Getter
//@Setter
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@AllArgsConstructor
//public class StockEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    // 등록자 id
//    private String userId;
//    // 재고
//    private int stock;
//    // false : 컨슈머에서 처리 전 / true : 컨슈머에서 처리완료
//    private boolean processed;
//    // 생성일
//    private LocalDateTime createdAt;
//    // 수정일
//    private LocalDateTime updatedAt;
//}
