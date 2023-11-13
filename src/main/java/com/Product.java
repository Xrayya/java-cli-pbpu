package com;

import java.util.Arrays;

/**
 * Product
 */
public class Product {

    public int id;
    public String title;
    public String description;
    public double price;
    public double discountPercentage;
    public double rating;
    public int stock;
    public String brand;
    public String category;
    public String thumbnail;
    public String[] images;

    public Product(int id, String title, String description, double price, double discountPercentage, double rating,
            int stock, String brand, String category, String thumbnail, String[] images) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.discountPercentage = discountPercentage;
        this.rating = rating;
        this.stock = stock;
        this.brand = brand;
        this.category = category;
        this.thumbnail = thumbnail;
        this.images = images;
    }

    // @Override
    // public String toString() {
    //     return String.format(
    //             "Product{id=%s, title=%s, description=%s, price=%s, discountPercentage=%s, rating=%s, stock=%s, brand=%s, category=%s, thumbnail=%s, images=%s}",
    //             id, title, description, price, discountPercentage, rating, stock, brand, category, thumbnail,
    //             Arrays.toString(images));
    // }

}
