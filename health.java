package app;

/**
 * Represents a health item in the store.
 */
public class health extends SalableProduct
{
    private int healAmount;

    /**
     * Creates a new health item.
     *
     * @param name health item name
     * @param description health item description
     * @param price health item price
     * @param quantity health item quantity
     * @param healAmount amount healed
     */
    public health(String name, String description, double price, int quantity, int healAmount)
    {
        super(name, description, price, quantity);
        this.healAmount = healAmount;
    }

    /**
     * Gets the healing amount.
     *
     * @return heal amount
     */
    public int getHealAmount()
    {
        return healAmount;
    }

    /**
     * Returns health item information as a string.
     *
     * @return formatted health item information
     */
    @Override
    public String toString()
    {
        return "[Health] " + super.toString() + ", Heal Amount: " + healAmount;
    }
}