package de.lmu.ifi.cip.model.moves;

import de.lmu.ifi.cip.model.User;
import de.lmu.ifi.cip.model.board.Cell;
import java.util.Set;

/** this class represents the game state when a player asks another player about a specific cell. */
public class Question extends GameState {

  Cell cell;
  User askedUser;

  /**
   * Constructor for the game state Question, that sets the allowed moves for this game state and
   * safes the information regarding this interaction.
   *
   * @param initiator the user that started this interaction
   * @param cell the cell this interaction is about
   * @param askedUser the user that was asked to the cell
   */
  public Question(User initiator, Cell cell, User askedUser) {
    super(askedUser, MoveTypes.PLACE_DISC, MoveTypes.PLACE_CUBE);
    this.questioningUser = initiator;
    this.cell = cell;
    this.askedUser = askedUser;
  }

  @Override
  public boolean isAllowed(User user, MoveTypes moveType, Cell cell) {
    if (!user.equals(currentAllowedUser)) {
      return false;
    }
    if (!Set.of(MoveTypes.PLACE_CUBE, MoveTypes.PLACE_DISC).contains(moveType)) {
      return false;
    }
    return cell.equals(this.cell);
  }
}
