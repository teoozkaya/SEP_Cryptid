package de.lmu.ifi.cip.client.panels;

import de.lmu.ifi.cip.client.ImageLoader;
import de.lmu.ifi.cip.client.MainFrame;
import de.lmu.ifi.cip.client.controller.GameController;
import de.lmu.ifi.cip.client.util.ButtonBuilder;
import de.lmu.ifi.cip.client.util.ButtonLighter;
import de.lmu.ifi.cip.client.util.ColorMapper;
import de.lmu.ifi.cip.client.util.PlayerButtonBuilder;
import de.lmu.ifi.cip.client.view.PlayerButton;
import de.lmu.ifi.cip.model.board.Cell;
import de.lmu.ifi.cip.model.events.GameStartEvent;
import de.lmu.ifi.cip.model.events.HintEvent;
import de.lmu.ifi.cip.model.events.ItemPlacedEvent;
import de.lmu.ifi.cip.model.events.PlayerChangeAnswerEvent;
import de.lmu.ifi.cip.model.events.PlayerChangeEvent;
import de.lmu.ifi.cip.model.events.PlayerChangeReactionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;

/** Creates a Panel for the creation screen of the game. */
public class GamePanel extends JPanel implements PropertyChangeListener {

  private MapPanel map;
  private JToggleButton hintButton;
  private JLabel gameInfo;
  private JButton searchButton;
  private JButton askButton;
  private JButton placeDiskButton;
  private JButton placeCubeButton;
  private JButton gameRestartButton;
  private JButton gameAbortButton;
  private JPanel sideControls;

  private PlayerButton playerOneButton;
  private PlayerButton playerTwoButton;
  private PlayerButton playerThreeButton;
  private PlayerButton playerFourButton;
  private PlayerButton playerFiveButton;

  private String hintText;
  GameController controller;

  private GridBagConstraints gbcPlaceCube;

  private GridBagConstraints gbcPlaceDiskButton;

  private GridBagConstraints gbcAskButton;

  private GridBagConstraints gbcSearchButton;

  private JLabel backgroundCreation;

