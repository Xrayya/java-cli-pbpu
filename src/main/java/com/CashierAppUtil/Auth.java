package com.CashierAppUtil;

import java.util.List;

import com.Model.Employee;
import com.RecordUtil.Record;

public class Auth {
    public final static String managerType = "manager";
    public final static String cashierType = "cashier";
    private static List<Employee> listEmployee;
    private Record<Employee> recordEmployee = new Record<>("employee", Employee[].class);

    Auth() {
        Auth.listEmployee = recordEmployee.readRecordFile();
    }

    public Employee authentication(String username, String password) {
        for (Employee e : Auth.listEmployee) {
            if(e.getUsername().equals(username) && e.getPassword().equals(password)){
                return e;
            }
        }
        return null;
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
