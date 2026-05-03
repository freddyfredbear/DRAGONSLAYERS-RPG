/* GAME & BATTLE METHODS */
import java.util.Scanner;

public class GameMethods
{
    Scanner input = new Scanner(System.in);

    /**
     * Prints the battle menu with two buttons
     * @param but1      Title of button 1
     * @param but2      Title of button 2
     * @param enemy     Current enemy
     * @param party     User's entire party
     */
    public void PrintGUI(String but1, String but2, Enemy enemy, Playable[] party)
    {
        // format party boxes
        String C1HP = GUIFormat(party[0].GetHP() + "/" + party[0].GetMaxHP(),1);
        String C1NAME = GUIFormat(party[0].GetName(),1);
        String C2HP = GUIFormat(party[1].GetHP() + "/" + party[1].GetMaxHP(),1);
        String C2NAME = GUIFormat(party[1].GetName(),1);
        String C3HP = GUIFormat(party[2].GetHP() + "/" + party[2].GetMaxHP(),1);
        String C3NAME = GUIFormat(party[2].GetName(),1);
        String C4HP = GUIFormat(party[3].GetHP() + "/" + party[3].GetMaxHP(),1);
        String C4NAME = GUIFormat(party[3].GetName(),1);

        // format enemy box
        String ENAME = GUIFormat(enemy.GetName(),2);
        String EHP = GUIFormat( (enemy.GetHP() + "/" + enemy.GetMaxHP() +" "+ enemy.HPBar(0)), 2 );

        // printing gui
        System.out.println("╔══════════╗ ╔═════════════════════════════════════╗ ╔══════════╗");
        System.out.println("║"+ C1NAME +"║ ║"+ ENAME +"║ ║"+ C2NAME +"║");
        System.out.println("║"+ party[0].HPBar(0) +"║ ║"+ EHP +"║ ║"+ party[1].HPBar(0) +"║");
        System.out.println("║"+ C1HP +"║ ╚═════════════════════════════════════╝ ║"+ C2HP +"║");
        System.out.println("╚══════════╝                                         ╚══════════╝");
        System.out.println("╔══════════╗╔═══════════════════╦═══════════════════╗╔══════════╗");
        System.out.println("║"+ C3NAME +"║║                   ║                   ║║"+ C4NAME +"║");
        System.out.println("║"+ party[2].HPBar(0) +"║║ 1 "+ GUIFormat(but1,3) +" ║ 2 "
                            + GUIFormat(but2,3) +" ║║" + party[3].HPBar(0) +"║");
        System.out.println("║"+ C3HP +"║║                   ║                   ║║"+ C4HP +"║");
        System.out.println("╚══════════╝╚═══════════════════╩═══════════════════╝╚══════════╝");
    }

