package com.crm.customer.orm;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    public List<CustomerModel> getCustomerList(){ 

        List<CustomerModel> customerList=new ArrayList<CustomerModel>();
        //This should be coming from suite CRM DB
        customerList.add(new CustomerModel(1,"Ricky","Australia"));
        customerList.add(new CustomerModel(2,"Steve","Australia"));
        customerList.add(new CustomerModel(3,"Green","Australia"));
        return customerList;
    }
}
