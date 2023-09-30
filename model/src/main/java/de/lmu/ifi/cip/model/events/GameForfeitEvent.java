package de.lmu.ifi.cip.model.events;

import java.util.ArrayList;

/** Event that signals that the Game was forfeited. */
public class GameForfeitEvent extends GameEvent {

  public GameForfeitEvent(ArrayList<String> playerIds) {
    this.playerIds = playerIds;
  }

  @Override
  public String getName() {
    return "GameForfeitEvent";
  }

  @Override
  public boolean equal(GameEvent e) {
    return getName().equals(e.getName());
  }
}
