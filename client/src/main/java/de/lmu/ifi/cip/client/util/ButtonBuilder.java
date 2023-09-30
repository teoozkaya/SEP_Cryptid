package de.lmu.ifi.cip.client.util;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

/** Implements a builder for buttons. */
public class ButtonBuilder {

  /**
   * Creates Buttons.
   *
   * @param text for the button.
   * @param colorText is color for the text.
   * @param colorButton is color for the button.
   * @param xposition sets the xPosition in the Panel.
   * @param yposition sets the yPosition in the Panel.
   * @param width sets the width of the button.
   * @param height sets the height of the button.
   * @return JButton with the set parameters.
   */
  public static JButton createButton(
      String text,
      Font font,
      Color colorText,
      Color colorButton,
      int xposition,
      int yposition,
      int width,
      int height) {
    JButton button = new JButton();
    button.setOpaque(true);
    button.setBorderPainted(false);
    button.setText(text);
    button.setFont(font);
    button.setForeground(colorText);
    button.setBackground(colorButton);
    button.setBounds(xposition, yposition, width, height);
    return button;
  }
}
