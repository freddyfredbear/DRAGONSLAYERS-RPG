public class Rogue extends Playable
{
    public Rogue(String name, int hp)
    {
        super(name, hp);
        super.SetAtkName(1, "VICIOUS FLURRY");
        super.SetAtkName(2, "SILENT SLASH");
        super.SetAtkName(3, "BACKSTAB");
        super.SetAtkName(4, "SHADOW SNEAK");
    }

    /**
     * ATTACK 1 : VICIOUS FLURRY - Attacks enemy 1-7 times, each hit
     * deals 2-6 damage
     * @param enemy     The enemy that is being attacked.
     */
    @Override
    public void Atk1(Enemy enemy)
    {
        System.out.println(super.GetName() + " used " 
            + super.GetAtkName(1) + "!");

        // generate a number from 1 - 7
        int hits = RandInt(1,7);

        for (int i = 0; i < hits; i++)
        {
            // generate a number from 2 - 6
            int dmg = RandInt(2,6);
            enemy.LoseHP(dmg);
        }
    }

    /**
     * ATTACK 2 : BACKSTAB - Deals 12-15 damage to enemy
     * @param enemy     The enemy that is being attacked.
     * @param party     User's entire party.
     */
    @Override
    public void Atk2(Enemy enemy, Playable[] party)
    {
        System.out.println(super.GetName() + " used " 
            + super.GetAtkName(2) + "!");

        // generate a number from 12 - 15
        int dmg = RandInt(12,15);
        enemy.LoseHP(dmg);
    }

    /**
     * ATTACK 3 : TWISTING STAB - Deals 10-25 damage to enemy
     * @param enemy     The enemy that is being attacked.
     * @param party     User's entire party
     */
    @Override
    public void Atk3(Enemy enemy, Playable[] party)
    {
        System.out.println(super.GetName() + " used " 
            + super.GetAtkName(3) + "!");

        // generate a number from 10 - 25
        int dmg = RandInt(10,25);
        enemy.LoseHP(dmg);
    }

    /**
     * ATTACK 4 : SHADOW SNEAK - Deals 10-12 damage to enemy,
     * 0-3 times. If 0, displays a missed message.
     * @param enemy     The enemy that is being attacked.
     */
    @Override
    public void Atk4(Enemy enemy)
    {
        System.out.println(super.GetName() + " used " 
            + super.GetAtkName(4) + "!");

        // generate a number from 0 - 3
        int hits = RandInt(0,3);

        if (hits == 0) {
            System.out.println("Missed!");
        }

        for (int i = 0; i < hits; i++)
        {
            // generate a number from 10 - 12
            int dmg = RandInt(2,6);
            enemy.LoseHP(dmg);
        }
    }
}
