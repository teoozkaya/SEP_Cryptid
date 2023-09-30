package de.lmu.ifi.cip.server;

import de.lmu.ifi.cip.jsonbuilder.ModelInputConverter;
import de.lmu.ifi.cip.jsonbuilder.modelinput.ModelInput;
import de.lmu.ifi.cip.jsonbuilder.modelinput.StartGame;
import java.util.ArrayList;

/**
 * This class handles incoming JsonStrings, converts them and initiates the corresponding model
 * methods.
 */
public class JsonReader {

  public JsonReader() {}

  /**
   * this method handles any incoming Jsons. it determines whether the player is in a running game
   * or not and handles the commands based on that.
   *
   * @param jsonString information from client in json format
   * @param playerId the id of the player currently interacting with the server
   * @param gameManagers a list of all gameManagers
   * @param playerHandler the current PlayerHandler of the specific player
   */
  public void handleJson(
      String jsonString,
      String playerId,
      ArrayList<GameManager> gameManagers,
      PlayerHandler playerHandler) {
    ModelInput modelInput = ModelInputConverter.fromJson(jsonString);
    if (modelInput.getName().equals("StartGame")) {
      StartGame startGame = (StartGame) modelInput;
      for (GameManager gameManager : gameManagers) {
        if (gameManager.getPlayerNumber() == startGame.getPlayerNumber()
            && gameManager.isGameMode() == startGame.getIsSimple()
            && gameManager.gameNotFull()) {
          gameManager.addPlayer(playerId, startGame.getNicknameList());
          return;
        }
      }
      playerHandler.addGameManager(
          new GameManager(
              startGame.getPlayerNumber(),
              startGame.getIsSimple(),
              playerId,
              playerHandler,
              startGame.getNicknameList()));
    } else {
      for (GameManager gameManager : gameManagers) {
        if ((gameManager.contains(playerId) && modelInput.getPlayerId().equals(playerId))
            || modelInput.getName().equals("AbortGame")) {
          if (gameManager.getCryptid().getGame() != null) {
            modelInput.invokeModel(gameManager.getCryptid());
          }
        }
      }
    }
  }
}
