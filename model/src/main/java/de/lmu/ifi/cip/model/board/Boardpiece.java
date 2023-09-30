package de.lmu.ifi.cip.model.board;

import java.util.ArrayList;

/** Represents a board piece in a game board. */
public class Boardpiece {
  private final int columnAmount = 6;
  private final int rowAmount = 3;
  private ArrayList<ArrayList<Cell>> cellList;

  public ArrayList<ArrayList<Cell>> getCellList() {
    return cellList;
  }

  private int bpNumber;

  /**
   * Constructs a new Boardpiece with the given board piece number.
   *
   * @param bpNumber The board piece number.
   */
  public Boardpiece(int bpNumber) {
    this.bpNumber = bpNumber;
    ArrayList<ArrayList<Cell>> cellList = new ArrayList<>();
    for (int i = 0; i < rowAmount; i++) {
      ArrayList<Cell> row = new ArrayList<>();
      for (int j = 0; j < columnAmount; j++) {
        Cell cell = new Cell(new Coordinate(i, j), Cell.BiomeType.EMPTY, Cell.Territory.EMPTY);
        row.add(cell);
      }
      cellList.add(row);
    }
    this.cellList = cellList;
    this.initializeBoardpiece();
    if (this.bpNumber >= 7) {
      this.reversePiece();
    }
  }

  /**
   * Returns the board piece number.
   *
   * @return The board piece number.
   */
  public int getBpNumber() {
    return bpNumber;
  }

  /**
   * Sets the board piece number.
   *
   * @param bpNumber The board piece number.
   */
  public void setBpNumber(int bpNumber) {
    this.bpNumber = bpNumber;
  }

  /**
   * Returns the cell at the specified coordinate.
   *
   * @param coordinate The coordinate of the cell.
   * @return The cell at the specified coordinate.
   */
  public Cell getCell(Coordinate coordinate) {
    int row = coordinate.getRow();
    int column = coordinate.getColumn();
    return this.cellList.get(row).get(column);
  }

