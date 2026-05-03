// ENEMY NPC CHARACTER CLASS

public abstract class Enemy extends Character
{
    private String atk1_Name;
    private String atk2_Name;
    private String atk3_Name;

    /**
     * Constructor for Enemy type character
     * @param name      Enemy's name
     * @param hp        Enemy's max HP
     */
    public Enemy(String name, int hp)
    {
        super(name, hp);
        System.out.println("[!] A " + super.GetName() + " appears!");
    }

    /**
     * Provides enemy's attack name
     * @param atk       Attack number
     * @return          Name of attack
     */
    public String GetAtkName(int atk)
    {
        return switch (atk) {
            case 1 -> this.atk1_Name;
            case 2 -> this.atk2_Name;
            case 3 -> this.atk3_Name;
            default -> "Error";
        };
    }

    /**
     * Sets attack name, used in constructor
     * @param atk       Attack number
     * @param name      Name of attack
     */
    public void SetAtkName(int atk, String name)
    {
        switch (atk)
        {
            case 1 -> this.atk1_Name = name;
            case 2 -> this.atk2_Name = name;
            case 3 -> this.atk3_Name = name;
        }
    }

    public abstract void Atk1(Playable target);
    public abstract void Atk2(Playable target);
    public abstract void Atk3(Playable target);
}
