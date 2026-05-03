public class ReviveHerb extends Item
{
    /**
     * Constructor for Revive Herb item
     */
    public ReviveHerb()
    {
        super("Revive Herb");
    }

    /**
     * Revives and heals a character by 20 HP when used
     * @param target    Character to be revived and healed
     * @return          If item use was successful
     */
    @Override
    public boolean Use(Character target)
    {
        target.Revive(20);
        super.UseItem(1);
        System.out.println(target.GetName() + " is healed by 20 hp!");
        return true;
    }
}
