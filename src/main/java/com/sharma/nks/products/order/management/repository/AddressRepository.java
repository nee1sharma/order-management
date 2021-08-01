package com.sharma.nks.products.order.management.repository;

import com.sharma.nks.products.domain.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
