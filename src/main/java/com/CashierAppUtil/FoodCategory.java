package com.CashierAppUtil;

/**
 * FoodCategory
 */
public enum FoodCategory {
    Makanan("makanan"),
    Minuman("minuman");

    private String categoryName;

    private FoodCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

}
