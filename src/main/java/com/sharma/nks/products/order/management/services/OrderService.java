package com.sharma.nks.products.order.management.services;

import com.sharma.nks.products.rest.models.Order;
import com.sharma.nks.products.rest.models.OrderItem;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    /**
     * Create order for customer id based on order items. Must have at least one item
     * @param orderItems
     * @param customerId
     * @return
     */
    String createOrder(List<OrderItem> orderItems, String customerId);

    Optional<Order> getOrderByOrderId(String orderId);

    List<Order> getOrdersByCustomerId(String customerId);
}
