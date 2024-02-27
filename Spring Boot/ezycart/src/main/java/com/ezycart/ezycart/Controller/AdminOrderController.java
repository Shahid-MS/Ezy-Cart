package com.ezycart.ezycart.Controller;

import com.ezycart.ezycart.Entities.Order;
import com.ezycart.ezycart.Exception.OrderException;
import com.ezycart.ezycart.Service.OrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/orders")
public class AdminOrderController {

  @Autowired
  private OrderService orderService;

  @GetMapping("/")
  public ResponseEntity<List<Order>> getAllOrdersHandler() {
    List<Order> orders = orderService.getAllOrders();

    return new ResponseEntity<List<Order>>(orders, HttpStatus.ACCEPTED);
  }

  // @PutMapping("{orderId}/confirmed")
  // public ResponseEntity<Order> confirmedOrderHandler(
  //   @PathVariable Long orderId,
  //   @RequestHeader("Authorization") String jwt
  // ) throws OrderException {
  //   Order order = OrderService.confirmedOrder(orderId);
  //   return new ResponseEntity<>(order, HttpStatus.OK);
  // }
}
