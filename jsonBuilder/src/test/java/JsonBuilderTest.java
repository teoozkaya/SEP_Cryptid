import static org.junit.Assert.assertTrue;

import de.lmu.ifi.cip.jsonbuilder.JsonBuilder;
import de.lmu.ifi.cip.model.Disc;
import de.lmu.ifi.cip.model.Game;
import de.lmu.ifi.cip.model.User;
import de.lmu.ifi.cip.model.events.GameEvent;
import de.lmu.ifi.cip.model.events.GameStartEvent;
import de.lmu.ifi.cip.model.events.ItemPlacedEvent;
import de.lmu.ifi.cip.model.events.PlayerChangeAnswerEvent;
import de.lmu.ifi.cip.model.events.PlayerChangeEvent;
import de.lmu.ifi.cip.model.events.PlayerChangeReactionEvent;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/** This is a dummy test class. */
public class JsonBuilderTest {
  Game game;

  static String[] playerList = {"1", "2", "3", "4", "5"};
  static ArrayList<String> playerIds = new ArrayList<>(List.of(playerList));

  private static GameStartEvent getGameStartEvent() {
    Game game = new Game(false, 5, playerIds);
    return new GameStartEvent(
        game.getBoard().getCellList(), 5, game.getUsers(), game.createPlayerIdList());
  }

  private static ItemPlacedEvent getItemPlacedEvent() {
    Game game = new Game(false, 5, playerIds);
    Disc disc = new Disc(game.getUsers().get(0));
    disc.place(game.getUsers().get(0), game.getBoard().getCellList().get(0).get(0));
    return new ItemPlacedEvent(game.getBoard().getCellList(), new ArrayList<>());
  }

  private static PlayerChangeAnswerEvent getPlayerChangeAnswerEvent() {
    return new PlayerChangeAnswerEvent(new User(1, "1"), playerIds);
  }

  private static PlayerChangeEvent getPlayerChangeEvent() {
    return new PlayerChangeEvent(new User(2, "2"), playerIds);
  }

  private static PlayerChangeReactionEvent getPlayerChangeReactionEvent() {
    return new PlayerChangeReactionEvent(new User(3, "3"), playerIds);
  }

  List<GameEvent> gameEvents =
      List.of(
          /* new GameForfeitEvent(),
          new GameLoseEvent(),
          getGameStartEvent(),
          new GameWonEvent(),*/
          getItemPlacedEvent() /*,
                               getPlayerChangeAnswerEvent(),
                               getPlayerChangeEvent(),
                               getPlayerChangeReactionEvent()*/);

  @Test
  public void testJson() {
    for (GameEvent gameEvent : gameEvents) {
      // Converted to a json string , output to the console just for viewing
      String json = JsonBuilder.toJson(gameEvent);
      System.out.println(json);

      // If e.g. an AbortGameEvent-Json String goes in here, an AbortGameEvent also comes out
      GameEvent gameEvent1 = JsonBuilder.fromJson(json);
      assertTrue(gameEvent.equal(gameEvent1));
    }
  }
}
