package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GroceryInventory inventory = new GroceryInventory();

        while(true){
            mainMenu();
            String option = sc.nextLine().trim();

            switch (option){
                case "1" :{ // View Inventory
                    if(inventory.getInventory().isEmpty()){
                        System.out.println("Grocery inventory is empty. Add some products first");
                    } else{
                        inventory.viewInventory();
                    }
                    break;
                }
                case "2":{ // Add Product
                    System.out.print("Enter product name: ");
                    String productName = sc.nextLine();

                    System.out.print("Enter quantity: ");

                    try{
                        int productQuantity = Integer.parseInt(sc.nextLine());
                        inventory.addProduct(productName, productQuantity);
                    } catch (NumberFormatException e){
                        System.out.println("Invalid quantity");
                        break;
                    }

                    System.out.println("Product Added!");
                    break;
                }
                case "3":{ // Check Product
                    System.out.print("Enter product to check: ");
                    String productName = sc.nextLine();

                    if(inventory.productExists(productName)){
                        System.out.println(productName + " exists" + " with " + inventory.getInventory().get(productName) + " quantity");
                    } else {
                        System.out.println("Product doesn't exist");
                    }
                    break;
                }

                case "4": { // Update Product
                    System.out.print("Enter product name to update: ");
                    String productName = sc.nextLine();

                    System.out.print("Enter new quantity: ");
                    try {
                        int newQuantity = Integer.parseInt(sc.nextLine());
                        inventory.updateProduct(productName, newQuantity);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid quantity.");
                    }
                    break;
                }

                case "5":{ // Remove Product
                    System.out.print("Enter product name to remove: ");
                    String productName = sc.nextLine();

                    if (inventory.removeProduct(productName)){
                        System.out.println("Removed Successfully!");
                    } else {
                        System.out.println(productName + " doesn't exist.");
                    }
                    break;
                }
                case "6":{ // Exit
                    System.out.println("Exiting... Thank you!");
                    sc.close();
                    return;
                }
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }

    public static void mainMenu(){
        System.out.println("\n=== Grocery Inventory System ===");
        System.out.println("1. View inventory");
        System.out.println("2. Add Product");
        System.out.println("3. Check Product");
        System.out.println("4. Update Product");
        System.out.println("5. Remove Product");
        System.out.println("6. Exit");

        System.out.print("Enter option: ");
    }
}