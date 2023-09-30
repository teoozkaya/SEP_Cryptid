package de.lmu.ifi.cip.jsonbuilder.modelinput;

import de.lmu.ifi.cip.model.Cryptid;
import de.lmu.ifi.cip.model.User;
import de.lmu.ifi.cip.model.board.Coordinate;

/** This model input represents questioning a cell. */
public class AskField extends ModelInput {

  private User askedUser;
  private User questioningUser;
  private Coordinate coordinate;

  /**
   * Constructor for the model input of questioning a cell.
   *
   * @param coordinate questioning cell's coordinate
   * @param questioningUser questioning player
   * @param askedUser asked player
   */
  public AskField(Coordinate coordinate, User questioningUser, User askedUser, String playerId) {
    this.askedUser = askedUser;
    this.coordinate = coordinate;
    this.questioningUser = questioningUser;
    this.playerId = playerId;
  }

  @Override
  public void invokeModel(Cryptid cryptid) {
    cryptid.questionCell(coordinate, questioningUser, askedUser);
  }

  @Override
  public String getName() {
    return "AskField";
  }
}
