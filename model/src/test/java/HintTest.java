import de.lmu.ifi.cip.model.Game;
import de.lmu.ifi.cip.model.User;
import java.util.ArrayList;
import java.util.UUID;
import org.junit.Test;

/** A Test to check if the hint generation and distribution functions properly. */
public class HintTest {

  @Test
  public void hintDistribution() {
    ArrayList<String> playerIds = new ArrayList<>();
    for (int i = 0; i < 3; i++) {
      playerIds.add(UUID.randomUUID().toString());
    }
    Game threePlayerGame = new Game(true, 3, playerIds);
    ArrayList<User> userList3 = threePlayerGame.getUsers();
    System.out.println("Three player clues:");
    for (int i = 0; i < userList3.size(); i++) {
      User currentUser = userList3.get(i);
      System.out.println(currentUser.getHint());
    }
    playerIds.add(UUID.randomUUID().toString());
    Game fourPlayerGame = new Game(true, 4, playerIds);
    ArrayList<User> userList4 = fourPlayerGame.getUsers();
    System.out.println("Four player clues:");
    for (int i = 0; i < userList4.size(); i++) {
      User currentUser = userList4.get(i);
      System.out.println(currentUser.getHint());
    }
    playerIds.add(UUID.randomUUID().toString());
    Game fivePlayerGame = new Game(true, 5, playerIds);
    ArrayList<User> userList5 = fivePlayerGame.getUsers();
    System.out.println("Five player clues:");
    for (int i = 0; i < userList5.size(); i++) {
      User currentUser = userList5.get(i);
      System.out.println(currentUser.getHint());
    }
  }
}
