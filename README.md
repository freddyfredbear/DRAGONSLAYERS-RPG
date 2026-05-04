# DRAGONSLAYERS RPG 

> a text-based, turn-based fantasy RPG where you play as a group of heroes on a quest to slay a great dragon.

## About the game
DRAGONSLAYERS RPG is a a text-based, turn-based fantasy RPG built in Java for a collaborative academic project where you fight your way through a series of enemies to beat the dragon boss. Strategize using each of your heroes' unique skillsets and items you collect along your journey to slay the Decaying Dragon Envir! This game was designed using core Object-Oriented Programming principles, featuring a full class hierarchy, four playable character classes, a variety of enemy types, a combat system with unique abilities for each hero, a complete shared inventory system, and a mid-quest minigame.

## How to Run

### Requirements:
- [Java JDK 8+](https://www.oracle.com/java/technologies/downloads/) installed

**Option 1: Command Line**
```bash
#1. Clone repository
git clone https://github.com/freddyfredbear/dragonslayers-rpg.git
cd dragonslayers-rpg
 
#2. Compile all Java files
javac *.java
 
#3. Run the game
java MainGame
```
**Option 2 — IDE **
1. Open the project folder in your IDE
2. Make sure all `.java` files are in the same source directory
3. Run `MainGame.java` as the entry point
   
I can confirm VS code but others should work the same as well

## Playable Classes

| Class | Description |
|-------|-----------|
| **Knight** | A balanced hero with multi-hit combos and a high risk power strike |
| **Mage** | A flexible spellcaster hero capable of dishing out damage and healing the party |
| **Rogue** | A fast attacker with multi-hit abilities and burst damage |
| **Brute** | A high risk high reward tank that hits hard and can take a beating |

Each class has **4 unique abilities** with variable damage ranges, hit counts, and side effects. They were designed to provide variety between each hero and fulfill a unique role so the player can strategize each encounter accordingly.

## Enemies
- Goblin
- Witch
- Siren
- Wulver
- Dragon

## Inventory System
Manage up to three consumable item types to aid you in battles:
- **Potion** heals a living party member for 30 HP
- **Revive Herb** revives a fallen party member or heals a living one for 20HP
- **Witch Pie** brings any party member to 30 HP, dead or alive (👀)

## TicTacToe Minigame
Play a short best of 3 TicTacToe match against an NPC for a **Potion** reward.

## Architecture
Designed using OOP principles with a class hierarchy:

```
Character (abstract base)
├── Playable.....> Knight, Mage, Rogue, Brute
├── Enemy.....> Goblin, Witch, Siren, Wulver, Dragon
└── Friendly.....> NPC characters

Item (abstract base)
├── Potion
├── ReviveHerb
└── WitchPie

GameMethods.....> Combat engine, turn-based logic, item use, GUI output
TicTacToe.....> Minigame logic and NPC interaction
MainGame.....> Entry point and game flow
```
UML diagram available in [`docs/RPG UML - Page 1 (9).png`](https://github.com/freddyfredbear/DRAGONSLAYERS-RPG/blob/main/docs/RPG%20UML%20-%20Page%201%20(9).png)

## Testing
All game systems were manually tested and documented
- 20+ test cases covering every attack function, item interaction, and edge case
- all 4 attacks tested for every playable class on every enemy type
- Inventory system edge cases tested (using items on dead characters, empty inventory, etc.)
- Bugs tracked and fixed throughout development

Full test case documentation available in [`docs/Test Cases.docx`](https://github.com/freddyfredbear/DRAGONSLAYERS-RPG/blob/main/docs/Test%20Cases.docx)

## Built With
- Java
- OOP (class inheritance, polymorphism, abstract classes)
- Collaborative team development
