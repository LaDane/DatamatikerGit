package com.example.shoppinglistwebsite;

import java.util.ArrayList;
import java.util.List;

public class Users {
    public String fname;
    public String lname;
    List<ItemObj> usersItems;

    public Users(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
        usersItems = new ArrayList<>();
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public List<ItemObj> getUsersItems() {
        return usersItems;
    }
}
