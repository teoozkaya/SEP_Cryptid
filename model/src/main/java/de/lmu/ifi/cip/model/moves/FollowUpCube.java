package de.lmu.ifi.cip.model.moves;

import de.lmu.ifi.cip.model.User;
import de.lmu.ifi.cip.model.board.Cell;
import java.util.Set;

/**
 * A gamestate that occurs after a cube was placed by an asked player in the search or question
 * interaction.
 */
public class FollowUpCube extends GameState {

  public FollowUpCube(User nextPlayer) {
    super(nextPlayer, MoveTypes.PLACE_CUBE);
    questioningUser = nextPlayer;
  }

  @Override
  public boolean isAllowed(User user, MoveTypes moveType, Cell cell) {
    if (!user.equals(currentAllowedUser)) {
      return false;
    }
    if ((!Set.of(MoveTypes.PLACE_CUBE).contains(moveType))) {
      return false;
    }
    return true;
  }
}
