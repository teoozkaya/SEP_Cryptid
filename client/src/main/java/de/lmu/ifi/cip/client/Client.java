package de.lmu.ifi.cip.client;

import javax.swing.SwingUtilities;

/** This class implements the main-class for the client. */
public class Client {

  /**
   * Main method for the Client.
   *
   * @param args arguments.
   */
  public static void main(String[] args) {
    SwingUtilities.invokeLater(MainFrame::getInstance);
  }
}
