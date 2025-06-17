package com.shop;

import com.shop.constant.OrderStatus;
import com.shop.constant.Role;
import com.shop.entity.Member;
import com.shop.entity.Order;
import com.shop.repository.OrderRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
@Transactional
public class NpluseOneTest {

    @Autowired
    private EntityManager em;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void nPlusOne확인_주문조회시_회원조회까지되는가() {
        // given: 데이터 세팅
        for (int i = 1; i <= 5; i++) {
            Member member = new Member();
            member.setEmail("user" + i + "@test.com");
            member.setName("사용자" + i);
            member.setAddress("서울시");
            member.setPassword("1234");
            member.setRole(Role.USER);
            em.persist(member);

            Order order = new Order();
            order.setMember(member);
            order.setOrderDate(LocalDateTime.now());
            order.setOrderStatus(OrderStatus.ORDER);
            em.persist(order);
        }

        em.flush();
        em.clear();

        // when: 모든 주문을 조회
        List<Order> orders = orderRepository.findAll();

        // then: member.getName()을 호출 → Lazy 로딩 → N개의 추가 쿼리 발생
        for (Order order : orders) {
            System.out.println("주문 회원명: " + order.getMember().getName()); // ← 여기서 N번 SELECT
        }
    }

}
