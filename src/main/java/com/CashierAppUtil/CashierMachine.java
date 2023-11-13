package com.CashierAppUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.RecordUtil.Log;
import com.RecordUtil.Record;

/**
 * Cashier
 */
public class CashierMachine {

    private List<Order> orders;
    protected List<Menu> menus;

    public CashierMachine() {
        this.menus = new ArrayList<>();
        this.synchronizeMenu();
        this.orders = new ArrayList<>();
    }

    /**
     * Print all menu in the record
     */
    public void printMenu() {
        for (Menu menu : this.menus) {
            System.out.println("-".repeat(50));
            System.out.println(menu.toString());
        }
        System.out.println("-".repeat(50));
    }

    public List<Menu> getAllMenu() {
        return this.menus;
    }

    /**
     * Add new order
     * 
     * @param order new order to be added
     */
    public boolean addOrder(Order order) {
        if (checkNull(order)) {
            return false;
        }
        this.orders.add(order);
        return true;
    }

    private boolean checkNull(Object o) {
        return o == null;
    }

    /**
     * Remove one order
     * 
     * @param order order to be removed from the list of orders
     */
    public boolean removeOrder(UUID orderId) {
        if (checkNull(orderId)) {
            return false;
        }
        int findOrder = findOrder(orderId);
        if (findOrder == -1) {
            return false;
        }
        this.orders.remove(findOrder);
        return true;
    }

    /**
     * Edit existing order
     * 
     * @param orderId orderId from the order that to be edited
     * @param order   edited order
     */
    public boolean editOrder(UUID orderId, Order order) {
        int indexFound = findOrder(orderId);
        if (indexFound == -1) {
            return false;
        }
        this.orders.set(indexFound, order);
        return true;
    }

    public int findOrder(UUID orderId) {
        for (int i = 0; i < this.orders.size(); i++) {
            if (this.orders.get(i).getOrderId().equals(orderId)) {
                return i;
            }
        }
        return -1;
    }

    public List<Order> getUnfinishedOrders() {
        List<Order> orders = new ArrayList<>();
        for (Order order : this.orders) {
            if (!order.isDone()) {
                orders.add(order);
            }
        }

        return orders;
    }

    public List<Order> getFinishedOrders() {
        List<Order> orders = new ArrayList<>();
        for (Order order : this.orders) {
            if (order.isDone()) {
                orders.add(order);
            }
        }

        return orders;
    }

    public List<Order> getOrders() {
        return this.orders;
    }

    /**
     * Print struct of order
     * 
     * @param order order to be printed in struct
     */
    public void printStruct(Order order) {
        // checkNull(order);
        // System.out.printf("%-20s %-20s %s\n", "ORDER ID", "TABLE NUMBER", "TOTAL PRICE");
        // System.out.printf("%-20s %-20s %s\n", order.getOrderID(), order.getTableNumber(), order.getTotalPrice());
        // System.out.println("====================== ORDERS =======================");
        // System.out.printf("%-20s %-20s %-20s %s\n", "MENU NAME", "PRICE", "QUANTITY", "TOTAL PRICE");
        // for (MenuOrder mo : order.getMenuOrders()) {
        //     System.out.printf("%-20s %-20s %s\n", mo.getMenu().getMenuName(), mo.getMenu().getPrice(), mo.getQuantity(),
        //             mo.getTotalPrice());
        // }
        System.out.println(order.toString());
    }

    /**
     * Save the current order list to the record file
     */
    public boolean saveToRecord() {
        Log<Order> orderLog = new Log<>("orders", Order[].class);
        return orderLog.appendRecord(this.orders);
    }

    public void synchronizeMenu() {
        this.menus.addAll(new Record<Menu>("menus", Menu[].class).readRecordFile());
    }
}
