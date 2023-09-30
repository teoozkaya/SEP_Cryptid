package de.lmu.ifi.cip.client;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.imageio.ImageIO;

/** This is a utility class that loads images from the resource folder. */
public class ImageLoader {

  /** Enums that symbolize a specific image and path. */
  public enum Image {
    DESERT,
    SWAMP,
    MOUNTAIN,
    WATER,
    FOREST,
    BACKGROUND_START,
    BACKGROUND_CREATION,
    BACKGROUND_GAMEPANEL,
    RULES_ONE,
    RULES_TWO,
    RULES_THREE,
    RULES_FOUR,
    RULES_FIVE,
    RULES_SIX,
    FLAG
  }

  private static final Map<Image, String> enumToPath =
      Map.ofEntries(
          Map.entry(Image.DESERT, "images/WüsteNew.png"),
          Map.entry(Image.SWAMP, "images/Sumpf.png"),
          Map.entry(Image.MOUNTAIN, "images/Berg.png"),
          Map.entry(Image.FOREST, "images/Wald.png"),
          Map.entry(Image.WATER, "images/Wasser.png"),
          Map.entry(Image.BACKGROUND_START, "images/background_image.png"),
          Map.entry(Image.BACKGROUND_CREATION, "images/Creation_Panel_Background.png"),
          Map.entry(Image.BACKGROUND_GAMEPANEL, "images/Gamepanel_Background_image.jpg"),
          Map.entry(Image.RULES_ONE, "images/rules/Gelandearten.png"),
          Map.entry(Image.RULES_TWO, "images/rules/Territories.png"),
          Map.entry(Image.RULES_THREE, "images/rules/Buildings.png"),
          Map.entry(Image.RULES_FOUR, "images/rules/Würfel_und_Scheibe.png"),
          Map.entry(Image.RULES_FIVE, "images/rules/Befragen.png"),
          Map.entry(Image.RULES_SIX, "images/rules/Durchsuchen.png"),
          Map.entry(Image.FLAG, "images/flag.png"));

  private static final Map<Image, BufferedImage> imageCache = new HashMap<>();

  /**
   * Loads and caches the given image behind the Image enum.
   *
   * @param image An enum that specifies, which image should be loaded.
   * @return the cached image.
   */
  public static BufferedImage getImage(Image image) {
    return imageCache.computeIfAbsent(image, ImageLoader::loadImage);
  }

  private static BufferedImage loadImage(Image image) {
    try {
      return ImageIO.read(
          Objects.requireNonNull(ClassLoader.getSystemResourceAsStream(enumToPath.get(image))));
    } catch (IOException e) {
      throw new RuntimeException(
          String.format("Could not find image with path %s", enumToPath.get(image)));
    }
  }
}
