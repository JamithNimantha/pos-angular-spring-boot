package com.jamith.absd.posangularspringboot.service;

import com.jamith.absd.posangularspringboot.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {

    List<CustomerDTO> getAllCustomers();

    boolean saveCustomer(CustomerDTO customerDto);

    boolean updateCustomer(CustomerDTO customerDto);

    boolean deleteCustomer(String id);
}
