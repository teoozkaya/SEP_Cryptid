package de.lmu.ifi.cip.jsonbuilder.modelinput;

import de.lmu.ifi.cip.model.Cryptid;
import de.lmu.ifi.cip.model.User;
import de.lmu.ifi.cip.model.board.Coordinate;

/** This model input represents placing a cube. */
public class PlaceCube extends ModelInput {
  private Coordinate coordinate;
  private User user;

  /**
   * Constructor for the class PlaceCube, that specifies the coordinate, user and playerId.
   *
   * @param coordinate coordinate of the cell the cube is placed.
   * @param user the user placing the cube.
   * @param playerId the id of the player placing the cube.
   */
  public PlaceCube(Coordinate coordinate, User user, String playerId) {
    this.coordinate = coordinate;
    this.user = user;
    this.playerId = playerId;
  }

  @Override
  public void invokeModel(Cryptid cryptid) {
    cryptid.placeCube(coordinate, user);
  }

  @Override
  public String getName() {
    return "PlaceCube";
  }
}
