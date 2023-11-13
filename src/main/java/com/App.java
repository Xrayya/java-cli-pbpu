package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import com.CashierAppUtil.Auth;
import com.CashierAppUtil.CashierMachine;
import com.CashierAppUtil.MenuOrder;
import com.CashierAppUtil.FoodCategory;
import com.CashierAppUtil.ManagerMachine;
import com.CashierAppUtil.Menu;
import com.CashierAppUtil.Order;
import com.Model.Employee;
import com.Model.Manager;

/**
 * Hello world!
 *
 */
public class App {
    private static final Scanner input = new Scanner(System.in);
    private static Employee employee;
    private static CashierMachine cashierMachine;

    public static void main(String[] args) {
        while (true) {
            login();
            runMainLoop();
        }
    }

    private static void runMainLoop() {
        while (true) {
            printMainMenu();
            if (employee instanceof Manager) {
                printManagerAdditionalMainMenu();
            }
            printExitMenus();

            System.out.print("Enter the number: ");
            String inputNumber = input.nextLine();

            switch (inputNumber) {
                case "1":
                    printAllMenu();
                    break;
                case "2":
                    takeOrder();
                    break;
                case "3":
                    markOrderComplete();
                    break;
                case "4":
                    editUnfinishedOrder();
                    break;
                case "5":
                    cancelUnfinishedOrder();
                    break;
                case "6":
                    printUnfinishedOrders();
                    break;
                case "7":
                    printNewFinishedOrders();
                    break;
                case "8":
                    printAllOrderNewOrders();
                    break;
                case "9":
                    saveOrderToRecord();
                    break;
                case "0":
                    logout();
                    break;
                case "00":
                    exit();
                    break;
                default:
                    if (employee instanceof Manager) {
                        switch (inputNumber) {
                            case "10":
                                printOrderRecord();
                                break;
                            case "11":
                                addMenu();
                                break;
                            case "12":
                                removeMenu();
                                break;
                            case "13":
                                editMenu();
                                break;
                        }
                    } else {
                        System.out.println("Sorry, your input is not recognized, please input valid number");
                    }
                    break;
            }
        }
    }

    private static void printMainMenu() {
        printBoldSeparator();
        System.out.println("Cashier App");
        printBoldSeparator();
        System.out.println("1. Print All Menu");
        System.out.println("2. Take Order");
        System.out.println("3. Mark Order Done");
        System.out.println("4. Edit Unfinished Order");
        System.out.println("5. Cancel Unfinished Order"); // not mvp
        System.out.println("6. Print Unfinished Orders"); // not mvp
        System.out.println("7. Print New Finished Orders"); // not mvp
        System.out.println("8. Print All new Orders");
        System.out.println("9. Save Order to Record"); // tiap take order, not mvp
    }

    private static void printManagerAdditionalMainMenu() {
        System.out.println("10. Print Order Record"); // not mvp
        System.out.println("11. Add Menu");
        System.out.println("12. Remove Menu");
        System.out.println("13. Edit Menu");
    }

    private static void printExitMenus() {
        System.out.println("0. Logout"); // buat keluar loop
        System.out.println("00. Exit");
    }

    private static void login() {
        while (employee == null) {
            System.out.print("Enter username: ");
            String username = input.nextLine();
            System.out.print("Enter password: ");
            String password = input.nextLine();
            employee = Auth.authenticate(username, password);
        }
    }

    private static void logout() {
        employee = null;
        cashierMachine = null;
    }

    private static void exit() {
        System.exit(0);
    }

    private static void printAllMenu() {
        if (cashierMachine == null) {
            return;
        }
        cashierMachine.printMenu();
    }

