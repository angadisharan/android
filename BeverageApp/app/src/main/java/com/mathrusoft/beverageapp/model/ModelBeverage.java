package com.mathrusoft.beverageapp.model;

import java.io.Serializable;

/**
 * Created by sharanangadi on 30/12/16.
 */

public class ModelBeverage implements Serializable {

    private String _id;
    private String name;
    private float price;
    private String description;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
