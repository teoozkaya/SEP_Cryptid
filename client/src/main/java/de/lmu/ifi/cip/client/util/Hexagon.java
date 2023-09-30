package de.lmu.ifi.cip.client.util;

import java.awt.Point;
import java.awt.Polygon;

/** This class creates a Hexagon with the Polygon class. */
public class Hexagon extends Polygon {
  private int radius;

  private Point center;

  private int idX;

  private int idY;

  /**
   * Constructor for the Hexagon class.
   *
   * @param center the center point of the hexagon.
   * @param radius the radius around the hexagon on which every point lays.
   * @param idX id of the x Position of the hexagon in regard to the hexagon map.
   * @param idY id of the y Position of the hexagon in regard to the hexagon map.
   */
  public Hexagon(Point center, int radius, int idX, int idY) {

    this.center = new Point((int) center.getX(), (int) center.getY());
    this.radius = radius;
    this.idX = idX;
    this.idY = idY;
    setRadius(radius);
    createHexagon();
  }

  private Polygon createHexagon() {

    for (int i = 0; i < 6; i++) {
      int xval = (int) (center.x + radius * Math.cos(i * 2 * Math.PI / 6D));
      int yval = (int) (center.y + radius * Math.sin(i * 2 * Math.PI / 6D));
      addPoint(xval, yval);
    }
    return this;
  }

  public Point getCenter() {
    return new Point((int) center.getX(), (int) center.getY());
  }

  /**
   * Sets the center point of a hexagon.
   *
   * @param center center point of the hexagon.
   */
  public void setCenter(Point center) {
    this.center = new Point(center);
    reset();
    createHexagon();
  }

  public int getRadius() {
    return radius;
  }

  /**
   * Sets the radius of a hexagon.
   *
   * @param radius integer value of radius length.
   */
  public void setRadius(int radius) {
    this.radius = radius;
    reset();
    createHexagon();
  }

  public int getIdX() {
    return idX;
  }

  public int getIdY() {
    return idY;
  }
}
