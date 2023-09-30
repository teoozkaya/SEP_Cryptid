package de.lmu.ifi.cip.model.board;

/**
 * This class implements the Building object, which contains the different buildings that can be
 * placed on the GameMap.
 */
public class Building {

  /** Represents the type of building. */
  public enum BuildingType {
    HUT,
    STONE
  }

  /** Represents the color of the building. */
  public enum BuildingColor {
    WHITE,
    GREEN,
    BLUE,
    BLACK
  }

  private BuildingType type;
  private BuildingColor color;
  private Coordinate coordinate;

  /**
   * Constructor for huts (Hütten) and stones (Hinkelsteine).
   *
   * @param type (HUT or STONE)
   * @param color (WHITE, GREEN, BLUE or BLACK)
   * @param coordinate Example: new Building(BuildingType.HUT, BuildingColor.BLUE, coord) creates a
   *     blue hut on given coordinate
   */
  public Building(BuildingType type, BuildingColor color, Coordinate coordinate) {
    this.type = type;
    this.color = color;
    this.coordinate = coordinate;
  }

  /**
   * Returns the coordinate of the building.
   *
   * @return The coordinate of the building.
   */
  public Coordinate getCoordinate() {
    return coordinate;
  }

  /**
   * Returns the color of the building.
   *
   * @return The color of the building.
   */
  public Enum getBuildingColor() {
    return color;
  }

  /**
   * Returns the type of the building.
   *
   * @return The type of the building.
   */
  public Enum getBuildingType() {
    return type;
  }

  /**
   * Compares this Building object to the specified object. The result is true if and only if the
   * argument is not null and is a Building object that has the same type, color, and coordinate as
   * this Building object.
   *
   * @param obj the object to compare this Building against
   * @return true if the given object represents a matching Building, false otherwise
   */
  public boolean equals(Object obj) {
    if (obj instanceof Building b) {
      return this.type == b.type && this.color == b.color && this.coordinate.equals(b.coordinate);
    }
    return false;
  }
}
