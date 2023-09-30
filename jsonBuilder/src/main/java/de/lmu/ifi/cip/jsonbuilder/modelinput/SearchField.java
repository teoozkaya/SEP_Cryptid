package de.lmu.ifi.cip.jsonbuilder.modelinput;

import de.lmu.ifi.cip.model.Cryptid;
import de.lmu.ifi.cip.model.User;
import de.lmu.ifi.cip.model.board.Coordinate;

/** This model input represents search of a cell. */
public class SearchField extends ModelInput {

  private User user;
  private Coordinate coordinate;

  /**
   * The constructor for the class SearchField. it specifies the coordinate, User and playerId.
   *
   * @param coordinate coordinate of the cell that is searched.
   * @param user the user that searches the cell.
   * @param playerId the id of the searching player.
   */
  public SearchField(Coordinate coordinate, User user, String playerId) {
    this.user = user;
    this.coordinate = coordinate;
    this.playerId = playerId;
  }

  @Override
  public void invokeModel(Cryptid cryptid) {
    cryptid.searchCell(coordinate, user);
  }

  @Override
  public String getName() {
    return "SearchField";
  }
}
