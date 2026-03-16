package app;

/**
 * Represents an armor product in the store.
 */
public class armor extends SalableProduct
{
    private int defense;

    /**
     * Creates a new armor item.
     *
     * @param name armor name
     * @param description armor description
     * @param price armor price
     * @param quantity armor quantity
     * @param defense armor defense value
     */
    public armor(String name, String description, double price, int quantity, int defense)
    {
        super(name, description, price, quantity);
        this.defense = defense;
    }

    /**
     * Gets the defense value.
     *
     * @return defense value
     */
    public int getDefense()
    {
        return defense;
    }

    /**
     * Returns armor information as a string.
     *
     * @return formatted armor information
     */
    @Override
    public String toString()
    {
        return "[Armor] " + super.toString() + ", Defense: " + defense;
    }
}