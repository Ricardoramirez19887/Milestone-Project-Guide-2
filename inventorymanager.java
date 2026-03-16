package app;

import java.util.ArrayList;

/**
 * Manages the inventory for the store front.
 */
public class inventorymanager
{
    private ArrayList<SalableProduct> inventory;

    /**
     * Creates a new inventory manager.
     */
    public inventorymanager()
    {
        inventory = new ArrayList<SalableProduct>();
    }

    /**
     * Adds a product to inventory.
     *
     * @param product product to add
     */
    public void addProduct(SalableProduct product)
    {
        inventory.add(product);
    }

    /**
     * Displays all inventory items.
     */
    public void displayInventory()
    {
        System.out.println("\n===== STORE INVENTORY =====");
        for (int i = 0; i < inventory.size(); i++)
        {
            System.out.println((i + 1) + ". " + inventory.get(i));
        }
    }

    /**
     * Gets a product by index.
     *
     * @param index product index
     * @return product if valid, null otherwise
     */
    public SalableProduct getProduct(int index)
    {
        if (index >= 0 && index < inventory.size())
        {
            return inventory.get(index);
        }
        return null;
    }

    /**
     * Purchases a product by reducing quantity by one.
     *
     * @param index product index
     * @return true if purchase successful, false otherwise
     */
    public boolean purchaseProduct(int index)
    {
        SalableProduct product = getProduct(index);
        if (product != null)
        {
            return product.decreaseQuantity(1);
        }
        return false;
    }

    /**
     * Cancels a purchase by adding one back to quantity.
     *
     * @param index product index
     * @return true if cancellation successful, false otherwise
     */
    public boolean cancelPurchase(int index)
    {
        SalableProduct product = getProduct(index);
        if (product != null)
        {
            product.increaseQuantity(1);
            return true;
        }
        return false;
    }

    /**
     * Gets number of items in inventory.
     *
     * @return inventory size
     */
    public int getInventorySize()
    {
        return inventory.size();
    }
}