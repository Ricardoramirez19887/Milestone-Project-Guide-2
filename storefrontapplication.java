package app;

import java.util.Scanner;

/**
 * Console-based store front application.
 */
public class storefrontapplication
{
    private inventorymanager inventoryManager;
    private Scanner scanner;

    /**
     * Creates the store front application.
     */
    public storefrontapplication()
    {
        inventoryManager = new inventorymanager();
        scanner = new Scanner(System.in);
        initializeInventory();
    }

    /**
     * Populates the store with initial hard-coded inventory.
     */
    private void initializeInventory()
    {
        inventoryManager.addProduct(new weapon("Sword", "Steel longsword", 150.00, 5, 25));
        inventoryManager.addProduct(new weapon("Bow", "Oak hunting bow", 120.00, 4, 18));

        inventoryManager.addProduct(new armor("Helmet", "Iron protective helmet", 80.00, 3, 12));
        inventoryManager.addProduct(new armor("Chestplate", "Heavy steel chestplate", 200.00, 2, 30));

        inventoryManager.addProduct(new health("Health Potion", "Restores player health", 35.00, 10, 50));
    }

    /**
     * Displays the menu options.
     */
    private void displayMenu()
    {
        System.out.println("\n===== DRAGON'S DEN STORE FRONT =====");
        System.out.println("Welcome to the Dragon's Den!");
        System.out.println("Please choose an option:");
        System.out.println("1. View Inventory");
        System.out.println("2. Purchase Product");
        System.out.println("3. Cancel Purchase");
        System.out.println("4. Exit");
        System.out.print("Enter choice: ");
    }

    /**
     * Runs the application loop.
     */
    public void run()
    {
        int choice = 0;

        while (choice != 4)
        {
            displayMenu();

            if (scanner.hasNextInt())
            {
                choice = scanner.nextInt();
            }
            else
            {
                System.out.println("Error: Please enter a valid numeric option.");
                scanner.next();
                continue;
            }

            switch (choice)
            {
                case 1:
                    inventoryManager.displayInventory();
                    break;
                case 2:
                    purchaseFlow();
                    break;
                case 3:
                    cancelFlow();
                    break;
                case 4:
                    System.out.println("Thank you for visiting the Dragon's Den. Goodbye!");
                    break;
                default:
                    System.out.println("Error: Invalid menu option. Please choose 1-4.");
            }
        }

        scanner.close();
    }

    /**
     * Handles purchasing a product.
     */
    private void purchaseFlow()
    {
        inventoryManager.displayInventory();
        System.out.print("Enter the number of the product to purchase: ");

        if (scanner.hasNextInt())
        {
            int productNumber = scanner.nextInt();
            int index = productNumber - 1;

            SalableProduct product = inventoryManager.getProduct(index);

            if (product == null)
            {
                System.out.println("Error: Product number does not exist.");
            }
            else if (inventoryManager.purchaseProduct(index))
            {
                System.out.println("Success: You purchased " + product.getName()
                        + " for $" + String.format("%.2f", product.getPrice()) + ".");
            }
            else
            {
                System.out.println("Error: " + product.getName() + " is out of stock.");
            }
        }
        else
        {
            System.out.println("Error: Invalid input. Please enter a valid product number.");
            scanner.next();
        }
    }

    /**
     * Handles canceling a purchase.
     */
    private void cancelFlow()
    {
        inventoryManager.displayInventory();
        System.out.print("Enter the number of the product to cancel purchase: ");

        if (scanner.hasNextInt())
        {
            int productNumber = scanner.nextInt();
            int index = productNumber - 1;

            SalableProduct product = inventoryManager.getProduct(index);

            if (product == null)
            {
                System.out.println("Error: Product number does not exist.");
            }
            else if (inventoryManager.cancelPurchase(index))
            {
                System.out.println("Success: Purchase cancellation processed for " + product.getName() + ".");
            }
            else
            {
                System.out.println("Error: Unable to cancel purchase.");
            }
        }
        else
        {
            System.out.println("Error: Invalid input. Please enter a valid product number.");
            scanner.next();
        }
    }

    /**
     * Main method that starts the store front.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args)
    {
        storefrontapplication app = new storefrontapplication();
        app.run();
    }
}