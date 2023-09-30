package de.lmu.ifi.cip.client;

import static java.nio.charset.StandardCharsets.UTF_8;

import de.lmu.ifi.cip.jsonbuilder.JsonBuilder;
import de.lmu.ifi.cip.model.Cryptid;
import de.lmu.ifi.cip.model.events.GameEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/** This class establishes a network connection for the client. */
public class ClientNetworkConnection {

  private static final String HOST = "Localhost";
  private static final int PORT = 8080;
  private Socket socket;
  private final PropertyChangeSupport support;

  private BufferedReader reader;
  private BufferedWriter writer;
  private Cryptid cryptid;

  /**
   * Constructor for the client network connection. It creates a new client for the server.
   *
   * @param cryptid The current game
   * @param listener when a change is made, it makes the support notify the server
   */
  public ClientNetworkConnection(
      Cryptid cryptid, PropertyChangeListener listener, PropertyChangeListener secondListener) {
    this.support = new PropertyChangeSupport(this);
    this.cryptid = cryptid;
    support.addPropertyChangeListener(listener);
    support.addPropertyChangeListener(secondListener);
  }

  /**
   * Starts the network connection for the client. Connects the client to the server and listens the
   * servers notifications game events.
   */
  public void start() {
    try {
      this.socket = new Socket(HOST, PORT);

      this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), UTF_8));
      this.writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), UTF_8));

      new Thread(
              () -> {
                while (!socket.isClosed()) {
                  try {
                    String responseMessage = reader.readLine();
                    handleResponseMessage(responseMessage);
                  } catch (IOException e) {
                    closeEverything();
                  }
                }
              })
          .start();

    } catch (IOException e) {
      closeEverything();
    }
  }

  /**
   * Flushes the json message to the server.
   *
   * @param json the message to be sent
   */
  public void sendJson(String json) {
    try {
      writer.write(json + "\n");
      writer.flush();
    } catch (IOException e) {
      closeEverything();
    }
  }

  /**
   * Handles the update from the server. Creates an event for the update and notifies their model.
   *
   * @param responseMessage incoming json update from the server
   */
  public void handleResponseMessage(String responseMessage) {
    if (responseMessage == null || responseMessage.trim().length() == 0) {
      return;
    }
    GameEvent gameEvent = JsonBuilder.fromJson(responseMessage);
    notifyListeners(gameEvent);
  }

  private void notifyListeners(GameEvent event) {
    support.firePropertyChange(event.getName(), null, event);
  }

  /** Closes the socket connection with the server. */
  public void closeEverything() {
    try {
      if (socket != null) {
        socket.close();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
