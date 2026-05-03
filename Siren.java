public class Siren extends Enemy
{
    public Siren(String name)
    {
        super(name, 100);
        super.SetAtkName(1, "BITE");
        super.SetAtkName(2, "SING");
        super.SetAtkName(3, "N/A");
    }

    /**
     * ATTACK 1 : BITE - Deals 8 damage to a character
     * @param target        The character that is getting attacked.
     */
    @Override
    public void Atk1(Playable target)
    {
        System.out.println(super.GetName() + " used " 
            + super.GetAtkName(1) + "!");

        int dmg = 8;
        target.LoseHP(dmg);
    }

    /**
     * ATTACK 2 : SING - Deals 12 damage to a character
     * @param target        The character that is getting attacked.
     */
    @Override
    public void Atk2(Playable target)
    {
        System.out.println(super.GetName() + " used " 
            + super.GetAtkName(2) + "!");

        int dmg = 12;
        target.LoseHP(dmg);
    }

    /* ATTACK 3 : N/A */
    @Override
    public void Atk3(Playable target)
    {
        // does nothing
    }
}
