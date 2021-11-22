package com.example.demo.Entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "User description")
@Entity
public class User {

    @Id
    @GeneratedValue
    Integer id;

    @NotNull
    @Size(min = 2, max = 10, message = "Must be minimum of 2 characters and maximum of 10")
    @ApiModelProperty(notes = "Must be minimum of 2 characters and maximum of 10")
    String name;

    @ApiModelProperty(notes = "Must be past String.")
    private String address;

    public User() {

    }

    public User(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getaddress() {
        return address;
    }

    public void setaddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserModel{" + "id=" + id + ", name='" + name + '\'' + ", address=" + address + '}';
    }
}
