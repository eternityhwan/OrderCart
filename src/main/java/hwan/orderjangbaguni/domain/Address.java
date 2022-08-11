package hwan.orderjangbaguni.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Embeddable;
            // 다른 곳에 내장될 수 있다. Embedded로 사용하면 된다.
@Embeddable //  다른 엔티티에 포함될 수 있다는 것을 알려주는 어노테이션 @Embedded 와 연결됨
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class Address {

    private String city;
    private String street;
    private String zipcode;
}
