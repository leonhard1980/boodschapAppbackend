package com.example.demo.repositories;

import com.example.demo.model.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderLine, Long> {


}
