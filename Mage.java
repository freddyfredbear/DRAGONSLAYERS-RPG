public class Mage extends Playable
{
    public Mage(String name, int hp)
    {
        super(name, hp);
        super.SetAtkName(1, "FIREBALL");
        super.SetAtkName(2, "FOREST HEALING");
        super.SetAtkName(3, "LIFESTEAL");
        super.SetAtkName(4, "ARCANE BLAST");
    }

    /**
     * ATTACK 1 : FIREBALL - Randomly generates a number from 15-20,
     * deals that amount of damage to the enemy.
     * @param enemy     The enemy that is being attacked.
     */
    @Override
    public void Atk1(Enemy enemy)
    {
        System.out.println(super.GetName() + " used " 
            + super.GetAtkName(1) + "!");
        
        // generate a number from 15 - 20
        int dmg = RandInt(15,20);
        enemy.LoseHP(dmg);
    }

    /**
     * ATTACK 2 : FOREST HEALING - Heals the entire party by 10-30 HP
     * @param enemy     The current enemy
     * @param party     User's entire party
     */
    @Override
    public void Atk2(Enemy enemy, Playable[] party)
    {
        System.out.println(super.GetName() + " used " 
            + super.GetAtkName(2) + "!");
        
        // generate a number from 10 - 30
        int heal = RandInt(10,30);
        
        System.out.println("Party is healed by " + heal + " hp!");
        for (int i = 0; i < party.length; i++)
        {
            party[i].AddHP(heal);
        }
    }

    /**
     * ATTACK 3 : LIFESTEAL - Deals 5-15 damage to enemy, and
     * heals the entire party by the same amount.
     * @param enemy     The enemy that is being attacked
     * @param party     User's entire party
     */
    @Override
    public void Atk3(Enemy enemy, Playable[] party)
    {
        System.out.println(super.GetName() + " used " 
            + super.GetAtkName(3) + "!");

        // generate a number from 5 - 15
        int dmg = RandInt(5,15);
        enemy.LoseHP(dmg);

        System.out.println("Party is healed by " + dmg + " hp!");
        for (int i = 0; i < party.length; i++)
        {
            party[i].AddHP(dmg);
        }
    }

    /**
     * ATTACK 4 : ARCANE BLAST - Randomly generates a number
     * from 10-30, deals that amount of damage to the enemy.
     * @param enemy     The enemy that is being attacked.
     */
    @Override
    public void Atk4(Enemy enemy)
    {
        System.out.println(super.GetName() + " used " 
            + super.GetAtkName(4) + "!");

        // generate a number from 10 - 30
        int dmg = RandInt(10,30);
        enemy.LoseHP(dmg);
    }
}
