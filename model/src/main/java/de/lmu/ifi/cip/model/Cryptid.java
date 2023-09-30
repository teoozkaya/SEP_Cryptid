package de.lmu.ifi.cip.model;

import de.lmu.ifi.cip.model.board.Cell;
import de.lmu.ifi.cip.model.board.Coordinate;
import de.lmu.ifi.cip.model.events.GameEvent;
import de.lmu.ifi.cip.model.events.GameForfeitEvent;
import de.lmu.ifi.cip.model.events.GameLoseEvent;
import de.lmu.ifi.cip.model.events.GameStartEvent;
import de.lmu.ifi.cip.model.events.GameWonEvent;
import de.lmu.ifi.cip.model.events.HintEvent;
import de.lmu.ifi.cip.model.events.ItemPlacedEvent;
import de.lmu.ifi.cip.model.events.PlayerChangeAnswerEvent;
import de.lmu.ifi.cip.model.events.PlayerChangeEvent;
import de.lmu.ifi.cip.model.events.PlayerChangeReactionEvent;
import de.lmu.ifi.cip.model.events.WrongMoveEvent;
import de.lmu.ifi.cip.model.moves.FollowUpCube;
import de.lmu.ifi.cip.model.moves.GameStartCubes;
import de.lmu.ifi.cip.model.moves.GameState;
import de.lmu.ifi.cip.model.moves.GameWon;
import de.lmu.ifi.cip.model.moves.Question;
import de.lmu.ifi.cip.model.moves.Search;
import de.lmu.ifi.cip.model.moves.TurnBegin;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

/** A class that implements all interactions the game class for a Cryptid game. */
public class Cryptid {

  private GameState gameState;
  private Game game;
  private final PropertyChangeSupport support;

  private HintSearch hintSearch = new HintSearch();

  /**
   * This constructor sets up the Cryptid instances. It creates a PropertyChangeSupport and can add
   * up to two Listeners to it.
   *
   * @param listener the first listener for property changes.
   * @param secondListener the second listener for property changes.
   */
  public Cryptid(PropertyChangeListener listener, PropertyChangeListener secondListener) {
    support = new PropertyChangeSupport(this);
    support.addPropertyChangeListener(listener);
    support.addPropertyChangeListener(secondListener);
  }

  /**
   * Creates the game nad notifies the server.
   *
   * @param isSimple simple or advanced
   * @param numberOfPlayers How many players will be playing
   */
  public void newGame(
      boolean isSimple,
      int numberOfPlayers,
      ArrayList<String> playerIdList,
      ArrayList<String> nicknameList) {
    game = new Game(isSimple, numberOfPlayers, playerIdList);
    for (int i = 0; i < game.getUsers().size(); i++) {
      game.getUsers().get(i).setName(nicknameList.get(i));
    }
    List<User> users = new ArrayList<>();
    int currentUserIndex = 0;
    for (int i = 0; i < game.getUsers().size() * 2; i++) {
      users.add(game.getUsers().get(currentUserIndex));
      currentUserIndex = nextPlayerIndex(currentUserIndex);
    }
    this.gameState = new GameStartCubes(users);
    Hint hint1 = game.getHints().get(0);

    GameStartEvent gameStartEvent =
        new GameStartEvent(
            game.getBoard().getCellList(),
            numberOfPlayers,
            game.getUsers(),
            game.createPlayerIdList());
    this.notifyListeners(gameStartEvent);
    for (User user : game.getUsers()) {
      HintEvent hintEvent = new HintEvent(user.getHint(), user, user.getPlayerId());
      notifyListeners(hintEvent);
    }
    HintEvent hintEvent =
        new HintEvent(
            game.getUsers().get(0).getHint(),
            game.getUsers().get(0),
            game.getUsers().get(0).getPlayerId());
    notifyListeners(hintEvent);
  }

  /** Method to abort/forfeit the game. */
  public void abortGame() {

    GameForfeitEvent gameForfeitEvent = new GameForfeitEvent(game.createPlayerIdList());
    this.notifyListeners(gameForfeitEvent);
  }

  /** Method th restart the running game. */
  public void restartGame() {

    game.restart();
    List<User> users = new ArrayList<>();
    int currentUserIndex = 0;
    for (int i = 0; i < game.getUsers().size() * 2; i++) {
      users.add(game.getUsers().get(currentUserIndex));
      currentUserIndex = nextPlayerIndex(currentUserIndex);
    }
    gameState = new GameStartCubes(users);
    GameStartEvent restartGameEvent =
        new GameStartEvent(
            game.getBoard().getCellList(),
            game.getUsers().size(),
            game.getUsers(),
            game.createPlayerIdList());
    this.notifyListeners(restartGameEvent);
    for (User user : game.getUsers()) {
      HintEvent hintEvent = new HintEvent(user.getHint(), user, user.getPlayerId());
      notifyListeners(hintEvent);
    }
  }

