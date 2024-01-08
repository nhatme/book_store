package com.example.meowproj.Model;
public class Author {
    private int resourceId;
    private String author_name, author_Occup, description;

    public Author(int resourceId, String author_name, String author_Occup, String description) {
        this.resourceId = resourceId;
        this.author_name = author_name;
        this.author_Occup = author_Occup;
        this.description = description;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getAuthor_Occup() {
        return author_Occup;
    }

    public void setAuthor_Occup(String author_Occup) {
        this.author_Occup = author_Occup;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
