package de.lmu.ifi.cip.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/**
 * This class handles the Player that connect to the server and the communication with the players.
 */
public class PlayerHandler implements Runnable {

  public static HashMap<String, PlayerHandler> playerHandlers = new HashMap<>();

  private static ArrayList<GameManager> gameManagers = new ArrayList<>();
  private Socket socket;
  private BufferedReader bufferedReader;
  private BufferedWriter bufferedWriter;
  private String playerId;

  private JsonReader jsonReader;

  /**
   * Constructor for the PlayerHandler class, that instantiates the BufferedReader and
   * BufferedWriter for this Player and adds it to the list of players.
   *
   * @param socket the socket communication is established on
   */
  public PlayerHandler(Socket socket) {
    try {
      this.socket = socket;
      this.bufferedWriter =
          new BufferedWriter(
              new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));
      this.bufferedReader =
          new BufferedReader(
              new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
      playerId = UUID.randomUUID().toString();
      playerHandlers.put(playerId, this);
      jsonReader = new JsonReader();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void run() {

    while (socket.isConnected()) {
      try {
        String jsonString;
        jsonString = bufferedReader.readLine();
        jsonReader.handleJson(jsonString, playerId, gameManagers, this);
      } catch (IOException e) {
        closeEverything(socket, bufferedWriter, bufferedReader);
        throw new RuntimeException(e);
      }
    }
  }

  /**
   * This method sends information to all players that are referenced in the List of playerIds.
   *
   * @param jsonString the information to send as Json.
   * @param playerIds the list of players that should receive this information.
   */
  public void broadcast(String jsonString, ArrayList<String> playerIds) {
    for (String playerId : playerIds) {
      if (playerHandlers.keySet().contains(playerId)) {
        try {
          PlayerHandler playerHandler = playerHandlers.get(playerId);
          playerHandler.bufferedWriter.write(jsonString);
          playerHandler.bufferedWriter.newLine();
          playerHandler.bufferedWriter.flush();

        } catch (IOException e) {
          closeEverything(socket, bufferedWriter, bufferedReader);
        }
      }
    }
  }

  public void addGameManager(GameManager gameManager) {
    gameManagers.add(gameManager);
  }

  private void removePlayerHandler() {
    for (GameManager gameManager : gameManagers) {
      if (gameManager.contains(this.playerId)) {
        gameManager.removePlayer(playerId);
      }
      playerHandlers.remove(playerId);
    }
  }

  private void closeEverything(
      Socket socket, BufferedWriter bufferedWriter, BufferedReader bufferedReader) {
    removePlayerHandler();
    try {
      if (bufferedReader != null) {
        bufferedReader.close();
      }
      if (bufferedWriter != null) {
        bufferedWriter.close();
      }
      if (socket != null) {
        socket.close();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
