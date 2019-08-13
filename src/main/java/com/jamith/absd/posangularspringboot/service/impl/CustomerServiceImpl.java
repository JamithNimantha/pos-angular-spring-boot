package com.jamith.absd.posangularspringboot.service.impl;

import com.jamith.absd.posangularspringboot.dto.CustomerDTO;
import com.jamith.absd.posangularspringboot.entity.Customer;
import com.jamith.absd.posangularspringboot.repository.CustomerRepository;
import com.jamith.absd.posangularspringboot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;


    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll().stream().map(Customer::getCustomerDto).collect(Collectors.toList());

    }

    @Override
    public boolean saveCustomer(CustomerDTO customerDto) {
        try {
            Customer customer = new Customer();
            customer.setId(customerDto.getId());
            customer.setName(customerDto.getName());
            customer.setAddress(customerDto.getAddress());
            customer.setSalary(customerDto.getSalary());
            customerRepository.save(customer);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateCustomer(CustomerDTO customerDto) {
        try {
            Customer exists = customerRepository.findTopById(customerDto.getId());
            if (exists!=null){
                exists.setName(customerDto.getName());
                exists.setAddress(customerDto.getAddress());
                exists.setSalary(customerDto.getSalary());
                customerRepository.save(exists);
                return true;
            }else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteCustomer(String id) {
        try {
            Customer topById = customerRepository.findTopById(id);
            customerRepository.delete(topById);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
