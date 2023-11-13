package com.CashierAppUtil;

/**
 * FoodCategory
 */
public enum FoodCategory {
    Makanan("food"),
    Minuman("drink");

    private String categoryName;

    private FoodCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return this.categoryName;
    }
}
