package de.lmu.ifi.cip.client.util;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

/** Creates a Builder for JLabel. */
public class LabelBuilder {

  /**
   * Method to build a JLabel.
   *
   * @param text for the label.
   * @param font for the label.
   * @param color for the text of the label.
   * @param xposition of the label in the panel.
   * @param yposition of the label in the panel.
   * @param width of the label.
   * @param height of the label.
   * @return JLabel
   */
  public static JLabel buildLabel(
      String text, Font font, Color color, int xposition, int yposition, int width, int height) {
    JLabel label = new JLabel();
    label.setText(text);
    label.setFont(font);
    label.setForeground(color);
    label.setBounds(xposition, yposition, width, height);
    return label;
  }
}