  /**
   * Constructor for the BuildPanel that instantiates the class.
   *
   * @param controller the Controller for the Game. The controller can be a singleplayer or
   *     multiplayer controller.
   */
  public GamePanel(GameController controller) {

    this.controller = controller;
    setLayout(new GridBagLayout());
    ImageIcon backgroundImage =
        new ImageIcon(ImageLoader.getImage(ImageLoader.Image.BACKGROUND_GAMEPANEL));
    backgroundCreation =
        new JLabel(backgroundImage) {
          @Override
          protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            BufferedImage img = ImageLoader.getImage(ImageLoader.Image.BACKGROUND_GAMEPANEL);
            int newWidth = getWidth();
            int newHeight = getHeight();
            g.drawImage(img.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH), 0, 0, this);
          }
        };
    backgroundCreation.setLayout(new GridBagLayout());
    backgroundCreation.setPreferredSize(this.getPreferredSize());

    GridBagConstraints gbcMap = new GridBagConstraints();
    gbcMap.fill = GridBagConstraints.BOTH;
    gbcMap.weightx = 1.0;
    gbcMap.weighty = 1.0;
    gbcMap.gridx = 0;
    gbcMap.gridy = 0;
    gbcMap.ipadx = 650;
    gbcMap.ipady = 400;
    gbcMap.anchor = GridBagConstraints.CENTER;
    backgroundCreation.add(createMapPanel(), gbcMap);

    GridBagConstraints gbcLowerPanel = new GridBagConstraints();
    gbcLowerPanel.weighty = 0.1;
    gbcLowerPanel.gridx = 0;
    gbcLowerPanel.gridy = 1;
    backgroundCreation.add(createLowerPanel(), gbcLowerPanel);

    GridBagConstraints gbcSidePanel = new GridBagConstraints();
    gbcSidePanel.weighty = 1.0;
    gbcSidePanel.gridheight = 2;
    gbcSidePanel.gridx = 1;
    gbcSidePanel.gridy = 0;
    gbcSidePanel.fill = GridBagConstraints.BOTH;
    gbcSidePanel.anchor = GridBagConstraints.FIRST_LINE_END;
    backgroundCreation.add(createSidepanel(), gbcSidePanel);
    GridBagConstraints g = new GridBagConstraints();
    g.gridx = 0;
    g.gridy = 0;
    g.weightx = 1;
    g.weighty = 1;
    g.fill = GridBagConstraints.BOTH;
    add(backgroundCreation, g);
  }

  private MapPanel createMapPanel() {
    map = new MapPanel(null, controller);
    map.setBackground(new Color(153, 76, 0));
    map.setBounds(0, 0, 650, 400);
    map.setOpaque(false);
    return map;
  }

  private JPanel createLowerPanel() {

    JPanel lowerControls = new JPanel();
    lowerControls.setLayout(new GridBagLayout());
    lowerControls.setOpaque(false);

    hintButton = new JToggleButton();
    hintButton.setBounds(50, 65, 550, 30);
    hintButton.addItemListener(
        new ItemListener() {
          @Override
          public void itemStateChanged(ItemEvent e) {
            if (hintButton.isSelected()) {
              hintButton.setText(hintText);
            } else {
              hintButton.setText(null);
            }
          }
        });
    GridBagConstraints gbcHintButton = new GridBagConstraints();
    gbcHintButton.gridx = 0;
    gbcHintButton.gridy = 1;
    gbcHintButton.anchor = GridBagConstraints.LINE_START;
    gbcHintButton.ipadx = 275;
    gbcHintButton.ipady = 15;
    gbcHintButton.insets = new Insets(20, 0, 0, 0);
    gbcHintButton.fill = GridBagConstraints.HORIZONTAL;
    lowerControls.add(hintButton, gbcHintButton);

    gameInfo = new JLabel();
    gameInfo.setHorizontalAlignment(JLabel.CENTER);
    gameInfo.setVerticalAlignment(JLabel.CENTER);
    gameInfo.setBackground(new Color(0, 0, 0, 0));
    GridBagConstraints gbcGameInfo = new GridBagConstraints();
    gbcGameInfo.gridx = 0;
    gbcGameInfo.gridy = 0;
    gbcGameInfo.weightx = 1.0;
    gbcGameInfo.anchor = GridBagConstraints.CENTER;
    gbcGameInfo.ipadx = 275;
    gbcGameInfo.ipady = 20;
    gbcGameInfo.insets = new Insets(0, 0, 20, 0);
    gbcHintButton.fill = GridBagConstraints.HORIZONTAL;
    lowerControls.add(gameInfo, gbcGameInfo);

    return lowerControls;
  }

  private JPanel createSidepanel() {

    sideControls = new JPanel();
    sideControls.setLayout(new GridBagLayout());
    sideControls.setOpaque(false);

    searchButton =
        ButtonBuilder.createButton(
            "Feld durchsuchen",
            new Font("Arial", Font.BOLD, 15),
            Color.WHITE,
            Color.getHSBColor(0.33f, 0.8f, 0.5f),
            80,
            210,
            180,
            40);
    searchButton.addActionListener(e -> controller.searchField());
    gbcSearchButton = new GridBagConstraints();
    gbcSearchButton.gridx = 0;
    gbcSearchButton.gridy = 3;
    gbcSearchButton.gridwidth = 2;
    gbcSearchButton.ipadx = 90;
    gbcSearchButton.ipady = 20;
    gbcSearchButton.weighty = 1.0;
    gbcSearchButton.weightx = 1.0;
    gbcSearchButton.anchor = GridBagConstraints.CENTER;
    searchButton.addMouseListener(ButtonLighter.buttonLight(searchButton));

    askButton =
        ButtonBuilder.createButton(
            "Feld befragen",
            new Font("Arial", Font.BOLD, 15),
            Color.WHITE,
            Color.getHSBColor(0.33f, 0.8f, 0.5f),
            80,
            270,
            180,
            40);
    askButton.addActionListener(e -> controller.askField());
    gbcAskButton = new GridBagConstraints();
    gbcAskButton.gridx = 0;
    gbcAskButton.gridy = 2;
    gbcAskButton.gridwidth = 2;
    gbcAskButton.ipadx = 117;
    gbcAskButton.ipady = 20;
    gbcAskButton.weighty = 1.0;
    gbcAskButton.weightx = 1.0;
    gbcAskButton.anchor = GridBagConstraints.CENTER;
    askButton.addMouseListener(ButtonLighter.buttonLight(askButton));

    placeDiskButton =
        ButtonBuilder.createButton(
            "Scheibe platzieren",
            new Font("Arial", Font.BOLD, 15),
            Color.WHITE,
            Color.getHSBColor(0.33f, 0.8f, 0.5f),
            80,
            210,
            180,
            40);
    placeDiskButton.addActionListener(e -> controller.placeDisk());
    gbcPlaceDiskButton = new GridBagConstraints();
    gbcPlaceDiskButton.gridx = 0;
    gbcPlaceDiskButton.gridy = 2;
    gbcPlaceDiskButton.gridwidth = 2;
    gbcPlaceDiskButton.ipadx = 90;
    gbcPlaceDiskButton.ipady = 20;
    gbcPlaceDiskButton.weighty = 1.0;
    gbcPlaceDiskButton.weightx = 1.0;
    gbcPlaceDiskButton.anchor = GridBagConstraints.CENTER;
    placeDiskButton.addMouseListener(ButtonLighter.buttonLight(placeDiskButton));

    placeCubeButton =
        ButtonBuilder.createButton(
            "Würfel platzieren",
            new Font("Arial", Font.BOLD, 15),
            Color.WHITE,
            Color.getHSBColor(0.33f, 0.8f, 0.5f),
            80,
            270,
            180,
            40);
    placeCubeButton.addActionListener(e -> controller.placeCube());
    gbcPlaceCube = new GridBagConstraints();
    gbcPlaceCube.gridx = 0;
    gbcPlaceCube.gridy = 3;
    gbcPlaceCube.gridwidth = 2;
    gbcPlaceCube.ipadx = 90;
    gbcPlaceCube.ipady = 20;
    gbcPlaceCube.weighty = 1.0;
    gbcPlaceCube.weightx = 1.0;
    gbcPlaceCube.anchor = GridBagConstraints.CENTER;
    sideControls.add(placeCubeButton, gbcPlaceCube);
    placeCubeButton.addMouseListener(ButtonLighter.buttonLight(placeCubeButton));

    gameRestartButton =
        ButtonBuilder.createButton(
            "Spiel Neustarten",
            new Font("Arial", Font.BOLD, 15),
            Color.WHITE,
            Color.getHSBColor(0.33f, 0.8f, 0.5f),
            80,
            400,
            180,
            40);
    gameRestartButton.addActionListener(e -> controller.restartGame());
    GridBagConstraints gbcRestartGame = new GridBagConstraints();
    gbcRestartGame.gridx = 0;
    gbcRestartGame.gridy = 5;
    gbcRestartGame.gridwidth = 2;
    gbcRestartGame.ipadx = 90;
    gbcRestartGame.ipady = 20;
    gbcRestartGame.weightx = 1.0;
    gbcRestartGame.weighty = 1.0;
    gbcRestartGame.anchor = GridBagConstraints.CENTER;
    gbcRestartGame.insets = new Insets(0, 0, 10, 0);
    sideControls.add(gameRestartButton, gbcRestartGame);
    gameRestartButton.addMouseListener(ButtonLighter.buttonLight(gameRestartButton));

    gameAbortButton =
        ButtonBuilder.createButton(
            "Spiel Abbrechen",
            new Font("Arial", Font.BOLD, 15),
            Color.WHITE,
            Color.getHSBColor(0.33f, 0.8f, 0.5f),
            80,
            460,
            180,
            40);
    gameAbortButton.addActionListener(e -> controller.abortGame());
    GridBagConstraints gbcAbortGame = new GridBagConstraints();
    gbcAbortGame.gridx = 0;
    gbcAbortGame.gridy = 5;
    gbcAbortGame.gridwidth = 2;
    gbcAbortGame.ipadx = 90;
    gbcAbortGame.ipady = 20;
    gbcAbortGame.weighty = 1.0;
    gbcAbortGame.anchor = GridBagConstraints.CENTER;
    gbcAbortGame.insets = new Insets(110, 0, 0, 0);
    sideControls.add(gameAbortButton, gbcAbortGame);
    gameAbortButton.addMouseListener(ButtonLighter.buttonLight(gameAbortButton));

    playerOneButton =
        PlayerButtonBuilder.createButton(
            new Font("Arial", Font.BOLD, 15), Color.WHITE, new Color(112, 70, 0), 30, 30, 100, 40);
    playerOneButton.addActionListener(
        e -> controller.setSelectedPlayer(playerOneButton.getPlayerId()));
    GridBagConstraints gbcPlayerOne = new GridBagConstraints();
    gbcPlayerOne.gridx = 0;
    gbcPlayerOne.gridy = 0;
    gbcPlayerOne.ipadx = 50;
    gbcPlayerOne.ipady = 20;
    gbcPlayerOne.weighty = 1.0;
    gbcPlayerOne.anchor = GridBagConstraints.PAGE_START;
    gbcPlayerOne.insets = new Insets(10, 0, 10, 10);

    sideControls.add(playerOneButton, gbcPlayerOne);
    playerTwoButton =
        PlayerButtonBuilder.createButton(
            new Font("Arial", Font.BOLD, 15), Color.WHITE, new Color(112, 70, 0), 150, 30, 100, 40);
    playerTwoButton.addActionListener(
        e -> controller.setSelectedPlayer(playerTwoButton.getPlayerId()));
    GridBagConstraints gbcPlayerTwo = new GridBagConstraints();
    gbcPlayerTwo.gridx = 1;
    gbcPlayerTwo.gridy = 0;
    gbcPlayerTwo.ipadx = 50;
    gbcPlayerTwo.ipady = 20;
    gbcPlayerTwo.weighty = 1.0;
    gbcPlayerTwo.anchor = GridBagConstraints.PAGE_START;
    gbcPlayerTwo.insets = new Insets(10, 0, 10, 10);
    sideControls.add(playerTwoButton, gbcPlayerTwo);
    playerThreeButton =
        PlayerButtonBuilder.createButton(
            new Font("Arial", Font.BOLD, 15), Color.WHITE, new Color(112, 70, 0), 30, 90, 100, 40);
    playerThreeButton.addActionListener(
        e -> controller.setSelectedPlayer(playerThreeButton.getPlayerId()));
    GridBagConstraints gbcPlayerThree = new GridBagConstraints();
    gbcPlayerThree.gridx = 0;
    gbcPlayerThree.gridy = 0;
    gbcPlayerThree.ipadx = 50;
    gbcPlayerThree.ipady = 20;
    gbcPlayerThree.weighty = 1.0;
    gbcPlayerThree.anchor = GridBagConstraints.PAGE_START;
    gbcPlayerThree.insets = new Insets(70, 0, 10, 10);
    sideControls.add(playerThreeButton, gbcPlayerThree);
    return sideControls;
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

    Object newValue = event.getNewValue();
    if (event.getPropertyName().equals("ItemPlacedEvent")) {
      ItemPlacedEvent itemPlacedEvent = (ItemPlacedEvent) newValue;

      Cell c = itemPlacedEvent.getCell();
      map.setSelectCell(c);

      map.setCellList(itemPlacedEvent.getCellList());
      map.removeAll();
      map.revalidate();
      map.repaint();
    }
    if (event.getPropertyName().equals("GameStartEvent")) {

      map.setSelectCell(null);

      GameStartEvent gameStartEvent = (GameStartEvent) newValue;
      if (gameStartEvent.getPlayerNumber() > 3) {
        playerFourButton =
            PlayerButtonBuilder.createButton(
                new Font("Arial", Font.BOLD, 15),
                Color.WHITE,
                new Color(112, 70, 0),
                30,
                30,
                100,
                40);
        playerFourButton.setText(gameStartEvent.getUserList().get(3).getName());
        playerFourButton.setPlayerId(gameStartEvent.getUserList().get(3).getPlayerId());
        playerFourButton.addActionListener(
            e -> controller.setSelectedPlayer(playerFourButton.getText()));
        GridBagConstraints gbcPlayerFour = new GridBagConstraints();
        gbcPlayerFour.gridx = 1;
        gbcPlayerFour.gridy = 0;
        gbcPlayerFour.ipadx = 50;
        gbcPlayerFour.ipady = 20;
        gbcPlayerFour.weighty = 1.0;
        gbcPlayerFour.anchor = GridBagConstraints.PAGE_START;
        gbcPlayerFour.insets = new Insets(70, 0, 10, 10);

        sideControls.add(playerFourButton, gbcPlayerFour);

        if (gameStartEvent.getPlayerNumber() > 4) {

          playerFiveButton =
              PlayerButtonBuilder.createButton(
                  new Font("Arial", Font.BOLD, 15),
                  Color.WHITE,
                  new Color(112, 70, 0),
                  30,
                  30,
                  100,
                  40);
          playerFiveButton.setText(gameStartEvent.getUserList().get(4).getName());
          playerFiveButton.setPlayerId(gameStartEvent.getUserList().get(4).getPlayerId());
          playerFiveButton.addActionListener(
              e -> controller.setSelectedPlayer(playerFiveButton.getText()));
          GridBagConstraints gbcPlayerFive = new GridBagConstraints();
          gbcPlayerFive.gridx = 0;
          gbcPlayerFive.gridy = 0;
          gbcPlayerFive.ipadx = 50;
          gbcPlayerFive.ipady = 20;
          gbcPlayerFive.weighty = 1.0;
          gbcPlayerFive.anchor = GridBagConstraints.PAGE_START;
          gbcPlayerFive.insets = new Insets(130, 0, 10, 10);
          sideControls.add(playerFiveButton, gbcPlayerFive);
        }
      }
      gameInfo.setText(null);
      map.setCellList(gameStartEvent.getCellList());
      map.removeAll();
      map.revalidate();
      map.repaint();
      playerOneButton.setText(gameStartEvent.getUserList().get(0).getName());
      playerOneButton.setBackground(
          ColorMapper.getColor(gameStartEvent.getUserList().get(0).getPlayerColour()));
      playerOneButton.setPlayerId(gameStartEvent.getUserList().get(0).getPlayerId());
      playerTwoButton.setText(gameStartEvent.getUserList().get(1).getName());
      playerTwoButton.setBackground(
          ColorMapper.getColor(gameStartEvent.getUserList().get(1).getPlayerColour()));
      playerTwoButton.setPlayerId(gameStartEvent.getUserList().get(1).getPlayerId());
      playerThreeButton.setText(gameStartEvent.getUserList().get(2).getName());
      playerThreeButton.setBackground(
          ColorMapper.getColor(gameStartEvent.getUserList().get(2).getPlayerColour()));
      playerThreeButton.setPlayerId(gameStartEvent.getUserList().get(2).getPlayerId());
      if (gameStartEvent.getPlayerNumber() > 3) {
        playerFourButton.setText(gameStartEvent.getUserList().get(3).getName());
        playerFourButton.setBackground(
            ColorMapper.getColor(gameStartEvent.getUserList().get(3).getPlayerColour()));
      }
      if (gameStartEvent.getPlayerNumber() > 4) {
        playerFiveButton.setText(gameStartEvent.getUserList().get(4).getName());
        playerFiveButton.setBackground(
            ColorMapper.getColor(gameStartEvent.getUserList().get(4).getPlayerColour()));
      }
      controller.setUserList(gameStartEvent.getUserList());
      controller.setActivePlayer(gameStartEvent.getUserList().get(0));
      sideControls.remove(placeDiskButton);
      sideControls.remove(askButton);
      sideControls.remove(searchButton);
      sideControls.remove(placeCubeButton);
      sideControls.repaint();
      sideControls.add(placeCubeButton, gbcPlaceCube);
      hintText = gameStartEvent.getUserList().get(0).getHint();
    }
    if (event.getPropertyName().equals("PlayerChangeAnswerEvent")) {

      hintButton.setSelected(false);
      sideControls.remove(placeDiskButton);
      sideControls.remove(askButton);
      sideControls.remove(searchButton);
      sideControls.remove(placeCubeButton);
      sideControls.repaint();
      PlayerChangeAnswerEvent playerChangeAnswerEvent = (PlayerChangeAnswerEvent) newValue;
      controller.setActivePlayer(playerChangeAnswerEvent.getPlayer());
      sideControls.add(placeCubeButton, gbcPlaceCube);
      sideControls.add(placeDiskButton, gbcPlaceDiskButton);
      gameInfo.setFont(new Font("Arial", Font.PLAIN, 30));
      gameInfo.setForeground(Color.WHITE);
      gameInfo.setText(playerChangeAnswerEvent.getPlayer().getName() + " ist an der Reihe");
      Cell c = playerChangeAnswerEvent.getCell();
      map.setSelectCell(c);
      map.repaint();
    }
    if (event.getPropertyName().equals("PlayerChangeEvent")) {

      hintButton.setSelected(false);
      sideControls.remove(placeDiskButton);
      sideControls.remove(askButton);
      sideControls.remove(searchButton);
      sideControls.remove(placeCubeButton);
      sideControls.repaint();
      PlayerChangeEvent playerChangeEvent = (PlayerChangeEvent) newValue;
      controller.setActivePlayer(playerChangeEvent.getPlayer());
      sideControls.add(askButton, gbcAskButton);
      sideControls.add(searchButton, gbcSearchButton);
      gameInfo.setFont(new Font("Arial", Font.PLAIN, 30));
      gameInfo.setForeground(Color.WHITE);
      gameInfo.setText(playerChangeEvent.getPlayer().getName() + " ist an der Reihe");
      Cell c = playerChangeEvent.getCell();
      map.setSelectCell(c);
      map.repaint();
    }
    if (event.getPropertyName().equals("PlayerChangeReactionEvent")) {

      hintButton.setSelected(false);
      sideControls.remove(placeDiskButton);
      sideControls.remove(askButton);
      sideControls.remove(searchButton);
      sideControls.remove(placeCubeButton);
      sideControls.repaint();
      PlayerChangeReactionEvent playerChangeReactionEvent = (PlayerChangeReactionEvent) newValue;
      controller.setActivePlayer(playerChangeReactionEvent.getPlayer());
      sideControls.add(placeCubeButton, gbcPlaceCube);
      gameInfo.setFont(new Font("Arial", Font.PLAIN, 30));
      gameInfo.setForeground(Color.WHITE);
      gameInfo.setText(playerChangeReactionEvent.getPlayer().getName() + " ist an der Reihe");
      Cell c = playerChangeReactionEvent.getCell();
      map.setSelectCell(c);
      map.repaint();
    }
    if (event.getPropertyName().equals("GameForfeitEvent")) {
      gameInfo.setFont(new Font("Arial", Font.PLAIN, 30));
      gameInfo.setForeground(Color.WHITE);
      gameInfo.setText("Ein Spieler hat aufgegeben");
      MainFrame.switchTo(MainFrame.PanelName.BUILD);
    }
    if (event.getPropertyName().equals("GameLoseEvent")) {
      gameInfo.setFont(new Font("Arial", Font.PLAIN, 30));
      gameInfo.setForeground(Color.WHITE);
      gameInfo.setText("Du hast verloren");
    }
    if (event.getPropertyName().equals("GameWonEvent")) {
      gameInfo.setFont(new Font("Arial", Font.PLAIN, 30));
      gameInfo.setForeground(Color.WHITE);
      gameInfo.setText("Du hast gewonnen");
    }
    if (event.getPropertyName().equals("HintEvent")) {
      HintEvent hintEvent = (HintEvent) newValue;
      hintText = hintEvent.getHint();
    }
    if (event.getPropertyName().equals("WrongMoveEvent")) {
      gameInfo.setFont(new Font("Arial", Font.PLAIN, 18));
      gameInfo.setForeground(Color.WHITE);
      gameInfo.setText(
          "Diese Interaktion ist nicht erlaubt. Bitte wähle eine andere Interaktion aus");
    }
  }
}
