package com.example.abhishek_pc.foodstore;

import android.content.res.Resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class ShoppingCartHelper {

    public static final String PRODUCT_INDEX = "PRODUCT_INDEX";

    private static List<Product> catalog;
    private static Map<Product, ShoppingCartEntry> cartMap = new HashMap<Product, ShoppingCartEntry>();

    public static List<Product> getCatalog(Resources res){
        if(catalog == null) {
            catalog = new Vector<Product>();

            catalog.add(new Product("CHANA MASHALA", res
                    .getDrawable(R.drawable.dd),
                    "Chana mashala made with diff. spices and shud desi ghee", 120.50));
            catalog.add(new Product("CHICKEN KORMA", res
                    .getDrawable(R.drawable.ff),
                    "Chicken korma ! fav dish of the day", 180.50));
            catalog.add(new Product("CHICKEN TIKKA", res
                    .getDrawable(R.drawable.f),
                    "spicey chicken tikaa with maa ka pyaar", 250.50));

            catalog.add(new Product("PEAS PULAV", res
                    .getDrawable(R.drawable.t),
                    "tasty and healty peas pulav", 110.50));
            catalog.add(new Product("ZEERA RICE", res
                    .getDrawable(R.drawable.u),
                    "tasty tasty Zeera Rice!!!", 100.50));
            catalog.add(new Product("STEAM RICE", res
                    .getDrawable(R.drawable.sss),
                    "Rice with ghar ka taste!", 80.50));

            catalog.add(new Product("BUTTER NAAN", res
                    .getDrawable(R.drawable.q),
                    "utterly butterly NaaN", 30.50));
            catalog.add(new Product("BUTTER KULCHA", res
                    .getDrawable(R.drawable.w),
                    "desi kulche with butter", 20.50));
            catalog.add(new Product("RUMALI ROTI", res
                    .getDrawable(R.drawable.r),
                    "Best Rumali Roti of sharma da dhaba", 50.50));
            catalog.add(new Product("PNR_B MASALA", res
                    .getDrawable(R.drawable.bb),
                    "Delicious paneer butter mashala", 150.50));
            catalog.add(new Product("PNR SCHEZWAN", res
                    .getDrawable(R.drawable.cc),
                    "Hydabadi paneer schezwan ..yammi", 120.50));
        }

        return catalog;
    }

    public static void setQuantity(Product product, int quantity) {
        // Get the current cart entry
        ShoppingCartEntry curEntry = cartMap.get(product);

        // If the quantity is zero or less, remove the products
        if(quantity <= 0) {
            if(curEntry != null)
                removeProduct(product);
            return;
        }

        // If a current cart entry doesn't exist, create one
        if(curEntry == null) {
            curEntry = new ShoppingCartEntry(product, quantity);
            cartMap.put(product, curEntry);
            return;
        }

        // Update the quantity
        curEntry.setQuantity(quantity);
    }

    public static int getProductQuantity(Product product) {
        // Get the current cart entry
        ShoppingCartEntry curEntry = cartMap.get(product);

        if(curEntry != null)
            return curEntry.getQuantity();

        return 0;
    }

    public static void removeProduct(Product product) {
        cartMap.remove(product);
    }

    public static List<Product> getCartList() {
        List<Product> cartList = new Vector<Product>(cartMap.keySet().size());
        for(Product p : cartMap.keySet()) {
            cartList.add(p);
        }

        return cartList;
    }


}