package de.lmu.ifi.cip.model;

import de.lmu.ifi.cip.model.board.Board;
import de.lmu.ifi.cip.model.board.Building;
import de.lmu.ifi.cip.model.board.Cell;
import de.lmu.ifi.cip.model.board.Structure;
import java.util.ArrayList;

/** Implements the class Game, which represents a game of Cryptid. */
public class Game {

  private int numberOfPlayers;
  private ArrayList<Hint> hints = new ArrayList<>();
  private Board board;
  private boolean isSimple;
  private Structure structure;
  private ArrayList<User> users = new ArrayList<>();

  /**
   * Creates a Game Object.
   *
   * @param isSimple boolean, which signifies, the game mode. For true a normal game starts, for
   *     false an advanced game starts.
   * @param numberOfPlayers the number of players a game will have. In the range of 3-5
   */
  public Game(boolean isSimple, int numberOfPlayers, ArrayList<String> playerIdList) {
    this.numberOfPlayers = numberOfPlayers;
    this.isSimple = isSimple;

    if (isSimple) {
      this.structure = Structure.randomSimple();
    } else {
      this.structure = Structure.randomAdvanced();
    }
    this.board = new Board(structure.getOrder());
    placeBuildings(structure.getBuildingList());

    createUsers(numberOfPlayers, playerIdList);

    if (numberOfPlayers == 3) {
      setHints(structure.getThreePlayerHints());
    } else if (numberOfPlayers == 4) {
      setHints(structure.getFourPlayerHints());
    } else if (numberOfPlayers == 5) {
      setHints(structure.getFivePlayerHints());
    }
    for (int i = 0; i < users.size(); i++) {
      users.get(i).setHint(hints.get(i));
    }
  }

  /**
   * Method to set the Hints for this specific game.
   *
   * @param hintIds An Array of integers, which symbolizes the hints for a specific game.
   */
  public void setHints(int[] hintIds) {
    for (int i = 0; i < hintIds.length; i++) {
      Hint hint = new Hint("");
      this.hints.add(new Hint(hint.getHint(hintIds[i])));
    }
  }

  /**
   * Creates the User for a specific game.
   *
   * @param numberOfPlayers total number of players.
   */
  public void createUsers(int numberOfPlayers, ArrayList<String> playerIdList) {
    for (int i = 0; i < numberOfPlayers; i++) {
      User user = new User(i, playerIdList.get(i));
      users.add(user);
    }
  }

  /**
   * Creates a list of the playerIds of the players in the game.
   *
   * @return a list of player ids
   */
  public ArrayList<String> createPlayerIdList() {
    ArrayList<String> playerIdList = new ArrayList<>();
    for (User user : this.getUsers()) {
      playerIdList.add(user.getPlayerId());
    }
    return playerIdList;
  }

  /** A method to restart the currently running game. */
  public void restart() {
    ArrayList<ArrayList<Cell>> board = this.getBoard().getCellList();
    for (ArrayList<Cell> ac : board) {
      for (Cell c : ac) {
        c.removeAllPlaceables();
      }
    }
  }

  public Board getBoard() {
    return board;
  }

  public ArrayList<Hint> getHints() {
    return hints;
  }

  public ArrayList<User> getUsers() {
    return users;
  }

  /**
   * Method that places buildings on cells based on the specific game.
   *
   * @param bl a specific list of buildings.
   */
  public void placeBuildings(ArrayList<Building> bl) {
    ArrayList<ArrayList<Cell>> cellList = board.getCellList();
    for (Building b : bl) {
      for (ArrayList<Cell> row : cellList) {
        for (Cell c : row) {
          if (b.getCoordinate().equals(c.getCoordinate())) {
            c.setBuilding(b);
          }
        }
      }
    }
  }
}
