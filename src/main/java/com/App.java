package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import com.CashierAppUtil.Auth;
import com.CashierAppUtil.CashierMachine;
import com.CashierAppUtil.ManagerMachine;
import com.Model.Employee;
import com.Model.EmployeeModel;
import com.Model.FoodCategory;
import com.Model.Manager;
import com.Model.Menu;
import com.Model.MenuOrder;
import com.Model.Order;
import com.RecordUtil.Log;

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
        boolean keepLoop = true;
        while (keepLoop) {
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
                    keepLoop = false;
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
            if (employee == null) {
                System.out.println("Username or password mismatch");
            }
        }
        cashierMachine = employee.getMachine();
    }

    private static void logout() {
        employee = null;
        cashierMachine = null;
    }

    private static void exit() {
        System.exit(0);
    }

    private static void printAllMenu() {
        cashierMachine.printMenu();
    }

    private static void takeOrder() {
        List<MenuOrder> orderedMenuList = new ArrayList<>();
        boolean validate = true;
        boolean menuExist = false;

        printBoldSeparator();
        System.out.println("Add Customer Orders");
        printBoldSeparator();
        cashierMachine.printMenu();
        printtThinSeparator();

        System.out.print("Input customer name: ");
        String customerName = input.nextLine();
        System.out.print("Input customer total money: ");
        int customerMoney = input.nextInt();
        System.out.print("Input customer table: ");
        int customerTable = input.nextInt();
        input.nextLine();
        printtThinSeparator();

        do {
            System.out.print("Input short menu name: ");
            String menuShortName = input.nextLine();
            String menuQuantity = "";
            while (!menuQuantity.matches("[0-9]+")) {
                System.out.print("Input the Quantity: ");
                menuQuantity = input.nextLine();
            }

            List<Menu> allMenu = cashierMachine.getAllMenu();
            for (Menu menu : allMenu) {
                if (menuShortName.equals(menu.getMenuShortName())) {
                    orderedMenuList.add(new MenuOrder(menu, Integer.parseInt(menuQuantity)));
                    System.out.println("Menu successfully added to Menu Order");
                    menuExist = true;
                    break;
                }
            }

            if (!menuExist) {
                System.out.println("The menu doesn't exist, please input again!");
                continue;
            }

            System.out.print("do you want to add order again? (y/n)");
            String lanjut = input.nextLine();

            if (lanjut.equals("n")) {
                validate = false;
            }
            printtThinSeparator();
        } while (validate);

        cashierMachine.addOrder(new Order(orderedMenuList, customerName, customerMoney, employee, customerTable));
    }

    private static void markOrderComplete() {
        UUID uuid = null;
        while (true) {
            try {
                System.out.print("Input finished order ID (type ? to list all unfinished orders and ?x to cancel): ");
                String inputString = input.nextLine();
                if (inputString.equals("?")) {
                    printUnfinishedOrders();
                } else if (inputString.equals("?x")) {
                    break;
                }
                uuid = UUID.fromString(inputString);
                break;
            } catch (Exception e) {
                System.out.println("Invalid UUID, please enter the valid one!");
            }
        }
        List<Order> orders = cashierMachine.getUnfinishedOrders();
        for (Order order : orders) {
            if (order.getOrderId().equals(uuid)) {
                order.setDone(true);
                cashierMachine.editOrder(uuid, order);
            }
        }
    }

    private static void editUnfinishedOrder() {
        List<Order> unfinishedOrders = cashierMachine.getUnfinishedOrders();
        int size = unfinishedOrders.size();
        int i = 0;
        for (Order order : unfinishedOrders) {
            System.out.println(i + ":");
            System.out.println(order.toString());
        }

        System.out.printf("Select unfinished order to edit (0 to %d)", size);
        String inputString = "";
        int unfinishedOrderNum = -1;
        do {
            inputString = input.nextLine();
            if (inputString.matches("[0-9]+")) {
                unfinishedOrderNum = Integer.parseInt(input.nextLine());
                if (unfinishedOrderNum >= 0 && unfinishedOrderNum <= size) {
                    break;
                }
            }

            System.out.println("Input must be number and between 0 and " + size);
        } while (true);

        Order unfinishedOrder = unfinishedOrders.get(unfinishedOrderNum);

        System.out.println(unfinishedOrder.toString());

        int editChoice = -1;
        do {
            printtThinSeparator();
            System.out.println("Field to edit");
            printtThinSeparator();
            System.out.println("1. Customer Name");
            System.out.println("2. Table Number");
            System.out.println("3. Order Status");
            System.out.println("Choose field to edit: ");
            inputString = input.nextLine();
            if (inputString.matches("[1-4]")) {
                editChoice = Integer.parseInt(inputString);
                break;
            }
        } while (true);

        switch (editChoice) {
            case 1:
                System.out.printf("Old customer name: %s\n", unfinishedOrder.getCustomerName());
                System.out.println("Enter new customer name (type enter to keep the old one): ");
                inputString = input.nextLine();
                if (!inputString.equals("")) {
                    unfinishedOrder.setCustomerName(inputString);
                }
                break;
            case 2:
                System.out.printf("Old table number: %d\n", unfinishedOrder.getTableNumber());
                do {
                    System.out.println("Enter new table number (type enter to keep the old one): ");
                    inputString = input.nextLine();
                    if (!inputString.equals("")) {
                        if (inputString.equals("[0-9]+")) {
                            unfinishedOrder.setTableNumber(Integer.parseInt(inputString));
                        } else {
                            System.out.println("Input must be number");
                        }
                    }
                } while (!inputString.equals(""));
                break;
            case 3:
                System.out.println("Change order status to done? (Y/n)");
                String case4Choice = input.nextLine();
                if (case4Choice.equals("Y") || case4Choice.equals("y") || case4Choice.equals("")) {
                    unfinishedOrder.setDone(true);
                }
                break;
        }

    }

    private static void cancelUnfinishedOrder() {
        UUID uuid = null;
        while (true) {
            try {
                System.out.print(
                        "Input order ID to be canceled (type ? to list all unfinished orders and ?x to cancel): ");
                String inputString = input.nextLine();
                if (inputString.equals("?")) {
                    printUnfinishedOrders();
                } else if (inputString.equals("?x")) {
                    break;
                }
                uuid = UUID.fromString(inputString);
                break;
            } catch (Exception e) {
                System.out.println("Invalid UUID, please enter the valid one!");
            }

            if (!cashierMachine.removeOrder(uuid)) {
                System.out.println("Order with specified order ID not found");
                continue;
            }

            System.out.println("Order removed successfully");
        }

    }

    private static void printUnfinishedOrders() {
        List<Order> unfinishedOrderList = cashierMachine.getUnfinishedOrders();
        printBoldSeparator();
        System.out.println("Unfinished Orders");
        printBoldSeparator();
        for (Order order : unfinishedOrderList) {
            System.out.println(order.toString());
            printtThinSeparator();
        }
    }

    private static void printNewFinishedOrders() {
        List<Order> finishedOrderList = cashierMachine.getFinishedOrders();
        printBoldSeparator();
        System.out.println("New Finished Orders");
        printBoldSeparator();
        for (Order order : finishedOrderList) {
            System.out.println(order.toString());
            printtThinSeparator();
        }
    }

    private static void printAllOrderNewOrders() {
        List<Order> newOrderList = new ArrayList<>();
        newOrderList.addAll(cashierMachine.getUnfinishedOrders());
        newOrderList.addAll(cashierMachine.getFinishedOrders());

        printBoldSeparator();
        System.out.println("All new Orders: ");
        printBoldSeparator();
        for (Order order : newOrderList) {
            System.out.println(order.toString());
            printtThinSeparator();
        }
    }

    private static void saveOrderToRecord() {
        if (cashierMachine.saveToRecord()) {
            System.out.println("New Orders saved to record successfully");
        } else {
            System.out.println("Failed to save new orders to record");
        }
    }

    private static void printOrderRecord() {
        List<Order> orderRecordList = ((ManagerMachine) cashierMachine).getOrderRecord();
        printBoldSeparator();
        System.out.println("Order Record List");
        printBoldSeparator();
        for (Order order : orderRecordList) {
            System.out.println(order.toString());
            printtThinSeparator();
        }
    }

    private static void addMenu() {
        System.out.print("Enter new menu name: ");
        String menuName = input.nextLine();
        System.out.print("Enter new menu shortname: ");
        String menuShortName = input.nextLine();
        System.out.printf("1. Food\n2. Drink\nEnter category for %s (1 or 2): ", menuShortName);
        int foodCatInt = Integer.parseInt(input.nextLine());
        System.out.printf("Enter price for %s: ", menuShortName);
        int newMenuPrice = Integer.parseInt(input.nextLine());

        FoodCategory newMenuFoodCat;
        if (foodCatInt == 1) {
            newMenuFoodCat = FoodCategory.Food;
        } else if (foodCatInt == 2) {
            newMenuFoodCat = FoodCategory.Drink;
        } else {
            newMenuFoodCat = FoodCategory.Food;
        }

        ManagerMachine managerMachine = (ManagerMachine) cashierMachine;

        if (managerMachine.addMenu(new Menu(menuShortName, menuName, newMenuFoodCat, newMenuPrice))) {
            System.out.println("New menu is successfully added");
            return;
        }

        System.out.println("Failed to add new menu");
    }

    private static void removeMenu() {
        ManagerMachine managerMachine = (ManagerMachine) cashierMachine;
        String menuShortName = "";
        do {
            System.out.print("Enter menu short name (type ? to list all menu): ");
            menuShortName = input.nextLine();
            if (menuShortName.equals("?")) {
                printAllMenu();
            }
        } while (menuShortName.equals("?"));

        if (managerMachine.removeMenu(menuShortName)) {
            System.out.println("Successfully remove specified menu");
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
                    inputString = input.nextLine();
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
        }
        System.out.println("Sorry, menu with specified menu short name not found");
    }

    private static void printBoldSeparator() {
        System.out.println("=".repeat(50));
    }

    private static void printtThinSeparator() {
        System.out.println("-".repeat(50));
    }
}
