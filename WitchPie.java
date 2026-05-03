public class WitchPie extends Item
{
    /**
     * Constructor for Witch's Pie item
     */
    public WitchPie()
    {
        super("Witch's Pie");
    }

    /**
     * Revives and heals a character by 30 HP when used
     * @param target    Character to be revived and healed
     * @return          If item use was successful
     */
    @Override
    public boolean Use(Character target)
    {
        target.Revive(30);
        super.UseItem(1);
        System.out.println(target.GetName() + " is healed by 30 hp!");
        return true;
    }
}
