package org.example;

import java.util.HashMap;

public class GroceryInventory {
    private static HashMap<String, Integer> inventory = new HashMap<>();

    public static HashMap<String, Integer> getInventory() {
        return inventory;
    }

    public static void addProduct(String product, int quantity){
        if (checkProduct(product)) System.out.println(product + " already exists. Updating instead.");
        inventory.put(product, quantity);
    }

    public static boolean checkProduct(String product){
        return inventory.containsKey(product);
    }

    public static boolean updateProduct(String existingProduct, int newQuantity){
        if (!checkProduct(existingProduct)) return false;

        inventory.put(existingProduct, newQuantity);
        return true;
    }

    public static boolean removeProduct(String existingProduct){
        if (!checkProduct(existingProduct)) return false;

        inventory.remove(existingProduct);
        return true;
    }

    public static void viewInventory(){
        if (inventory.isEmpty()) return;
        System.out.println("Current inventory: ");
        for (String product : inventory.keySet()) {
            System.out.println(product + " - " + inventory.get(product) + "pcs");
        }
    }
}
