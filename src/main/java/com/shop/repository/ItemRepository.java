package com.shop.repository;

import com.shop.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item,Long>, QuerydslPredicateExecutor<Item> ,ItemRepositoryCustom{


    //select
    List<Item> findByItemNm(String itemNm);

    //or조건
    List<Item> findByItemNmOrItemDetail(String itemNm, String itemDetail);

    //LessThan 조건
    List<Item> findByPriceLessThan(Integer price);

    //LessThan 조건 + 내림차순 정렬
    List<Item> findByPriceLessThanOrderByPriceDesc(Integer price);

    // 쿼리 메소드 단점 이름이 길어짐을 보완하기 위해 +  객체 복잡한 쿼리는 jpql, 특정데베에 독립적
    @Query("select i from Item i where i.itemDetail like %:itemDetail% order by i.price desc")
    List<Item> findByItemDetail(@Param("itemDetail") String itemDetail);

    //db sql , 특정 데베에 종속
    @Query(value = "select * from item i where i.item_detail like %:itemDetail% order by i.price desc", nativeQuery = true)
    List<Item> findByItemDetailByNative(@Param("itemDetail") String itemDetail);



}
