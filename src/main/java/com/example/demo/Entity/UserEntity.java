package com.example.demo.Entity;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "User description")
public class UserEntity {

    Integer id;

    
    @NotNull
    @Size(min = 2, max = 10, message = "Must be minimum of 2 characters and maximum of 10")
    @ApiModelProperty(notes = "Must be minimum of 2 characters and maximum of 10")
    String name;
 
    @Past
    @ApiModelProperty(notes = "Must be past Date.")
    private Date birthDate;

    public UserEntity(Integer id, String name, Date birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "UserModel{" + "id=" + id + ", name='" + name + '\'' + ", birthDate=" + birthDate + '}';
    }
}
