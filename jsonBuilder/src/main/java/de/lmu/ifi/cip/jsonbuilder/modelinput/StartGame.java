package de.lmu.ifi.cip.jsonbuilder.modelinput;

import de.lmu.ifi.cip.model.Cryptid;
import java.util.ArrayList;

/** This model input represents starting the game. */
public class StartGame extends ModelInput {

  private final boolean isSimple;
  private final int playerNumber;
  private final ArrayList<String> nicknameList;

  /**
   * Constructor for the class StartGame. It specifies the game mode, the number of players and the
   * nicknames of the players.
   *
   * @param isSimple boolean that specifies the game mode. True is the normal game mode, false is
   *     the advanced game mode.
   * @param playerNumber the number of players in the game.
   * @param nicknameList the list of the player's nicknames.
   */
  public StartGame(boolean isSimple, int playerNumber, ArrayList<String> nicknameList) {
    this.isSimple = isSimple;
    this.playerNumber = playerNumber;
    this.nicknameList = nicknameList;
  }

  @Override
  public void invokeModel(Cryptid cryptid) {
    cryptid.newGame(isSimple, playerNumber, new ArrayList<String>(), nicknameList);
  }

  @Override
  public String getName() {
    return "StartGame";
  }

  public boolean getIsSimple() {
    return isSimple;
  }

  public int getPlayerNumber() {
    return playerNumber;
  }

  public ArrayList<String> getNicknameList() {
    return nicknameList;
  }
}
