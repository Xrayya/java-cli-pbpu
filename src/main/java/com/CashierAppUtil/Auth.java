package com.CashierAppUtil;

import java.util.List;

import com.Model.Cashier;
import com.Model.Employee;
import com.RecordUtil.Record;

/**
 * Auth
 */
public class Auth {
    private static final List<Employee> employeesRecord = new Record<Employee>("employees", Employee[].class).readRecordFile();
    public static Employee authenticate(String username, String password) {
        for (Employee employee : employeesRecord) {
            if (employee.getUsername().equals(username) && employee.getPassword().equals(password)) {
                return employee;
            }
        }
        return null;
    }
}
