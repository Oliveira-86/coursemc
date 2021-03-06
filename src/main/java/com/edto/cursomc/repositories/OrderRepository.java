package com.edto.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edto.cursomc.domain.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
