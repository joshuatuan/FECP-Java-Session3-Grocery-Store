package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("\n=== Grocery Inventory System ===");
            System.out.println("1. View inventory");
            System.out.println("2. Add Product");
            System.out.println("3. Check Product");
            System.out.println("4. Update Product");
            System.out.println("5. Remove Product");
            System.out.println("6. Exit");

            System.out.print("Enter option: ");
            int option = sc.nextInt();
            sc.nextLine();

            switch (option){
                case 1:{ // View Inventory
                    if(GroceryInventory.getInventory().isEmpty()){
                        System.out.println("Grocery inventory is empty. Add some products first");
                    } else{
                        GroceryInventory.viewInventory();
                    }
                    break;
                }
                case 2:{ // Add Product
                    System.out.print("Enter product name: ");
                    String productName = sc.nextLine();

                    System.out.print("Enter quantity: ");
                    int productQuantity = sc.nextInt();
                    sc.nextLine();

                    GroceryInventory.addProduct(productName, productQuantity);
                    System.out.println("Product Added!");
                    break;
                }
                case 3:{ // Check Product
                    System.out.print("Enter product to check: ");
                    String productName = sc.nextLine();

                    if(GroceryInventory.checkProduct(productName)){
                        System.out.println(productName + " exists" + " with " + GroceryInventory.getInventory().get(productName) + " quantity");
                    } else {
                        System.out.println("Product doesn't exist");
                    }
                    break;
                }
                case 4:{ // Update Product
                    System.out.print("Enter product name to update: ");
                    String productName = sc.nextLine();

                    System.out.print("Enter new quantity: ");
                    int newQuantity = sc.nextInt();
                    sc.nextLine();

                    if (GroceryInventory.updateProduct(productName, newQuantity)){
                        System.out.println("Updated Successfully!");
                    } else {
                        System.out.println(productName + " doesn't exist yet.");
                    }

                    break;
                }
                case 5:{ // Remove Product
                    System.out.print("Enter product name to remove: ");
                    String productName = sc.nextLine();

                    if (GroceryInventory.removeProduct(productName)){
                        System.out.println("Removed Successfully!");
                    } else {
                        System.out.println(productName + " doesn't exist.");
                    }
                    break;
                }
                case 6:{ // Exit
                    System.out.println("Exiting... Thank you!");
                    sc.close();
                    return;
                }
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
}