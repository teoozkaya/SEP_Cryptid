package de.lmu.ifi.cip.model.events;

import java.util.ArrayList;

/** Event that signals that the game was lost. */
public class GameLoseEvent extends GameEvent {

  public GameLoseEvent(ArrayList<String> playerIds) {
    this.playerIds = playerIds;
  }

  @Override
  public String getName() {
    return "GameLoseEvent";
  }

  @Override
  public boolean equal(GameEvent e) {
    return getName().equals(e.getName());
  }
}