  /**
   * Starts questioning of a cell, first checks if the move is allowed by the current gameState. If
   * allowed than changes the gameState to Question state. The next player will be questioning
   * player. At the end notifies the gui about player change.
   *
   * @param coordinate of the selected Cell
   * @param activeUser the user that started the Interaction
   * @param selectedPlayer the player that is asked a question to the specified cell
   */
  public void questionCell(Coordinate coordinate, User activeUser, User selectedPlayer) {
    if (!activeUser.equals(gameState.getCurrentAllowedUser())) {
      WrongMoveEvent wrongMoveEvent = new WrongMoveEvent(activeUser.getPlayerId());
      this.notifyListeners(wrongMoveEvent);
      return;
    }
    Cell cell = game.getBoard().getCellList().get(coordinate.getRow()).get(coordinate.getColumn());
    User questionedUser = selectedPlayer;
    User questioningUser = gameState.getQuestioningUser();
    if (!gameState.isAllowed(questioningUser, GameState.MoveTypes.PLACE_PAWN, cell)
        || questionedUser == null) {
      WrongMoveEvent wrongMoveEvent = new WrongMoveEvent(activeUser.getPlayerId());
      this.notifyListeners(wrongMoveEvent);
      return;
    }
    this.gameState = new Question(questioningUser, cell, questionedUser);
    PlayerChangeAnswerEvent playerChangeEvent =
        new PlayerChangeAnswerEvent(questionedUser, game.createPlayerIdList());
    playerChangeEvent.setCell(cell);
    this.notifyListeners(playerChangeEvent);
    HintEvent hintEvent =
        new HintEvent(questionedUser.getHint(), questionedUser, questionedUser.getPlayerId());
    notifyListeners(hintEvent);
  }

  /**
   * Starts search of a cell, first checks if the move is allowed by the gameState. Afterwards
   * creates a list of users for the search method to asks each of them. At the end notifies the gui
   * about player change.
   *
   * @param coordinate of the cell that should be searched
   * @param activeUser the user that started the interaction
   */
  public void searchCell(Coordinate coordinate, User activeUser) {
    if (!activeUser.equals(gameState.getCurrentAllowedUser())) {
      WrongMoveEvent wrongMoveEvent = new WrongMoveEvent(activeUser.getPlayerId());
      this.notifyListeners(wrongMoveEvent);
      return;
    }
    Cell cell = game.getBoard().getCellList().get(coordinate.getRow()).get(coordinate.getColumn());
    User questioningUser = gameState.getQuestioningUser();
    if (!hintSearch.canPlaceDisc(activeUser.getHint(), game.getBoard(), cell)
        || !gameState.isAllowed(questioningUser, GameState.MoveTypes.PLACE_PAWN, cell)) {
      WrongMoveEvent wrongMoveEvent = new WrongMoveEvent(activeUser.getPlayerId());
      this.notifyListeners(wrongMoveEvent);
      return;
    }
    // Users are being rearranged starting from the questioning user
    List<User> askedUsers = new ArrayList<>();
    int currentIndex = nextPlayerIndex(questioningUser.getPlayerNumber());
    for (int i = 0; i < game.getUsers().size() - 1; i++) {
      askedUsers.add(game.getUsers().get(currentIndex));
      currentIndex = nextPlayerIndex(currentIndex);
    }
    Disc disc = new Disc(activeUser);
    disc.place(activeUser, cell);
    ItemPlacedEvent itemPlacedEvent =
        new ItemPlacedEvent(game.getBoard().getCellList(), game.createPlayerIdList());
    itemPlacedEvent.setCell(cell);
    this.notifyListeners(itemPlacedEvent);

    gameState = new Search(questioningUser, cell, askedUsers);
    int nextIndex = nextPlayerIndex(questioningUser.getPlayerNumber());
    User nextPlayer = game.getUsers().get(nextIndex);
    PlayerChangeAnswerEvent playerChangeEvent =
        new PlayerChangeAnswerEvent(nextPlayer, game.createPlayerIdList());
    playerChangeEvent.setCell(cell);
    this.notifyListeners(playerChangeEvent);
    HintEvent hintEvent = new HintEvent(nextPlayer.getHint(), nextPlayer, nextPlayer.getPlayerId());
    notifyListeners(hintEvent);
  }

