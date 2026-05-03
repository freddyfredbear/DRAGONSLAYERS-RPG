// FRIENDLY NPC CHARACTER CLASS

public class Friendly extends Character
{
    /**
     * Constructor for a Friendly NPC given name
     * @param name      Name of NPC
     */
    public Friendly(String name)
    {
        super(name);
    }
    
    /**
     * Constructor for a Friendly NPC given name and HP
     * @param name      Name of NPC
     * @param hp        NPC's maximum health
     */
    public Friendly(String name, int hp)
    {
        super(name, hp);
    }
}
