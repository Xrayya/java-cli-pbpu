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
        List<Manager> managers = new Record<Manager>("managers", Manager[].class).readRecordFile();
        for (Manager manager : managers) {
            if (manager.getUsername().equals(username) && manager.getPassword().equals(password)) {
                return manager;
            }
        }

        List<Cashier> cashiers = new Record<Cashier>("cashiers", Cashier[].class).readRecordFile();
        for (Cashier cashier : cashiers) {
            if (cashier.getUsername().equals(username) && cashier.getPassword().equals(password)) {
                return cashier;
            }
        }
        return null;
    }
}
