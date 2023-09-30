import static junit.framework.TestCase.assertEquals;

import de.lmu.ifi.cip.model.Game;
import de.lmu.ifi.cip.model.Hint;
import de.lmu.ifi.cip.model.HintSearch;
import de.lmu.ifi.cip.model.board.Board;
import de.lmu.ifi.cip.model.board.Building;
import de.lmu.ifi.cip.model.board.Cell;
import de.lmu.ifi.cip.model.board.Coordinate;
import java.util.ArrayList;
import java.util.UUID;
import org.junit.Test;

/** Unit test for the hintSearchTest() method. Author: Gianluca */
public class HintSearchTest {

  private ArrayList<String> createIdList() {
    ArrayList<String> idList = new ArrayList<>();
    for (int i = 1; i <= 3; i++) {
      idList.add(UUID.randomUUID().toString());
    }
    return idList;
  }

  private void addCellInList(ArrayList<Cell> ret, Cell c) {
    for (int i = 0; i < ret.size(); i++) {
      if (ret.get(i).getCoordinate().equals(c.getCoordinate())) {
        return;
      }
    }
    ret.add(c);
  }

  private void printMapOrder(int[] order) {
    String s = "";
    for (int i : order) {
      s += String.valueOf(i) + " ";
    }
    System.out.println("map order = [" + s + "]");
  }

  private void printCellList(ArrayList<Cell> cellList) {
    String s = "";
    for (int i = 0; i < cellList.size(); i++) {
      if (i % 10 == 0) {
        s += "\n";
      }
      s +=
          "["
              + String.valueOf(cellList.get(i).getCoordinate().getRow())
              + ","
              + String.valueOf(cellList.get(i).getCoordinate().getColumn())
              + "]";
    }
    System.out.println("cell list size = " + String.valueOf(cellList.size()));
    System.out.println("cell list = {" + s + "}");
  }

  private boolean isCellInList(Cell c, ArrayList<Cell> cellList) {
    for (Cell cell : cellList) {
      if (c.equal(cell)) {
        return true;
      }
    }
    return false;
  }

  @Test
  public void hintSearchTest() {

    Game game = new Game(true, 3, createIdList());
    Board testBoard = game.getBoard();
    printMapOrder(testBoard.getBoardOrder());

    HintSearch hintSearch = new HintSearch();

    Hint h = new Hint("");
    String hintstr = h.getHint(0);

    ArrayList<Cell> cellList = hintSearch.search(hintstr, testBoard);
    printCellList(cellList);

    ArrayList<Cell> testList = new ArrayList<>();

    for (int x = 0; x < testBoard.getCellList().size(); x++) {
      for (int y = 0; y < testBoard.getCellList().get(x).size(); y++) {
        if (testBoard.getCellList().get(x).get(y).getBiome() == Cell.BiomeType.DESERT
            || testBoard.getCellList().get(x).get(y).getBiome() == Cell.BiomeType.SWAMP) {
          testList.add(testBoard.getCellList().get(x).get(y));
        }
      }
    }
    assertEquals(testList, cellList);
  }

  @Test
  public void hintSearchTest2() {

    Game game = new Game(true, 3, createIdList());
    Board testBoard = game.getBoard();
    printMapOrder(testBoard.getBoardOrder());

    HintSearch hintSearch = new HintSearch();

    Hint h = new Hint("");
    String hintstr = h.getHint(1);

    ArrayList<Cell> cellList = hintSearch.search(hintstr, testBoard);
    printCellList(cellList);

    ArrayList<Cell> testList = new ArrayList<>();

    for (int x = 0; x < testBoard.getCellList().size(); x++) {
      for (int y = 0; y < testBoard.getCellList().get(x).size(); y++) {
        Cell c = testBoard.getCellList().get(x).get(y);
        if (c.getTerritory() == Cell.Territory.PUMA) {
          ArrayList<Cell> cl = testBoard.getNeighbours(c, 2);
          for (Cell each : cl) {
            addCellInList(testList, each);
          }
          addCellInList(testList, c);
        }
      }
    }
    assertEquals(testList, cellList);
  }

  @Test
  public void hintSearchTest3() {

    Game game = new Game(true, 3, createIdList());
    Board testBoard = game.getBoard();
    printMapOrder(testBoard.getBoardOrder());

    HintSearch hintSearch = new HintSearch();

    Hint h = new Hint("");
    String hintstr = h.getHint(2);

    ArrayList<Cell> cellList = hintSearch.search(hintstr, testBoard);
    printCellList(cellList);

    ArrayList<Cell> testList = new ArrayList<>();

    for (int x = 0; x < testBoard.getCellList().size(); x++) {
      for (int y = 0; y < testBoard.getCellList().get(x).size(); y++) {
        Cell c = testBoard.getCellList().get(x).get(y);
        if (c.getBuilding() != null) {
          if (c.getBuilding().getBuildingColor() == Building.BuildingColor.BLUE) {
            ArrayList<Cell> cl = testBoard.getNeighbours(c, 3);
            for (Cell each : cl) {
              addCellInList(testList, each);
            }
            addCellInList(testList, c);
          }
        }
      }
    }
    assertEquals(testList, cellList);
  }

