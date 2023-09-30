package de.lmu.ifi.cip.client.panels;

import de.lmu.ifi.cip.client.ImageLoader;
import de.lmu.ifi.cip.client.MainFrame;
import de.lmu.ifi.cip.client.controller.GameController;
import de.lmu.ifi.cip.client.controller.MultiplayerController;
import de.lmu.ifi.cip.client.controller.SinglePlayerController;
import de.lmu.ifi.cip.client.util.ButtonBuilder;
import de.lmu.ifi.cip.client.util.ButtonLighter;
import de.lmu.ifi.cip.client.util.LabelBuilder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIDefaults;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/** Creates a Panel for the creation screen of the game. */
public class CreationPanel extends JPanel {
  private final GameController controller;
  private JSlider modeSlider;
  private JSlider numberSlider;
  private JLabel backgroundCreation;
  private ArrayList<JTextField> textFieldList;

  /**
   * Constructor for the BuildPanel that instantiates the class.
   *
   * @param controller the Controller for the Game. The controller can be a singleplayer or
   *     multiplayer controller.
   */
  public CreationPanel(GameController controller) {
    this.controller = controller;
    setOpaque(false);
    setLayout(new GridBagLayout());

    ImageIcon backgroundImage =
        new ImageIcon(ImageLoader.getImage(ImageLoader.Image.BACKGROUND_CREATION));
    backgroundCreation =
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
    backgroundCreation.setLayout(new GridBagLayout());
    backgroundCreation.setPreferredSize(this.getPreferredSize());

    GridBagConstraints gbcBackground = new GridBagConstraints();
    gbcBackground.gridx = 0;
    gbcBackground.gridy = 0;
    gbcBackground.gridwidth = GridBagConstraints.REMAINDER;
    gbcBackground.gridheight = GridBagConstraints.REMAINDER;
    gbcBackground.weightx = 1.0;
    gbcBackground.weighty = 1.0;
    gbcBackground.fill = GridBagConstraints.BOTH;

    GridBagConstraints gbcCreationTitle = new GridBagConstraints();
    gbcCreationTitle.gridx = 0;
    gbcCreationTitle.gridy = 1;
    gbcCreationTitle.weightx = 1;
    gbcCreationTitle.weighty = 1;
    gbcCreationTitle.gridwidth = 3;
    JLabel creationTitle =
        LabelBuilder.buildLabel(
            "Spielerstellung",
            new Font("Arial", Font.BOLD, 30),
            new Color(255, 190, 0),
            415,
            45,
            300,
            45);
    backgroundCreation.add(creationTitle, gbcCreationTitle);

    createLabels();
    createButtons();
    createSlider();
    createTextField();
    add(backgroundCreation);
    add(backgroundCreation, gbcBackground);
  }

  /** This Method creates all Labels for the creation panel. */
  private void createLabels() {
    GridBagConstraints gbcModeTitle = new GridBagConstraints();
    gbcModeTitle.gridx = 0;
    gbcModeTitle.gridy = 2;
    gbcModeTitle.gridwidth = 1;
    gbcModeTitle.anchor = GridBagConstraints.CENTER;
    gbcModeTitle.weightx = 1;
    gbcModeTitle.weighty = 1;
    JLabel modeTitle =
        LabelBuilder.buildLabel(
            "Spielmodus",
            new Font("Arial", Font.BOLD, 25),
            new Color(255, 190, 0),
            100,
            100,
            300,
            45);
    backgroundCreation.add(modeTitle, gbcModeTitle);

    GridBagConstraints gbcPnumbertitle = new GridBagConstraints();
    gbcPnumbertitle.gridx = 0;
    gbcPnumbertitle.gridy = 3;
    gbcPnumbertitle.weightx = 1;
    gbcPnumbertitle.weighty = 1;
    JLabel playerNumberTitle =
        LabelBuilder.buildLabel(
            "Anzahl Spieler",
            new Font("Arial", Font.BOLD, 25),
            new Color(255, 190, 0),
            100,
            250,
            300,
            45);
    backgroundCreation.add(playerNumberTitle, gbcPnumbertitle);
  }

