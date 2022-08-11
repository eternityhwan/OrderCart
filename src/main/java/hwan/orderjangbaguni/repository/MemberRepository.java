package hwan.orderjangbaguni.repository;

import hwan.orderjangbaguni.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
// Entity를 찾아주는 기능이다 레파지토리는 dao로 생각해
// Repository 선언하면 컴포넌트 스캔으로 스프링빈이 자동으로 주입된다
public class MemberRepository {

    @PersistenceContext // PersistenceContext 붙여주면 스프링이 엔티티매니저를 만들어서 주입해준다.
    private EntityManager em;
    // jpa니까 EntityManager를 써야해
    // 디펜던시 추가하는 것만으로도 엔티티 매니저 생성되니까 그냥 쓰면된다.

    public Long save(Member member) {
        em.persist(member); // entityManager에게 member를 넣어주면 jpa가 저장함.
        return member.getId();
    } // member로 받아도돼.
    // jpa가 persist, find 메서드 제공함

    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findAll() {
       return em.createQuery("select m from Member m", Member.class).getResultList();
    }

    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}
