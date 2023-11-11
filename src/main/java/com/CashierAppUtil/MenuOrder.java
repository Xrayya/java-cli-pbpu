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

    public int getTotalPrice() {
        // TODO: implement this method
        // Note: hitung total harga dari menuOrder ini berdasarkan menu yang dipilih dan
        // jumlahnya
        return 0;
    }
}