  /**
   * First checks if the game state is eligible with this action. If its allowed then places a cube
   * on a given cell. Afterwards notifies the listeners about the cube placement. After that changes
   * the next user according to the gameState. If in GameStartCubes nextPlayer is always the next
   * user in queue until the queue is empty. If gameState is in Search or Question than it goes back
   * to the questioning user and changes the GameState to FollowUpCube, where the questioning user
   * must place another cube. If gameState is in FollowUpCube nextPlayer is the nextPlayer in line
   * and gameState sets in to TurnBegin.
   *
   * @param coordinate Coordinate of the selected Cell
   * @param activeUser the User who started this action
   */
  public void placeCube(Coordinate coordinate, User activeUser) {

    if (!activeUser.equals(gameState.getCurrentAllowedUser())) {
      WrongMoveEvent wrongMoveEvent = new WrongMoveEvent(activeUser.getPlayerId());
      this.notifyListeners(wrongMoveEvent);
      return;
    }
    // no cell is selected
    if (coordinate == null) {
      WrongMoveEvent wrongMoveEvent = new WrongMoveEvent(activeUser.getPlayerId());
      this.notifyListeners(wrongMoveEvent);
      return;
    }
    Cell cell = game.getBoard().getCellList().get(coordinate.getRow()).get(coordinate.getColumn());
    User placingUser = gameState.getCurrentAllowedUser();
    if (this.gameState instanceof FollowUpCube) {
      placingUser = gameState.getQuestioningUser();
    }
    if (!gameState.isAllowed(placingUser, GameState.MoveTypes.PLACE_CUBE, cell)) {
      WrongMoveEvent wrongMoveEvent = new WrongMoveEvent(activeUser.getPlayerId());
      this.notifyListeners(wrongMoveEvent);
      return;
    }

    // a cube is already there error message

    if (cell.getCube() || !hintSearch.canPlaceCube(activeUser.getHint(), game.getBoard(), cell)) {
      WrongMoveEvent wrongMoveEvent = new WrongMoveEvent(activeUser.getPlayerId());
      this.notifyListeners(wrongMoveEvent);
      return;
    }

    // cube placing player already has a placeable on the same cell
    for (Placeable p : cell.getPlaceables()) {
      if (p.getUser().equals(placingUser)) {
        WrongMoveEvent wrongMoveEvent = new WrongMoveEvent(activeUser.getPlayerId());
        this.notifyListeners(wrongMoveEvent);
        return;
      }
    }
    Cube cube = new Cube(placingUser);
    cube.place(placingUser, cell);

    ItemPlacedEvent itemPlacedEvent =
        new ItemPlacedEvent(game.getBoard().getCellList(), game.createPlayerIdList());
    itemPlacedEvent.setCell(cell);
    this.notifyListeners(itemPlacedEvent);

    if (gameState instanceof GameStartCubes startCubes) {
      User nextUser = startCubes.getUsersInLine().poll();
      if (nextUser == null) {
        User next = game.getUsers().get(0);
        this.gameState = new TurnBegin(next);
        PlayerChangeEvent playerChangeEvent =
            new PlayerChangeEvent(next, game.createPlayerIdList());
        playerChangeEvent.setCell(cell);
        notifyListeners(playerChangeEvent);
        HintEvent hintEvent = new HintEvent(next.getHint(), next, next.getPlayerId());
        notifyListeners(hintEvent);
      } else {
        startCubes.setCurrentAllowedUser(nextUser);

        PlayerChangeReactionEvent playerChangeEvent =
            new PlayerChangeReactionEvent(nextUser, game.createPlayerIdList());
        playerChangeEvent.setCell(cell);
        notifyListeners(playerChangeEvent);
        HintEvent hintEvent = new HintEvent(nextUser.getHint(), nextUser, nextUser.getPlayerId());
        notifyListeners(hintEvent);
      }

    } else if (this.gameState instanceof Search || this.gameState instanceof Question) {
      User nextUser = gameState.getQuestioningUser();

      gameState = new FollowUpCube(nextUser);

      PlayerChangeReactionEvent playerChangeReactionEvent =
          new PlayerChangeReactionEvent(nextUser, game.createPlayerIdList());
      playerChangeReactionEvent.setCell(cell);
      this.notifyListeners(playerChangeReactionEvent);
      HintEvent hintEvent = new HintEvent(nextUser.getHint(), nextUser, nextUser.getPlayerId());
      notifyListeners(hintEvent);
      return;
    } else if (this.gameState instanceof FollowUpCube) {
      int nextPlayerIndex = this.nextPlayerIndex(placingUser.getPlayerNumber());
      User nextPlayer = game.getUsers().get(nextPlayerIndex);
      gameState = new TurnBegin(nextPlayer);

      PlayerChangeEvent playerChangeEvent =
          new PlayerChangeEvent(nextPlayer, game.createPlayerIdList());
      playerChangeEvent.setCell(cell);
      this.notifyListeners(playerChangeEvent);
      HintEvent hintEvent =
          new HintEvent(nextPlayer.getHint(), nextPlayer, nextPlayer.getPlayerId());
      notifyListeners(hintEvent);
      return;
    }
  }

