package com.CashierAppUtil;

import java.util.List;
import java.util.UUID;

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
        // TODO: implement this method
        // NOTE: gunakan class `Record` untuk membaca record, kemudian format data yang
        // didapat menjadi list menu yang human-readable lalu cetak ke terminal
    }

    /**
     * Add new order
     * @param order new order to be added
     */
    public void addOrder(Order order) {
        // TODO: implement this method
        // NOTE: manipulasi object orders di class ini sehingga bisa menambahkan order
        // dari parameter method ini
    }

    /**
     * Remove one order
     * @param order order to be removed from the list of orders
     */
    public void removeOrder(Order order) {
        // TODO: implement this method
        // NOTE: manipulasi object orders di class ini sehingga bisa menghapus order
        // dari parameter method ini
    }

    /**
     * Edit existing order
     * @param orderId orderId from the order that to be edited
     * @param order edited order
     */
    public void editOrder(UUID orderId, Order order) {
        // TODO: implement this method
        // NOTE: manipulasi object orders di class ini sehingga mengubah object order
        // dengan orderId sesuai parameter lalu
    }

    /**
     * Print struct of order
     * @param order order to be printed in struct
     */
    public void printStruct(Order order) {
        // TODO: implement this method
        // NOTE: cetak struk berdasarkan data order dari parameter
    }

    /**
     * Save the current order list to the record file
     */
    public void saveToRecord() {
        // TODO: implement this method
        // NOTE: gunakan class `Log` untuk menyimpan data orders ke record
    }
}
