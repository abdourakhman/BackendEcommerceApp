package ma.gemadec.ecom.controllers;

import ma.gemadec.ecom.models.Order;
import ma.gemadec.ecom.services.OrderService;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping("/user/{userID}")
    public List<Order> findUserOrder(@PathVariable ObjectId userID){
        return orderService.findByUserID(userID);
    }
}