    private static void takeOrder() {
        List<MenuOrder> menuOrderedByCustomer = new ArrayList<>();
        boolean validate = true;
        boolean doesMenuExist = false;

        // Header
        printBoldSeparator();
        System.out.println("Add Customer Orders");
        printBoldSeparator();
        cashierMachine.printMenu();
        printtThinSeparator();

        // Customer
        System.out.print("Input customer name: ");
        String customerName = input.nextLine();
        System.out.print("Input customer total money: ");
        int customerMoney = input.nextInt();
        System.out.print("Input customer table: ");
        int customerTable = input.nextInt();
        printtThinSeparator();

        // Penambahan order
        do {
            System.out.print("Input short menu name: ");
            String menuShortName = input.nextLine();
            System.out.print("Input the Quantity: ");
            int totalMenuOrdered = input.nextInt();

            for (int i = 0; i < cashierMachine.getAllMenu().size(); i++) {
                if (menuShortName == cashierMachine.getAllMenu().get(i).getMenuShortName()) {
                    menuOrderedByCustomer.add(new MenuOrder(cashierMachine.getAllMenu().get(i), totalMenuOrdered));
                    doesMenuExist = true;
                    break;
                }
            }

            if (doesMenuExist == false) {
                System.out.println("The menu doesn't exist, please input again!");
                continue;
            }

            System.out.print("do you want to add order again? (y/t)");
            String lanjut = input.nextLine();

            if (lanjut.equals('t')) {
                validate = false;
            }
            printtThinSeparator();
        } while (validate);

        // Buat objek order
        Order order = new Order(menuOrderedByCustomer, customerName, customerMoney, employee, customerTable);
        cashierMachine.addOrder(order);
    }

    private static void markOrderComplete() {

        boolean validate = false;
        int findOrder = 0;

        do {
            System.out.print("Input finished order ID: ");
            String uuid = input.nextLine();
            findOrder = cashierMachine.findOrder(UUID.fromString(uuid));

            if (findOrder == -1) {
                validate = true;
                System.out.println("Wrong ID!, please input ID again!");
            }

        } while (validate);

        cashierMachine.getOrders().get(findOrder).setDone(true);
    }

    private static void editUnfinishedOrder() {
        // TODO
        List<Order> unfinishedOrders = cashierMachine.getUnfinishedOrders();
        for (int i = 0; i < unfinishedOrders.size(); i++) {
            System.out.println((i+1) + " " +
                    unfinishedOrders.get(i).getOrderId() + " " +
                    unfinishedOrders.get(i).getCustomerName() + " " +
                    unfinishedOrders.get(i).getTotalPrice() + " " +
                    unfinishedOrders.get(i).getTableNumber());
        }
        System.out.printf("Select unfinished order to edit (1 to %d)", unfinishedOrders.size());
        int unfinishedOrderNum = Integer.parseInt(input.nextLine());
        if (unfinishedOrderNum > unfinishedOrders.size()) return;
        Order unfinishedOrder = unfinishedOrders.get(unfinishedOrderNum-1);
        System.out.println(unfinishedOrder.toString());
        System.out.println("Select field to edit 1. Menu Order\n" +
                "2. Customer Name\n" +
                "3. Table Number\n" +
                "4. Order Status\n");
        int editChoice = Integer.parseInt(input.nextLine());

        switch (editChoice) {
            case 1:

                break;
            case 2:
                System.out.printf("Old customer name: %s\n", unfinishedOrder.getCustomerName());
                System.out.println("New customer name: ");
                unfinishedOrder.setCustomerName(input.nextLine());
                break;
            case 3:
                System.out.printf("Old table number: %d\n", unfinishedOrder.getTableNumber());
                System.out.println("New table number: ");
                unfinishedOrder.setTableNumber(Integer.parseInt(input.nextLine()));
                break;
            case 4:
                System.out.println("Change order status to done? (Y/n)");
                String case4Choice = input.nextLine();
                if (case4Choice.equals("Y") || case4Choice.equals("y") || case4Choice.equals("")) {
                    unfinishedOrder.setDone(true);
                }
                break;
        }

    }

    private static void cancelUnfinishedOrder() {
        // WARNING: not mvp
    }

    private static void printUnfinishedOrders() {
        // WARNING: not mvp
    }

    private static void printNewFinishedOrders() {
        // WARNING: not mvp
    }

    private static void printAllOrderNewOrders() {
        List<Order> newOrderList = new ArrayList<>();
        newOrderList.addAll(cashierMachine.getUnfinishedOrders());
        newOrderList.addAll(cashierMachine.getFinishedOrders());

        printtThinSeparator();
        System.out.println("All new Orders: ");
        printtThinSeparator();
        for (Order order : newOrderList) {
            System.out.println(order.toString());
        }
    }

