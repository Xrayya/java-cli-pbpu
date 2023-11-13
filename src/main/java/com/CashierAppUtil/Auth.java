package com.CashierAppUtil;

import java.util.List;

import com.Model.Cashier;
import com.Model.Employee;
import com.Model.Manager;
import com.RecordUtil.Record;

/**
 * Auth
 */
public class Auth {
    public static Employee authenticate(String username, String password) {
        List<Employee> employees = new Record<Employee>("managers", Employee[].class).readRecordFile();
        for (Employee employee : employees) {
            if (employee.getUsername().equals(username) && employee.getPassword().equals(password)) {
                return new Manager(employee);
            }
        }

        employees = new Record<Employee>("cashiers", Employee[].class).readRecordFile();
        for (Employee employee : employees) {
            if (employee.getUsername().equals(username) && employee.getPassword().equals(password)) {
                return new Cashier(employee);
            }
        }
        return null;
    }
}