  /** This method creates all buttons for the creation panel. */
  private void createButtons() {
    JButton backToMenu =
        ButtonBuilder.createButton(
            "Zurück zum Hauptmenü",
            new Font("Arial", Font.BOLD, 20),
            Color.WHITE,
            Color.getHSBColor(0.33f, 0.8f, 0.5f),
            550,
            400,
            250,
            45);
    backToMenu.addMouseListener(ButtonLighter.buttonLight(backToMenu));
    backToMenu.addActionListener(e -> MainFrame.switchTo(MainFrame.PanelName.BUILD));
    GridBagConstraints gbcBack = new GridBagConstraints();
    gbcBack.gridx = 1;
    gbcBack.gridy = 5;
    gbcBack.anchor = GridBagConstraints.CENTER;
    gbcBack.insets.right = 20;
    gbcBack.ipadx = 125;
    gbcBack.ipady = 23;
    gbcBack.fill = GridBagConstraints.RELATIVE;

    gbcBack.weightx = 0.25;
    gbcBack.weighty = 0.25;

    backgroundCreation.add(backToMenu, gbcBack);

    JButton startGame =
        ButtonBuilder.createButton(
            "Spiel starten",
            new Font("Arial", Font.BOLD, 20),
            Color.WHITE,
            Color.getHSBColor(0.33f, 0.8f, 0.5f),
            250,
            400,
            130,
            45);
    startGame.addMouseListener(ButtonLighter.buttonLight(startGame));
    startGame.addActionListener(
        e ->
            controller.startGame(
                modeSlider.getValue(), numberSlider.getValue(), createNicknameList()));

    GridBagConstraints gbcStart = new GridBagConstraints();
    gbcStart.gridx = 0;
    gbcStart.gridy = 5;
    gbcStart.gridwidth = 1;
    gbcStart.anchor = GridBagConstraints.CENTER;
    gbcStart.insets.right = 0;
    gbcStart.ipadx = 65;
    gbcStart.ipady = 23;
    gbcStart.weightx = 1;
    gbcStart.weighty = 1;
    backgroundCreation.add(startGame, gbcStart);
  }

  /** This method creates all slider for the creation panel. */
  private void createSlider() {
    modeSlider = new JSlider();
    modeSlider.setSnapToTicks(true);
    modeSlider.setOrientation(SwingConstants.HORIZONTAL);
    modeSlider.setMaximum(1);
    modeSlider.setMajorTickSpacing(1);
    modeSlider.setPaintTicks(true);
    modeSlider.setOpaque(false);
    UIDefaults dict = new UIDefaults();
    dict.put(0, new JLabel("normaler Modus"));
    dict.put(1, new JLabel("fortgeschrittener Modus"));
    modeSlider.setLabelTable(dict);
    modeSlider.setPaintLabels(true);
    GridBagConstraints gbcModeSlider = new GridBagConstraints();
    gbcModeSlider.gridx = 1;
    gbcModeSlider.gridy = 2;
    gbcModeSlider.ipadx = 200;
    gbcModeSlider.insets.top = 5;
    gbcModeSlider.insets.right = 20;
    gbcModeSlider.anchor = GridBagConstraints.LINE_START;
    gbcModeSlider.fill = GridBagConstraints.HORIZONTAL;
    gbcModeSlider.weightx = 1;
    gbcModeSlider.weighty = 1;
    backgroundCreation.add(modeSlider, gbcModeSlider);

    numberSlider = new JSlider();
    numberSlider.setSnapToTicks(true);
    numberSlider.setOrientation(SwingConstants.HORIZONTAL);
    numberSlider.setMinimum(3);
    numberSlider.setMaximum(5);
    numberSlider.setMajorTickSpacing(1);
    numberSlider.setPaintTicks(true);
    numberSlider.setPaintLabels(true);

    numberSlider.setValue(0);
    numberSlider.setOpaque(false);
    numberSlider.addChangeListener(
        new ChangeListener() {
          @Override
          public void stateChanged(ChangeEvent e) {
            createTextField();
            revalidate();
            repaint();
          }
        });
    GridBagConstraints gbcNumberSlider = new GridBagConstraints();
    gbcNumberSlider.gridx = 1;
    gbcNumberSlider.gridy = 3;
    gbcNumberSlider.insets.right = 20;
    gbcNumberSlider.anchor = GridBagConstraints.LINE_START;
    gbcNumberSlider.fill = GridBagConstraints.HORIZONTAL;
    gbcNumberSlider.weightx = 1;
    gbcNumberSlider.weighty = 1;

    backgroundCreation.add(numberSlider, gbcNumberSlider);
  }

