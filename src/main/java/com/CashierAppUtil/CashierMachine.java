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
        // ?? Field yang di print apa saja
        // NOTE: gunakan class `Record` untuk membaca record, kemudian format data yang
        // didapat menjadi list menu yang human-readable lalu cetak ke terminal
        checkNull(this.menus);
        for (Menu m : this.menus) {
            // TODO: Print all menu here
            System.out.println(m);
        }
    }

    /**
     * Add new order
     * 
     * @param order new order to be added
     */
    public void addOrder(Order order) {
        // NOTE: manipulasi object orders di class ini sehingga bisa menambahkan order
        // dari parameter method ini
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
    public void removeOrder(Order order, UUID ordeUuid) {
        // ?? Remove order berdasarkan Id?
        // NOTE: manipulasi object orders di class ini sehingga bisa menghapus order
        // dari parameter method ini
        checkNull(ordeUuid);
        checkNull(order);
        int indexFound = findOrder(ordeUuid);
        if (indexFound == -1) {
            System.out.println("Order tidak ditemukan");
        } else {
            this.orders.remove(indexFound);
        }
    }

    /**
     * Edit existing order
     * 
     * @param orderId orderId from the order that to be edited
     * @param order   edited order
     */
    public void editOrder(UUID orderId, Order order) {
        // ?? Field yang bisa diupdate apa saja?
        // NOTE: manipulasi object orders di class ini sehingga mengubah object order
        // dengan orderId sesuai parameter lalu
        int indexFound = findOrder(orderId);
        if (indexFound == -1) {
            System.out.println("Order tidak ditemukan");
        } else {
            // TODO: edit order disini
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
        // ?? print struk butuh field apa saja
        // NOTE: cetak struk berdasarkan data order dari parameter
        checkNull(order);
    }

    /**
     * Save the current order list to the record file
     */
    public void saveToRecord() {
        // NOTE: gunakan class `Log` untuk menyimpan data orders ke record
        checkNull(this.orders);
    }
}
