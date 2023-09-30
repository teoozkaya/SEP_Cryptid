package de.lmu.ifi.cip.client.view;

import java.awt.Point;
import java.awt.Polygon;

/** Creates a Triangle, which symbolizes the hut placeable. */
public class TriangleHut extends Polygon {

  Point center;
  int radius;

  /**
   * Creates a specific Triangle around a point.
   *
   * @param center is a point which will be in the middle of the triangle
   */
  public TriangleHut(Point center, int radius) {

    this.radius = radius;
    this.center = new Point((int) center.getX(), (int) center.getY());
    createTriangleHut();
  }

  private Polygon createTriangleHut() {

    addPoint((int) center.getX(), (int) center.getY() - (int) Math.ceil(4 * radius * 0.1));
    addPoint(
        (int) center.getX() + (int) Math.ceil(4 * radius * 0.1),
        (int) center.getY() + (int) Math.ceil(4 * radius * 0.1));
    addPoint(
        (int) center.getX() - (int) Math.ceil(4 * radius * 0.1),
        (int) center.getY() + (int) Math.ceil(4 * radius * 0.1));

    return this;
  }
}
