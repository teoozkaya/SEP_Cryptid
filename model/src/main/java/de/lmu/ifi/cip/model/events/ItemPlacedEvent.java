package de.lmu.ifi.cip.model.events;

import de.lmu.ifi.cip.model.board.Cell;
import java.util.ArrayList;

/** an event that tells the observer that an item was placed and the map must bbe updated. */
public class ItemPlacedEvent extends GameEvent {

  private ArrayList<ArrayList<Cell>> cellList;

  private Cell cell = null;

  public ItemPlacedEvent(ArrayList<ArrayList<Cell>> cellList, ArrayList<String> playerIds) {
    this.cellList = cellList;
    this.playerIds = playerIds;
  }

  public ArrayList<ArrayList<Cell>> getCellList() {
    return cellList;
  }

  @Override
  public String getName() {
    return "ItemPlacedEvent";
  }

  @Override
  public boolean equal(GameEvent e) {
    boolean b1 = getName().equals(e.getName());

    for (int i = 0; i < cellList.size(); i++) {
      for (int j = 0; j < cellList.get(i).size(); j++) {
        if (cellList.get(i).get(j).equal(((ItemPlacedEvent) e).getCellList().get(i).get(j))
            == false) {
          return false;
        }
      }
    }

    return b1;
  }

  public void setCell(Cell c) {
    cell = c;
  }

  public Cell getCell() {
    return cell;
  }
}
