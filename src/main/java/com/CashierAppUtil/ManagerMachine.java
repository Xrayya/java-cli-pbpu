package com.CashierAppUtil;

import java.util.UUID;

/**
 * ManagerMachine
 */
public class ManagerMachine extends CashierMachine {
    
    /**
     * Add menu to menu list
     * @param menu menu to be added
     * @return `true` if menu succesfully added or `false` if not
     */
    public boolean addMenu(Menu menu) {
        return this.menus.add(menu);
    }

    /**
     * Remove menu from menu list
     * @param menu menu to be removed from the list
     * @return `true` if the specified menu found or `false` if not found
     */
    public boolean removeMenu(Menu menu) {
        return this.menus.remove(menu);
    }

    /**
     * Edit menu in the menu list
     * @param menuId menuId from menu that to be edited
     * @param menu edited menu
     * @return `true` if edit the specified menuId found or `false` if not found
     */
    public boolean editMenu(UUID menuId, Menu menu) {
        for(int i = 0; i < this.menus.size(); i++) {
            if(menuId == this.menus.get(i).getMenuId()) {
                this.menus.set(i, menu);
                return true;
            }
        }

        return false;
    }
}
