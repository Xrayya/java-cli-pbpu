package com.CashierAppUtil;

import java.util.List;

import com.Model.Employee;

public class Auth {
    public final static String managerType = "manager";
    public final static String cashierType = "cashier";
    private static List<Employee> listEmployee;
    Auth(){
        
    }
    public Employee authentication(String username, String password) {
        for(Employee e : Auth.listEmployee){

        }
        return new Employee(null, username, username, password);
    }

    public CashierMachine authorization(String employeeType) {
        if (employeeType.equals(Auth.managerType)) {
            return new ManagerMachine();
        } else if (employeeType.equals(Auth.cashierType)) {
            return new CashierMachine();
        }
        return null;
    }
}
