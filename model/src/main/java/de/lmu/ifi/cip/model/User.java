package de.lmu.ifi.cip.model;

/** Implements a class which implements a user in the game. */
public class User {

  private String[] playerNumberToColor = {"red", "blue", "orange", "black", "turquoise"};
  private String playerColour;

  private String name;
  private String hint;

  private String playerId;
  private int playerNumber;

  /**
   * Constructor for the user class, which sets the parameters for the user.
   *
   * @param playerNumber sets the number, which identifies the user.
   */
  public User(int playerNumber, String playerId) {
    this.playerNumber = playerNumber;
    this.playerColour = (playerNumberToColor[playerNumber]);
    this.name = ("Spieler " + playerNumber);
    this.playerId = playerId;
  }

  /**
   * sets the name of the User, if no name is given the name is set to a default in the style of
   * "Spieler" and a number.
   *
   * @param name a name that is given to the user
   */
  public void setName(String name) {
    if (name.equals("")) {
      this.name = ("Spieler " + (playerNumber + 1));
    } else {
      this.name = name;
    }
  }

  public void setHint(Hint hinweis) {
    this.hint = hinweis.getHint();
  }

  public String getHint() {
    return hint;
  }

  public int getPlayerNumber() {
    return playerNumber;
  }

  public String getPlayerId() {
    return playerId;
  }

  public String getPlayerColour() {
    return playerColour;
  }

  public String getName() {
    return name;
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof User user) {
      return this.getPlayerNumber() == user.getPlayerNumber();
    }
    return false;
  }
}
