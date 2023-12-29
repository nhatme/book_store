package com.example.meowproj.Model;

public class ItemBook {
    private int resourceId;
    private String title, price;

    public ItemBook(int resourceId, String title, String price) {
        this.resourceId = resourceId;
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
