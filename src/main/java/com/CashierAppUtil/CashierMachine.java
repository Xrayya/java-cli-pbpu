package com.CashierAppUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.RecordUtil.Record;

/**
 * Cashier
 */
public class CashierMachine {

    private List<Order> orders;
    protected List<Menu> menus;

    public CashierMachine() {
        Record<Menu> menuRecord = new Record<>("menus");
        this.menus = menuRecord.readRecordFile();
        this.orders = new ArrayList<>();
    }

    /**
     * Print all menu in the record
     */
    public void printMenu() {
        for (Menu m : this.menus) {
            System.out.printf("%-20s %s\n", m.getMenuName(), m.getPrice());
        }
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
        System.out.println("Order berhasil ditambahkan");
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
    public boolean removeOrder(UUID ordeUuid) {
        if (checkNull(ordeUuid)) {
            return false;
        }
        int findOrder = findOrder(ordeUuid);
        if (findOrder == -1) {
            System.out.println("Order tidak ditemukan");
            return false;
        }
        this.orders.remove(findOrder);
        System.out.println("Order berhasil dihapus");
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
            System.out.println("Order tidak ditemukan");
            return false;
        }
        this.orders.set(indexFound, order);
        System.out.println("Order berhasil diupdate");
        return true;
    }

    private int findOrder(UUID ordeUuid) {
        for (int i = 0; i < this.orders.size(); i++) {
            if (this.orders.get(i).getOrderID().equals(ordeUuid)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Print struct of order
     * 
     * @param order order to be printed in struct
     */
    public void printStruct(Order order) {
        checkNull(order);
        System.out.printf("%-20s %-20s %s\n", "ORDER ID", "TABLE NUMBER", "TOTAL PRICE");
        System.out.printf("%-20s %-20s %s\n", order.getOrderID(), order.getTableNumber(), order.getTotalPrice());
        System.out.println("====================== ORDERS =======================");
        System.out.printf("%-20s %-20s %-20s %s\n", "MENU NAME", "PRICE", "QUANTITY", "TOTAL PRICE");
        for (MenuOrder mo : order.getMenuOrders()) {
            System.out.printf("%-20s %-20s %s\n", mo.getMenu().getMenuName(), mo.getMenu().getPrice(), mo.getQuantity(),
                    mo.getTotalPrice());
        }

    }

    /**
     * Save the current order list to the record file
     */
    public void saveToRecord() {
        // NOTE: gunakan class `Log` untuk menyimpan data orders ke record
        checkNull(this.orders);
        // TODO: write record
    }
}
