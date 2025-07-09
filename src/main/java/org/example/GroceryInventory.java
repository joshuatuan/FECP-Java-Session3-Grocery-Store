package org.example;

import java.util.HashMap;

public class GroceryInventory {
    private HashMap<String, Integer> inventory = new HashMap<>();

    public HashMap<String, Integer> getInventory() {
        return inventory;
    }

    public int getProductQuantity(String product) {
        product = normalize(product);

        if (productExists(product)) {
            Integer quantity = getInventory().get(product);
            return quantity != null ? quantity : 0;
        }

        return 0;
    }

    public void addProduct(String product, int quantity) {
        product = normalize(product);

        if (quantity < 0) {
            System.out.println("Quantity cannot be negative.");
            return;
        }

        if (productExists(product)) System.out.println(product + " already exists. Updating instead");
        inventory.put(product, quantity);
    }

    public boolean productExists(String product){
        return inventory.containsKey(normalize(product));
    }

    public boolean updateProduct(String product, int newQuantity) {
        product = normalize(product);

        if (!productExists(product)) {
            System.out.println("Product does not exist. Cannot update.");
            return false;
        }

        if (newQuantity < 0) {
            System.out.println("Quantity cannot be negative.");
            return false;
        }

        inventory.put(product, newQuantity);
        System.out.println("Updated " + product + " to quantity " + newQuantity);
        return true;
    }


    public boolean removeProduct(String existingProduct){
        if (!productExists(existingProduct)) return false;

        inventory.remove(normalize(existingProduct));
        return true;
    }

    public void viewInventory(){
        if (inventory.isEmpty()) return;
        System.out.println("Current inventory: ");
        for (String product : inventory.keySet()) {
            System.out.println(product + " - " + inventory.get(product) + "pcs");
        }
    }

    public String normalize(String product){
        return product.trim().toLowerCase();
    }
}