  /**
   * First checks if the game state is eligible with this action. If its allowed then places a disc
   * on a given cell. Afterwards notifies the listeners about the disc placement. After that changes
   * the next user according to the gameState. If gameState is in Search nextPlayer will be the
   * nextPlayer in queue, and they should also answer the search, If the poll method gives a null,
   * it means every User has placed a disc and game is Won. If in Question State than it goes back
   * to the player after the questioning player and Game State is set to TurnBegin.
   *
   * @param coordinate of the selected Cell
   * @param activeUser the User initiating this method
   */
  public void placeDisc(Coordinate coordinate, User activeUser) {
    if (!activeUser.equals(gameState.getCurrentAllowedUser())) {
      WrongMoveEvent wrongMoveEvent = new WrongMoveEvent(activeUser.getPlayerId());
      this.notifyListeners(wrongMoveEvent);
      return;
    }
    Cell cell = game.getBoard().getCellList().get(coordinate.getRow()).get(coordinate.getColumn());
    User placingUser = gameState.getCurrentAllowedUser();
    if (!gameState.isAllowed(placingUser, GameState.MoveTypes.PLACE_DISC, cell)) {
      WrongMoveEvent wrongMoveEvent = new WrongMoveEvent(activeUser.getPlayerId());
      this.notifyListeners(wrongMoveEvent);
      return;
    }
    // a cube is placed on the cell

    if (cell.getCube() || !hintSearch.canPlaceDisc(activeUser.getHint(), game.getBoard(), cell)) {
      WrongMoveEvent wrongMoveEvent = new WrongMoveEvent(activeUser.getPlayerId());
      this.notifyListeners(wrongMoveEvent);
      return;
    }

    // cube placing player already has a placeable on the same cell
    for (Placeable p : cell.getPlaceables()) {
      if (p.getUser().equals(placingUser)) {
        WrongMoveEvent wrongMoveEvent = new WrongMoveEvent(activeUser.getPlayerId());
        this.notifyListeners(wrongMoveEvent);
        return;
      }
    }
    Disc disc = new Disc(placingUser);
    disc.place(placingUser, cell);

    ItemPlacedEvent itemPlacedEvent =
        new ItemPlacedEvent(game.getBoard().getCellList(), game.createPlayerIdList());
    itemPlacedEvent.setCell(cell);
    this.notifyListeners(itemPlacedEvent);

    if (this.gameState instanceof Search gameStateS) {
      User nextUser = gameStateS.getToBeAsked().poll();
      if (nextUser == null) {
        GameLoseEvent gameLoseEvent = new GameLoseEvent(game.createPlayerIdList());
        notifyListeners(gameLoseEvent);
        this.gameState = new GameWon(this.gameState.getQuestioningUser());
        GameWonEvent gameWonEvent =
            new GameWonEvent(this.gameState.getCurrentAllowedUser().getPlayerId());
        notifyListeners(gameWonEvent);
      } else {
        gameStateS.setCurrentAllowedUser(nextUser);
        PlayerChangeAnswerEvent playerChangeEvent =
            new PlayerChangeAnswerEvent(nextUser, game.createPlayerIdList());
        playerChangeEvent.setCell(cell);
        this.notifyListeners(playerChangeEvent);
        HintEvent hintEvent = new HintEvent(nextUser.getHint(), nextUser, nextUser.getPlayerId());
        notifyListeners(hintEvent);
      }
    }

    if (this.gameState instanceof Question) {
      int nextPlayerIndex = this.nextPlayerIndex(gameState.getQuestioningUser().getPlayerNumber());
      User nextUser = game.getUsers().get(nextPlayerIndex);
      gameState = new TurnBegin(nextUser);

      PlayerChangeEvent playerChangeEvent =
          new PlayerChangeEvent(nextUser, game.createPlayerIdList());
      playerChangeEvent.setCell(cell);
      this.notifyListeners(playerChangeEvent);
      HintEvent hintEvent = new HintEvent(nextUser.getHint(), nextUser, nextUser.getPlayerId());
      notifyListeners(hintEvent);
    }
  }

  /**
   * Method that returns the id of the next player/user.
   *
   * @param currentPlayer the currently active player/user.
   * @return the index of the next player
   */
  public int nextPlayerIndex(int currentPlayer) {
    if (currentPlayer + 1 == this.game.getUsers().size()) {
      return 0;
    } else {
      return currentPlayer + 1;
    }
  }

  /**
   * Basic method to notify the GUI about updates.
   *
   * @param event an event that specifics a change in the model.
   */
  private void notifyListeners(GameEvent event) {
    support.firePropertyChange(event.getName(), null, event);
  }

  public Game getGame() {
    return game;
  }
}
