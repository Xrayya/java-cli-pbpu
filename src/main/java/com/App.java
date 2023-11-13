package com;

import javax.swing.*;
import java.io.Console;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        String username, password;
        Scanner sc = new Scanner(System.in);
        int input = -1, input2 = -1;
        while (input != 0 && input2 != 0) {
        System.out.print("Username: ");
        username = sc.nextLine();
        System.out.print("Password: ");
        password = sc.nextLine();
        input2 = -1;

            while (input2 != 0 && input2 != 4) {
                String choice = "===Cashier App===\n" +
                        "1. Create Order\n" +
                        "2. Read Orders\n" +
                        "3. Edit Orders\n" +
                        "4. Log Out\n" +
                        "0. Exit\n" +
                        "Select: ";
                System.out.println(choice);
                input2 = Integer.parseInt(sc.nextLine());
                System.out.println(input2);

                switch (input2) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                }
            }
        }
    }
}
