package com.example.meowproj.Model;

import java.util.List;

public class CategoryViewHome {
    private List<ItemBook> itemBookList;
    private List<Vendor> vendorList;
    private List<Author> authorList;

    public CategoryViewHome(List<ItemBook> itemBookList, List<Vendor> vendorList, List<Author> authorList) {
        this.itemBookList = itemBookList;
        this.vendorList = vendorList;
        this.authorList = authorList;
    }

    public List<ItemBook> getTopWeekList() {
        return itemBookList;
    }

    public void setTopWeekList(List<ItemBook> itemBookList) {
        this.itemBookList = itemBookList;
    }

    public List<Vendor> getVendorList() {
        return vendorList;
    }

    public void setVendorList(List<Vendor> vendorList) {
        this.vendorList = vendorList;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }
}

