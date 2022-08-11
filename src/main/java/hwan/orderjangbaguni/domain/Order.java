package hwan.orderjangbaguni.domain;

import hwan.orderjangbaguni.Constant.DeliveryStatus;
import hwan.orderjangbaguni.Constant.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter @Setter
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "order_id") // 테이블명_id로 매핑해야된다.
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    // EAGER(즉시로딩) 예측이 어렵고 어떤 SQL실행될지 추적어려워
    // 절대 쓰지마라 LAZY로해라 SQL 꼬인다.
    // ManyToOne, OneToMany 패칭 타입이 EAGER가 기본이니까 항상 LAZY로 바꿔라.
    @JoinColumn(name = "member_id") // 매핑을 뭘로 할 거냐, 외래키 이름이 member_id
    private Member member;
    // 주문과 맴버는 다대일 관계다, @ManyToOne

    @OneToMany(mappedBy = "order")
    // 하나의 회원이 여러개의 상품을 주문하니까 @OneToMany
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id") // <-
    private Delivery delivery;

    private Date date;
    private LocalDateTime orderDate;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    //==연관관계 메서드==//
    public void setMember(Member member) {
        this.member = member;
        member.getOrder().add(this);
    }
    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }
    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
        delivery.setOrder(this);
    }
    //==생성 메서드==//
    public static Order createOrder(Member member, Delivery delivery,
                                    OrderItem... orderItems) {
        Order order = new Order();
        order.setMember(member);
        order.setDelivery(delivery);
        for (OrderItem orderItem : orderItems) {
            order.addOrderItem(orderItem);
        }
        order.setStatus(OrderStatus.ORDER);
        order.setOrderDate(LocalDateTime.now());
        return order;
    }
//==비즈니스 로직==//
    /** 주문 취소 */
    public void cancel() {
        if (delivery.getStatus() == DeliveryStatus.COMP) {
            throw new IllegalStateException("이미 배송완료된 상품은 취소가 불가능합니다.");
        }
        this.setStatus(OrderStatus.CANCEL);
        for (OrderItem orderItem : orderItems) {
            orderItem.cancel();
        }
    }
//==조회 로직==//
    /** 전체 주문 가격 조회 */
    public int getTotalPrice() {
        int totalPrice = 0;
        for (OrderItem orderItem : orderItems) {
            totalPrice += orderItem.getTotalPrice();
        }
        return totalPrice;
    }
}
