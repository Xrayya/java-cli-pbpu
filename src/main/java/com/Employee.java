package com;

import java.util.UUID;

public class Employee {
    private UUID employeeID;
    private String name;
    private String username;
    private String password;

    public Employee(UUID employeeID, String name, String username, String password) {
        this.employeeID = employeeID;
        this.name = name;
        this.username = username;
    }

    public UUID getEmployeeID() {
        return employeeID;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }
}
