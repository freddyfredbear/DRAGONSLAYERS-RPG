public class Knight extends Playable
{
    public Knight(String name, int hp)
    {
        super(name, hp);
        super.SetAtkName(1, "SACRED SWORD");
        super.SetAtkName(2, "STEEL FURY");
        super.SetAtkName(3, "FULL IMPACT");
        super.SetAtkName(4, "RAGEFUL SWING");
    }

    /**
     * ATTACK 1 : SACRED SWORD - Randomly generates a number from 10-15,
     * deals that amount of damage to the enemy.
     * @param enemy     The enemy that is being attacked.
     */
    @Override
    public void Atk1(Enemy enemy)
    {
        System.out.println(super.GetName() + " used " 
            + super.GetAtkName(1) + "!");
        
        // generate a number from 10 - 15
        int dmg = RandInt(10,15);
        enemy.LoseHP(dmg);
    }

    /**
     * ATTACK 2 : STEEL FURY - Randomly generates a number from 2-5 to determine
     * how many hits will be dealt, and then generates numbers from 3-8 to
     * determine the amount of damage for the hit.
     * @param enemy     The enemy that is being attacked.
     * @param party     User's entire party (knight, mage, rogue, brute)
     */
    @Override
    public void Atk2(Enemy enemy, Playable[] party)
    {
        System.out.println(super.GetName() + " used " 
            + super.GetAtkName(2) + "!");
        
        // generate a number from 2 - 5
        int hits = RandInt(2,5);

        for (int i = 0; i < hits; i++)
        {
            // generate a number from 3 - 8
            int dmg = RandInt(3,8);
            enemy.LoseHP(dmg);

            if (enemy.GetHP() <= 0)
            {
                // stop attacking if enemy is dead
                break;
            }
        }
    }

    /**
     * ATTACK 3 : FULL IMPACT - Randomly generates a number from 25-35,
     * deals that amount of damage to the enemy. Generates a number from
     * 10-12, deals that amount of damage back to Knight character.
     * @param enemy     The enemy that is being attacked.
     * @param party     User's entire party (knight, mage, rogue, brute)
     */
    @Override
    public void Atk3(Enemy enemy, Playable[] party)
    {
        System.out.println(super.GetName() + " used " 
            + super.GetAtkName(3) + "!");
        
        // generate a number from 25 - 35
        int dmg = RandInt(25,35);
        enemy.LoseHP(dmg);

        // generate a number from 10 - 12
        int recoil = RandInt(10,12);
        super.LoseHP(recoil);
    }

    /**
     * ATTACK 4 : RAGEFUL SWING - Randomly generates a number from 5-35,
     * deals that amount of damage to the enemy.
     * @param enemy     The enemy that is being attacked
     */
    @Override
    public void Atk4(Enemy enemy)
    {
        System.out.println(super.GetName() + " used " 
            + super.GetAtkName(4) + "!");
        
        // generate a number from 5 - 35
        int dmg = RandInt(5,35);
        enemy.LoseHP(dmg);
    }
}
