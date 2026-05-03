public class Goblin extends Enemy
{
    /**
     * Constructor for Goblin enemy
     * @param name      Goblin's name
     */
    public Goblin(String name)
    {
        super(name, 80);
        super.SetAtkName(1, "SCRATCH");
        super.SetAtkName(2, "ROCK THROW");
        super.SetAtkName(3, "N/A");
    }

    /**
     * ATTACK 1 : SCRATCH - deals 5 damage to a character
     * @param target    The character that is getting attacked
     */
    @Override
    public void Atk1(Playable target)
    {
        System.out.println(super.GetName() + " used " 
            + super.GetAtkName(1) + "!");

        int dmg = 5;
        target.LoseHP(dmg);
    }

    /**
     * ATTACK 2 : ROCK THROW - deals 8 damage to a character
     * @param target    The character that is getting attacked
     */
    @Override
    public void Atk2(Playable target)
    {
        System.out.println(super.GetName() + " used " 
            + super.GetAtkName(2) + "!");

        int dmg = 8;
        target.LoseHP(dmg);
    }

    /* ATTACK 3 : N/A */
    @Override
    public void Atk3(Playable target)
    {
        // does nothing
    }
}
