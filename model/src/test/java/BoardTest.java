import de.lmu.ifi.cip.model.board.Board;
import org.junit.Test;

/** A Test to check if the board creation functions properly. */
public class BoardTest {

  @Test
  public void boardCreation() {
    int[] testBoardOrder = {4, 6, 8, 11, 3, 2};
    Board testBoard = new Board(testBoardOrder);
  }
}
