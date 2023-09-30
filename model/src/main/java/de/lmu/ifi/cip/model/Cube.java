package de.lmu.ifi.cip.model;

import de.lmu.ifi.cip.model.board.Cell;

/** Implements the Placeable Cube. */
public class Cube implements Placeable {
  User user;

  public Cube(User user) {
    this.user = user;
  }

  public User getUser() {
    return user;
  }

  @Override
  public void place(User user, Cell cell) {
    cell.setPlaceable(this);
  }

  public boolean isCube() {
    return true;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Cube) {
      return this.user.getPlayerNumber() == ((Cube) obj).user.getPlayerNumber();
    }
    return false;
  }
}
