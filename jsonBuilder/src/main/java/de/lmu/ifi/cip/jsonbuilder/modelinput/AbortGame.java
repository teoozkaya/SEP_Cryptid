package de.lmu.ifi.cip.jsonbuilder.modelinput;

import de.lmu.ifi.cip.model.Cryptid;

/** This model input represents aborting the game. */
public class AbortGame extends ModelInput {

  public AbortGame(String playerId) {
    this.playerId = playerId;
  }

  @Override
  public void invokeModel(Cryptid cryptid) {
    cryptid.abortGame();
  }

  @Override
  public String getName() {
    return "AbortGame";
  }
}
