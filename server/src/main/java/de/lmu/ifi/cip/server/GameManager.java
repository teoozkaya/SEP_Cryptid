package de.lmu.ifi.cip.server;

import de.lmu.ifi.cip.model.Cryptid;
import java.util.ArrayList;

/** This class manages a specific game and its players. */
public class GameManager {

  private ArrayList<String> playerIdList = new ArrayList<>();
  private int playerNumber;
  private boolean gameMode;

  private Cryptid cryptid;
  private PlayerHandler playerHandler;
  private ArrayList<String> nicknameList = new ArrayList<>();

  /**
   * Constructor for the GameManager.
   *
   * @param playerNumber number of players allowed in thsi game
   * @param gameMode the gameMode of this game
   * @param playerId the playerId of the first player
   * @param playerHandler playerHandler instance
   */
  public GameManager(
      int playerNumber,
      boolean gameMode,
      String playerId,
      PlayerHandler playerHandler,
      ArrayList<String> nicknameList) {
    this.playerNumber = playerNumber;
    this.gameMode = gameMode;
    this.playerHandler = playerHandler;
    this.nicknameList.addAll(nicknameList);
    playerIdList.add(playerId);
  }

  /**
   * method checks if this GameManager has reached its player limit.
   *
   * @return true if the limit is not reached, false if the limit is reached.
   */
  public boolean gameNotFull() {
    if (playerIdList.size() >= playerNumber) {
      return false;
    }
    return true;
  }

  /**
   * This method checks if a specific player is part of this Game.
   *
   * @param playerId the id of a specific player
   * @return true if the player is part of this game, false if not.
   */
  public boolean contains(String playerId) {
    if (playerIdList.contains(playerId)) {
      return true;
    }
    return false;
  }

  /**
   * This Method adds a specific player to this Game.
   *
   * @param playerId the id of a specific player
   */
  public void addPlayer(String playerId, ArrayList<String> nicknameList) {
    if (gameNotFull()) {
      playerIdList.add(playerId);
      this.nicknameList.addAll(nicknameList);
      if (!gameNotFull()) {
        startGame();
      }
    }
  }

  /** starts a new game if the max player number is reached. */
  private void startGame() {
    cryptid = new Cryptid(new JsonWriter(playerHandler), null);
    cryptid.newGame(gameMode, playerNumber, playerIdList, nicknameList);
  }

  public int getPlayerNumber() {
    return playerNumber;
  }

  public boolean isGameMode() {
    return gameMode;
  }

  public Cryptid getCryptid() {
    return cryptid;
  }

  /**
   * removes a specific player from the list of players connected to the game.
   *
   * @param playerId id of the player that is removed
   */
  public void removePlayer(String playerId) {
    playerIdList.remove(playerId);
    if (cryptid != null) {
      cryptid.abortGame();
    }
  }
}
