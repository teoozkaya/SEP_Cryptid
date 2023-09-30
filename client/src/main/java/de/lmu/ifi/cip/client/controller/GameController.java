package de.lmu.ifi.cip.client.controller;

import de.lmu.ifi.cip.client.panels.GamePanel;
import de.lmu.ifi.cip.model.User;
import de.lmu.ifi.cip.model.board.Coordinate;
import java.util.ArrayList;

/**
 * Creates an abstract class of GameController. This implements the framework for all Controller.
 */
public abstract class GameController {

  protected User selectedPlayer;
  protected User activePlayer;
  protected Coordinate coordinate;
  protected GamePanel gamePanel;
  protected ArrayList<User> userList;

  /**
   * Method to start a game with a specific game mode and player number.
   *
   * @param gameMode of the Game to start.
   * @param playerNumber Number of players in the game.
   */
  public abstract void startGame(int gameMode, int playerNumber, ArrayList<String> nicknameList);

  /** Invokes a search on the given field. The given user is the initiator. */
  public abstract void searchField();

  /**
   * Asks the given target user, if the given cell is a valid habitat. Initiated by another user.
   */
  public abstract void askField();

  /** The given user want's to place a cube on the given cell. */
  public abstract void placeCube();

  /** The given user want's to place a disk on the given cell. */
  public abstract void placeDisk();

  /**
   * Saves a player for the methods {@link #askField()} and {@link #searchField()}.
   *
   * @param playerId of the User, which was selected.
   */
  public void setSelectedPlayer(String playerId) {
    for (User u : userList) {
      if (u.getPlayerId().equals(playerId)) {
        selectedPlayer = u;
      }
    }
  }

  public void setActivePlayer(User activePlayer) {
    this.activePlayer = activePlayer;
  }

  public User getActivePlayer() {
    return activePlayer;
  }

  /**
   * Saves the currently selected field for the methods {@link #askField()}, {@link #searchField()},
   * {@link #placeCube()} and, {@link #placeDisk()}.
   *
   * @param idX the x coordinate
   * @param idY thy y coordinate
   */
  public void setSelectedField(int idX, int idY) {
    coordinate = new Coordinate(idY, idX);
  }

  public void setUserList(ArrayList<User> userList) {
    this.userList = userList;
  }

  /** Tries to restart the current game. */
  public abstract void restartGame();

  /** Tries to abort the current game. */
  public abstract void abortGame();
}
