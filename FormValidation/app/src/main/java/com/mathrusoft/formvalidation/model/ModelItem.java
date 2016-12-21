package com.mathrusoft.formvalidation.model;

import java.io.Serializable;

/**
 * Created by sharanangadi on 21/12/16.
 */

public class ModelItem implements Serializable {

    private String name;
    private int quantity;
    private String date;
    private String phone;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

