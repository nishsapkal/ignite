package com.crm.customer;
import com.crm.customer.orm.CustomerModel;
import com.crm.customer.orm.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.websocket.server.PathParam;
import java.util.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping ("/api")

public class CustomerController {
    @Autowired
    CustomerService customerService;
    @GetMapping("/customers")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerModel> getCustomers(){
        return customerService.getCustomerList();

    }
    @GetMapping("/customer")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerModel> returnCustomers(@PathParam("custId") Integer custId){
        System.out.println("Input customer id is :::"+ custId);
        List<CustomerModel> customerList=null;
        if(custId !=null) {

            return Optional.ofNullable( customerService.getCustomerList())
                    .orElse(Collections.emptyList())
                    .stream()
                    .filter(q -> q.getCustomerId() == custId)
                    .collect(Collectors.toList());
        }else{
            System.out.println("Please provide customerID");
        }
        return  customerList;
    }

}
