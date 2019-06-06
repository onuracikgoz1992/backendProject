package com.example.project;

import java.util.HashMap;

public class User {
    private String name="";
    private String surname="";
    private String password="";
    private String email="";
    private ItemList itemList=new ItemList();

    User(String name, String surname, String password){
        this.name=name;
        this.surname=surname;
        this.password=password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return email;
    }

    public void setId(String id) {
        this.email = id;
    }

    public ItemList getItemList() {
        return itemList;
    }

    public void setItemList(ItemList itemList) {
        this.itemList = itemList;
    }
}
