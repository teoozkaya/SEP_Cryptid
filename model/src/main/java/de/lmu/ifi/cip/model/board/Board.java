package de.lmu.ifi.cip.model.board;

import java.util.ArrayList;

/** Represents a game board. */
public class Board {

  public ArrayList<ArrayList<Boardpiece>> getBoard() {
    return board;
  }

  private int cellRow = 9;
  private int cellColumn = 12;
  private ArrayList<Boardpiece> boardpieces = new ArrayList<>();
  private ArrayList<ArrayList<Cell>> cellList;
  private final int boardPieceRowAmount = 3;
  private final int boardPieceColumnAmount = 2; // for a 2 * 3 board out of board pieces

  private final int[] boardOrder;
  private ArrayList<ArrayList<Boardpiece>> board = new ArrayList<>();

  /** Creates a list of board pieces. */
  public void boardPieceList() {
    for (int i = 1; i <= 12; i++) {
      boardpieces.add(new Boardpiece(i));
    }
  }

  /**
   * Constructs a new Board with the given board order.
   *
   * @param boardOrder The order in which the board pieces should be arranged.
   */
  public Board(int[] boardOrder) {
    this.boardOrder = boardOrder;
    boardPieceList();

    cellList = new ArrayList<>(cellRow);
    for (int i = 0; i < cellRow; i++) {
      cellList.add(new ArrayList<>(cellColumn));
      // cellList is a two-dimensional array
      // the above operations only add the first dimensional data.
      // The following operations are required to add the second dimensional data
      // Otherwise, the second dimension data is empty, and subsequent references will result in an
      // error
      for (int j = 0; j < cellColumn; j++) {
        cellList
            .get(i)
            .add(new Cell(new Coordinate(0, 0), Cell.BiomeType.EMPTY, Cell.Territory.EMPTY));
      }
    }
    // empty board creation
    for (int i = 0; i < boardPieceRowAmount; i++) {
      ArrayList<Boardpiece> boardRow = new ArrayList<>(boardPieceColumnAmount);
      board.add(boardRow); // This only adds the first dimensional data
    }
    // adding board pieces to the board
    // boardOrder is the map list id, board is a two-dimensional array,The board needs to be
    // initialized based on boardOrder
    for (int i = 0; i < boardOrder.length; i++) {
      Boardpiece requiredBp = boardpieces.get(boardOrder[i] - 1);
      int row = i / 2;
      ArrayList<Boardpiece> boardRow = board.get(row);
      boardRow.add(requiredBp); // The second dimension of data has been added here
    }

    setNewCoordinates();
  }

  /**
   * Returns the board order.
   *
   * @return The board order.
   */
  public int[] getBoardOrder() {
    return boardOrder;
  }

  /**
   * Returns the number of rows in the cell grid.
   *
   * @return The number of rows in the cell grid.
   */
  public int getCellRow() {
    return cellRow;
  }

  /**
   * Returns the number of columns in the cell grid.
   *
   * @return The number of columns in the cell grid.
   */
  public int getCellColumn() {
    return cellColumn;
  }

