package com.sharma.nks.products.order.management.services;

import com.sharma.nks.products.rest.models.Address;
import com.sharma.nks.products.rest.models.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    String createCustomer(Customer customer);

    Optional<Customer> getCustomerById(String customerId);

    List<Customer> findCustomers();

    Customer updateAddress(String customerId, Address address);
}
