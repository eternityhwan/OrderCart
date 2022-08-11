package hwan.orderjangbaguni.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue // 시퀀스 값으로 생성할거야.
    @Column(name = "member_id") // <-매핑 pk 이름이 member_id 이다.
    private Long id;

    private String name;

    @Embedded // @Embeddable 어노테이션과 이어진다.
    private Address address;

    @OneToMany(mappedBy = "member") // 일 대 다 양방향 매핑 member라는 애랑 매핑
    // 맴버를 써줘야해매핑된 거울이라는 뜻 읽기전용의 뜻.
    private List<Order> order = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Cart> carts = new ArrayList<>();


}
