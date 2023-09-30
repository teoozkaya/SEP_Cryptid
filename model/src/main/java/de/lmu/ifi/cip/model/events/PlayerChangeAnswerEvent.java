package de.lmu.ifi.cip.model.events;

import de.lmu.ifi.cip.model.User;
import de.lmu.ifi.cip.model.board.Cell;
import java.util.ArrayList;

/**
 * Event that signals that the active player changed and has to answer a questioning and is only
 * allowed to place a cube or disc.
 */
public class PlayerChangeAnswerEvent extends GameEvent {

  private User nextPlayer;

  private Cell cell = null;

  public PlayerChangeAnswerEvent(User nextPlayer, ArrayList<String> playerIds) {
    this.nextPlayer = nextPlayer;
    this.playerIds = playerIds;
  }

  public User getPlayer() {
    return nextPlayer;
  }

  @Override
  public String getName() {
    return "PlayerChangeAnswerEvent";
  }

  @Override
  public boolean equal(GameEvent e) {
    boolean b1 = getName().equals(e.getName());
    boolean b2 = getPlayer().equals(((PlayerChangeAnswerEvent) e).getPlayer());
    return b1 && b2;
  }

  public void setCell(Cell c) {
    cell = c;
  }

  public Cell getCell() {
    return cell;
  }
}
