package com.sharma.nks.products.order.management.resources;

import com.sharma.nks.products.order.management.services.OrderService;
import com.sharma.nks.products.rest.models.Order;
import com.sharma.nks.products.rest.models.OrderItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private OrderService orderService;

    @PostMapping("/{customerId}")
    public String placeNewOrder(@RequestBody List<OrderItem> orderItems,
                                @PathVariable("customerId") String customerId) {
        LOGGER.debug("Placing order for {} with {} order items in one order", customerId, orderItems.size());
        //TODO: validate customer
        //TODO: validate product name or id
        //TODO: calculate product price, discount and total costs
        return orderService.createOrder(orderItems, customerId);
    }

    @GetMapping("/{orderId}")
    public Optional<Order> getOrderDetailByOrderId(@PathVariable("orderId") String orderId) {
        LOGGER.debug("Get order by orderId {}", orderId);

        return orderService.getOrderByOrderId(orderId);
    }

    @GetMapping
    public List<Order> getOrderByCustomerId(@RequestParam(value = "customerId") String customerId) {

        return orderService.getOrdersByCustomerId(customerId);
    }
}
