public class Potion extends Item
{
    /**
     * Constructor for Potion item
     */
    public Potion()
    {
        super("Potion");
    }

    /**
     * Heals given character by 30 HP when item is used
     * @param target    Character to heal
     * @return          If item use was successful
     */
    @Override
    public boolean Use(Character target)
    {
        boolean valid = target.AddHP(30);

        if (!valid) {
            System.out.println("Character has fallen, could not heal.");
        }
        else {
            super.UseItem(1);
            System.out.println(target.GetName() + " is healed by 30 hp!");
        }

        return valid;
    }
}
