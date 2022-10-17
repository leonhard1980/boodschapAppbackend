package com.example.demo.services;
import com.example.demo.adapters.ProductAdapter;
import com.example.demo.dto.OrderLinesDto;
import com.example.demo.dto.ProductDto;
import com.example.demo.model.OrderLine;
import com.example.demo.model.Product;
import com.example.demo.repositories.OrderLineRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class OrderLineService {

    private final OrderLineRepository orderLineRepository;

    public OrderLineService(OrderLineRepository orderLineRepository){
        this.orderLineRepository = orderLineRepository;
    }

    public int putOrderLine(OrderLinesDto newOrderLineDto){
        OrderLine o = new OrderLine(newOrderLineDto.orderPrice, newOrderLineDto.amount, newOrderLineDto.originalPrice);
        OrderLine savedOrder = orderLineRepository.save(o);
     return savedOrder.getOrderId();
    }

    public OrderLinesDto getOrder(Long orderId){
        Optional<OrderLine> oo = orderLineRepository.findById(orderId);
        if (oo.isPresent()){
            OrderLine o = oo.get();
            OrderLinesDto odto = new OrderLinesDto();
            odto.amount = o.getAmount();
            odto.orderPrice = o.getOrderPrice();
            odto.originalPrice = o.getOriginalPrice();

            return odto;
        }
        return null;
    }

    public double getAmount(Long orderId){
        Optional<OrderLine> oo = orderLineRepository.findById(orderId);
        if (oo.isPresent()){
            OrderLine o = oo.get();
            return o.calculateAmount();
        }
        return 0;
    }

    public Collection<OrderLinesDto> getAll() {
        var products = orderLineRepository.findAll();
        ArrayList<OrderLinesDto> orderLineDtos = new ArrayList<>();

        return orderLineDtos;
    }
}
