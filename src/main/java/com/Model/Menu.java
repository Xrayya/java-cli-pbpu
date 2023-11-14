package com.Model;

/**
 * Menu
 */
public class Menu {

    private String menuShortName;
    private String menuName;
    private FoodCategory foodCategory;
    private int price;

    public Menu(String menuShortName, String menuName, FoodCategory foodCategory, int price) {
        this.menuShortName = menuShortName;
        this.menuName = menuName;
        this.foodCategory = foodCategory;
        this.price = price;
    }

    public void setMenuShortName(String menuShortName) {
        this.menuShortName = menuShortName;
    }

    public String getMenuShortName() {
        return this.menuShortName;
    }

    public String getMenuName() {
        return this.menuName;
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
        s.append(String.format("%-15s : %s\n", "Short Name", this.menuShortName));
        s.append(String.format("%-15s : %s\n", "Menu Name", this.menuName));
        s.append(String.format("%-15s : %s\n", "Category", this.foodCategory.getCategoryName()));
        s.append(String.format("%-15s : %d\n", "Price", this.price));

        return s.toString();
    }
}
