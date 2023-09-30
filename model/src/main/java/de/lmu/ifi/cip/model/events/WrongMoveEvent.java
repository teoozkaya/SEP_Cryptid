package de.lmu.ifi.cip.model.events;

import java.util.ArrayList;
import java.util.List;

/** Event that signals that an impossible move is tried to be made. */
public class WrongMoveEvent extends GameEvent {

  public WrongMoveEvent(String playerId) {
    this.playerIds = new ArrayList<>(List.of(playerId));
  }

  @Override
  public String getName() {
    return "WrongMoveEvent";
  }

  @Override
  public boolean equal(GameEvent e) {
    return getName().equals(e.getName());
  }
}
