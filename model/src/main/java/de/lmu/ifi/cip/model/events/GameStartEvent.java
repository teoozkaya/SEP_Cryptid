package de.lmu.ifi.cip.model.events;

import de.lmu.ifi.cip.model.User;
import de.lmu.ifi.cip.model.board.Cell;
import java.util.ArrayList;

/** A Class which provides the information to create the GUi, when the game starts. */
public class GameStartEvent extends GameEvent {

  private ArrayList<ArrayList<Cell>> cellList;
  private int playerNumber;

  private ArrayList<User> userList;

  /**
   * Instantiates the Event.
   *
   * @param cellList the list of cells making up the map and holding relevant inforamtion for the
   *     cell layout
   * @param playerNumber number of players in the game
   * @param userList lsit of all players
   */
  public GameStartEvent(
      ArrayList<ArrayList<Cell>> cellList,
      int playerNumber,
      ArrayList<User> userList,
      ArrayList<String> playerIds) {
    this.cellList = cellList;
    this.playerNumber = playerNumber;
    this.userList = userList;
    this.playerIds = playerIds;
  }

  public ArrayList<ArrayList<Cell>> getCellList() {
    return cellList;
  }

  public int getPlayerNumber() {
    return playerNumber;
  }

  @Override
  public String getName() {
    return "GameStartEvent";
  }

  public ArrayList<User> getUserList() {
    return userList;
  }

  @Override
  public boolean equal(GameEvent e) {
    boolean b1 = getName().equals(e.getName());
    boolean b2 = getPlayerNumber() == ((GameStartEvent) e).getPlayerNumber();

    for (int i = 0; i < cellList.size(); i++) {
      for (int j = 0; j < cellList.get(i).size(); j++) {
        if (!cellList.get(i).get(j).equal(((GameStartEvent) e).getCellList().get(i).get(j))) {
          return false;
        }
      }
    }

    return b1 && b2;
  }
}
