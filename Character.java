// CHARACTER PARENT CLASS

public abstract class Character
{
    private final String NAME;
    private final int MAX_HP;
    private int currHP;

    /**
     * Constructor for Character given name
     * @param name      Character's name
     */
    public Character(String name)
    {
        this.NAME = name;
        this.MAX_HP = 100;
        this.currHP = 100;
    }

    /**
     * Constructor for Character given name and health
     * @param name      Character's name
     * @param hp        Character's max HP
     */
    public Character(String name, int hp)
    {
        this.NAME = name;
        this.MAX_HP = hp;
        this.currHP = hp;
    }

    /**
     * Provides name of character
     * @return      Name of character
     */
    public String GetName()
    {
        return this.NAME;
    }

    /**
     * Provides the current health of character
     * @return      Character's current health
     */
    public int GetHP()
    {
        return this.currHP;
    }

    /**
     * Provides the maximum health a character can have
     * @return      Character's max health
     */
    public int GetMaxHP()
    {
        return this.MAX_HP;
    }

    /**
     * Returns a stylized text-based health bar
     * @param ind       Index of health bar for recursion
     * @return          Health bar as a string
     */
    public String HPBar(int ind) {
        if (ind >= this.MAX_HP/10) {
            return ""; // Base case: return an empty string when complete
        }
        if (ind < (int)this.currHP/10)
        {
            return "█" + HPBar(ind + 1); // Filled section of hp bar
        }
        else
        {
            return "▒" + HPBar(ind + 1); // Empty section of hp bar
        }
    }

    /**
     * Generates a random integer within the given range
     * @param min       Minimum value of the range
     * @param max       Maximum value of the range
     * @return          Randomly generated integer
     */
    public int RandInt(int min, int max)
    {
        return (int)( (Math.random() * (max-min+1)) + min);
    }

    /**
     * Updates a character's health after healing
     * @param amt       The amount of HP that is being added
     * @return          Validity of heal (if it worked or not)
     */
    public boolean AddHP(int amt)
    {
        if (this.currHP > 0) { // Checking if character is dead
            if (this.currHP + amt <= this.MAX_HP) {
                this.currHP += amt; // Adds given amt to current HP
                return true;
            }
            else {
                this.currHP = this.MAX_HP; // Sets HP to max if amt exceeds max
                return true;
            }
        }
        else {
            return false; // Heal does not work if character is dead
        }
    }

    /**
     * Updates a character's health after revival
     * @param amt       The amount of HP that is being added
     */
    public void Revive(int amt)
    {
        if (this.currHP + amt <= this.MAX_HP) {
            this.currHP += amt; // Adds given amt to HP
        }
        else {
            this.currHP = this.MAX_HP; // Sets HP to max if amt exceeds max
        }
    }

    /**
     * Updates a character's health after getting attacked
     * @param amt       The amount of HP that is being removed
     */
    public void LoseHP(int amt)
    {
        if (this.currHP - amt > 0) {
            this.currHP -= amt; // Removes given amt from HP
        }
        else {
            this.currHP = 0; // Sets HP to 0 if amt would go into negative health
        }

        System.out.println(this.GetName() + " took " + amt + " damage!");
    }
}