    private static void saveOrderToRecord() {
        // WARNING: not mvp
    }

    private static void printOrderRecord() {
        // WARNING: not mvp
    }

    private static void addMenu() {
        if (cashierMachine == null) {
            return;
        }

        System.out.println("Enter new menu name");
        String menuName = input.nextLine();
        System.out.println("Enter new menu shortname");
        String menuShortName = input.nextLine();
        System.out.printf("1. Food\n2. Drink\nEnter category for %s (1 or 2)\n", menuShortName);
        int foodCatInt = Integer.parseInt(input.nextLine());
        System.out.printf("Enter price for %s\n", menuShortName);
        int newMenuPrice = Integer.parseInt(input.nextLine());

        FoodCategory newMenuFoodCat;
        if (foodCatInt == 1) {
            newMenuFoodCat = FoodCategory.Food;
        } else if (foodCatInt == 2) {
            newMenuFoodCat = FoodCategory.Drink;
        } else {
            newMenuFoodCat = FoodCategory.Food;
        }

        ManagerMachine mc = (ManagerMachine) cashierMachine;
        boolean isAdded = mc.addMenu(
                new Menu(menuShortName, menuName, newMenuFoodCat, newMenuPrice)
        );

        if (isAdded) {
            System.out.println("New menu is successfully added");
            return;
        }
        System.out.println("New menu is added");
    }

    private static void removeMenu() {
        if (cashierMachine == null) {
            return;
        }
        printAllMenu();
        System.out.println("Enter menu short name :");
        String menuShortName = input.nextLine();
        ManagerMachine mc = (ManagerMachine) cashierMachine;
        boolean isRemoved = mc.removeMenu(menuShortName);
        if (isRemoved) {
            System.out.println("Menu is successfully removed");
            return;
        }
        System.out.println("Menu is not found");
    }

    private static void editMenu() {
        ManagerMachine managerMachine = (ManagerMachine) cashierMachine;
        String menuShortName = "";
        do {
            System.out.print("Enter menu short name (type ? to list all menu): ");
            menuShortName = input.nextLine();
            if (menuShortName.equals("?")) {
                printAllMenu();
            }
        } while (menuShortName.equals("?"));
        for (Menu menu : managerMachine.getAllMenu()) {
            if (menu.getMenuShortName().equals(menuShortName)) {
                Menu newMenu = menu;
                System.out.print("Enter new short name (type enter to keep the old one): ");
                String inputString = input.nextLine();
                if (!inputString.equals("")) {
                    newMenu.setMenuShortName(inputString);
                }
                System.out.print("Enter new menu name (type enter to keep the old one): ");
                inputString = input.nextLine();
                if (!inputString.equals("")) {
                    newMenu.setMenuName(inputString);
                }
                do {
                    System.out.print("Enter new food category [Makanan/Minuman] (type enter to keep the old one): ");
                    if (inputString.equals("Makanan")) {
                        newMenu.setFoodCategory(FoodCategory.Food);
                        break;
                    } else if (inputString.equals("Minuman")) {
                        newMenu.setFoodCategory(FoodCategory.Drink);
                        break;
                    } else if (inputString.equals("")) {
                        break;
                    } else {
                        System.out.println("Sorry, your input is unrecognized as value of food category");
                    }
                } while (true);
                do {
                    System.out.print("Enter new price [must be number] (type enter to keep the old one): ");
                    inputString = input.nextLine();
                    if (!inputString.equals("")) {
                        if (inputString.matches("[0-9]+")) {
                            newMenu.setPrice(Integer.parseInt(inputString));
                            break;
                        } else {
                            System.out.println(
                                    "Sorry, your input contains non-number character, please input number only");
                        }
                    } else {
                        break;
                    }
                } while (true);

                managerMachine.editMenu(menuShortName, newMenu);
                return;
            }

            System.out.println("Sorry, menu with specified menu short name not found");
        }
    }

    private static void printBoldSeparator() {
        System.out.println("=".repeat(50));
    }

    private static void printtThinSeparator() {
        System.out.println("-".repeat(50));
    }
}
