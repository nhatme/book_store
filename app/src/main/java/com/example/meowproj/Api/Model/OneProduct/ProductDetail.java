package com.example.meowproj.Api.Model.OneProduct;

public class ProductDetail {
    private String name;
    private float price;
    private ImageProduct imageProduct;
    private String description;
    private int review;
    private int favorite;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public ImageProduct getImageProduct() {
        return imageProduct;
    }

    public void setImageProduct(ImageProduct imageProduct) {
        this.imageProduct = imageProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getReview() {
        return review;
    }

    public void setReview(int review) {
        this.review = review;
    }

    public int getFavorite() {
        return favorite;
    }

    public void setFavorite(int favorite) {
        this.favorite = favorite;
    }
}
