package com.example.meowproj.ui.VendorDetail;

public class VendorsItem {
    private int resourceId, reviewStar, blackStarId, filledStarId;
    private String nameVendor;

    public VendorsItem(int resourceId, int reviewStar, int blackStarId, int filledStarId, String nameVendor) {
        this.resourceId = resourceId;
        this.reviewStar = reviewStar;
        this.blackStarId = blackStarId;
        this.filledStarId = filledStarId;
        this.nameVendor = nameVendor;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public int getReview() {
        return reviewStar;
    }

    public void setReview(int reviewStar) {
        this.reviewStar = reviewStar;
    }

    public int getBlackStarId() {
        return blackStarId;
    }

    public void setBlackStarId(int blackStarId) {
        this.blackStarId = blackStarId;
    }

    public int getFilledStarId() {
        return filledStarId;
    }

    public void setFilledStarId(int filledStarId) {
        this.filledStarId = filledStarId;
    }

    public String getNameVendor() {
        return nameVendor;
    }

    public void setNameVendor(String nameVendor) {
        this.nameVendor = nameVendor;
    }
}
