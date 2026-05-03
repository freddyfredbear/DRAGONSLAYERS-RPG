import java.util.Scanner;

public class MainGame
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        GameMethods gm = new GameMethods();

        /* Creating all characters */
        Playable Knight = new Knight("KNIGHT",100);
        Playable Mage = new Mage("MAGE",100);
        Playable Rogue = new Rogue("ROGUE",100);
        Playable Brute = new Brute("BRUTE",100);

        Friendly King = new Friendly("King Eldrin", 100);
        Friendly OldMan = new Friendly("Old Man", 100);
        Friendly MystWoman = new Friendly("Mysterious Woman", 100);

        /* Initializing variables */
        String Player_Name;
        boolean Valid;
        boolean Victory;
        String Choice;
        Playable[] Party = new Playable[]{Knight, Mage, Rogue, Brute};
        Item[] Inventory = new Item[3];

        /* Creating items */
        Item Herb = new ReviveHerb();
        Item Pie = new WitchPie();
        Item Pot = new Potion();

        /* Game start */
        System.out.println(". . .\n");

        System.out.println("[ " + King.GetName() + " ]");
        System.out.println("Ah, thank you for arriving, brave one. What is your name?\n");
        
        /* USER ENTERS A NAME */
        do {
            System.out.print(">> ");
            Player_Name = input.nextLine();

            Valid = !Player_Name.equals("");
            if (!Valid) {
                System.out.println("Error! Please enter a name.");
            }
        } while (!Valid);

        System.out.println("\n[ " + King.GetName() + " ]");
        System.out.println("General " + Player_Name + ", I have a mission for you...");
        System.out.println("""
                A great dragon has stolen our kingdom's ancient relic and taken refuge atop
                Terrafore Mountain at Embers Peak. We need you to retrieve it. Beware, the
                path is dangerous, and not all who wander it return. Do you accept this quest?\n""");

        /* USER ENTERS YES OR NO */
        Choice = gm.YesNo();

        /* KING'S REACTION TO USER'S CHOICE */
        System.out.println("\n[ " + King.GetName() + " ]");
        if (Choice.toUpperCase().equals("NO")) {
            System.out.println("Wonderfu- ... oh. What?");
            System.out.println("Ah, a humourous joke. Haha. ");
        }
        else {
            System.out.println("Excellent! Your bravery is greatly appreciated. ");
        }

        GameMethods.Wait(1000);

        // King introduces the party members to the player
        System.out.println("\n[ " + King.GetName() + " ]");
        System.out.println("""
                Please follow me out to the castle gates so you can meet the team we've
                prepared to accompany you on this journey...""");

        GameMethods.Wait(2000);

        System.out.println("\n[ At the Castle Gates ]");

        System.out.println("\n[ " + King.GetName() + " ]");
        System.out.println("""
                Knight: Strong and loyal, protector of the weak.
                Mage: Wielder of powerful elemental magic.
                Rogue: Swift, cunning, and deadly in the shadows.
                Brute: Powerful tank, able to give and take a beating.""");

        GameMethods.Wait(2500);

        // User receives a revive herb from the King
        System.out.println("\n[ " + King.GetName() + " ]");
        System.out.println("To begin your journey, I've prepared a small gift for you.");

        /* HERB IS ADDED TO INVENTORY */
        gm.AddInv(Inventory, Herb);
        
        /* ADVENTURE BEGINS */
        System.out.println("\n. . .\n");
        GameMethods.Wait(2000);

        System.out.println("""
                As you travel through the dark woods, you notice some rustling leaves.
                Suddenly, a small figure bursts through the trees - it's a Goblin!\n""");

        GameMethods.Wait(1000);

        /* FIRST BATTLE : GOBLIN */
        Enemy gob = new Goblin("GOBLIN");
        do {
            Victory = gm.Battle(gob, Party, Inventory);
        } while (!Victory);
        System.out.println(gob.GetName() + " defeated!\n");

        /* ADVENTURE CONTINUES */
        System.out.println("""
                After defeating the goblin, your team carries on venturing through the woods.
                You come across a small crooked hut, smoke rising from its chimney. As you
                approach the hut, an old woman standing outside sees you and smiles.\n""");

        GameMethods.Wait(1500);

        System.out.println("[ " + MystWoman.GetName() + " ]");
        System.out.println("""
                Good day adventurers. You lot look hungry. Please, come inside for some pie...!
                Freshly baked with my homegrown fruits!\n""");

        GameMethods.Wait(1000);

        System.out.println("""
                Your stomach growls as the aroma of the pie reaches your nose. Cinnamon,
                butter, apples, and... an ingredient that smells strange... something is
                wrong. The Mage sense dark magic from this woman. It's a WITCH in disguise!\n""");

        GameMethods.Wait(1500);

        /* SECOND BATTLE : WITCH */
        Enemy wtch1 = new Witch("WITCH");
        do {
            Victory = gm.Battle(wtch1, Party, Inventory);
        } while (!Victory);
        System.out.println(wtch1.GetName() + " defeated!\n");

        /* PIE IS ADDED TO INVENTORY */
        System.out.println("""
                The group takes a moment to rest. Before leaving, you grab the
                slice of pie sitting by the window.""");

        gm.AddInv(Inventory, Pie);

        /* PARTY IS HEALED */
        for (int i = 0; i < Party.length; i++)
        {
            Party[i].AddHP(100);
        }

        GameMethods.Wait(1000);

        /* ADVENTURE CONTINUES */
        System.out.println("""
                \nThe group continues to traverse through the forest. You approach
                a fork in the road... where will you go?\n
                Left: A sweet melody echoes from a distant lake.
                Right: Continue on the path into the forest.\n""");

        /* USER CHOOSES A PATH */
        do {
            System.out.print(">> ");
            Choice = input.nextLine();

            switch (Choice.toUpperCase())
            {
                case "LEFT":
                case "L":
                    Choice = "L";
                    Valid = true;
                    break;
                case "RIGHT":
                case "R":
                    Choice = "R";
                    Valid = true;
                    break;
                default:
                    System.out.println("Error! Please enter valid choice. (left or right)");
                    Valid = false;
                    break;
            }
        } while(!Valid);

        if (Choice.equals("L"))
        {
            /* LEFT PATH */
            System.out.println("""
                \nYou walk down a foggy road leading to a lake shore. An unmanned boat eerily
                drifts towards you. As you begin to board it, a siren emerges from the water
                to attack, singing a haunting melody!\n""");

            GameMethods.Wait(1500);

            /* THIRD BATTLE : SIREN */
            Enemy srn = new Siren("SIREN");
            do {
                Victory = gm.Battle(srn, Party, Inventory);
            } while (!Victory);
            System.out.println(srn.GetName() + " defeated!\n");

            GameMethods.Wait(1000);

            System.out.println("""
                    After you defeat the siren, you row the boat to the other side of the
                    lake and continue on your journey.""");
        }
        else if (Choice.equals("R"))
        {
            /* RIGHT PATH */
            System.out.println("""
                \nYou continue on the path through the forest and stumble upon an unassuming
                old man sitting by some rocks.\n""");

            GameMethods.Wait(1000);

            /* TIC-TAC-TOE : OLD MAN */
            System.out.println("[ " + OldMan.GetName() + " ]");
            System.out.println("Hello traveller. Would you like to play a game for a prize?");

            Choice = gm.YesNo();
            
            /* TIC-TAC-TOE STARTS */
            if (Choice.toUpperCase().equals("YES") || Choice.toUpperCase().equals("Y"))
            {
                boolean tttWin, cont;
                int numGames = 0;

                do
                {
                    TicTacToe t = new TicTacToe(OldMan);
                    tttWin = t.Game();
                    numGames += 1;

                    if (tttWin) {
                        /* POTION IS ADDED TO INVENTORY */
                        gm.AddInv(Inventory, Pot);
                    }

                    if (numGames < 3) {
                        System.out.println("[ " + OldMan.GetName() + " ]");
                        System.out.println("That was fun, do you want to play again?");

                        Choice = gm.YesNo();
                        cont = Choice.equals("YES") || Choice.equals("Y");
                    }
                    else {
                        cont = false;
                    }
                    
                } while (cont);

                System.out.println("\n[ " + OldMan.GetName() + " ]");
                System.out.println("Thank you for playing with me. Be careful on your adventures!");
            }
            else { /* IF USER CHOOSES NOT TO PLAY */
                System.out.println("\n[ " + OldMan.GetName() + " ]");
                System.out.println("That's alright. Have fun on your travels!");
            }
        }

        GameMethods.Wait(1000);

        /* ADVENTURE CONTINUES */
        System.out.println("""
                \nYou travel on for a few hours before resting outside some
                abandoned ruins. The forest is unnaturally quiet... You
                hear some rustling in the bushes nearby, but the second you
                get close enough to realize what it is, a gang of 4 goblins
                surprise attack you!\n""");
        
        GameMethods.Wait(2000);

        /* FOURTH BATTLE : GOBLIN GANG */
        /* FIRST GOBLIN */
        Enemy gob1 = new Goblin("GOBLIN 1");
        do { 
            Victory = gm.Battle(gob1, Party, Inventory);
        } while (!Victory);
        System.out.println(gob1.GetName() + " defeated!\n");

        /* SECOND GOBLIN */
        Enemy gob2 = new Goblin("GOBLIN 2");
        do { 
            Victory = gm.Battle(gob2, Party, Inventory);
        } while (!Victory);
        System.out.println(gob2.GetName() + " defeated!\n");

        /* THIRD GOBLIN */
        Enemy gob3 = new Goblin("GOBLIN 1");
        do { 
            Victory = gm.Battle(gob3, Party, Inventory);
        } while (!Victory);
        System.out.println(gob3.GetName() + " defeated!\n");

        /* FOURTH GOBLIN */
        Enemy gob4 = new Goblin("GOBLIN 1");
        do { 
            Victory = gm.Battle(gob4, Party, Inventory);
        } while (!Victory);
        System.out.println(gob4.GetName() + " defeated!\n");

        GameMethods.Wait(1000);

        System.out.println("""
            You decide to take your leave after your fight, as the ruins
            are certainly not a safe place to rest.\n""");
        
        GameMethods.Wait(1000);

        System.out.println("""
            Exhausted but determined, you continue forward for hours, until
            you see a large clearing.\n""");

        GameMethods.Wait(1000);
        
        System.out.println("""
            Having survived all the challenges, you step outside the dark
            forest for the first time in days. A sense of dread overcomes
            you as you look at what awaits- the final stretch.\n""");

        GameMethods.Wait(1000);

        System.out.println("""
            You take a moment to process your terror. There's no turning back
            now. You swallow your fear and approach the foot of Terrafore
            Mountain, home of the Decaying Dragon Envir.\n""");

        GameMethods.Wait(3000);

        System.out.println("""
                You climb up about halfway up the mountain, avoiding any
                potential fights, when you hear a snarling noise behind some
                rocks just up ahead.\n""");

        GameMethods.Wait(1000);

        System.out.println("""
                You've felt its presence a few times, and realize how it's
                been stalking you since you first stepped foot on its home. But
                it's not trying to hide itself anymore- and it's angry.\n""");

        GameMethods.Wait(1000);

        System.out.println("""
                You find yourself face to face with an enraged Wulver. Prepare
                for a tough fight!\n""");

        GameMethods.Wait(2000);

        /* FIFTH BATTLE : WULVER (mini boss) */
        Enemy wlvr = new Wulver("WULVER");
        do {
            Victory = gm.Battle(wlvr, Party, Inventory);
        } while (!Victory);
        System.out.println(wlvr.GetName() + " defeated!\n");

        GameMethods.Wait(1000);

        System.out.println("""
                After this powerful foe, you take your time to rest up. This
                high up the mountain, you can even hear the dragon roar.
                It's time for your final climb up to the summit.\n""");

        /* PARTY IS HEALED */
        for (int i = 0; i < Party.length; i++)
        {
            Party[i].AddHP(100);
        }

        GameMethods.Wait(1000);

        System.out.println("""
                You finally reach the top of the mountain, Embers Peak.
                Looking down, you can only see a vast blanket of clouds. You
                ignore the insane realization of just how high up you are
                and march into the giant cave in front of you.\n""");

        GameMethods.Wait(2000);

        System.out.println("""
                It's pitch black inside, and eventually you walk into a big
                pile of gold coins and trinkets, knocking it over. Suddenly,
                you're hit with a blast of heat as the entire cave rumbles.\n""");

        GameMethods.Wait(2000);

        System.out.println("""
                The Decaying Dragon Envir, now awoken by your presence, lets
                out a thunderous roar, prepared to defend its treasures. This
                is the final fight.\n""");

        GameMethods.Wait(2500);

        /* SIXTH BATTLE : DRAGON (final boss) */
        Enemy drgn = new Dragon("THE DECAYING DRAGON ENVIR");
        do {
            Victory = gm.Battle(drgn, Party, Inventory);
        } while (!Victory);
        System.out.println(drgn.GetName() + " defeated!\n");

        GameMethods.Wait(1000);

        System.out.println("""
                The uproar from the fight causes everything to cave in! You
                snatch the relic and narrowly escape from the collapsing
                dragon's lair.\n""");

        GameMethods.Wait(1000);

        System.out.println("""
                The dragon Envir has been slain and the relic
                retreived. You relish in relief for a few moments, before
                beginning the long road back to the castle. Good work!\n""");

        System.out.println(". . .\n");
        GameMethods.Wait(2000);

        System.out.println("[ " + King.GetName() + " ]");
        System.out.println("General " + Player_Name + ", you've done it!" 
            + "\nThe relic is back in safe hands.");

        GameMethods.Wait(1000);

        System.out.println("""
                The people rejoice, and a feast awaits you in the Great Hall.
                This kingdom shall remember your name for generations!\n""");

        System.out.println(". . .");
        GameMethods.Wait(1000);

        System.out.println("END");

        /* GAME ENDS */
        input.close();
    }
}