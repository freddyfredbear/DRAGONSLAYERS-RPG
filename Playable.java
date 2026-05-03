// PLAYABLE CHARACTER CLASS

public abstract class Playable extends Character
{
    private String Atk1_Name;
    private String Atk2_Name;
    private String Atk3_Name;
    private String Atk4_Name;

    /**
     * Constructor for a playable character
     * @param name      Name of the character
     * @param hp        Character's maximum health
     */
    public Playable(String name, int hp)
    {
        super(name, hp);
    }

    /**
     * Constructor for a playable character, with attack names
     * @param name      Name of the character
     * @param hp        Character's maximum health
     * @param atk1      Name of attack 1
     * @param atk2      Name of attack 2
     * @param atk3      Name of attack 3
     * @param atk4      Name of attack 4
     */
    public Playable(String name, int hp, String atk1, String atk2, String atk3, String atk4)
    {
        super(name, hp);
        this.Atk1_Name = atk1;
        this.Atk2_Name = atk2;
        this.Atk3_Name = atk3;
        this.Atk4_Name = atk4;
    }

    /**
     * Provides character's attack name
     * @param atk       Attack number
     * @return          Name of attack
     */
    public String GetAtkName(int atk)
    {
        return switch (atk) {
            case 1 -> this.Atk1_Name;
            case 2 -> this.Atk2_Name;
            case 3 -> this.Atk3_Name;
            case 4 -> this.Atk4_Name;
            default -> "Error";
        };
    }

    /**
     * Sets attack names, used in constructor
     * @param atk       Attack number
     * @param name      Name of attack
     */
    public void SetAtkName(int atk, String name)
    {
        switch (atk)
        {
            case 1 -> this.Atk1_Name = name;
            case 2 -> this.Atk2_Name = name;
            case 3 -> this.Atk3_Name = name;
            case 4 -> this.Atk4_Name = name;
        }
    }

    public abstract void Atk1(Enemy enemy);
    public abstract void Atk2(Enemy enemy, Playable[] party);
    public abstract void Atk3(Enemy enemy, Playable[] party);
    public abstract void Atk4(Enemy enemy);
}
