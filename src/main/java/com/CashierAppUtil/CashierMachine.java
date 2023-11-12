package com.CashierAppUtil;

import java.util.List;
import java.util.UUID;

import com.RecordUtil.Log;

/**
 * Cashier
 */
public class CashierMachine {

    private List<Order> orders;
    protected List<Menu> menus;

    /**
     * Print all menu in the record
     */
    public void printMenu() {
        checkNull(this.menus);
        System.out.printf("%-20s %s\n", "NAMA MENU", "HARGA");
        for (Menu m : this.menus) {
            System.out.printf("%-20s %s\n", m.getMenuName(), m.getPrice());
        }
    }

    /**
     * Add new order
     * 
     * @param order new order to be added
     */
    public void addOrder(Order order) {
        checkNull(order);
        this.orders.add(order);
        System.out.println("Order berhasil ditambahkan");
    }

    private void checkNull(Object o) throws NullPointerException {
        if (o == null) {
            throw new NullPointerException("Object tidak boleh null");
        }
    }

    /**
     * Remove one order
     * 
     * @param order order to be removed from the list of orders
     */
    public void removeOrder(UUID ordeUuid) {
        checkNull(ordeUuid);
        int indexFound = findOrder(ordeUuid);
        if (indexFound == -1) {
            System.out.println("Order tidak ditemukan");
        } else {
            this.orders.remove(indexFound);
            System.out.println("Order berhasil dihapus");
        }
    }

    /**
     * Edit existing order
     * 
     * @param orderId orderId from the order that to be edited
     * @param order   edited order
     */
    public void editOrder(UUID orderId, Order order) {
        int indexFound = findOrder(orderId);
        if (indexFound == -1) {
            System.out.println("Order tidak ditemukan");
        } else {
            this.orders.set(indexFound, order);
            System.out.println("Order telah diupdate");
        }

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
