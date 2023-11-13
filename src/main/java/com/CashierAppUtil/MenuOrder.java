package com.CashierAppUtil;

/**
 * MenuOrder
 */
public class MenuOrder {
    private Menu menu;
    private int quantity;

    public MenuOrder(Menu menu, int quantity) {
        this.menu = menu;
        this.quantity = quantity;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSubTotal() {
        if(menu.equals(null)){
            return 0;
        }

        return menu.getPrice() * quantity;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(menu.toString());
        s.append(String.format("%-15 : %s\n", "Quantity", this.quantity));
        s.append(String.format("%-15 : %s\n", "Sub Total Price", this.getSubTotal()));

        return s.toString();
    }
}
