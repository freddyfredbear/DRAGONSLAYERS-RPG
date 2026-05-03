// ITEM PARENT CLASS

public abstract class Item
{
    private final String NAME;
    private int qty;
    
    /**
     * Constructor for an item
     * @param name      Name of item
     */
    public Item(String name)
    {
        this.NAME = name;
        this.qty = 1;
    }

    /**
     * Provides the name of the item
     * @return      Item name
     */
    public String GetName()
    {
        return this.NAME;
    }

    /**
     * Provides the quantity of the item
     * @return      Quantity
     */
    public int GetQty()
    {
        return this.qty;
    }

    /**
     * Adds to quantity of item
     * @param amt   Amount to add
     */
    public void AddQty(int amt)
    {
        this.qty += amt;
    }

    /**
     * Removes from quantity when item is used
     * @param amt   Amount to remove
     */
    public void UseItem(int amt)
    {
        this.qty -= amt;
    }

    public abstract boolean Use(Character target);
}
