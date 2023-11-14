package com.Model;

import java.util.UUID;

public class EmployeeModel {
    private UUID employeeID;
    private String name;
    private String username;
    private String password;

    public EmployeeModel(UUID employeeID, String name, String username, String password) {
        this.employeeID = employeeID;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public EmployeeModel(EmployeeModel employee) {
        this.employeeID = employee.getEmployeeID();
        this.name = employee.getName();
        this.username = employee.getUsername();
        this.password = employee.getPassword();
    }

    public UUID getEmployeeID() {
        return this.employeeID;
    }

    public String getName() {
        return this.name;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
}
