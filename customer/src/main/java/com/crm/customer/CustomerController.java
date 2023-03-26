package com.crm.customer;
import com.crm.customer.orm.CustomerModel;
import com.crm.customer.orm.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.websocket.server.PathParam;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@RestController
@RequestMapping ("/api")

public class CustomerController {
    @Autowired
    CustomerService customerService;
    @GetMapping("/getCustomer")
    public List<CustomerModel> getGroupMed(@PathParam("custId")  Integer custId){
        System.out.println("Input customer id is :::"+ custId);
        List<CustomerModel> customerList=  customerService.getCustomerList();
        return customerList
                .stream()
                .filter(q -> q.getCustomerId() ==custId)
                .collect(Collectors.toList());

       // return Arrays.asList(matchingCustomer);
    }
}
