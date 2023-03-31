package com.crm.customer.orm;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryService {

    public List<Inventory> getProductInventory(){ 

        List<Inventory> inventoryList=new ArrayList<Inventory>();
        //This should be coming from suite CRM DB
        inventoryList.add(new Inventory("Mobile",
                "I Phone X", 1200D,1000000L,true));
        inventoryList.add(new Inventory("Tablet",
                "I Pad air", 700D,500000L,true));
        inventoryList.add(new Inventory("Laptop",
                "Macbook air", 2220D,0L,false));

        return  inventoryList;
        }
}
