package com.CashierAppUtil;

import java.util.List;

import com.Model.Cashier;
import com.Model.Employee;
import com.Model.Manager;
import com.RecordUtil.Record;

public class Auth {
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

    public CashierMachine authorization(Employee employeeType) {
        if (employeeType instanceof Manager) {
            return new ManagerMachine();
        } else if (employeeType instanceof Cashier) {
            return new CashierMachine();
        }
        return null;
    }
}
