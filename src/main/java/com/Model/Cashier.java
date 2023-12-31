package com.Model;

import java.util.UUID;

import com.CashierAppUtil.CashierMachine;

public class Cashier extends Employee {
    public Cashier(UUID employeeID, String name, String username, String password) {
        super(employeeID, name, username, password);
    }

    public Cashier(Employee employee) {
        super(employee);
    }

    @Override
    public CashierMachine getMachine() {
        return new CashierMachine();
    }
}
