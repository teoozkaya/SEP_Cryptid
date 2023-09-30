package de.lmu.ifi.cip.model.board;

/**
 * A class that implements a Coordinate, that represents a specific row and colum of the game map.
 */
public class Coordinate {

  private int row;
  private int column;

  @Override
  public String toString() {
    return "Coordinate{" + "row=" + row + ", column=" + column + '}';
  }

  public Coordinate(int row, int column) {
    this.row = row;
    this.column = column;
  }

  public int getRow() {
    return row;
  }

  public int getColumn() {
    return column;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Coordinate coordinate) {
      return this.column == coordinate.column && this.row == coordinate.row;
    }
    return false;
  }
}