    /**
     * Prints the battle menu with four buttons
     * @param but1      Title of button 1
     * @param but2      Title of button 2
     * @param but3      Title of button 3
     * @param but4      Title of button 4
     * @param enemy     Current enemy
     * @param party     User's entire party
     */
    public void PrintGUI(String but1, String but2, String but3, String but4, Enemy enemy, Playable[] party)
    {
        // format party boxes
        String C1HP = GUIFormat(party[0].GetHP() + "/" + party[0].GetMaxHP(),1);
        String C1NAME = GUIFormat(party[0].GetName(),1);
        String C2HP = GUIFormat(party[1].GetHP() + "/" + party[1].GetMaxHP(),1);
        String C2NAME = GUIFormat(party[1].GetName(),1);
        String C3HP = GUIFormat(party[2].GetHP() + "/" + party[2].GetMaxHP(),1);
        String C3NAME = GUIFormat(party[2].GetName(),1);
        String C4HP = GUIFormat(party[3].GetHP() + "/" + party[3].GetMaxHP(),1);
        String C4NAME = GUIFormat(party[3].GetName(),1);

        // format enemy box
        String ENAME = GUIFormat(enemy.GetName(),2);
        String EHP = GUIFormat( (enemy.GetHP() + "/" + enemy.GetMaxHP() +" "+ enemy.HPBar(0)), 2 );

        // printing gui
        System.out.println("╔══════════╗ ╔═════════════════════════════════════╗ ╔══════════╗");
        System.out.println("║"+ C1NAME +"║ ║"+ ENAME +"║ ║"+ C2NAME +"║");
        System.out.println("║"+ party[0].HPBar(0) +"║ ║"+ EHP +"║ ║"+ party[1].HPBar(0) +"║");
        System.out.println("║"+ C1HP +"║ ╚═════════════════════════════════════╝ ║"+ C2HP +"║");
        System.out.println("╚══════════╝                                         ╚══════════╝");
        System.out.println("╔══════════╗╔═══════════════════╦═══════════════════╗╔══════════╗");
        System.out.println("║"+ C3NAME +"║║ 1 "+ GUIFormat(but1,3) +" ║ 2 "
                            + GUIFormat(but2,3) +" ║║"+ C4NAME +"║");
        System.out.println("║"+ party[2].HPBar(0) +"║╠═══════════════════╬" 
                            + "═══════════════════╣║"+ party[3].HPBar(0) +"║");
        System.out.println("║"+ C3HP +"║║ 3 "+ GUIFormat(but3,3) +" ║ 4 "
                            + GUIFormat(but4,3) +" ║║"+ C4HP +"║");
        System.out.println("╚══════════╝╚═══════════════════╩═══════════════════╝╚══════════╝");
    }

    /**
     * Formats text for GUI buttons
     * @param text      Text that is to be formatted
     * @param type      Type of button the text will be in
     * @return          Formatted string, aligned with empty spaces where needed
     */
    public String GUIFormat(String text, int type)
    {
        int padding; // amount of empty spaces around text
        String leftPad; // text formatted with empty spaces on the left
        switch (type)
        {
            case 1 -> {
                /* party members box (name, health num) */
                padding = (10 - text.length()) / 2;
                leftPad = String.format("%" + (padding + text.length()) + "s", text);
                return String.format("%-10s", leftPad);
            }
            case 2 -> {
                /* enemy box (name, health num) */
                padding = (37 - text.length()) / 2;
                leftPad = String.format("%" + (padding + text.length()) + "s", text);
                return String.format("%-37s", leftPad);
            }
            case 3 -> {
                /* action buttons */
                return String.format("%-15s", text);
            }
        }
        return "Error!";
    }

    /**
     * Takes in user's input during battle (in the form of integers)
     * @param min       Minimum option
     * @param max       Maximum option
     * @return          User's chosen option
     */
    public int MenuChoice(int min, int max)
    {
        int choice; // user's choice
        boolean valid; // validity of choice (within range)

        do {
            System.out.print(">> ");
            choice = input.nextInt();
            input.nextLine(); /*absorb hanging line*/

            valid = (choice >= min && choice <= max); // checking if valid

            if (!valid) {
                System.out.println("Error! Invalid choice.");
            }
        } while (!valid); // loop until valid choice is entered
        return choice;
    }

    /**
     * PLAYER'S TURN - user chooses to fight or use items
     * @param enemy     Current enemy
     * @param party     User's entire party
     * @param inv       User's inventory
     */
    public void PlayerTurn(Enemy enemy, Playable[] party, Item[] inv)
    {
        boolean valid; // validity of choice
        int choice; // choice
        do {
            PrintGUI("FIGHT","ITEMS",enemy,party);
            choice = MenuChoice(1,2);

            switch (choice)
            {
                case 1:
                    /* FIGHT */
                    valid = Fight(enemy, party);
                    break;
                case 2:
                    /* ITEMS */
                    valid = Items(enemy, party, inv);
                    break;
                default:
                    valid = false;
            }
        } while (!valid); /* if failed, rerun */
    }

