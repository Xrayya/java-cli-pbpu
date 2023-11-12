package com.CashierAppUtil;

import java.util.UUID;

/**
 * ManagerMachine
 */
public class ManagerMachine extends CashierMachine {
    
    /**
     * Add menu to menu list
     * @param menu menu to be added
     */
    public void addMenu(Menu menu) {
        // TODO: implement this method
        // NOTE: manipulasi object menus pada class ini untuk menambahkan menu dari
        // parameter method ini
        this.menus.add(menu);
        System.out.println("Berhasil menambahkan menu");
    }

    /**
     * Remove menu from menu list
     * @param menu menu to be removed from the list
     */
    public void removeMenu(Menu menu) {
        // TODO: implement this method
        // NOTE: manipulasi object menus pada class ini untuk menghapus menu dari
        // parameter method ini
        for(int i = 0; i < this.menus.size(); i++) {
            if(menu.getMenuId() == this.menus.get(i).getMenuId()) {
                this.menus.remove(i);
                System.out.println("Berhasil menghapus menu yang dipilih");
                return;
            }
        }
        System.out.println("Menu yang kamu masukkan tidak terdaftar!");
    }

    /**
     * Edit menu in the menu list
     * @param menuId menuId from menu that to be edited
     * @param menu edited menu
     */
    public void editMenu(UUID menuId, Menu menu) {
        // TODO: implement this method
        // NOTE: manipulasi object menus pada class ini untuk mengedit menu dengan menuId dari
        // parameter method ini kemudian ubah isinya sesuai dengan menu pada parameter kedua
        for(int i = 0; i < this.menus.size(); i++) {
            if(menuId == this.menus.get(i).getMenuId()) {
                this.menus.set(i, menu);
                System.out.println("Berhasil mengedit menu yang dipilih");
                return;
            }
        }
        System.out.println("Menu yang kamu pilih tidak terdaftar!");
    }
}