  /** Sets new coordinates for the cells based on the board layout. */
  public void setNewCoordinates() {
    ArrayList<ArrayList<Boardpiece>> pieces = this.getBoard();
    for (int i = 0; i < pieces.size(); i++) {
      for (int j = 0; j < pieces.get(i).size(); j++) {
        ArrayList<ArrayList<Cell>> cells = pieces.get(i).get(j).getCellList();
        if (i == 0 && j == 1) {
          for (int k = 0; k < 3; k++) {
            for (int l = 6; l < 12; l++) {
              Cell cell = cells.get(k).get(l - 6);
              cell.setCoordinate(new Coordinate(k, l));
              cellList.get(k).set(l, cell);
            }
          }
        } else if (i == 1 && j == 1) {
          for (int k = 3; k < 6; k++) {
            for (int l = 6; l < 12; l++) {
              Cell cell = cells.get(k - 3).get(l - 6);
              cell.setCoordinate(new Coordinate(k, l));
              cellList.get(k).set(l, cell);
            }
          }
        } else if (i == 2 && j == 1) {
          for (int k = 6; k < 9; k++) {
            for (int l = 6; l < 12; l++) {
              Cell cell = cells.get(k - 6).get(l - 6);
              cell.setCoordinate(new Coordinate(k, l));
              cellList.get(k).set(l, cell);
            }
          }
        } else if (i == 0 && j == 0) {
          for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 6; l++) {
              Cell cell = cells.get(k).get(l);
              cell.setCoordinate(new Coordinate(k, l));
              cellList.get(k).set(l, cell);
            }
          }
        } else if (i == 1 && j == 0) {
          for (int k = 3; k < 6; k++) {
            for (int l = 0; l < 6; l++) {
              Cell cell = cells.get(k - 3).get(l);
              cell.setCoordinate(new Coordinate(k, l));
              cellList.get(k).set(l, cell);
            }
          }
        } else if (i == 2 && j == 0) {
          for (int k = 6; k < 9; k++) {
            for (int l = 0; l < 6; l++) {
              Cell cell = cells.get(k - 6).get(l);
              cell.setCoordinate(new Coordinate(k, l));
              cellList.get(k).set(l, cell);
            }
          }
        }
      }
    }
  }

  /**
   * Checks if the board contains a cell with the given coordinate.
   *
   * @param coordinate The coordinate to check.
   * @return True if the board contains the cell, false otherwise.
   */
  public boolean contains(Coordinate coordinate) {
    int row = coordinate.getRow();
    int column = coordinate.getColumn();
    return row >= 0 && column >= 0 && row < this.getCellRow() && column < this.getCellColumn();
  }

  /**
   * Returns the cells around of the given cell between the given distance.
   *
   * @param cell The cell to get the neighbors of.
   * @param distance The distance of the neighbour cells to the given cell
   * @return The neighboring cells of the given cell.
   */
  public ArrayList<Cell> getNeighbours(Cell cell, int distance) {

    Coordinate cellCoordinate = cell.getCoordinate();
    ArrayList<Cell> neighbours = new ArrayList<>();
    int k;
    if (cellCoordinate.getColumn() % 2 == 0) {
      // on a even column
      k = -1;
    } else {
      // on a odd column
      k = 1;
    }

    for (int i = -distance; i <= distance; i++) {
      for (int j = -distance; j <= distance; j++) {
        if (k * i == 0 && k * j == 0) {
          continue;
        }
        if (distance == 1) {
          if (k * i == -1 && k * j == -1) {
            continue;
          }
          if (k * i == -1 && k * j == 1) {
            continue;
          }
          int rowCoordinate = cellCoordinate.getRow() + i;
          int columnCoordinate = cellCoordinate.getColumn() + j;
          Coordinate coordinate = new Coordinate(rowCoordinate, columnCoordinate);
          if (this.contains(coordinate)) {
            neighbours.add(cellList.get(rowCoordinate).get(columnCoordinate));
          }
        }
        if (distance == 2) {

          if (k * i == -2 && k * j == -2) {
            continue;
          }
          if (k * i == -2 && k * j == -1) {
            continue;
          }
          if (k * i == -2 && k * j == 1) {
            continue;
          }
          if (k * i == -2 && k * j == 2) {
            continue;
          }
          if (k * i == 2 && k * j == -2) {
            continue;
          }
          if (k * i == 2 && k * j == 2) {
            continue;
          }
          int rowCoordinate = cellCoordinate.getRow() + i;
          int columnCoordinate = cellCoordinate.getColumn() + j;
          Coordinate coordinate = new Coordinate(rowCoordinate, columnCoordinate);
          if (this.contains(coordinate)) {
            neighbours.add(cellList.get(rowCoordinate).get(columnCoordinate));
          }
        }
        if (distance == 3) {
          if (k * i == -3 && k * j == -3) {
            continue;
          }
          if (k * i == -3 && k * j == -2) {
            continue;
          }
          if (k * i == -2 && k * j == -3) {
            continue;
          }
          if (k * i == -3 && k * j == -1) {
            continue;
          }
          if (k * i == -3 && k * j == 1) {
            continue;
          }
          if (k * i == -3 && k * j == 2) {
            continue;
          }
          if (k * i == -3 && k * j == 3) {
            continue;
          }
          if (k * i == -2 && k * j == 3) {
            continue;
          }
          if (k * i == 3 && k * j == -3) {
            continue;
          }
          if (k * i == 3 && k * j == -2) {
            continue;
          }
          if (k * i == 3 && k * j == 2) {
            continue;
          }
          if (k * i == 3 && k * j == 3) {
            continue;
          }
          int rowCoordinate = cellCoordinate.getRow() + i;
          int columnCoordinate = cellCoordinate.getColumn() + j;
          Coordinate coordinate = new Coordinate(rowCoordinate, columnCoordinate);
          if (this.contains(coordinate)) {
            neighbours.add(cellList.get(rowCoordinate).get(columnCoordinate));
          }
        }
      }
    }
    return neighbours;
  }

  /**
   * Returns the list of cells in the board.
   *
   * @return The list of cells in the board.
   */
  public ArrayList<ArrayList<Cell>> getCellList() {
    return cellList;
  }
}
