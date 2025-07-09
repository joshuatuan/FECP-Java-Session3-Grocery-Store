package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GroceryInventoryTest {

    private GroceryInventory inventory;

    @BeforeEach
    void setUp() {
        inventory = new GroceryInventory();
    }

    // Adding product
    @Test
    void testAddingProductWithValidQuantity() {
        inventory.addProduct("banana", 30);
        assertTrue(inventory.productExists("banana"));
        assertEquals(30, inventory.getProductQuantity("banana"));
    }

    // Add product with quantity 0
    // I allowed 0 quantity
    @Test
    void testAddingProductWithZeroQuantity() {
        inventory.addProduct("mango", 0);
        assertTrue(inventory.productExists("mango"));
        assertEquals(0, inventory.getProductQuantity("mango"));
    }

    @Test
    void testAddingExistingProductShouldOverwrite() {
        inventory.addProduct("milk", 20);
        inventory.addProduct("milk", 50); // should overwrite
        assertEquals(50, inventory.getProductQuantity("milk"));
    }

    // Checking if product exists
    @Test
    void testCheckExistingProduct() {
        inventory.addProduct("milk", 20);
        assertTrue(inventory.productExists("milk"));
        assertEquals(20, inventory.getProductQuantity("milk"));
    }

    @Test
    void testCheckNonExistingProduct() {
        assertFalse(inventory.productExists("ice cream"));
    }

    // Updating product
    @Test
    void testUpdateExistingProduct() {
        inventory.addProduct("bread", 10);
        boolean result = inventory.updateProduct("bread", 25);
        assertTrue(result); // product updated
        assertEquals(25, inventory.getProductQuantity("bread"));
    }

    @Test
    void testUpdateNonExistingProduct() {
        boolean result = inventory.updateProduct("tofu", 12);
        assertFalse(result); // product not updated
    }

    // Removing products
    @Test
    void testRemoveExistingProduct() {
        inventory.addProduct("eggs", 12);
        boolean result = inventory.removeProduct("eggs");
        assertTrue(result); // removed
        assertFalse(inventory.productExists("eggs"));
    }

    @Test
    void testRemoveNonExistingProduct() {
        boolean result = inventory.removeProduct("pizza");
        assertFalse(result); // not removed
    }
}