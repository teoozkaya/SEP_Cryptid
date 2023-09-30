package de.lmu.ifi.cip.model;

import de.lmu.ifi.cip.model.board.Cell;

/** Implements the interface for a Placeable. */
public interface Placeable {

  User getUser();

  void place(User user, Cell cell);

  boolean isCube();

  public boolean equals(Object obj);
}
