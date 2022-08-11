package hwan.orderjangbaguni.domain;

import hwan.orderjangbaguni.Constant.DeliveryStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Delivery {

    @Id
    @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING) // ORDINAL 1,2, 이렇게 들어감 오디널쓰지마 스트링써
    private DeliveryStatus status;
}
