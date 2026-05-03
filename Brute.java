public class Brute extends Playable
{
    /**
     * Constructor for Brute class character
     * @param name      Brute's name
     * @param hp        Brute's max HP
     */
    public Brute(String name, int hp)
    {
        super(name, hp);
        super.SetAtkName(1, "GIGA IMPACT");
        super.SetAtkName(2, "BODY SLAM");
        super.SetAtkName(3, "BLIND FRENZY");
        super.SetAtkName(4, "RAGE");
    }

    /**
     * ATTACK 1 : GIGA IMPACT - Randomly generates a number from 30-45, deals that
     * amount of damage to the enemy. Character also takes 20 recoil damage.
     * @param enemy     The enemy that is being attacked.
     */
    @Override
    public void Atk1(Enemy enemy)
    {
        System.out.println(super.GetName() + " used " 
            + super.GetAtkName(1) + "!");
        
        // generate a number from 30 - 45
        int dmg = RandInt(30,45);
        enemy.LoseHP(dmg);

        // brute takes 20 recoil damage
        super.LoseHP(dmg);
    }

    /**
     * ATTACK 2 : BODY SLAM - Randomly generates a number from 15-20, deals that
     * amount of damage to enemy.
     * @param enemy     The enemy that is being attacked.
     * @param party     User's entire party (knight, mage, rogue, brute).
     */
    @Override
    public void Atk2(Enemy enemy, Playable[] party)
    {
        System.out.println(super.GetName() + " used " 
            + super.GetAtkName(2) + "!");
        
        // generate a number from 15 - 20
        int dmg = RandInt(15,20);
        enemy.LoseHP(dmg);
    }

    /**
     * ATTACK 3 : BLIND FRENZY - Randomly generates a number from 0-2 to determine
     * how many hits will be dealt, and then generates numbers from 20-25 to
     * determine the amount of damage for the hit.
     * @param enemy     The enemy that is being attacked.
     * @param party     User's entire party (knight, mage, rogue, brute).
     */
    @Override
    public void Atk3(Enemy enemy, Playable[] party)
    {
        System.out.println(super.GetName() + " used " 
            + super.GetAtkName(3) + "!");
        
        // generate a number from 0 - 2
        int hits = RandInt(0,2);

        if (hits == 0)
        {
            System.out.println("Missed!");
        }

        for (int i = 0; i < hits; i++)
        {
            // generate a number from 20 - 25
            int dmg = RandInt(20,25);
            enemy.LoseHP(dmg);
        }
    }

    /**
     * ATTACK 4 : RAGE - Simulates a 50/50 chance to hit self or enemy, dealing 40
     * damage to the randomly chosen target.
     * @param enemy     The enemy that is being attacked
     */
    @Override
    public void Atk4(Enemy enemy)
    {
        System.out.println(super.GetName() + " used " 
            + super.GetAtkName(4) + "!");
        
        int dmg = 40;

        // simulate random 50/50 chance
        int chance = (int)(Math.random()*101);

        if (chance % 2 == 0) {
            // 50% chance to hit enemy
            enemy.LoseHP(dmg);
        }
        else {
            // 50% chance to hit yourself
            this.LoseHP(dmg);
        }
    }
}
