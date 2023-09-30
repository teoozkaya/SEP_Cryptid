package de.lmu.ifi.cip.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/** This class establishes a network connection for the server. */
public class ServerNetworkConnection {

  private static final int PORT = 8080;
  ServerSocket serverSocket;
  Socket socket;

  /**
   * Constructor for the server network connection. It creates a new server socket with the
   * specified port.
   */
  public ServerNetworkConnection() {
    try {
      this.serverSocket = new ServerSocket(PORT);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * this method checks whether a server socket is open and then starts to accept input from this
   * socket and handles new clients.
   */
  public void start() {
    try {
      while (!serverSocket.isClosed()) {
        socket = serverSocket.accept();

        PlayerHandler playerHandler = new PlayerHandler(socket);

        Thread thread = new Thread(playerHandler);
        thread.start();
      }

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /** This Method closes the server socket. */
  public void stop() {
    try {
      if (serverSocket != null) {
        serverSocket.close();
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
