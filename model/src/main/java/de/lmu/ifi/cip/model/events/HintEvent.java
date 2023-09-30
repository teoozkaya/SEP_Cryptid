package de.lmu.ifi.cip.model.events;

import de.lmu.ifi.cip.model.User;
import java.util.ArrayList;
import java.util.List;

/** This class establishes an event that provides the hint to every player. */
public class HintEvent extends GameEvent {

  private String hint;
  private User player;

  /**
   * Constructor for the HintEvent. It creates a set of a specific player, its id and a specific
   * hint.
   *
   * @param hint the specific hint in the event
   * @param player the player that the hint belongs to
   * @param playerId the playerId to identify the player
   */
  public HintEvent(String hint, User player, String playerId) {
    this.hint = hint;
    this.player = player;
    this.playerIds = new ArrayList<>(List.of(playerId));
  }

  @Override
  public String getName() {
    return "HintEvent";
  }

  public String getHint() {
    return hint;
  }

  public User getPlayer() {
    return player;
  }

  @Override
  public boolean equal(GameEvent e) {
    boolean b1 = getName().equals(e.getName());
    boolean b2 = getName().equals(((HintEvent) e).getHint());
    boolean b3 = getHint().equals(((HintEvent) e).getHint());
    return b1 && b2 && b3;
  }
}
