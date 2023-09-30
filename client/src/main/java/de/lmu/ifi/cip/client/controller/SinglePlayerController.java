package de.lmu.ifi.cip.client.controller;

import de.lmu.ifi.cip.client.MainFrame;
import de.lmu.ifi.cip.client.panels.CreationPanel;
import de.lmu.ifi.cip.client.panels.GamePanel;
import de.lmu.ifi.cip.model.Cryptid;
import de.lmu.ifi.cip.model.board.Coordinate;
import java.util.ArrayList;
import java.util.UUID;

/** Implements the controller for single player games. */
public class SinglePlayerController extends GameController {

  private Cryptid game;

  /** Constructor for the single player controller. */
  public SinglePlayerController() {
    MainFrame.register(MainFrame.PanelName.CREATION, new CreationPanel(this));
    MainFrame.switchTo(MainFrame.PanelName.CREATION);
  }

  /** {@inheritDoc} */
  public void startGame(int gameMode, int playerNumber, ArrayList<String> nicknameList) {
    gamePanel = new GamePanel(this);

    MainFrame.register(MainFrame.PanelName.GAME, gamePanel);

    game = new Cryptid(gamePanel, null);
    MainFrame.switchTo(MainFrame.PanelName.GAME);
    ArrayList<String> playerIdList = new ArrayList<>();
    for (int i = 0; i < playerNumber; i++) {
      playerIdList.add(UUID.randomUUID().toString());
    }
    game.newGame(gameMode == 0, playerNumber, playerIdList, nicknameList);
  }

  /** {@inheritDoc} */
  public void searchField() {
    game.searchCell(coordinate, activePlayer);
  }

  /** {@inheritDoc} */
  public void askField() {
    game.questionCell(coordinate, activePlayer, selectedPlayer);
  }

  /** {@inheritDoc} */
  public void placeCube() {
    game.placeCube(coordinate, activePlayer);
  }

  /** {@inheritDoc} */
  public void placeDisk() {
    game.placeDisc(coordinate, activePlayer);
  }

  /** {@inheritDoc} */
  public void setSelectedField(int idX, int idY) {
    this.coordinate = new Coordinate(idY, idX);
  }

  /** {@inheritDoc} */
  public void restartGame() {
    game.restartGame();
  }

  /** {@inheritDoc} */
  public void abortGame() {
    if (game != null) {
      game.abortGame();
    }
  }
}
