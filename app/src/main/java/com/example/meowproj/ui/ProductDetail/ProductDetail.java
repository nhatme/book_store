package com.example.meowproj.ui.ProductDetail;

public class ProductDetail {
    private int imgResourceId, logoResourceId;
    private String title, description;
    private boolean isFavorite;
    private float review;

    public ProductDetail(int imgResourceId, int logoResourceId, String title, String description, boolean isFavorite, float review) {
        this.imgResourceId = imgResourceId;
        this.logoResourceId = logoResourceId;
        this.title = title;
        this.description = description;
        this.isFavorite = isFavorite;
        this.review = review;
    }

    public int getImgResourceId() {
        return imgResourceId;
    }

    public void setImgResourceId(int imgResourceId) {
        this.imgResourceId = imgResourceId;
    }

    public int getLogoResourceId() {
        return logoResourceId;
    }

    public void setLogoResourceId(int logoResourceId) {
        this.logoResourceId = logoResourceId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public float getReview() {
        return review;
    }

    public void setReview(float review) {
        this.review = review;
    }
}
