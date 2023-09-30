package de.lmu.ifi.cip.model.moves;

import de.lmu.ifi.cip.model.User;
import de.lmu.ifi.cip.model.board.Cell;

/** A state that allows a player to select a field. */
public class TurnBegin extends GameState {

  public TurnBegin(User playersTurn) {
    super(playersTurn, MoveTypes.PLACE_PAWN);
    setQuestioningUser(playersTurn);
  }

  @Override
  public boolean isAllowed(User user, MoveTypes moveType, Cell cell) {
    if (!user.equals(currentAllowedUser)) {
      return false;
    }
    if (!moveType.equals(MoveTypes.PLACE_PAWN)) {
      return false;
    }
    return true;
  }
}
