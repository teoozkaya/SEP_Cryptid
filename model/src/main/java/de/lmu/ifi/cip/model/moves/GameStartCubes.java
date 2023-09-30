package de.lmu.ifi.cip.model.moves;

import de.lmu.ifi.cip.model.User;
import de.lmu.ifi.cip.model.board.Cell;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * this gamestate represents the first two rounds of every game where players are only allowed to
 * place cubes.
 */
public class GameStartCubes extends GameState {

  Queue<User> usersInLine;

  /**
   * Constructor for the gamestate in the first phase of the game.
   *
   * @param users a list of the in the game
   */
  public GameStartCubes(List<User> users) {
    super(users.get(0), MoveTypes.PLACE_CUBE);
    this.usersInLine = new LinkedList<>(users);
    this.usersInLine.poll();
  }

  public Queue<User> getUsersInLine() {
    return usersInLine;
  }

  public void setCurrentAllowedUser(User nextUser) {
    this.currentAllowedUser = nextUser;
  }

  @Override
  public boolean isAllowed(User user, MoveTypes moveType, Cell cell) {
    if (!user.equals(currentAllowedUser)) {
      return false;
    }
    if ((!moveType.equals(MoveTypes.PLACE_CUBE))) {
      return false;
    }
    return true;
  }
}
