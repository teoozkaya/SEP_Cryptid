package de.lmu.ifi.cip.client.util;

import java.awt.Color;
import java.util.Map;

/** Creates a Map of all colors the players of the gam can have and binds them to a key word. */
public class ColorMapper {
  private static final Map<String, Color> colours =
      Map.of(
          "red",
          new Color(227, 0, 0),
          "blue",
          new Color(0, 0, 234),
          "orange",
          new Color(218, 141, 0),
          "black",
          new Color(0, 0, 0),
          "turquoise",
          new Color(64, 224, 208));

  public static Color getColor(String key) {
    Color color = colours.get(key);
    return color;
  }
}
