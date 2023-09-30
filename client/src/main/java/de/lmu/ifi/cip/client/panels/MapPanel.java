package de.lmu.ifi.cip.client.panels;

import static de.lmu.ifi.cip.model.board.Building.BuildingType.HUT;
import static de.lmu.ifi.cip.model.board.Building.BuildingType.STONE;

import de.lmu.ifi.cip.client.ImageLoader;
import de.lmu.ifi.cip.client.controller.GameController;
import de.lmu.ifi.cip.client.util.ColorMapper;
import de.lmu.ifi.cip.client.util.Hexagon;
import de.lmu.ifi.cip.client.view.TriangleHut;
import de.lmu.ifi.cip.model.board.Cell;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.TexturePaint;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JPanel;

/** Implements the Panel which contains the Game Map. */
public class MapPanel extends JPanel {

  private ArrayList<ArrayList<Cell>> cellList;

  private final ArrayList<Hexagon> hexagonList;

  private final BufferedImage desert;

  private final BufferedImage forest;

  private final BufferedImage mountain;

  private final BufferedImage water;

  private final BufferedImage swamp;

  private int radius;

  private Dimension size;

  private final BufferedImage flag;

  /** Constructor of the MapPanel, which sets the Position of the Hexagons contained in the map. */
  private GameController controller;

  private Cell selectCell = null;

