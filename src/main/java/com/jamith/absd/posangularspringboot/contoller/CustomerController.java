package com.jamith.absd.posangularspringboot.contoller;

import com.jamith.absd.posangularspringboot.dto.CustomerDTO;
import com.jamith.absd.posangularspringboot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/get-all")
    @ResponseBody
    public List<CustomerDTO> getCustomers(){
        return customerService.getAllCustomers();
    }

    @PostMapping("/save")
    @ResponseBody
    public boolean saveCustomer(@RequestBody CustomerDTO customerDto){
        return customerService.saveCustomer(customerDto);
    }

    @PostMapping("/update")
    @ResponseBody
    public boolean updateCustomer(@RequestBody CustomerDTO customerDto){
        return customerService.updateCustomer(customerDto);
    }

    @PostMapping("/delete")
    @ResponseBody
    public boolean deleteCustomer(@RequestBody String id){
        return customerService.deleteCustomer(id);
    }
}
