package com.Model;

/**
 * FoodCategory
 */
public enum FoodCategory {
    Food("food"),
    Drink("drink");

    private String categoryName;

    private FoodCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return this.categoryName;
    }
}
