package de.lmu.ifi.cip.client.panels;

import de.lmu.ifi.cip.client.ImageLoader;
import de.lmu.ifi.cip.client.MainFrame;
import de.lmu.ifi.cip.client.util.ButtonBuilder;
import de.lmu.ifi.cip.client.util.ButtonLighter;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/** Creates a Panel for the game rules screen of the game. */
public class RulesPanel extends JPanel {

  private final BufferedImage[] allRules = {
    (ImageLoader.getImage(ImageLoader.Image.RULES_ONE)),
    (ImageLoader.getImage(ImageLoader.Image.RULES_TWO)),
    (ImageLoader.getImage(ImageLoader.Image.RULES_THREE)),
    (ImageLoader.getImage(ImageLoader.Image.RULES_FOUR)),
    (ImageLoader.getImage(ImageLoader.Image.RULES_FIVE)),
    (ImageLoader.getImage(ImageLoader.Image.RULES_SIX))
  };

  private JLabel currentRuleLabel;
  private int currentPage;
  private JLabel backgroundLabel;
  private GridBagConstraints gbcCurrentRule;
  private JButton prevButton;
  private JButton nextButton;

  /** Constructor for the RulesPanel that instantiates the class. */
  public RulesPanel() {

    super();
    this.setOpaque(false);
    this.setLayout(new GridBagLayout());

    ImageIcon backgroundImage =
        new ImageIcon(ImageLoader.getImage(ImageLoader.Image.BACKGROUND_CREATION));

    backgroundLabel =
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

    currentPage = 0;

    currentRuleLabel = new JLabel(new ImageIcon(allRules[currentPage]));

    gbcCurrentRule = new GridBagConstraints();
    gbcCurrentRule.gridx = 0;
    gbcCurrentRule.gridy = 0;
    gbcCurrentRule.gridwidth = 3;
    gbcCurrentRule.weightx = 1.0;
    gbcCurrentRule.weighty = 1.0;
    gbcCurrentRule.anchor = GridBagConstraints.CENTER;
    gbcCurrentRule.fill = GridBagConstraints.BOTH;
    backgroundLabel.add(currentRuleLabel, gbcCurrentRule);

    JButton quitButton =
        ButtonBuilder.createButton(
            "Zurück zum Hauptmenu",
            new Font("Arial", Font.BOLD, 20),
            Color.WHITE,
            Color.getHSBColor(0.33f, 0.8f, 0.5f),
            390,
            150,
            180,
            45);
    quitButton.addMouseListener(ButtonLighter.buttonLight(quitButton));
    quitButton.addActionListener(e -> MainFrame.switchTo(MainFrame.PanelName.BUILD));
    GridBagConstraints gbcQuitButton = new GridBagConstraints();
    gbcQuitButton.gridx = 0;
    gbcQuitButton.gridy = 1;
    gbcQuitButton.weightx = 1.0;
    gbcQuitButton.weighty = 1.0;
    gbcQuitButton.anchor = GridBagConstraints.CENTER;
    backgroundLabel.add(quitButton, gbcQuitButton);

    nextButton =
        ButtonBuilder.createButton(
            "Nächste Seite",
            new Font("Arial", Font.BOLD, 20),
            Color.WHITE,
            Color.getHSBColor(0.33f, 0.8f, 0.5f),
            390,
            150,
            180,
            45);

    nextButton.addMouseListener(ButtonLighter.buttonLight(nextButton));
    nextButton.addActionListener(e -> nextButtonPressed());
    GridBagConstraints gbcNextButton = new GridBagConstraints();
    gbcNextButton.gridx = 2;
    gbcNextButton.gridy = 1;
    gbcNextButton.weightx = 1.0;
    gbcNextButton.weighty = 1.0;
    gbcNextButton.anchor = GridBagConstraints.CENTER;
    backgroundLabel.add(nextButton, gbcNextButton);

    prevButton =
        ButtonBuilder.createButton(
            "Vorherige Seite",
            new Font("Arial", Font.BOLD, 20),
            Color.WHITE,
            Color.getHSBColor(0.33f, 0.8f, 0.5f),
            390,
            150,
            180,
            45);
    prevButton.setEnabled(false);
    prevButton.addMouseListener(ButtonLighter.buttonLight(prevButton));
    prevButton.addActionListener(e -> prevButtonPressed());

    GridBagConstraints gbcPrevButton = new GridBagConstraints();
    gbcPrevButton.gridx = 1;
    gbcPrevButton.gridy = 1;
    gbcPrevButton.weightx = 1.0;
    gbcPrevButton.weighty = 1.0;
    gbcPrevButton.anchor = GridBagConstraints.CENTER;
    backgroundLabel.add(prevButton, gbcPrevButton);

    add(backgroundLabel, gbcBackground);
  }

  private void nextButtonPressed() {
    prevButton.setEnabled(true);
    currentPage = currentPage + 1;
    if (currentPage == 5) {
      nextButton.setEnabled(false);
    }
    currentRule(currentPage);
  }

  private void prevButtonPressed() {
    nextButton.setEnabled(true);
    currentPage = currentPage - 1;
    if (currentPage == 0) {
      prevButton.setEnabled(false);
    }
    currentRule(currentPage);
  }

  private void currentRule(int i) {
    ImageIcon ruleImage = new ImageIcon(allRules[i]);
    backgroundLabel.remove(currentRuleLabel);
    currentRuleLabel = new JLabel(ruleImage);

    backgroundLabel.add(currentRuleLabel, gbcCurrentRule);
    revalidate();
    repaint();
  }
}
