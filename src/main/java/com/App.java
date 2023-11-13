package com;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.CashierAppUtil.FoodCategory;
import com.CashierAppUtil.Menu;
import com.RecordUtil.Record;
import com.google.gson.Gson;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        // Record<String> r = new Record<>("test");
        // ArrayList<Menu> list = new ArrayList<>();
        // list.add(new Menu(UUID.randomUUID(), "nasgor", FoodCategory.Makanan, 15000));
        // list.add(new Menu(UUID.randomUUID(), "nasgor ayam", FoodCategory.Makanan,
        //         15000));
        // list.add(new Menu(UUID.randomUUID(), "nasgor sapi", FoodCategory.Makanan,
        //         15000));
        // list.add(new Menu(UUID.randomUUID(), "nasgor kuah", FoodCategory.Makanan,
        //         15000));

        // Gson gson = new Gson();

        // String s = gson.toJson(list);
        // System.out.println(s);
        // File testFile = new File("./src/main/java/com/RecordFiles/test.json");
        // try {
        //     FileWriter fileWriter = new FileWriter(testFile);
        //     fileWriter.append(s);
        //     fileWriter.close();
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }

        Record<Product> test2Record = new Record<Product>("test2");
        List<Product> list = test2Record.readRecordFile();
        System.out.println(((Product) list.get(0)).id);
    }
}
