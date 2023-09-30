package de.lmu.ifi.cip.model;

import de.lmu.ifi.cip.model.board.Board;
import de.lmu.ifi.cip.model.board.Building;
import de.lmu.ifi.cip.model.board.Cell;
import java.util.ArrayList;

/** Represents a hint search for a game board. */
public class HintSearch {
  private int typeIn = 1; // 1 is in     0 is not in
  private ArrayList<Cell.BiomeType> biomeType = new ArrayList<>();
  private ArrayList<Cell.Territory> territory = new ArrayList<>();
  private Building.BuildingColor buildingColor = null;
  private Building.BuildingType buildingType = null;
  private int distance = 0; // around distance

  /** Constructs a new HintSearch object. */
  public void hintSearch() {}

  // process hint string to struct
  private void processHint(String hint) {
    biomeType.clear();
    territory.clear();
    buildingColor = null;
    buildingType = null;
    distance = 0;

    if (hint.contains("nicht")) {
      typeIn = 0;
    } else {
      typeIn = 1;
    }

    String wuste = "Wüste";
    String bar = "Bärenterritorium";
    String hut = "Hütte";
    String gru = "grüne";
    String wei = "weiße";

    // in one place
    if ((hint.contains("im") || hint.contains("in der")) && hint.contains("oder")) {
      if (hint.contains("Sumpf")) {
        biomeType.add(Cell.BiomeType.SWAMP);
      }
      if (hint.contains("Gebirge")) {
        biomeType.add(Cell.BiomeType.MOUNTAIN);
      }
      if (hint.contains("Wald")) {
        biomeType.add(Cell.BiomeType.FOREST);
      }
      if (hint.contains(wuste)) {
        biomeType.add(Cell.BiomeType.DESERT);
      }
      if (hint.contains("Wasser")) {
        biomeType.add(Cell.BiomeType.WATER);
      }
    }
    // around one place
    if (hint.contains("im Umkreis von einem Feld")) {
      if (hint.contains("Sumpf")) {
        biomeType.add(Cell.BiomeType.SWAMP);
      }
      if (hint.contains("Gebirge")) {
        biomeType.add(Cell.BiomeType.MOUNTAIN);
      }
      if (hint.contains("Wald")) {
        biomeType.add(Cell.BiomeType.FOREST);
      }
      if (hint.contains(wuste)) {
        biomeType.add(Cell.BiomeType.DESERT);
      }
      if (hint.contains("Wasser")) {
        biomeType.add(Cell.BiomeType.WATER);
      }
      if (hint.contains("Territorium")) {
        territory.add(Cell.Territory.BEAR);
        territory.add(Cell.Territory.PUMA);
      }
      distance = 1;
    }
    // around one place by 2 distance
    if (hint.contains("im Umkreis von 2 Feldern")) {
      if (hint.contains(bar)) {
        territory.add(Cell.Territory.BEAR);
      }
      if (hint.contains("Pumaterritorium")) {
        territory.add(Cell.Territory.PUMA);
      }
      if (hint.contains(hut)) {
        buildingType = Building.BuildingType.HUT;
      }
      if (hint.contains("Hinkelstein")) {
        buildingType = Building.BuildingType.STONE;
      }
      distance = 2;
    }
    // around one place by 3 distance
    if (hint.contains("im Umkreis von 3 Feldern")) {
      if (hint.contains("blaue")) {
        buildingColor = Building.BuildingColor.BLUE;
      }
      if (hint.contains(gru)) {
        buildingColor = Building.BuildingColor.GREEN;
      }
      if (hint.contains("schwarze")) {
        buildingColor = Building.BuildingColor.BLACK;
      }
      if (hint.contains(wei)) {
        buildingColor = Building.BuildingColor.WHITE;
      }
      distance = 3;
    }
  }

  // if has same cell, do NOT add in list
  private void addCellInList(ArrayList<Cell> ret, Cell c) {
    for (int i = 0; i < ret.size(); i++) {
      if (ret.get(i).getCoordinate().equals(c.getCoordinate())) {
        return;
      }
    }
    ret.add(c);
  }