    /**
     * FIGHT MENU - user chooses a character and attack to use against enemy
     * @param enemy     Current enemy
     * @param party     User's entire party
     * @return          Validity of move
     */
    public boolean Fight(Enemy enemy, Playable[] party)
    {
        /* SELECT A CHARACTER TO USE */
        PrintGUI(party[0].GetName(),party[1].GetName(),party[2].GetName(),
                party[3].GetName(),enemy,party);
        int chr = MenuChoice(1,4);

        if (party[chr-1].GetHP() <= 0) {
            /* Return false if chosen character is dead */
            System.out.println(party[chr-1].GetName() + " has fallen. " 
                + "Revive them or select another hero!");
            return false;
        }
        else {
            /* SELECT AN ATTACK TO USE */
            PrintGUI(party[chr - 1].GetAtkName(1),party[chr - 1].GetAtkName(2),
                    party[chr - 1].GetAtkName(3),party[chr - 1].GetAtkName(4),
                    enemy,party);
            int atk = MenuChoice(1,4);
            switch (atk)
            {
                case 1 -> {
                    party[chr - 1].Atk1(enemy);
                    return true;
                }
                case 2 -> {
                    party[chr - 1].Atk2(enemy, party);
                    return true;
                }
                case 3 -> {
                    party[chr - 1].Atk3(enemy, party);
                    return true;
                }
                case 4 -> {
                    party[chr - 1].Atk4(enemy);
                    return true;
                }
                default -> {
                    return false;
                }
            }
        }
    }

    /**
     * ITEMS MENU - user accesses inventory and chooses an item to use
     * @param enemy     Current enemy
     * @param party     User's entire party
     * @param inv       User's inventory
     * @return          If an item was used
     */
    public boolean Items(Enemy enemy, Playable[] party, Item[] inv)
    {
        boolean valid; // validity of item use
        int choice, chr; // user's item choice and character choice
        String[] names = {"-","-","-"}; // default name for inventory menu
        String[] qty = {"0", "0", "0"}; // default amount for inventory menu

        /* REPLACING EMPTY BUTTONS WITH INVENTORY ITEMS */
        for (int i = 0; i < inv.length; i++) {
            if (inv[i] != null) {
                names[i] = inv[i].GetName();
                qty[i] = Integer.toString(inv[i].GetQty());
            }
        }

        /* SELECT AN ITEM TO USE */
        PrintGUI(names[0] + "(" + qty[0] + ")", names[1] + "(" + qty[1] + ")", 
                names[2] + "(" + qty[2] + ")", "BACK",enemy,party);
        choice = MenuChoice(1,4);

        if (choice == 4) {
            // exit inventory menu, back to Player_Turn
            return false;
        }
        else if (Integer.parseInt(qty[choice-1]) > 0) {
            /* SELECT A CHARACTER TO USE ITEM ON */
            System.out.println("Choose a character to use " + inv[choice-1].GetName() + " on:");
            PrintGUI(party[0].GetName(),party[1].GetName(),party[2].GetName(),
                    party[3].GetName(),enemy,party);
            chr = MenuChoice(1,4);

            // Checking if item use succeeded
            valid = inv[choice-1].Use(party[chr-1]);
            return valid;
        }
        else {
            System.out.println("Error! Item unavailable.");
            return false;
        }
    }

    /**
     * ENEMY TURN - Chooses an attack to use against a character in the player's party
     * @param enemy     Current enemy
     * @param party     User's entire party
     * @return          Validity of attack
     */
    public boolean EnemyTurn(Enemy enemy, Playable[] party)
    {
        int max, atk, target;
        if (enemy.GetName().equals("DRAGON") 
            || enemy.GetName().equals("WULVER")) {
            max = 3; /* for boss enemies */
        }
        else {
            max = 2; /* regular enemies */
        }
        /* RANDOM NUMBER TO CHOOSE ATTACK */
        atk = enemy.RandInt(1,max);

        /* RANDOM NUMBER TO CHOOSE TARGET */
        do {
            target = enemy.RandInt(1,4);
        } while (CheckDead(party[target-1]));

        switch (atk)
        {
            case 1 -> {
                enemy.Atk1(party[target-1]);
                return true;
            }
            case 2 -> {
                enemy.Atk2(party[target-1]);
                return true;
            }
            case 3 -> {
                enemy.Atk3(party[target-1]);
                return true;
            }
            default -> {
                return false;
            }
        }
    }

