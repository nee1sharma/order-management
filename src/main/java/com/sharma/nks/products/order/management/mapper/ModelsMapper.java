package com.sharma.nks.products.order.management.mapper;

import com.sharma.nks.products.domain.model.Address;
import com.sharma.nks.products.domain.model.Customer;
import com.sharma.nks.products.domain.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ModelsMapper {
    @Mappings({@Mapping(source="id", target = "orderId")})
    Order mapOrder(com.sharma.nks.products.rest.models.Order restOrder);

    @Mappings({@Mapping(source="orderId", target = "id")})
    com.sharma.nks.products.rest.models.Order mapOrder(Order order);

    @Mappings({@Mapping(source="id", target = "customerId")})
    Customer mapCustomer(com.sharma.nks.products.rest.models.Customer restCustomer);

    @Mappings({@Mapping(source="customerId", target = "id")})
    com.sharma.nks.products.rest.models.Customer mapCustomer(Customer customer);

    Address mapAddress(com.sharma.nks.products.rest.models.Address address);
}