  /**
   * Initializes the board piece by setting the properties of its cells based on the board piece
   * number.
   */
  public void initializeBoardpiece() {
    if (this.bpNumber == 1 || this.bpNumber == 7) {
      this.getCell(new Coordinate(0, 0)).setBiome(Cell.BiomeType.WATER);
      this.getCell(new Coordinate(0, 1)).setBiome(Cell.BiomeType.WATER);
      this.getCell(new Coordinate(0, 2)).setBiome(Cell.BiomeType.WATER);
      this.getCell(new Coordinate(0, 3)).setBiome(Cell.BiomeType.WATER);
      this.getCell(new Coordinate(0, 4)).setBiome(Cell.BiomeType.FOREST);
      this.getCell(new Coordinate(0, 5)).setBiome(Cell.BiomeType.FOREST);
      this.getCell(new Coordinate(1, 0)).setBiome(Cell.BiomeType.SWAMP);
      this.getCell(new Coordinate(1, 1)).setBiome(Cell.BiomeType.SWAMP);
      this.getCell(new Coordinate(1, 2)).setBiome(Cell.BiomeType.WATER);
      this.getCell(new Coordinate(1, 3)).setBiome(Cell.BiomeType.DESERT);
      this.getCell(new Coordinate(1, 4)).setBiome(Cell.BiomeType.FOREST);
      this.getCell(new Coordinate(1, 5)).setBiome(Cell.BiomeType.FOREST);
      this.getCell(new Coordinate(2, 0)).setBiome(Cell.BiomeType.SWAMP);
      this.getCell(new Coordinate(2, 1)).setBiome(Cell.BiomeType.SWAMP);
      this.getCell(new Coordinate(2, 2)).setBiome(Cell.BiomeType.DESERT);
      this.getCell(new Coordinate(2, 3)).setBiome(Cell.BiomeType.DESERT);
      this.getCell(new Coordinate(2, 3)).setTerritory(Cell.Territory.BEAR);
      this.getCell(new Coordinate(2, 4)).setBiome(Cell.BiomeType.DESERT);
      this.getCell(new Coordinate(2, 4)).setTerritory(Cell.Territory.BEAR);
      this.getCell(new Coordinate(2, 5)).setBiome(Cell.BiomeType.FOREST);
      this.getCell(new Coordinate(2, 5)).setTerritory(Cell.Territory.BEAR);
    } else if (this.bpNumber == 2 || this.bpNumber == 8) {
      this.getCell(new Coordinate(0, 0)).setBiome(Cell.BiomeType.SWAMP);
      this.getCell(new Coordinate(0, 0)).setTerritory(Cell.Territory.PUMA);
      this.getCell(new Coordinate(0, 1)).setBiome(Cell.BiomeType.FOREST);
      this.getCell(new Coordinate(0, 1)).setTerritory(Cell.Territory.PUMA);
      this.getCell(new Coordinate(0, 2)).setBiome(Cell.BiomeType.FOREST);
      this.getCell(new Coordinate(0, 2)).setTerritory(Cell.Territory.PUMA);
      this.getCell(new Coordinate(0, 3)).setBiome(Cell.BiomeType.FOREST);
      this.getCell(new Coordinate(0, 4)).setBiome(Cell.BiomeType.FOREST);
      this.getCell(new Coordinate(0, 5)).setBiome(Cell.BiomeType.FOREST);
      this.getCell(new Coordinate(1, 0)).setBiome(Cell.BiomeType.SWAMP);
      this.getCell(new Coordinate(1, 1)).setBiome(Cell.BiomeType.SWAMP);
      this.getCell(new Coordinate(1, 2)).setBiome(Cell.BiomeType.FOREST);
      this.getCell(new Coordinate(1, 3)).setBiome(Cell.BiomeType.DESERT);
      this.getCell(new Coordinate(1, 4)).setBiome(Cell.BiomeType.DESERT);
      this.getCell(new Coordinate(1, 5)).setBiome(Cell.BiomeType.DESERT);
      this.getCell(new Coordinate(2, 0)).setBiome(Cell.BiomeType.SWAMP);
      this.getCell(new Coordinate(2, 1)).setBiome(Cell.BiomeType.MOUNTAIN);
      this.getCell(new Coordinate(2, 2)).setBiome(Cell.BiomeType.MOUNTAIN);
      this.getCell(new Coordinate(2, 3)).setBiome(Cell.BiomeType.MOUNTAIN);
      this.getCell(new Coordinate(2, 4)).setBiome(Cell.BiomeType.MOUNTAIN);
      this.getCell(new Coordinate(2, 5)).setBiome(Cell.BiomeType.DESERT);
    } else if (this.bpNumber == 3 || this.bpNumber == 9) {
      this.getCell(new Coordinate(0, 0)).setBiome(Cell.BiomeType.SWAMP);
      this.getCell(new Coordinate(0, 1)).setBiome(Cell.BiomeType.SWAMP);
      this.getCell(new Coordinate(0, 2)).setBiome(Cell.BiomeType.FOREST);
      this.getCell(new Coordinate(0, 3)).setBiome(Cell.BiomeType.FOREST);
      this.getCell(new Coordinate(0, 4)).setBiome(Cell.BiomeType.FOREST);
      this.getCell(new Coordinate(0, 5)).setBiome(Cell.BiomeType.WATER);
      this.getCell(new Coordinate(1, 0)).setBiome(Cell.BiomeType.SWAMP);
      this.getCell(new Coordinate(1, 0)).setTerritory(Cell.Territory.PUMA);
      this.getCell(new Coordinate(1, 1)).setBiome(Cell.BiomeType.SWAMP);
      this.getCell(new Coordinate(1, 1)).setTerritory(Cell.Territory.PUMA);
      this.getCell(new Coordinate(1, 2)).setBiome(Cell.BiomeType.FOREST);
      this.getCell(new Coordinate(1, 3)).setBiome(Cell.BiomeType.MOUNTAIN);
      this.getCell(new Coordinate(1, 4)).setBiome(Cell.BiomeType.WATER);
      this.getCell(new Coordinate(1, 5)).setBiome(Cell.BiomeType.WATER);
      this.getCell(new Coordinate(2, 0)).setBiome(Cell.BiomeType.MOUNTAIN);
      this.getCell(new Coordinate(2, 0)).setTerritory(Cell.Territory.PUMA);
      this.getCell(new Coordinate(2, 1)).setBiome(Cell.BiomeType.MOUNTAIN);
      this.getCell(new Coordinate(2, 2)).setBiome(Cell.BiomeType.MOUNTAIN);
      this.getCell(new Coordinate(2, 3)).setBiome(Cell.BiomeType.MOUNTAIN);
      this.getCell(new Coordinate(2, 4)).setBiome(Cell.BiomeType.WATER);
      this.getCell(new Coordinate(2, 5)).setBiome(Cell.BiomeType.WATER);
    } else if (this.bpNumber == 4 || this.bpNumber == 10) {
      this.getCell(new Coordinate(0, 0)).setBiome(Cell.BiomeType.DESERT);
      this.getCell(new Coordinate(0, 1)).setBiome(Cell.BiomeType.DESERT);
      this.getCell(new Coordinate(0, 2)).setBiome(Cell.BiomeType.MOUNTAIN);
      this.getCell(new Coordinate(0, 3)).setBiome(Cell.BiomeType.MOUNTAIN);
      this.getCell(new Coordinate(0, 4)).setBiome(Cell.BiomeType.MOUNTAIN);
      this.getCell(new Coordinate(0, 5)).setBiome(Cell.BiomeType.MOUNTAIN);
      this.getCell(new Coordinate(1, 0)).setBiome(Cell.BiomeType.DESERT);
      this.getCell(new Coordinate(1, 1)).setBiome(Cell.BiomeType.DESERT);
      this.getCell(new Coordinate(1, 2)).setBiome(Cell.BiomeType.MOUNTAIN);
      this.getCell(new Coordinate(1, 3)).setBiome(Cell.BiomeType.WATER);
      this.getCell(new Coordinate(1, 4)).setBiome(Cell.BiomeType.WATER);
      this.getCell(new Coordinate(1, 5)).setBiome(Cell.BiomeType.WATER);
      this.getCell(new Coordinate(1, 5)).setTerritory(Cell.Territory.PUMA);
      this.getCell(new Coordinate(2, 0)).setBiome(Cell.BiomeType.DESERT);
      this.getCell(new Coordinate(2, 1)).setBiome(Cell.BiomeType.DESERT);
      this.getCell(new Coordinate(2, 2)).setBiome(Cell.BiomeType.DESERT);
      this.getCell(new Coordinate(2, 3)).setBiome(Cell.BiomeType.FOREST);
      this.getCell(new Coordinate(2, 4)).setBiome(Cell.BiomeType.FOREST);
      this.getCell(new Coordinate(2, 5)).setBiome(Cell.BiomeType.FOREST);
      this.getCell(new Coordinate(2, 5)).setTerritory(Cell.Territory.PUMA);
    } else if (this.bpNumber == 5 || this.bpNumber == 11) {
      this.getCell(new Coordinate(0, 0)).setBiome(Cell.BiomeType.SWAMP);
      this.getCell(new Coordinate(0, 1)).setBiome(Cell.BiomeType.SWAMP);
      this.getCell(new Coordinate(0, 2)).setBiome(Cell.BiomeType.SWAMP);
      this.getCell(new Coordinate(0, 3)).setBiome(Cell.BiomeType.MOUNTAIN);
      this.getCell(new Coordinate(0, 4)).setBiome(Cell.BiomeType.MOUNTAIN);
      this.getCell(new Coordinate(0, 5)).setBiome(Cell.BiomeType.MOUNTAIN);
      this.getCell(new Coordinate(1, 0)).setBiome(Cell.BiomeType.SWAMP);
      this.getCell(new Coordinate(1, 1)).setBiome(Cell.BiomeType.DESERT);
      this.getCell(new Coordinate(1, 2)).setBiome(Cell.BiomeType.DESERT);
      this.getCell(new Coordinate(1, 3)).setBiome(Cell.BiomeType.WATER);
      this.getCell(new Coordinate(1, 4)).setBiome(Cell.BiomeType.MOUNTAIN);
      this.getCell(new Coordinate(1, 5)).setBiome(Cell.BiomeType.MOUNTAIN);
      this.getCell(new Coordinate(1, 5)).setTerritory(Cell.Territory.BEAR);
      this.getCell(new Coordinate(2, 0)).setBiome(Cell.BiomeType.DESERT);
      this.getCell(new Coordinate(2, 1)).setBiome(Cell.BiomeType.DESERT);
      this.getCell(new Coordinate(2, 2)).setBiome(Cell.BiomeType.WATER);
      this.getCell(new Coordinate(2, 3)).setBiome(Cell.BiomeType.WATER);
      this.getCell(new Coordinate(2, 4)).setBiome(Cell.BiomeType.WATER);
      this.getCell(new Coordinate(2, 4)).setTerritory(Cell.Territory.BEAR);
      this.getCell(new Coordinate(2, 5)).setBiome(Cell.BiomeType.WATER);
      this.getCell(new Coordinate(2, 5)).setTerritory(Cell.Territory.BEAR);
    } else if (this.bpNumber == 6 || this.bpNumber == 12) {
      this.getCell(new Coordinate(0, 0)).setBiome(Cell.BiomeType.DESERT);
      this.getCell(new Coordinate(0, 0)).setTerritory(Cell.Territory.BEAR);
      this.getCell(new Coordinate(0, 1)).setBiome(Cell.BiomeType.DESERT);
      this.getCell(new Coordinate(0, 2)).setBiome(Cell.BiomeType.SWAMP);
      this.getCell(new Coordinate(0, 3)).setBiome(Cell.BiomeType.SWAMP);
      this.getCell(new Coordinate(0, 4)).setBiome(Cell.BiomeType.SWAMP);
      this.getCell(new Coordinate(0, 5)).setBiome(Cell.BiomeType.FOREST);
      this.getCell(new Coordinate(1, 0)).setBiome(Cell.BiomeType.MOUNTAIN);
      this.getCell(new Coordinate(1, 0)).setTerritory(Cell.Territory.BEAR);
      this.getCell(new Coordinate(1, 1)).setBiome(Cell.BiomeType.MOUNTAIN);
      this.getCell(new Coordinate(1, 2)).setBiome(Cell.BiomeType.SWAMP);
      this.getCell(new Coordinate(1, 3)).setBiome(Cell.BiomeType.SWAMP);
      this.getCell(new Coordinate(1, 4)).setBiome(Cell.BiomeType.FOREST);
      this.getCell(new Coordinate(1, 5)).setBiome(Cell.BiomeType.FOREST);
      this.getCell(new Coordinate(2, 0)).setBiome(Cell.BiomeType.MOUNTAIN);
      this.getCell(new Coordinate(2, 1)).setBiome(Cell.BiomeType.WATER);
      this.getCell(new Coordinate(2, 2)).setBiome(Cell.BiomeType.WATER);
      this.getCell(new Coordinate(2, 3)).setBiome(Cell.BiomeType.WATER);
      this.getCell(new Coordinate(2, 4)).setBiome(Cell.BiomeType.WATER);
      this.getCell(new Coordinate(2, 5)).setBiome(Cell.BiomeType.FOREST);
    }
  }

  /** Reverses the board piece by flipping its cells horizontally and vertically. */
  public void reversePiece() {
    ArrayList<ArrayList<Cell>> newList = new ArrayList<>();
    for (int i = rowAmount - 1; i >= 0; i--) {
      ArrayList<Cell> row = new ArrayList<>();
      for (int j = columnAmount - 1; j >= 0; j--) {
        Cell cell = this.getCell(new Coordinate(i, j));
        cell.setCoordinate(new Coordinate(rowAmount - 1 - i, columnAmount - 1 - j));
        row.add(cell);
      }
      newList.add(row);
    }
    this.cellList = newList;
  }
}
