package de.lmu.ifi.cip.client.util;

import de.lmu.ifi.cip.client.view.PlayerButton;
import java.awt.Color;
import java.awt.Font;

/** Implements a builder for player buttons. */
public class PlayerButtonBuilder {
  /**
   * Creates Player Buttons.
   *
   * @param colorText is color for the text.
   * @param colorButton is color for the button.
   * @param xposition sets the xPosition in the Panel.
   * @param yposition sets the yPosition in the Panel.
   * @param width sets the width of the button.
   * @param height sets the height of the button.
   * @return PlayerButton with the set parameters.
   */
  public static PlayerButton createButton(
      Font font,
      Color colorText,
      Color colorButton,
      int xposition,
      int yposition,
      int width,
      int height) {
    PlayerButton button = new PlayerButton();
    button.setOpaque(true);
    button.setBorderPainted(false);
    button.setFont(font);
    button.setForeground(colorText);
    button.setBackground(colorButton);
    button.setBounds(xposition, yposition, width, height);
    return button;
  }
}