  /** Constructor of the MapPanel, which sets the Position of the Hexagons contained in the map. */
  public MapPanel(ArrayList<ArrayList<Cell>> cellList, GameController controller) {
    this.cellList = cellList;
    this.controller = controller;

    desert = ImageLoader.getImage(ImageLoader.Image.DESERT);
    forest = ImageLoader.getImage(ImageLoader.Image.FOREST);
    mountain = ImageLoader.getImage(ImageLoader.Image.MOUNTAIN);
    water = ImageLoader.getImage(ImageLoader.Image.WATER);
    swamp = ImageLoader.getImage(ImageLoader.Image.SWAMP);
    flag = ImageLoader.getImage(ImageLoader.Image.FLAG);

    hexagonList = new ArrayList<>();
    double off = Math.sqrt(432);
    int offset = 21;
    int x;
    int y;
    for (int i = 0; i < 12; i++) {
      for (int n = 0; n < 9; n++) {
        x = 100 + (i * 36);
        if (i % 2 == 0) {
          y = (int) (35 + (n * off * 2));
        } else {
          y = (int) (35 + (n * off * 2) + off);
        }
        Point point = new Point(x, y);
        hexagonList.add(new Hexagon(point, 50, i, n));
      }
    }

    addMouseListener(
        new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            for (int i = 0; i < 108; i++) {
              if (hexagonList.get(i).contains(e.getPoint())
                  && e.getButton() == MouseEvent.BUTTON1) {
                controller.setSelectedField(
                    hexagonList.get(i).getIdX(), hexagonList.get(i).getIdY());
              }
            }
          }
        });

    addComponentListener(
        new ComponentAdapter() {
          public void componentResized(ComponentEvent e) {
            super.componentResized(e);
            resizeHexagons();
          }
        });
  }

  private void resizeHexagons() {
    size = getSize();
    int radius = (int) Math.floor(Math.min(size.getWidth() / 24, size.getHeight() / 18));
    int offsetY = getyDistance(radius);
    for (int column = 0; column < 12; column++) {
      int realoffsetY = offsetY * (column % 2);
      int offsetX = (int) (1.5 * radius * column);
      for (int row = 0; row < 9; row++) {
        Hexagon hexagon = hexagonList.get(column * 9 + row);
        hexagon.setCenter(new Point(offsetX + 150, offsetY * 2 * row + realoffsetY + 60));
        hexagon.setRadius(radius - 2);
      }
    }
    repaint();
  }

  private static int getyDistance(int radius) {
    return (int) Math.sqrt(Math.pow(radius, 2) - Math.pow(radius / 2, 2));
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    for (int i = 0; i < 108; i++) {
      if (cellList == null) {
        break;
      }
      Cell currentCell = cellList.get(hexagonList.get(i).getIdY()).get(hexagonList.get(i).getIdX());
      if (currentCell.getBiome() == Cell.BiomeType.SWAMP) {
        TexturePaint paint = new TexturePaint(swamp, hexagonList.get(i).getBounds());
        ((Graphics2D) g).setPaint(paint);
      }
      if (currentCell.getBiome() == Cell.BiomeType.DESERT) {

        TexturePaint paint = new TexturePaint(desert, hexagonList.get(i).getBounds());
        ((Graphics2D) g).setPaint(paint);
      }
      if (currentCell.getBiome() == Cell.BiomeType.WATER) {
        TexturePaint paint = new TexturePaint(water, hexagonList.get(i).getBounds());
        ((Graphics2D) g).setPaint(paint);
      }
      if (currentCell.getBiome() == Cell.BiomeType.FOREST) {
        TexturePaint paint = new TexturePaint(forest, hexagonList.get(i).getBounds());
        ((Graphics2D) g).setPaint(paint);
      }
      if (currentCell.getBiome() == Cell.BiomeType.MOUNTAIN) {
        TexturePaint paint = new TexturePaint(mountain, hexagonList.get(i).getBounds());
        ((Graphics2D) g).setPaint(paint);
      }
      g.fillPolygon(hexagonList.get(i));

      if (currentCell.getTerritory() == Cell.Territory.BEAR) {
        Graphics2D g2d = (Graphics2D) g;
        int lineWidth = 2;
        g2d.setStroke(new BasicStroke(lineWidth));
        g2d.setColor(new Color(255, 255, 255));
        g2d.drawPolygon(hexagonList.get(i));
        continue;
      }
      if (currentCell.getTerritory() == Cell.Territory.PUMA) {
        Graphics2D g2d = (Graphics2D) g;
        int lineWidth = 2;
        g2d.setStroke(new BasicStroke(lineWidth));
        g2d.setColor(new Color(255, 0, 0));
        g2d.drawPolygon(hexagonList.get(i));
        continue;
      }
      g.drawPolygon(hexagonList.get(i));
    }
    for (int i = 0; i < 108; i++) {
      if (cellList == null) {
        break;
      }

      Cell currentCell = cellList.get(hexagonList.get(i).getIdY()).get(hexagonList.get(i).getIdX());
      int placeableListSize = currentCell.getPlaceables().size();
      for (int e = 0; e < placeableListSize; e++) {
        int cubeOffsetX = 0;
        int cubeOffsetY = 0;
        if (currentCell.getPlaceables().get(e).isCube() && currentCell.getBuilding() != null) {
          int radius = (int) Math.min(size.getWidth() / 24, size.getHeight() / 18);
          if (currentCell.getBiome() == Cell.BiomeType.DESERT) {
            g.setColor(Color.black);
          } else {
            g.setColor(Color.white);
          }
          g.drawRect(
              (int) hexagonList.get(i).getCenter().getX() + (int) Math.floor(12 * radius * 0.04),
              (int) hexagonList.get(i).getCenter().getY() - (int) Math.floor(4 * radius * 0.04),
              (int) Math.ceil(radius * 0.2),
              (int) Math.ceil(radius * 0.2));
          g.setColor(
              ColorMapper.getColor(currentCell.getPlaceables().get(e).getUser().getPlayerColour()));
          g.fillRect(
              (int) hexagonList.get(i).getCenter().getX() + (int) Math.floor(12 * radius * 0.04),
              (int) hexagonList.get(i).getCenter().getY() - (int) Math.floor(4 * radius * 0.04),
              (int) Math.ceil(radius * 0.2),
              (int) Math.ceil(radius * 0.2));
        }
        if (currentCell.getPlaceables().get(e).isCube() && currentCell.getBuilding() == null) {
          int radius = (int) Math.min(size.getWidth() / 24, size.getHeight() / 18);

          if (currentCell.getBiome() == Cell.BiomeType.DESERT) {
            g.setColor(Color.black);
          } else {
            g.setColor(Color.white);
          }
          g.drawRect(
              (int) hexagonList.get(i).getCenter().getX() - (int) Math.floor(2 * radius * 0.04),
              (int) hexagonList.get(i).getCenter().getY() - (int) Math.floor(4 * radius * 0.04),
              (int) Math.ceil(radius * 0.2),
              (int) Math.ceil(radius * 0.2));
          g.setColor(
              ColorMapper.getColor(currentCell.getPlaceables().get(e).getUser().getPlayerColour()));
          g.fillRect(
              (int) hexagonList.get(i).getCenter().getX() - (int) Math.floor(2 * radius * 0.04),
              (int) hexagonList.get(i).getCenter().getY() - (int) Math.floor(4 * radius * 0.04),
              (int) Math.ceil(radius * 0.2),
              (int) Math.ceil(radius * 0.2));
        }
        int discOffsetX = -3;
        int discOffsetY = -1;
        if (e == 1) {
          discOffsetY = -25;
        }
        if (e == 2) {
          discOffsetX = 10;
          discOffsetY = -12;
        }
        if (e == 3) {
          discOffsetX = +6;
          discOffsetY = -22;
        }
        if (e == 4) {
          discOffsetX = 6;
          discOffsetY = -1;
        }
        if (!currentCell.getPlaceables().get(e).isCube()) {
          int radius = (int) Math.min(size.getWidth() / 24, size.getHeight() / 18);
          if (currentCell.getBiome() == Cell.BiomeType.DESERT) {
            g.setColor(Color.black);
          } else {
            g.setColor(Color.white);
          }
          g.drawOval(
              (int) hexagonList.get(i).getCenter().getX()
                  - (int) Math.ceil((4 + discOffsetX) * radius * 0.05),
              (int) hexagonList.get(i).getCenter().getY()
                  + (int) Math.ceil((10 + discOffsetY) * radius * 0.05),
              (int) Math.ceil(radius * 0.2),
              (int) Math.ceil(radius * 0.2));
          g.setColor(
              ColorMapper.getColor(currentCell.getPlaceables().get(e).getUser().getPlayerColour()));
          g.fillOval(
              (int) hexagonList.get(i).getCenter().getX()
                  - (int) Math.ceil((4 + discOffsetX) * radius * 0.05),
              (int) hexagonList.get(i).getCenter().getY()
                  + (int) Math.ceil((10 + discOffsetY) * radius * 0.05),
              (int) Math.ceil(radius * 0.2),
              (int) Math.ceil(radius * 0.2));
        }
      }
      if (currentCell.getBuilding() == null) {
        continue;
      }
      switch (currentCell.getBuilding().getBuildingColor().name()) {
        case "WHITE":
          g.setColor(Color.WHITE);
          break;
        case "GREEN":
          g.setColor(Color.GREEN);
          break;
        case "BLUE":
          g.setColor(Color.BLUE);
          break;
        case "BLACK":
          g.setColor(Color.BLACK);
          break;
        default:
      }
      if (currentCell.getBuilding().getBuildingType() == HUT) {
        int radius = (int) Math.min(size.getWidth() / 24, size.getHeight() / 18);
        TriangleHut triangleHut =
            new TriangleHut(hexagonList.get(i).getCenter(), (int) (radius * 0.8));
        g.drawPolygon(triangleHut);
        g.fillPolygon(triangleHut);
      }
      if (currentCell.getBuilding().getBuildingType() == STONE) {
        int radius = (int) Math.min(size.getWidth() / 24, size.getHeight() / 18);
        int rectWidth = (int) (radius * 0.4);
        int rectHeight = (int) (radius * 0.8);
        g.drawRect(
            (int) hexagonList.get(i).getCenter().getX() - (rectWidth / 2),
            (int) hexagonList.get(i).getCenter().getY() - (rectHeight / 2),
            rectWidth,
            rectHeight);
        g.fillRect(
            (int) hexagonList.get(i).getCenter().getX() - (rectWidth / 2),
            (int) hexagonList.get(i).getCenter().getY() - (rectHeight / 2),
            rectWidth,
            rectHeight);
      }
    }

    // show flag
    if (selectCell != null && cellList != null) {
      for (int i = 0; i < 108; i++) {
        Cell currentCell =
            cellList.get(hexagonList.get(i).getIdY()).get(hexagonList.get(i).getIdX());
        if (selectCell.getCoordinate().getRow() == currentCell.getCoordinate().getRow()
            && selectCell.getCoordinate().getColumn() == currentCell.getCoordinate().getColumn()) {
          ((Graphics2D) g)
              .drawImage(
                  flag,
                  hexagonList.get(i).getBounds().x + 20,
                  hexagonList.get(i).getBounds().y + 20,
                  20,
                  20,
                  null);
          break;
        }
      }
    }
  }

  public void setCellList(ArrayList<ArrayList<Cell>> cellList) {
    this.cellList = cellList;
  }

  public void setSelectCell(Cell c) {
    selectCell = c;
  }
}