    /**
     * Checks if given character is dead
     * @param target    Character to check
     * @return          If character is dead
     */
    public boolean CheckDead(Character target)
    {
        if (target.GetHP() < 0)
        {
            target.AddHP(0 - target.GetHP()); // set hp to 0 if it is below
        }
        return target.GetHP() <= 0;
    }

    /**
     * Counts how many characters in the player's party are dead
     * @param party     User's entire party
     * @param ind       Index for recursion search
     * @return          Number of dead characters
     */
    public int CountDead(Playable[] party, int ind)
    {
        if (ind == party.length) {
            return 0;
        }
        else if (party[ind].GetHP() <= 0) {
            party[ind].AddHP(0 - party[ind].GetHP());
            return (1 + CountDead(party, ind+1));
        }
        else {
            return CountDead(party, ind+1);
        }
    }

    /**
     * MAIN BATTLE METHOD - Loops player and enemy turn until someone dies
     * @param enemy     Current enemy
     * @param party     User's entire party
     * @param inv       User's inventory
     * @return          If player defeated the enemy
     */
    public boolean Battle(Enemy enemy, Playable[] party, Item[] inv)
    {
        boolean EnemyDead;
        boolean PartyDead = (CountDead(party, 0) == 4);

        do
        {
            if (PartyDead)
            {
                System.out.println("Party has fallen. Battle failed! Restarting...");

                for (int i = 0; i < party.length; i++)
                {
                    party[i].Revive(20); // Revive party
                }
            }

            PlayerTurn(enemy, party, inv); // Player's turn to attack
            EnemyDead = CheckDead(enemy);

            if (!EnemyDead) { // If enemy has not died, enemy makes a move
                EnemyTurn(enemy, party);
                PartyDead = (CountDead(party, 0) == 4);
            }
        } while (!EnemyDead && !PartyDead);

        return EnemyDead;
    }

    /**
     * Adds an item to the inventory
     * @param inv       User's inventory
     * @param item      Item to add
     */
    public void AddInv(Item[] inv, Item item)
    {
        int index = SearchInv(inv, item, 0);
        if (inv[index] != null && inv[index].equals(item)) {
            item.AddQty(1);
        }
        else {
            inv[index] = item;
        }
        System.out.println("[ You have received (1) " + inv[index].GetName() + "! ]");
    }

    /**
     * Searches for an item in the player's inventory
     * @param inv       User's inventory
     * @param item      Item to look for
     * @param index     Index of search
     * @return          Index of item or last empty space
     */
    public int SearchInv(Item[] inv, Item item, int index)
    {
        if (inv[index] == item) {
            // returns position of item if found
            return index;
        }
        else if (inv[index] == null) {
            // return index of empty space if the key is not found
            return index;
        }
        else {
            // continues searching if not found
            return SearchInv(inv, item, index+1);
        }
    }

    /**
     * Takes in yes or no input from user
     * @return      User's input
     */
    public String YesNo()
    {
        String choice; // user's choice
        boolean valid; // validity of choice
        do {
                System.out.print(">> ");
                choice = input.nextLine();

                switch (choice.toUpperCase())
                { /* CHECKING IF VALID CHOICE */
                    case "YES":
                    case "Y":
                    case "NO":
                    case "N":
                        valid = true;
                        break;
                    default:
                        valid = false;
                        break;
                }
                if (!valid) { /* DISPLAY MESSAGE IF INVALID */
                    System.out.println("Error! Please enter a valid choice. (yes or no)");
                }
            } while (!valid); /* LOOP UNTIL USER ENTERS VALID CHOICE */
        return choice.toUpperCase();
    }

    /**
     * Pauses program for given amount of time
     * @param ms    Milliseconds to wait
     */
    public static void Wait(int ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
}