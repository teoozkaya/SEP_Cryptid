package de.lmu.ifi.cip.model.moves;

import de.lmu.ifi.cip.model.User;
import de.lmu.ifi.cip.model.board.Cell;

/** The Game state that represents a won Game. */
public class GameWon extends GameState {

  public GameWon(User currentAllowedUser) {
    super(currentAllowedUser);
  }

  @Override
  public boolean isAllowed(User user, MoveTypes moveTypes, Cell cell) {
    return false;
  }
}
