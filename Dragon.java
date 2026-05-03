public class Dragon extends Enemy
{
    /**
     * Constructor for Dragon enemy
     * @param name      Dragon's name
     */
    public Dragon(String name)
    {
        super(name, 250);
        super.SetAtkName(1, "FIRE BREATH");
        super.SetAtkName(2, "DRAGON CLAW");
        super.SetAtkName(3, "DRACO RUSH");
    }

    /**
     * ATTACK 1 : FIRE BREATH - Deals 25 damage to a character
     * @param target    The character that is getting attacked
     */
    @Override
    public void Atk1(Playable target)
    {
        System.out.println(super.GetName() + " used " 
            + super.GetAtkName(1) + "!");

        int dmg = 25;
        target.LoseHP(dmg);
    }

    /**
     * ATTACK 2 : DRAGON CLAW - Deals 20 damage to a character
     * @param target    The character that is getting attacked
     */
    @Override
    public void Atk2(Playable target)
    {
        System.out.println(super.GetName() + " used " 
            + super.GetAtkName(2) + "!");

        int dmg = 20;
        target.LoseHP(dmg);
    }

    /**
     * ATTACK 3 : DRACO RUSH - Deals 30 damage to a character
     * @param target    The character that is getting attacked
     */
    @Override
    public void Atk3(Playable target)
    {
        System.out.println(super.GetName() + " used " 
            + super.GetAtkName(3) + "!");

        int dmg = 30;
        target.LoseHP(dmg);
    }
}
