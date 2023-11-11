package com.CashierAppUtil;

import java.util.List;
import java.util.UUID;

/**
 * Order
 */
public class Order {

    private UUID orderID;
    private List<MenuOrder> menuOrders;
    private String customerName;
    private int customerMoney;
    private int customerChange;
    private int totalPrice;
    private int tableNumber;
    private boolean done = false;

    public Order(UUID orderID, List<MenuOrder> menuOrders, String customerName, int customerMoney, int tableNumber) {
        this.orderID = orderID;
        this.menuOrders = menuOrders;
        this.customerName = customerName;
        this.customerMoney = customerMoney;
        this.tableNumber = tableNumber;
    }

    public int getTotalPrice() {
        // TODO: implement this method
        // NOTE: hitung total harga dari order ini berdasarkan list menuOrder
        int totalPrice = 0;

        return this.totalPrice = totalPrice;
    }

    public UUID getOrderID() {
        return orderID;
    }

    public List<MenuOrder> getMenuOrders() {
        return menuOrders;
    }

    public void setMenuOrders(List<MenuOrder> menuOrders) {
        this.menuOrders = menuOrders;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public void setOrderID(UUID orderID) {
        this.orderID = orderID;
    }

    public int getCustomerMoney() {
        return customerMoney;
    }

    public void setCustomerMoney(int customerMoney) {
        this.customerMoney = customerMoney;
    }

    public int getCustomerChange() {
        return customerChange;
    }

    public void setCustomerChange(int customerChange) {
        this.customerChange = customerChange;
    }
}
