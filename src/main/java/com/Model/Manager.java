package com.Model;

import java.util.UUID;

import com.CashierAppUtil.CashierMachine;
import com.CashierAppUtil.ManagerMachine;

public class Manager extends Employee {
    public Manager(UUID employeeID, String name, String username, String password) {
        super(employeeID, name, username, password);
    }

    @Override
    public CashierMachine getMachine() {
        return new ManagerMachine();
    }
}
