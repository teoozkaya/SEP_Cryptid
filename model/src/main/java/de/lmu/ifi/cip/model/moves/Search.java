package de.lmu.ifi.cip.model.moves;

import de.lmu.ifi.cip.model.User;
import de.lmu.ifi.cip.model.board.Cell;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/** A class that implements the search game state when a player wants to search a specific cell. */
public class Search extends GameState {

  Cell cell;
  Queue<User> toBeAsked;

  /**
   * Constructor for the game state Search, that sets the allowed moves for this game state and
   * safes the information regarding this interaction.
   *
   * @param initiator the user that started the interaction
   * @param cell the cell that is searched
   * @param toBeAsked the list of players that will be asked to this cell
   */
  public Search(User initiator, Cell cell, List<User> toBeAsked) {
    super(toBeAsked.get(0), MoveTypes.PLACE_CUBE, MoveTypes.PLACE_DISC);
    this.questioningUser = initiator;
    this.cell = cell;
    this.toBeAsked = new LinkedList<>(toBeAsked);
    this.toBeAsked.poll();
  }

  public Queue<User> getToBeAsked() {
    return toBeAsked;
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

  public void setCurrentAllowedUser(User nextUser) {
    this.currentAllowedUser = nextUser;
  }
}
