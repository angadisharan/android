package com.mathrusoft.democustomadapter.model;

import java.io.Serializable;

/**
 * Created by sharanangadi on 28/12/16.
 */

public class ModelStudentDetails implements Serializable {
    private String name;
    private String branch;
    private String usn;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getUsn() {
        return usn;
    }

    public void setUsn(String usn) {
        this.usn = usn;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
