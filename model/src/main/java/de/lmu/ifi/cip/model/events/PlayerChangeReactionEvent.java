package de.lmu.ifi.cip.model.events;

import de.lmu.ifi.cip.model.User;
import de.lmu.ifi.cip.model.board.Cell;
import java.util.ArrayList;

/**
 * Event that signals that the active player changed and has to reacted to a placed cube and is only
 * allowed to place a cube.
 */
public class PlayerChangeReactionEvent extends GameEvent {

  private User player;
  private Cell cell = null;

  public PlayerChangeReactionEvent(User player, ArrayList<String> playerIds) {
    this.player = player;
    this.playerIds = playerIds;
  }

  public User getPlayer() {
    return player;
  }

  @Override
  public String getName() {
    return "PlayerChangeReactionEvent";
  }

  @Override
  public boolean equal(GameEvent e) {
    boolean b1 = getName().equals(e.getName());
    boolean b2 = getPlayer().equals(((PlayerChangeReactionEvent) e).getPlayer());
    return b1 && b2;
  }

  public void setCell(Cell c) {
    cell = c;
  }

  public Cell getCell() {
    return cell;
  }
}
