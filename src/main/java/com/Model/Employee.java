package com.Model;

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
        this.password = password;
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
