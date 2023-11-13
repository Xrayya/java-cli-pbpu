package com.CashierAppUtil;

import java.util.ArrayList;
import java.util.List;

import com.RecordUtil.Log;
import com.RecordUtil.Record;

/**
 * ManagerMachine
 */
public class ManagerMachine extends CashierMachine {

    public List<Order> getOrderRecord() {
        List<Order> orderRecord = new ArrayList<>();
        orderRecord.addAll(new Record<Order>("orders", Order[].class).readRecordFile());
        return orderRecord;
    }

    /**
     * Add menu to menu list
     * 
     * @param menu menu to be added
     * @return `true` if menu succesfully added or `false` if not
     */
    public boolean addMenu(Menu menu) {
        new Log<Menu>("menus", Menu[].class).appendRecord(this.menus);
        return this.menus.add(menu);
    }

    /**
     * Remove menu from menu list
     * 
     * @param menu menu to be removed from the list
     * @return `true` if the specified menu found or `false` if not found
     */
    public boolean removeMenu(String menuShortName) {
        for (Menu menu : menus) {
            if (menu.getMenuShortName().equals(menuShortName)) {
                this.menus.remove(menu);
                new Log<Menu>("menus", Menu[].class).appendRecord(this.menus);
                return true;
            }
        }

        return false;
    }

    /**
     * Edit menu in the menu list
     * 
     * @param menuShortName menuId from menu that to be edited
     * @param menu          edited menu
     * @return `true` if edit the specified menuId found or `false` if not found
     */
    public boolean editMenu(String menuShortName, Menu menu) {
        for (int i = 0; i < this.menus.size(); i++) {
            if (menuShortName == this.menus.get(i).getMenuShortName()) {
                this.menus.set(i, menu);
                new Log<Menu>("menus", Menu[].class).appendRecord(this.menus);
                return true;
            }
        }

        return false;
    }
}
