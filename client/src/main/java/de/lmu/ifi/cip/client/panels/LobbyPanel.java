package de.lmu.ifi.cip.client.panels;

import de.lmu.ifi.cip.client.ImageLoader;
import de.lmu.ifi.cip.client.MainFrame;
import de.lmu.ifi.cip.client.controller.GameController;
import de.lmu.ifi.cip.client.util.ButtonBuilder;
import de.lmu.ifi.cip.client.util.ButtonLighter;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/** This creates a panel that acts as a waiting room for the Multiplayer Mode. */
public class LobbyPanel extends JPanel implements PropertyChangeListener {

  private final GameController controller;

  /**
   * This constructor sets up an instance of a LobbyPanel. It adds an info text and a button to get
   * back to the Main menu.
   *
   * @param controller sets a reference to a game controller
   */
  public LobbyPanel(GameController controller) {
    this.controller = controller;

    ImageIcon backgroundImage =
        new ImageIcon(ImageLoader.getImage(ImageLoader.Image.BACKGROUND_CREATION));
    JLabel backgroundLabel =
        new JLabel(backgroundImage) {
          @Override
          protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            BufferedImage img = ImageLoader.getImage(ImageLoader.Image.BACKGROUND_CREATION);
            int newWidth = getWidth();
            int newHeight = getHeight();
            g.drawImage(img.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH), 0, 0, this);
          }
        };
    backgroundLabel.setLayout(new BorderLayout());

    JLabel infoText = new JLabel("Warten auf Spieler....");
    infoText.setFont(new Font("Arial", Font.ITALIC, 50));
    infoText.setForeground(Color.WHITE);
    infoText.setHorizontalAlignment(SwingConstants.CENTER);
    infoText.setVerticalAlignment(SwingConstants.CENTER);
    backgroundLabel.add(infoText, BorderLayout.CENTER);

    JButton quit =
        ButtonBuilder.createButton(
            "Zurück zum Hauptmenu",
            new Font("Arial", Font.BOLD, 20),
            Color.WHITE,
            Color.getHSBColor(0.33f, 0.8f, 0.5f),
            390,
            150,
            180,
            45);
    quit.setHorizontalAlignment(SwingConstants.CENTER);
    quit.setVerticalAlignment(SwingConstants.CENTER);
    quit.addMouseListener(ButtonLighter.buttonLight(quit));
    quit.addActionListener(e -> MainFrame.switchTo(MainFrame.PanelName.BUILD));
    backgroundLabel.add(quit, BorderLayout.SOUTH);

    this.setLayout(new BorderLayout());
    this.add(backgroundLabel, BorderLayout.CENTER);
  }

  @Override
  public void propertyChange(PropertyChangeEvent event) {
    SwingUtilities.invokeLater(
        new Runnable() {
          @Override
          public void run() {
            handleModelUpdate(event);
          }
        });
  }

  private void handleModelUpdate(PropertyChangeEvent event) {
    if (event.getPropertyName().equals("GameStartEvent")) {
      MainFrame.switchTo(MainFrame.PanelName.GAME);
    }
  }
}
