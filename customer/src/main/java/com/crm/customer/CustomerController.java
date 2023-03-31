package com.crm.customer;
import com.crm.customer.orm.CustomerModel;
import com.crm.customer.orm.CustomerService;

import com.crm.customer.orm.Inventory;
import com.crm.customer.orm.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;


import javax.websocket.server.PathParam;
import java.util.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping ("/api")

public class CustomerController {
    @Autowired
    CustomerService customerService;
    @Autowired
    InventoryService inventoryService;
    @GetMapping("/customers")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerModel> getCustomers(){
        return customerService.getCustomerList();

    }
    @GetMapping("/products")
    @ResponseStatus(HttpStatus.OK)
    public List<Inventory> getInventory(@PathParam("active") String active){
        System.out.println("Customer is looking for product type:"+ active);
        if(!StringUtils.isEmpty(active)){
            return Optional.ofNullable( inventoryService.getProductInventory())
                    .orElse(Collections.emptyList())
                    .stream()
                    .filter(q -> q.isActive() == Boolean.valueOf(active))
                    .collect(Collectors.toList());
        }else  return inventoryService.getProductInventory();
    }

    @GetMapping("/customer")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerModel> returnCustomers(@PathParam("custid") Integer custId){
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
