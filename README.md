# Cryptid
## Project description

 A 2D implementation of the board game cryptid which can be played with 3 to 5 players.

 Cryptid is a unique deduction game of honest misdirection in which players must try to uncover information about their opponents' clues while throwing them off the scent of their own. Each player holds one piece of evidence to help them find the creature, and on their turn they can try to gain more information from their opponents. Be warned; give too much away and your opponents might beat you to the mysterious animal and claim the glory for themselves!

## Game modes
 2 game modes are possible:
 - Hotseat mode: To play at a single computer at a friendly or competitional gathering.
 - Multiplayer: To play online with people you can't meet up.

 Also you can choose the game's difficulty according to your mood:
 - Simple: Map with 3 stones and 3 huts.
 - Advanced: Map now has 4 stones and 4 huts so the clues get more complicated, since there are more structures on the map.

## Features
- There are 19 simple and 35 advanced maps in the game and you get the map randomly so you won't get bored.
- It is cheatproof! Cube placement or disc placement is checked by the game. You don't have to worry about someone cheating or making a mistake.

## Local Installation

After downloading the project you can easily open the game with the help of gradle. You can use the command-line terminal to build and run the project. 

These are the commands you can use:
- `gradlew`: To set up gradle.
- `gradlew asemble`: To build the code automatically.
- `gradlew run`: To launch the server and client codes of the applicationat the same time.
 

And for each command, if you press ⌘⏎ (macOS), or Ctrl+Enter (Windows/Linux), this command will be run in IntelliJ IDEA. In this case, the Run tool window is opened and the command is run there. You see the results the same way we would have if you'd run the command from the Gradle Tool Window. You can always use the Gradle Tool Window to make it less complicated.

## Dependencies

- GSon: The communication from client to server and server to clients is fulfilled through json.
- JUnit: Used to check the written code.

## Game manual 
Link to manual: http://www.skellig-rules.de/rules/0048-0004/CRYPTIDRepr_Rulebook_print5_DE2%20xs.pdf