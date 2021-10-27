package com.example.shoppinglistwebsite;

public class ItemObj {
    public String item;
    public String quantity;
    public String fname;
    public String lname;

    public ItemObj(String item, String quantity, String fname, String lname) {
        this.item = item;
        this.quantity = quantity;
        this.fname = fname;
        this.lname = lname;
    }

    public String getItem() {
        return item;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }
}
