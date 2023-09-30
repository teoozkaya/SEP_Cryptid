package de.lmu.ifi.cip.client.panels;

import de.lmu.ifi.cip.client.ImageLoader;
import de.lmu.ifi.cip.client.MainFrame;
import de.lmu.ifi.cip.client.controller.MultiplayerController;
import de.lmu.ifi.cip.client.controller.SinglePlayerController;
import de.lmu.ifi.cip.client.util.ButtonBuilder;
import de.lmu.ifi.cip.client.util.ButtonLighter;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/** Creates a Panel for the start screen of the game. */
public class BuildPanel extends JPanel {
  private Image backgroundImage;

  /** Constructor for the BuildPanel that instantiates the class. */
  public BuildPanel() {
    super();
    this.setOpaque(false);
    this.setLayout(new GridBagLayout());

    ImageIcon backgroundImage =
        new ImageIcon(ImageLoader.getImage(ImageLoader.Image.BACKGROUND_START));
    JLabel backgroundLabel =
        new JLabel(backgroundImage) {
          @Override
          protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            BufferedImage img = ImageLoader.getImage(ImageLoader.Image.BACKGROUND_START);
            int newWidth = getWidth();
            int newHeight = getHeight();
            g.drawImage(img.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH), 0, 0, this);
          }
        };
    backgroundLabel.setLayout(new GridBagLayout());
    backgroundLabel.setPreferredSize(this.getPreferredSize());
    GridBagConstraints gbcBackground = new GridBagConstraints();
    gbcBackground.gridx = 0;
    gbcBackground.gridy = 0;
    gbcBackground.gridwidth = GridBagConstraints.REMAINDER;
    gbcBackground.gridheight = GridBagConstraints.REMAINDER;
    gbcBackground.weightx = 1.0;
    gbcBackground.weighty = 1.0;
    gbcBackground.fill = GridBagConstraints.BOTH;

    JButton singlePlayer =
        ButtonBuilder.createButton(
            "Hot-Seat-Modus",
            new Font("Arial", Font.BOLD, 20),
            Color.WHITE,
            Color.getHSBColor(0.33f, 0.8f, 0.5f),
            390,
            150,
            180,
            45);
    singlePlayer.addMouseListener(ButtonLighter.buttonLight(singlePlayer));
    singlePlayer.addActionListener(e -> new SinglePlayerController());
    GridBagConstraints gbcSinglePlayer = new GridBagConstraints();
    gbcSinglePlayer.gridx = 0;
    gbcSinglePlayer.gridy = 1;
    gbcSinglePlayer.weightx = 1.0;
    gbcSinglePlayer.weighty = 0.0;
    gbcSinglePlayer.ipadx = 90;
    gbcSinglePlayer.ipady = 23;
    gbcSinglePlayer.insets = new Insets(40, 0, 20, 0);
    gbcSinglePlayer.anchor = GridBagConstraints.CENTER;
    backgroundLabel.add(singlePlayer, gbcSinglePlayer);

    JButton multiPlayer =
        ButtonBuilder.createButton(
            "Multiplayer",
            new Font("Arial", Font.BOLD, 20),
            Color.WHITE,
            Color.getHSBColor(0.33f, 0.8f, 0.5f),
            390,
            250,
            180,
            45);
    multiPlayer.addMouseListener(ButtonLighter.buttonLight(multiPlayer));
    multiPlayer.addActionListener(e -> new MultiplayerController());
    GridBagConstraints gbcMultiPlayer = new GridBagConstraints();
    gbcMultiPlayer.gridx = 0;
    gbcMultiPlayer.gridy = 2;
    gbcMultiPlayer.weightx = 1.0;
    gbcMultiPlayer.weighty = 0.0;
    gbcMultiPlayer.ipadx = 90;
    gbcMultiPlayer.ipady = 23;
    gbcMultiPlayer.insets = new Insets(20, 0, 20, 0);
    gbcMultiPlayer.anchor = GridBagConstraints.CENTER;
    backgroundLabel.add(multiPlayer, gbcMultiPlayer);

    JButton quit =
        ButtonBuilder.createButton(
            "Spiel beenden",
            new Font("Arial", Font.BOLD, 20),
            Color.WHITE,
            Color.getHSBColor(0.33f, 0.8f, 0.5f),
            390,
            350,
            180,
            45);
    quit.addMouseListener(ButtonLighter.buttonLight(quit));
    quit.addActionListener(e -> MainFrame.getFrame().dispose());
    GridBagConstraints gbcQuit = new GridBagConstraints();
    gbcQuit.gridx = 0;
    gbcQuit.gridy = 3;
    gbcQuit.weightx = 1.0;
    gbcQuit.weighty = 0.0;
    gbcQuit.ipadx = 90;
    gbcQuit.ipady = 23;
    gbcQuit.insets = new Insets(20, 0, 40, 0);
    gbcQuit.anchor = GridBagConstraints.CENTER;
    backgroundLabel.add(quit, gbcQuit);

    JButton rules =
        ButtonBuilder.createButton(
            "Spielregeln",
            new Font("Arial", Font.BOLD, 20),
            Color.WHITE,
            Color.getHSBColor(0.33f, 0.8f, 0.5f),
            390,
            350,
            180,
            45);
    rules.addMouseListener(ButtonLighter.buttonLight(rules));
    rules.addActionListener(e -> rulesButtonPressed());
    GridBagConstraints gbcRules = new GridBagConstraints();
    gbcRules.gridx = 0;
    gbcRules.gridy = 4;
    gbcRules.weightx = 1.0;
    gbcRules.weighty = 0.0;
    gbcRules.ipadx = 90;
    gbcRules.ipady = 23;
    gbcRules.insets = new Insets(10, 0, 40, 0);
    gbcRules.anchor = GridBagConstraints.CENTER;
    backgroundLabel.add(rules, gbcRules);

    // To set the widths of the Buttons equal regardless of the text on the Button
    int buttonWidth =
        Math.max(
            singlePlayer.getPreferredSize().width,
            Math.max(multiPlayer.getPreferredSize().width, quit.getPreferredSize().width));
    singlePlayer.setPreferredSize(
        new Dimension(buttonWidth, singlePlayer.getPreferredSize().height));
    multiPlayer.setPreferredSize(new Dimension(buttonWidth, multiPlayer.getPreferredSize().height));
    quit.setPreferredSize(new Dimension(buttonWidth, quit.getPreferredSize().height));
    rules.setPreferredSize(new Dimension(buttonWidth, quit.getPreferredSize().height));

    this.add(backgroundLabel, gbcBackground);
  }

  private void rulesButtonPressed() {
    MainFrame.register(MainFrame.PanelName.RULES, new RulesPanel());
    MainFrame.switchTo(MainFrame.PanelName.RULES);
  }
}
