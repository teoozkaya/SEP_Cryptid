package de.lmu.ifi.cip.model.board;

import de.lmu.ifi.cip.model.Placeable;
import java.util.ArrayList;
import java.util.List;

/** A class which implements the cells of each game map. */
public class Cell {

  private Coordinate coordinate;

  private List<Placeable> placeables;
  private Building building;
  private BiomeType biome;
  private Territory territory;

  @Override
  public String toString() {
    return "Cell{"
        + "coordinate="
        + coordinate
        + ", placeables="
        + placeables
        + ", building="
        + building
        + ", biome="
        + biome
        + ", territory="
        + territory
        + '}'
        + "\n";
  }

  /**
   * Sets a Building that this cell contains.
   *
   * @param building the type of building which is on this cell.
   */
  public void setBuilding(Building building) {
    this.building = building;
  }

  /** Enum that represents the different types of biomes a cell can be. */
  public enum BiomeType {
    EMPTY,
    SWAMP,
    WATER,
    FOREST,
    MOUNTAIN,
    DESERT;
  }

  /** Enum that represents the different territories a cell can contain. */
  public enum Territory {
    EMPTY,
    PUMA,
    BEAR;
  }

  public Cell() {
    this.placeables = new ArrayList<>();
  }

  /**
   * Constructor for the cell, which creates a cell which its different parameters.
   *
   * @param coordinate the coordinate the cell has on the game map.
   * @param biome the biome of teh cell.
   * @param territory teh territory of the cell.
   */
  public Cell(Coordinate coordinate, BiomeType biome, Territory territory) {
    this.territory = territory;
    this.biome = biome;
    this.coordinate = coordinate;
    this.placeables = new ArrayList<>();
    this.building = null;
  }

  public Coordinate getCoordinate() {
    return coordinate;
  }

  /**
   * A method to check whether the cell contains a cube or not.
   *
   * @return a boolean. If false, the cell does not contain a cube. If true, the cell does contain a
   *     cube.
   */
  public boolean getCube() {
    boolean cube = false;
    for (Placeable p : placeables) {
      if (p.isCube()) {
        cube = true;
      }
    }
    return cube;
  }

  public List<Placeable> getPlaceables() {
    return placeables;
  }

  public void setCoordinate(Coordinate coordinate) {
    this.coordinate = coordinate;
  }

  public BiomeType getBiome() {
    return biome;
  }

  public void setBiome(BiomeType biome) {
    this.biome = biome;
  }

  public Territory getTerritory() {
    return territory;
  }

  public void setTerritory(Territory territory) {
    this.territory = territory;
  }

  public Building getBuilding() {
    return building;
  }

  /**
   * Checks if the current cell is equal to the given cell.
   *
   * @param e The cell to compare with.
   * @return True if the cells are equal, false otherwise.
   */
  public boolean equal(Cell e) {
    for (int i = 0; i < placeables.size(); i++) {
      if (placeables.get(i).equals(e.getPlaceables().get(i)) == false) {
        return false;
      }
    }

    if (building != null) {
      if (building.equals(e.getBuilding()) == false) {
        return false;
      }
    }

    return coordinate.equals(e.getCoordinate())
        && biome == e.getBiome()
        && territory == e.getTerritory();
  }

  public void setPlaceable(Placeable placeable) {
    placeables.add(placeable);
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof Cell cell) {
      return this.biome == cell.biome
          && this.territory == cell.territory
          && this.coordinate == cell.coordinate;
    }
    return false;
  }

  public void removeAllPlaceables() {
    placeables = new ArrayList<>();
  }
}
