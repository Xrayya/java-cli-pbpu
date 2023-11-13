package com.CashierAppUtil;

import java.util.List;
import java.util.UUID;

import com.Model.Employee;

/**
 * Order
 */
public class Order {

    private UUID orderId;
    private List<MenuOrder> menuOrders;
    private String customerName;
    private int customerMoney;
    private int customerChange;
    private Employee employee;
    private int totalPrice;
    private int tableNumber;
    private boolean done = false;

    public Order(List<MenuOrder> menuOrders, String customerName, int customerMoney, Employee employee, int tableNumber) {
        this.orderId = UUID.randomUUID();
        this.menuOrders = menuOrders;
        this.customerName = customerName;
        this.customerMoney = customerMoney;
        this.employee = employee;
        this.tableNumber = tableNumber;
    }

    public int getTotalPrice() {
        totalPrice = 0;
        if (!menuOrders.isEmpty()){
            for (MenuOrder menuOrder : menuOrders) {
                totalPrice += menuOrder.getSubTotal();
            }
        }
        return totalPrice;
    }

    public UUID getOrderId() {
        return orderId;
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

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(String.format("%-15 : %s\n", "Order ID", this.orderId));
        s.append(String.format("%-15 : %s\n", "Customer Name", this.customerName));
        s.append(String.format("%-15 : %s\n", "Employee Name", this.employee.getName()));
        s.append("Selected Menu: \n");
        for (MenuOrder menuOrder : menuOrders) {
            s.append("-".repeat(50)).append('\n');
            s.append(menuOrder.toString());
        }
        s.append('\n');
        s.append(String.format("%-15 : %s\n", "Total Price", this.getTotalPrice()));
        s.append(String.format("%-15 : %s\n", "Cash", this.customerMoney));
        s.append(String.format("%-15 : %s\n", "Change", this.customerChange));

        return s.toString();
    }
}
