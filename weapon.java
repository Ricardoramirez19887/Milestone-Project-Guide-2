package app;

/**
 * Represents a weapon product in the store.
 */
public class weapon extends SalableProduct
{
    private int damage;

    /**
     * Creates a new weapon.
     *
     * @param name weapon name
     * @param description weapon description
     * @param price weapon price
     * @param quantity weapon quantity
     * @param damage weapon damage
     */
    public weapon(String name, String description, double price, int quantity, int damage)
    {
        super(name, description, price, quantity);
        this.damage = damage;
    }

    /**
     * Gets the weapon damage value.
     *
     * @return damage value
     */
    public int getDamage()
    {
        return damage;
    }

    /**
     * Returns weapon information as a string.
     *
     * @return formatted weapon information
     */
    @Override
    public String toString()
    {
        return "[Weapon] " + super.toString() + ", Damage: " + damage;
    }
}