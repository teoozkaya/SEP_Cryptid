package de.lmu.ifi.cip.jsonbuilder.modelinput;

import de.lmu.ifi.cip.model.Cryptid;

/** Abstract class for the model inputs. */
public abstract class ModelInput {

  String playerId;

  public abstract void invokeModel(Cryptid cryptid);

  public abstract String getName();

  public String getPlayerId() {
    return playerId;
  }
}
