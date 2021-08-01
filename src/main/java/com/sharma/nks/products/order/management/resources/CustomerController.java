package com.sharma.nks.products.order.management.resources;

import com.sharma.nks.products.order.management.services.CustomerService;
import com.sharma.nks.products.rest.models.Address;
import com.sharma.nks.products.rest.models.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public String registerCustomer(@RequestBody Customer customer) {
        LOGGER.debug("Creating customer {}", customer);
        return customerService.createCustomer(customer);
    }

    @GetMapping("/{customerId}")
    public Optional<Customer> getCustomerById(@PathVariable("customerId") String customerId) {
        return customerService.getCustomerById(customerId);
    }

    @GetMapping
    public List<Customer> findCustomers() {
        return customerService.findCustomers();
    }

    @PutMapping("/{id}/addresses")
    public Customer updateAddress(@PathVariable("id") String customerId, @RequestBody Address address) {
        LOGGER.debug("Updating address for customerId: {}, {}", customerId, address);
        customerService.updateAddress(customerId,address);
        return null;
    }

    @GetMapping("{id}/addresses")
    public Address getAddressByCustomerId(@PathVariable("id") String customerId) {
        LOGGER.debug("Find address of customerId : {}", customerId);
        return null;
    }
}