  @Test
  public void hintSearchTest4() {

    Game game = new Game(true, 3, createIdList());
    Board testBoard = game.getBoard();
    printMapOrder(testBoard.getBoardOrder());

    HintSearch hintSearch = new HintSearch();

    Hint h = new Hint("");
    String hintstr = h.getHint(3);

    ArrayList<Cell> cellList = hintSearch.search(hintstr, testBoard);
    printCellList(cellList);

    ArrayList<Cell> testList = new ArrayList<>();

    for (int x = 0; x < testBoard.getCellList().size(); x++) {
      for (int y = 0; y < testBoard.getCellList().get(x).size(); y++) {
        Cell c = testBoard.getCellList().get(x).get(y);
        if (c.getBiome() != Cell.BiomeType.FOREST && c.getBiome() != Cell.BiomeType.SWAMP) {
          ArrayList<Cell> cl = testBoard.getNeighbours(c, 0);
          for (Cell each : cl) {
            addCellInList(testList, each);
          }
          addCellInList(testList, c);
        }
      }
    }
    assertEquals(testList, cellList);
  }

  @Test
  public void hintSearchTest5() {

    Game game = new Game(true, 3, createIdList());
    Board testBoard = game.getBoard();
    printMapOrder(testBoard.getBoardOrder());

    HintSearch hintSearch = new HintSearch();

    Hint h = new Hint("");
    String hintstr = h.getHint(10);

    ArrayList<Cell> cellList = hintSearch.search(hintstr, testBoard);
    printCellList(cellList);

    ArrayList<Cell> testList = new ArrayList<>();

    for (int x = 0; x < testBoard.getCellList().size(); x++) {
      for (int y = 0; y < testBoard.getCellList().get(x).size(); y++) {
        Cell c = testBoard.getCellList().get(x).get(y);
        if (c.getBuilding() != null) {
          if (c.getBuilding().getBuildingType() == Building.BuildingType.HUT) {
            ArrayList<Cell> cl = testBoard.getNeighbours(c, 2);
            for (Cell each : cl) {
              addCellInList(testList, each);
            }
            addCellInList(testList, c);
          }
        }
      }
    }
    assertEquals(testList, cellList);
  }

  @Test
  public void hintSearchTest_Hint32() {

    Game game = new Game(false, 3, createIdList());
    Board testBoard = game.getBoard();
    printMapOrder(testBoard.getBoardOrder());

    HintSearch hintSearch = new HintSearch();

    Hint h = new Hint("");
    String hintstr = h.getHint(32);

    ArrayList<Cell> cellList = hintSearch.search(hintstr, testBoard);
    printCellList(cellList);

    ArrayList<Cell> testList = new ArrayList<>();

    for (int x = 0; x < testBoard.getCellList().size(); x++) {
      for (int y = 0; y < testBoard.getCellList().get(x).size(); y++) {
        Cell c = testBoard.getCellList().get(x).get(y);
        if (c.getBuilding() != null) {
          if (c.getBuilding().getBuildingType() == Building.BuildingType.STONE) {
            ArrayList<Cell> cl = testBoard.getNeighbours(c, 2);
            for (Cell each : cl) {
              addCellInList(testList, each);
            }
            addCellInList(testList, c);
          }
        }
      }
    }
    assertEquals(testList, cellList);
  }

  @Test
  public void hintSearchTest_Hint34() {

    Game game = new Game(false, 3, createIdList());
    Board testBoard = game.getBoard();
    printMapOrder(testBoard.getBoardOrder());

    HintSearch hintSearch = new HintSearch();

    Hint h = new Hint("");
    String hintstr = h.getHint(34);

    ArrayList<Cell> cellList = hintSearch.search(hintstr, testBoard);
    printCellList(cellList);

    ArrayList<Cell> testList = new ArrayList<>();

    for (int x = 0; x < testBoard.getCellList().size(); x++) {
      for (int y = 0; y < testBoard.getCellList().get(x).size(); y++) {
        Cell c = testBoard.getCellList().get(x).get(y);
        if (c.getBuilding() != null) {
          if (c.getBuilding().getBuildingType() == Building.BuildingType.HUT) {
            ArrayList<Cell> cl = testBoard.getNeighbours(c, 2);
            for (Cell each : cl) {
              addCellInList(testList, each);
            }
            addCellInList(testList, c);
          }
        }
      }
    }

    ArrayList<Cell> testList2 = new ArrayList<>();
    for (int x = 0; x < testBoard.getCellList().size(); x++) {
      for (int y = 0; y < testBoard.getCellList().get(x).size(); y++) {
        Cell c = testBoard.getCellList().get(x).get(y);
        if (isCellInList(c, testList) == false) {
          addCellInList(testList2, c);
        }
      }
    }

    assertEquals(testList2, cellList);
  }

  @Test
  public void testSearchHint() {
    HintSearch hintSearch = new HintSearch();
    // String hint = new Hint("").getHint(11);
    String hint = "nicht im Wald oder Sumpf";
    int[] ints = {4, 1, 6, 8, 11, 9};
    Board board = new Board(ints);
    ArrayList<Cell> search = hintSearch.search(hint, board);
    System.out.println(search.size() + " cells were searched");
    System.out.println("the hint is: " + hint);
    System.out.println(search);
  }

  @Test
  public void testGetNeighbours() {
    int[] ints = {4, 1, 6, 8, 11, 9};
    Board board = new Board(ints);
    ArrayList<Cell> neighbours =
        board.getNeighbours(
            new Cell(new Coordinate(7, 2), Cell.BiomeType.FOREST, Cell.Territory.BEAR), 1);
    System.out.println(neighbours);
  }
}
