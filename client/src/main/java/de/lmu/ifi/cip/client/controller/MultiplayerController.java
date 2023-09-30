package de.lmu.ifi.cip.client.controller;

import de.lmu.ifi.cip.client.ClientNetworkConnection;
import de.lmu.ifi.cip.client.MainFrame;
import de.lmu.ifi.cip.client.panels.CreationPanel;
import de.lmu.ifi.cip.client.panels.GamePanel;
import de.lmu.ifi.cip.client.panels.LobbyPanel;
import de.lmu.ifi.cip.jsonbuilder.ModelInputConverter;
import de.lmu.ifi.cip.jsonbuilder.modelinput.AbortGame;
import de.lmu.ifi.cip.jsonbuilder.modelinput.AskField;
import de.lmu.ifi.cip.jsonbuilder.modelinput.PlaceCube;
import de.lmu.ifi.cip.jsonbuilder.modelinput.PlaceDisc;
import de.lmu.ifi.cip.jsonbuilder.modelinput.RestartGame;
import de.lmu.ifi.cip.jsonbuilder.modelinput.SearchField;
import de.lmu.ifi.cip.jsonbuilder.modelinput.StartGame;
import de.lmu.ifi.cip.model.Cryptid;
import java.util.ArrayList;

/** Implements the MultiplayerController. */
public class MultiplayerController extends GameController {

  ClientNetworkConnection connection;
  Cryptid cryptid;
  LobbyPanel lobbyPanel;

  /** Constructor for the multiplayer controller. */
  public MultiplayerController() {
    MainFrame.register(MainFrame.PanelName.CREATION, new CreationPanel(this));
    MainFrame.switchTo(MainFrame.PanelName.CREATION);
    lobbyPanel = new LobbyPanel(this);
    gamePanel = new GamePanel(this);
    cryptid = new Cryptid(gamePanel, lobbyPanel);
    connection = new ClientNetworkConnection(cryptid, gamePanel, lobbyPanel);
    connection.start();
  }

  /** {@inheritDoc} */
  @Override
  public void startGame(int gameMode, int playerNumber, ArrayList<String> nicknameList) {

    MainFrame.register(MainFrame.PanelName.GAME, gamePanel);
    MainFrame.register(MainFrame.PanelName.LOBBY, lobbyPanel);
    String json =
        ModelInputConverter.toJson(new StartGame(gameMode == 0, playerNumber, nicknameList));
    this.connection.sendJson(json);
    MainFrame.switchTo(MainFrame.PanelName.LOBBY);
  }

  /** {@inheritDoc} */
  @Override
  public void searchField() {
    String json =
        ModelInputConverter.toJson(
            new SearchField(coordinate, activePlayer, activePlayer.getPlayerId()));
    if (!(coordinate == null || activePlayer == null || activePlayer.getPlayerId() == null)) {
      this.connection.sendJson(json);
    }
  }

  /** {@inheritDoc} */
  @Override
  public void askField() {
    String json =
        ModelInputConverter.toJson(
            new AskField(coordinate, activePlayer, selectedPlayer, activePlayer.getPlayerId()));
    if (!(coordinate == null
        || activePlayer == null
        || selectedPlayer == null
        || activePlayer.getPlayerId() == null)) {
      this.connection.sendJson(json);
    }
  }

  /** {@inheritDoc} */
  @Override
  public void placeCube() {
    String json =
        ModelInputConverter.toJson(
            new PlaceCube(coordinate, activePlayer, activePlayer.getPlayerId()));
    if (!(coordinate == null || activePlayer == null || activePlayer.getPlayerId() == null)) {
      this.connection.sendJson(json);
    }
  }

  /** {@inheritDoc} */
  @Override
  public void placeDisk() {
    String json =
        ModelInputConverter.toJson(
            new PlaceDisc(coordinate, activePlayer, activePlayer.getPlayerId()));
    if (!(coordinate == null || activePlayer == null || activePlayer.getPlayerId() == null)) {
      this.connection.sendJson(json);
    }
  }

  /** {@inheritDoc} */
  @Override
  public void restartGame() {
    String json = ModelInputConverter.toJson(new RestartGame(activePlayer.getPlayerId()));
    this.connection.sendJson(json);
  }

  /** {@inheritDoc} */
  @Override
  public void abortGame() {
    if (activePlayer != null) {
      String json = ModelInputConverter.toJson(new AbortGame(activePlayer.getPlayerId()));
      this.connection.sendJson(json);
    }
  }
}
