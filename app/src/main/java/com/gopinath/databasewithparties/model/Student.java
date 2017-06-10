package com.gopinath.databasewithparties.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by gopinath on 09/06/17.
 */

public class Student {
    @SerializedName("")
    private List<Student>students=null;
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("address")
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
