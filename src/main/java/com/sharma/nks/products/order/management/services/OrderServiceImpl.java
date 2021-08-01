package com.sharma.nks.products.order.management.services;

import com.sharma.nks.products.order.management.mapper.ModelsMapper;
import com.sharma.nks.products.order.management.repository.OrderRepository;
import com.sharma.nks.products.order.management.util.UniqueIdGenerator;
import com.sharma.nks.products.rest.models.Order;
import com.sharma.nks.products.rest.models.OrderItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ModelsMapper mapper;

    @Value("${app.operator.name}")
    private String operatorPrefix;

    @Override
    public String createOrder(List<OrderItem> orderItems, String customerId) {
        logger.debug("Create order with items: {}", orderItems);
        com.sharma.nks.products.domain.model.Order order = buildOrder(orderItems, customerId);
        com.sharma.nks.products.domain.model.Order save = orderRepository.save(order);
        return save.getOrderId();
    }

    private com.sharma.nks.products.domain.model.Order buildOrder(List<OrderItem> orderItems, String customerId) {
        Order order = new Order();
        order.setCustomerId(customerId);
        order.setId(UniqueIdGenerator.getUniqueId(operatorPrefix));
        order.setOrderedDate(LocalDate.now());
        order.setStatus("CREATED");
        order.setOrderItems(orderItems);
        return mapper.mapOrder(order);
    }

    @Override
    public Optional<Order> getOrderByOrderId(String orderId) {
        return orderRepository.findById(orderId).map(order -> mapper.mapOrder(order));
    }

    @Override
    public List<Order> getOrdersByCustomerId(String customerId) {
        List<com.sharma.nks.products.domain.model.Order> orders = orderRepository.findOrdersByCustomerId(customerId);
        logger.debug("{} Order found for customerId: {}", orders.size(), customerId);
        return orders.stream().map(order -> mapper.mapOrder(order)).collect(Collectors.toList());
    }
}
