package de.lmu.ifi.cip.server;

/** this class implements the main class for the server. */
public class Server {
  /**
   * Main method for the server.
   *
   * @param args arguments.
   */
  public static void main(String[] args) {
    final ServerNetworkConnection connection = new ServerNetworkConnection();
    connection.start();

    Runtime.getRuntime()
        .addShutdownHook(
            new Thread() {
              @Override
              public void run() {
                connection.stop();
              }
            });
  }
}
