package com.niit.jdp.PizzaCart.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Pizza {
    @Id
    private int pizzaId;
    private String pizzaName;
    private String pizzaSize;
    private String pizzaCategory;
    private double pizzaPrice;

    public Pizza() {
    }

    public Pizza(int pizzaId, String pizzaName, String pizzaSize, String pizzaCategory, double pizzaPrice) {
        this.pizzaId = pizzaId;
        this.pizzaName = pizzaName;
        this.pizzaSize = pizzaSize;
        this.pizzaCategory = pizzaCategory;
        this.pizzaPrice = pizzaPrice;
    }

    public int getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(int pizzaId) {
        this.pizzaId = pizzaId;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public String getPizzaSize() {
        return pizzaSize;
    }

    public void setPizzaSize(String pizzaSize) {
        this.pizzaSize = pizzaSize;
    }

    public String getPizzaCategory() {
        return pizzaCategory;
    }

    public void setPizzaCategory(String pizzaCategory) {
        this.pizzaCategory = pizzaCategory;
    }

    public double getPizzaPrice() {
        return pizzaPrice;
    }

    public void setPizzaPrice(double pizzaPrice) {
        this.pizzaPrice = pizzaPrice;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "pizzaId=" + pizzaId +
                ", pizzaName='" + pizzaName + '\'' +
                ", pizzaSize='" + pizzaSize + '\'' +
                ", pizzaCategory='" + pizzaCategory + '\'' +
                ", pizzaPrice=" + pizzaPrice +
                '}';
    }
}
