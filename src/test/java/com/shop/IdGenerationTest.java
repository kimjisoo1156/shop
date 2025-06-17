package com.shop;

import com.shop.constant.ItemSellStatus;
import com.shop.entity.Item;
import com.shop.entity.Member;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional


/*
JPA에서 GenerationType.AUTO 또는 SEQUENCE 사용 시,
Hibernate는 기본적으로 엔티티마다 별도의 시퀀스 테이블(*_seq)을 만든다.
이 경우, 각 엔티티가 자기 전용 시퀀스를 사용하므로 ID 충돌이 없다.
즉, "item 1, member 1, order 1" → 당연히 각각 다른 테이블이고 문제 없음.
(혹시나 한시퀀스로 여러 엔티티를 공유해서 id가 서로 중복되는 상황이 있나 테스트 해봄, 워크밴치확인시 각자 테이블 엔티티 별로 시퀀스 생김 )
 */
public class IdGenerationTest {

    @Autowired
    EntityManager em;

    @Test
    void checkIdMixingInAutoStrategy() {
        Item item = new Item();
        item.setItemNm("테스트상품");
        item.setPrice(10000);
        item.setStockNumber(10);
        item.setItemDetail("상세설명");
        item.setItemSellStatus(ItemSellStatus.SELL);

        Member member = new Member();
        member.setName("테스트회원");
        member.setEmail("test@email.com");
        member.setPassword("1234");
        member.setAddress("서울");

        em.persist(item);
        em.persist(member);
        em.flush();

        System.out.println("Item ID: " + item.getId());
        System.out.println("Member ID: " + member.getId());
    }
}
