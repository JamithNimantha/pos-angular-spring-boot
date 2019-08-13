package com.jamith.absd.posangularspringboot.repository;

import com.jamith.absd.posangularspringboot.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, String> {
    Item findTopByCode(String code);
}
