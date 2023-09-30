package de.lmu.ifi.cip.model;

import de.lmu.ifi.cip.model.board.Cell;

/** Implements the Placeable Disc. */
public class Disc implements Placeable {
  User user;

  public Disc(User user) {
    this.user = user;
  }

  public User getUser() {
    return user;
  }

  @Override
  public void place(User user, Cell cell) {
    cell.setPlaceable(this);
  }

  @Override
  public boolean isCube() {
    return false;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Disc) {
      return this.user.getPlayerNumber() == ((Disc) obj).user.getPlayerNumber();
    }
    return false;
  }
}
