# Dungeon Crawler - Chapter 1 Challenge 1.3

A text-based dungeon crawler game written in Java.

## Features
- **Randomized Rooms**: Encounter traps, healing potions, monsters, and treasure chests.
- **Combat System**: Guess the correct number to defeat monsters. Watch out, wrong guesses hurt!
- **Gold System**: Collect gold from chests and monsters.
- **Boss Battle**: Face the final boss in the last room.
- **Health Management**: Manage your health to survive the dungeon.
- **Object-Oriented Design**: The game logic is now split into multiple classes for better organization and extensibility.

## How to Run
1. Open the project in your IDE.
2. Run `Chapter1_Challenge_1_3.java`.
3. Follow the on-screen instructions.

## Rules
- You start with 100 Health.
- Navigate through 5 rooms.
- Survive traps and monsters.
- Collect as much gold as possible!

## Classes
- **Player**: Manages player health and gold.
- **GameEvent**: Abstract base class for all room events.
- **TrapEvent**: Deals damage to the player.
- **PotionEvent**: Heals the player.
- **MonsterEvent**: Handles combat with monsters and the boss.
- **TreasureEvent**: Awards gold to the player.
