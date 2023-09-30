package de.lmu.ifi.cip.client.view;

import javax.swing.JButton;

/** Creates a Button subclass that ca safe an id of the connected player. */
public class PlayerButton extends JButton {

  String playerId;

  public void setPlayerId(String playerId) {
    this.playerId = playerId;
  }

  public String getPlayerId() {
    return playerId;
  }
}