  /**
   * Searches for cells on the board based on the hint and board.
   *
   * @param hint The hint string.
   * @param b The board to search on.
   * @return The list of cells that match the hint criteria.
   */
  public ArrayList<Cell> search(String hint, Board b) {

    processHint(hint);

    ArrayList<ArrayList<Cell>> cellList = b.getCellList();

    ArrayList<Cell> ret = new ArrayList<>();

    for (int i = 0; i < cellList.size(); i++) {
      for (int j = 0; j < cellList.get(i).size(); j++) {
        Cell c = cellList.get(i).get(j);

        if (biomeType.size() > 0) {
          for (int k = 0; k < biomeType.size(); k++) {
            if (c.getBiome() == biomeType.get(k)) {
              ArrayList<Cell> cl = b.getNeighbours(c, distance);
              for (int l = 0; l < cl.size(); l++) {
                addCellInList(ret, cl.get(l));
              }
              addCellInList(ret, c);
            }
          }
        } else if (territory.size() > 0) {
          for (int k = 0; k < territory.size(); k++) {
            if (c.getTerritory() == territory.get(k)) {
              // in around cell
              ArrayList<Cell> cl = b.getNeighbours(c, distance);
              for (int l = 0; l < cl.size(); l++) {
                addCellInList(ret, cl.get(l));
              }
              addCellInList(ret, c);
            }
          }
        } else if (buildingColor != null) {
          if (c.getBuilding() != null) {
            if (c.getBuilding().getBuildingColor() == buildingColor) {
              // in around cell
              ArrayList<Cell> cl = b.getNeighbours(c, distance);
              for (int l = 0; l < cl.size(); l++) {
                addCellInList(ret, cl.get(l));
              }
              addCellInList(ret, c);
            }
          }
        } else if (buildingType != null) {
          if (c.getBuilding() != null && c.getBuilding().getBuildingType() == buildingType) {
            // in around cell
            ArrayList<Cell> cl = b.getNeighbours(c, distance);
            for (int l = 0; l < cl.size(); l++) {
              addCellInList(ret, cl.get(l));
            }
            addCellInList(ret, c);
          }
        }
      }
    }

    // if not in , find the complementary set
    if (typeIn == 0) {
      ArrayList<Cell> ret1 = new ArrayList<>();
      for (int i = 0; i < cellList.size(); i++) {
        for (int j = 0; j < cellList.get(i).size(); j++) {
          Cell c = cellList.get(i).get(j);
          boolean find = false;
          for (int k = 0; k < ret.size(); k++) {
            if (c.getCoordinate().equals(ret.get(k).getCoordinate())) {
              find = true;
              break;
            }
          }
          if (find == false) {
            ret1.add(c);
          }
        }
      }
      return ret1;
    }

    return ret;
  }

  /**
   * Checks if a disc can be placed based on the hint and board at the specified cell.
   *
   * @param hint The hint string.
   * @param b The board to check.
   * @param c The cell to check.
   * @return True if a disc can be placed, false otherwise.
   */
  public boolean canPlaceDisc(String hint, Board b, Cell c) {
    ArrayList<Cell> cl = search(hint, b);
    for (int i = 0; i < cl.size(); i++) {
      if (cl.get(i).equals(c)) {
        return true;
      }
    }

    return false;
  }

  /**
   * Checks if a cube can be placed based on the hint and board at the specified cell.
   *
   * @param hint The hint string.
   * @param b The board to check.
   * @param c The cell to check.
   * @return True if a cube can be placed, false otherwise.
   */
  public boolean canPlaceCube(String hint, Board b, Cell c) {
    ArrayList<Cell> cl = search(hint, b);
    for (int i = 0; i < cl.size(); i++) {
      if (cl.get(i).equals(c)) {
        return false;
      }
    }

    return true;
  }
}
