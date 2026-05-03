public class Wulver extends Enemy
{
    public Wulver(String name)
    {
        super(name, 170);
        super.SetAtkName(1, "NIGHT SLASH");
        super.SetAtkName(2, "SEISMIC TOSS");
        super.SetAtkName(3, "STONE RUSH");
    }

    /**
     * ATTACK 1 : NIGHT SLASH - Deals 5-15 damage to a character
     * @param target    The character that is getting attacked
     */
    @Override
    public void Atk1(Playable target)
    {
        System.out.println(super.GetName() + " used " 
            + super.GetAtkName(1) + "!");

        // generate a number from 5 - 15
        int dmg = RandInt(5,15);
        target.LoseHP(dmg);
    }

    /**
     * ATTACK 3 : SEISMIC TOSS - Deals 10 damage to a character
     * @param target    The character that is getting attacked
     */
    @Override
    public void Atk2(Playable target)
    {
        System.out.println(super.GetName() + " used " 
            + super.GetAtkName(2) + "!");

        int dmg = 10;
        target.LoseHP(dmg);
    }

    /**
     * ATTACK 3 : STONE RUSH - Randomly generates a number from 1-2 to
     * determine number of hits, deals 5-10 damage for each hit
     * @param target    The character that is getting attacked
     */
    @Override
    public void Atk3(Playable target)
    {
        System.out.println(super.GetName() + " used " 
            + super.GetAtkName(3) + "!");

        // generate a number from 1 - 2
        int hits = RandInt(1,2);
        
        // generate a number from 5 - 10
        int dmg = RandInt(5,10);

        for ( int i = 0; i < hits; i++)
        {
            target.LoseHP(dmg);
        }
    }
}
