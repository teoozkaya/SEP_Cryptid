package de.lmu.ifi.cip.model.events;

import java.util.ArrayList;
import java.util.List;

/** Event that signals that the game was won. */
public class GameWonEvent extends GameEvent {

  public GameWonEvent(String playerId) {
    this.playerIds = new ArrayList<>(List.of(playerId));
  }

  @Override
  public String getName() {
    return "GameWonEvent";
  }

  @Override
  public boolean equal(GameEvent e) {
    return getName().equals(e.getName());
  }
}
