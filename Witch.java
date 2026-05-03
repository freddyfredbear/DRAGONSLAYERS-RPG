public class Witch extends Enemy
{
    public Witch(String name)
    {
        super(name, 130);
        super.SetAtkName(1, "HEX");
        super.SetAtkName(2, "FIREBALL");
        super.SetAtkName(3, "N/A");
    }

    /**
     * ATTACK 3 : HEX - Deals 10 damage to a character
     * @param target        The character getting attacked
     */
    @Override
    public void Atk1(Playable target)
    {
        System.out.println(super.GetName() + " used " 
            + super.GetAtkName(1) + "!");

        int dmg = 10;
        target.LoseHP(dmg);
    }

    /**
     * ATTACK 2 : FIREBALL - Deals 15-20 damage to a character
     * @param target        The character getting attacked
     */
    @Override
    public void Atk2(Playable target)
    {
        System.out.println(super.GetName() + " used " 
            + super.GetAtkName(2) + "!");

        // generate a number from 15 - 20
        int dmg = RandInt(15,20);
        target.LoseHP(dmg);
    }

    /* ATTACK 3 : N/A */
    @Override
    public void Atk3(Playable target)
    {
        // does nothing
    }
}
