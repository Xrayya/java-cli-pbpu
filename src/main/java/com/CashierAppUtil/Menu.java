package com.CashierAppUtil;

import java.util.UUID;

/**
 * Menu
 */
public class Menu {

    private UUID menuId;
    private String menuName;
    private FoodCategory foodCategory;
    private int price;

    public Menu(UUID menuId, String menuName, FoodCategory foodCategory, int price) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.foodCategory = foodCategory;
        this.price = price;
    }

    public UUID getMenuId() {
        return menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public FoodCategory getFoodCategory() {
        return foodCategory;
    }

    public void setFoodCategory(FoodCategory foodCategory) {
        this.foodCategory = foodCategory;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(String.format("%-15 : %s\n", "Short Name", this.menuShortName));
        s.append(String.format("%-15 : %s\n", "Menu Name", this.menuName));
        s.append(String.format("%-15 : %s\n", "Category", this.foodCategory.getCategoryName()));
        s.append(String.format("%-15 : %d\n", "Price", this.price));

        return s.toString();
    }
}
