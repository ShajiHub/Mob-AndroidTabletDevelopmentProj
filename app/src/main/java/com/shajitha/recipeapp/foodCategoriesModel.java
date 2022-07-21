package com.shajitha.recipeapp;

public class foodCategoriesModel {
    String categoryName;
    int image;


    public foodCategoriesModel(String categoryName, int image) {
        this.categoryName = categoryName;
        this.image = image;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public int getImage() {
        return image;
    }
}
