package de.lmu.ifi.cip.model.events;

import java.util.ArrayList;

/**
 * Events that get send by the model when it changes its state. The events can afterwards be caught
 * by the listeners which are subscribed to the model.
 */
public abstract class GameEvent {

  ArrayList<String> playerIds;

  /**
   * The name of the event as string representation.
   *
   * @return a string describing the implementing event.
   */
  public abstract String getName();

  public abstract boolean equal(GameEvent e);

  public ArrayList<String> getPlayerIds() {
    return playerIds;
  }
}
