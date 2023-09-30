package de.lmu.ifi.cip.jsonbuilder.modelinput;

import de.lmu.ifi.cip.model.Cryptid;

/** This model input represents restaring the game. */
public class RestartGame extends ModelInput {

  public RestartGame(String playerId) {
    this.playerId = playerId;
  }

  @Override
  public void invokeModel(Cryptid cryptid) {
    cryptid.restartGame();
  }

  @Override
  public String getName() {
    return "RestartGame";
  }
}
