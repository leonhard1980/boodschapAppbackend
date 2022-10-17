package com.example.demo.controller;

import com.example.demo.dto.OrderLinesDto;
import com.example.demo.services.OrderLineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderLineController {
private final OrderLineService service;

public OrderLineController(OrderLineService service){
    this.service = service;
}

@PostMapping("/orderline") //klopt dit?
public ResponseEntity<Long> createOrderLine(@RequestBody OrderLinesDto newOrderLineDto){
    Long orderId = service.putOrderLine(newOrderLineDto);
return new ResponseEntity<>(orderId, HttpStatus.CREATED)
}

    //hieronder een methode die de amount van de Orderlines doorzoekt en
    // dan het product met de hoogste amount teruggeeft.
    @GetMapping("/products")
    public ResponseEntity<Object> getMostSoldProduct(){
        sort Orderline.amount
    }

    // methode om de invoice = eindbedrag op te vragen.
    @GetMapping("/orderline/{id}/invoice")
    public ResponseEntity<InvoiceDto> getamount(@PathVariable Long id){
    InvoiceDto invoiceDto = new invoiceDto();
    invoiceDto.orderId = id;
    invoiceDto.amount = service.getAmount(id);
    return new ResponseEntity<>(invoiceDto, HttpStatus.OK);
    }

}
