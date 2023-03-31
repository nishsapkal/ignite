package com.crm.customer.orm;

public class Inventory {
    private String name;
    private String description;
    private Double costPrice;
    private Long quantity;
    private boolean isActive;
    public Inventory(String name, String description, Double costPrice, Long quantity, boolean isActive) {
        this.name = name;
        this.description = description;
        this.costPrice = costPrice;
        this.quantity = quantity;
        this.isActive = isActive;
    }





    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
    @Override
    public String toString() {
        return "Inventory{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", costPrice=" + costPrice +
                ", quantity=" + quantity +
                ", isActive=" + isActive +
                '}';
    }


}
