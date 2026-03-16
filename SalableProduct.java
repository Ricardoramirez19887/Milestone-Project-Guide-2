package app;

/**
 * Represents a product that can be sold in the store front.
 */
public abstract class SalableProduct
{
    private String name;
    private String description;
    private double price;
    private int quantity;

    /**
     * Creates a new salable product.
     *
     * @param name product name
     * @param description product description
     * @param price product price
     * @param quantity product quantity
     */
    public SalableProduct(String name, String description, double price, int quantity)
    {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Gets the product name.
     *
     * @return product name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Gets the product description.
     *
     * @return product description
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Gets the product price.
     *
     * @return product price
     */
    public double getPrice()
    {
        return price;
    }

    /**
     * Gets the quantity available.
     *
     * @return quantity available
     */
    public int getQuantity()
    {
        return quantity;
    }

    /**
     * Sets the quantity.
     *
     * @param quantity new quantity
     */
    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    /**
     * Increases quantity by a given amount.
     *
     * @param amount amount to add
     */
    public void increaseQuantity(int amount)
    {
        if (amount > 0)
        {
            quantity += amount;
        }
    }

    /**
     * Decreases quantity by a given amount if enough stock exists.
     *
     * @param amount amount to remove
     * @return true if successful, false otherwise
     */
    public boolean decreaseQuantity(int amount)
    {
        if (amount > 0 && quantity >= amount)
        {
            quantity -= amount;
            return true;
        }
        return false;
    }

    /**
     * Returns product information as a string.
     *
     * @return formatted product information
     */
    @Override
    public String toString()
    {
        return "Name: " + name
                + ", Description: " + description
                + ", Price: $" + String.format("%.2f", price)
                + ", Quantity: " + quantity;
    }
}
   