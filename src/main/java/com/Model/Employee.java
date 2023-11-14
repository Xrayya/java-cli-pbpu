package com.Model;

import java.util.UUID;

import com.CashierAppUtil.CashierMachine;

/**
 * Employee
 */
public abstract class Employee extends EmployeeModel {

    public Employee(UUID employeeID, String name, String username, String password) {
        super(employeeID, name, username, password);
    }

    public Employee(EmployeeModel employee) {
        super(employee);
    }

    public abstract CashierMachine getMachine();
}