  private void clearTextfields() {
    for (Component component : backgroundCreation.getComponents()) {
      if (component instanceof JTextField) {
        backgroundCreation.remove(component);
      }
    }
  }

  private void createTextField() {
    textFieldList = new ArrayList<>();
    if (controller instanceof MultiplayerController) {
      JTextField textField = new JTextField();
      textFieldList.add(textField);
      textField.setBounds(450, 250, 100, 30);
      GridBagConstraints gbcTextField = new GridBagConstraints();
      gbcTextField.gridx = 1;
      gbcTextField.gridy = 4;
      gbcTextField.ipadx = 50;
      gbcTextField.ipady = 15;
      gbcTextField.anchor = GridBagConstraints.CENTER;
      backgroundCreation.add(textField, gbcTextField);
    }
    if (controller instanceof SinglePlayerController) {
      clearTextfields();
      for (int i = 0; i < numberSlider.getValue(); i++) {
        GridBagConstraints gbcTextField = new GridBagConstraints();
        gbcTextField.gridx = 0;
        gbcTextField.gridy = 4;
        gbcTextField.gridwidth = 2;
        gbcTextField.ipadx = 150;
        gbcTextField.ipady = 10;
        gbcTextField.anchor = GridBagConstraints.CENTER;
        gbcTextField.weightx = 1.0;
        if (numberSlider.getValue() == 3) {
          switch (i) {
            case 0:
              gbcTextField.insets = new Insets(0, 0, 0, 400);
              break;
            case 1:
              gbcTextField.insets = new Insets(0, 0, 0, 0);
              break;
            case 2:
              gbcTextField.insets = new Insets(0, 400, 0, 0);
              break;
            default:
              continue;
          }
        }
        if (numberSlider.getValue() == 4) {

          switch (i) {
            case 0:
              gbcTextField.insets = new Insets(0, 0, 0, 700);
              break;
            case 1:
              gbcTextField.insets = new Insets(0, 0, 0, 225);
              break;
            case 2:
              gbcTextField.insets = new Insets(0, 225, 0, 0);
              break;
            case 3:
              gbcTextField.insets = new Insets(0, 700, 0, 0);
              break;
            default:
              continue;
          }
        }
        if (numberSlider.getValue() == 5) {
          switch (i) {
            case 0:
              gbcTextField.insets = new Insets(0, 0, 0, 800);
              break;
            case 1:
              gbcTextField.insets = new Insets(0, 0, 0, 400);
              break;
            case 2:
              gbcTextField.insets = new Insets(0, 0, 0, 0);
              break;
            case 3:
              gbcTextField.insets = new Insets(0, 400, 0, 0);
              break;
            case 4:
              gbcTextField.insets = new Insets(0, 800, 0, 0);
              break;
            default:
              continue;
          }
        }
        JTextField textField = new JTextField();
        backgroundCreation.add(textField, gbcTextField);
      }
    }
  }

  private ArrayList<String> createNicknameList() {
    ArrayList<String> nicknameList = new ArrayList<>();
    Component[] components = backgroundCreation.getComponents();
    for (Component component : components) {
      if (component instanceof JTextField) {
        nicknameList.add(((JTextField) component).getText());
      }
    }
    return nicknameList;
  }
}
