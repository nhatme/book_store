package com.example.meowproj.Model;

public class Item {
    private int resourceId;
    private String title, price;

    public Item(int itemId, String title, String price) {
        this.resourceId = itemId;
        this.title = title;
        this.price = price;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
