package com.example.meowproj.Model;

import java.util.List;

public class Category {

    private List<Item> itemList;

    public Category(List<Item> itemList) {
        this.itemList = itemList;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}
