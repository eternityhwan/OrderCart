package hwan.orderjangbaguni.repository;

import hwan.orderjangbaguni.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class CartRepository {

    @PersistenceContext // PersistenceContext 붙여주면 스프링이 엔티티매니저를 만들어서 주입해준다.
    private EntityManager em;

    public List<Item> findCart() {
        return em.createQuery(
                "select c from Item c", Item.class).getResultList();
    }

}
