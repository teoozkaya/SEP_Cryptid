package de.lmu.ifi.cip.model.moves;

import de.lmu.ifi.cip.model.User;
import de.lmu.ifi.cip.model.board.Cell;
import java.util.Optional;
import java.util.Set;

/**
 * an abstract class for the different game states, that implements the basic functions of these
 * classes.
 */
public abstract class GameState {

  /**
   * Enums that specify the different types of moves that can be allowed in different game states.
   */
  public enum MoveTypes {
    PLACE_DISC,
    PLACE_CUBE,
    PLACE_PAWN;
  }

  User questioningUser;
  Set<MoveTypes> moveTypes;
  User currentAllowedUser;

  public GameState(User currentAllowedUser, MoveTypes... moveTypes) {
    this.currentAllowedUser = currentAllowedUser;
    this.moveTypes = Set.of(moveTypes);
  }

  public User getCurrentAllowedUser() {
    return currentAllowedUser;
  }

  public boolean moveIsAllowed(MoveTypes moveType, Optional<Cell> cell) {
    return this.moveTypes.contains(moveType);
  }

  /**
   * this method tests if there is currently a questioning User and if true it returns this user.
   *
   * @return the questioning user
   */
  public User getQuestioningUser() {
    if (questioningUser == null) {
      throw new NullPointerException();
    }
    return questioningUser;
  }

  public void setQuestioningUser(User questioningUser) {
    this.questioningUser = questioningUser;
  }

  public abstract boolean isAllowed(User user, MoveTypes moveTypes, Cell cell);
}
