package de.lmu.ifi.cip.model.board;

import java.util.ArrayList;

/** Implements a class which creates a list of buildings for each map. */
public class BuildingList {

  /** Represents a list of all buildings. */
  public static ArrayList<ArrayList<Building>> allBuildingist = new ArrayList<>();

  /**
   * Retrieves the building list at the specified ID.
   *
   * @param id The ID of the building list to retrieve.
   * @return The building list at the specified ID.
   */
  public static ArrayList<Building> getBuildingList(int id) {
    if (allBuildingist.size() <= 0) {
      ArrayList<Building> bl = new ArrayList<>();
      // from 0 to 53

      // add Simple 0 as index = 0
      // 0, 0, simple
      bl = new ArrayList<>();
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.GREEN, new Coordinate(1, 5)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLUE, new Coordinate(5, 5)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.GREEN, new Coordinate(5, 8)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.WHITE, new Coordinate(6, 4)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLUE, new Coordinate(7, 2)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.WHITE, new Coordinate(6, 6)));
      allBuildingist.add(bl);

      // 1, 1, simple
      bl = new ArrayList<>();
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLUE, new Coordinate(1, 4)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.WHITE, new Coordinate(2, 7)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.GREEN, new Coordinate(3, 10)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.WHITE, new Coordinate(3, 11)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.GREEN, new Coordinate(7, 1)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLUE, new Coordinate(7, 5)));
      allBuildingist.add(bl);

      // 2, 2, simple
      bl = new ArrayList<>();
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLUE, new Coordinate(1, 2)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLUE, new Coordinate(1, 4)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.WHITE, new Coordinate(5, 3)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.GREEN, new Coordinate(4, 11)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.GREEN, new Coordinate(6, 0)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.WHITE, new Coordinate(8, 1)));
      allBuildingist.add(bl);

      // 3, 3, simple
      bl = new ArrayList<>();
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.WHITE, new Coordinate(2, 2)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.GREEN, new Coordinate(3, 4)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLUE, new Coordinate(3, 7)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLUE, new Coordinate(8, 1)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.GREEN, new Coordinate(6, 6)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.WHITE, new Coordinate(8, 10)));
      allBuildingist.add(bl);

      // 4, 4, simple
      bl = new ArrayList<>();
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.GREEN, new Coordinate(2, 5)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLUE, new Coordinate(0, 6)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.WHITE, new Coordinate(3, 10)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.WHITE, new Coordinate(4, 10)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLUE, new Coordinate(8, 6)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.GREEN, new Coordinate(7, 9)));
      allBuildingist.add(bl);

      // 5, 5, simple
      bl = new ArrayList<>();
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.WHITE, new Coordinate(0, 3)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.GREEN, new Coordinate(0, 4)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLUE, new Coordinate(1, 8)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLUE, new Coordinate(6, 3)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.GREEN, new Coordinate(7, 10)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.WHITE, new Coordinate(8, 10)));
      allBuildingist.add(bl);

      // 6, 6, simple
      bl = new ArrayList<>();
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.WHITE, new Coordinate(0, 2)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.GREEN, new Coordinate(2, 10)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLUE, new Coordinate(5, 4)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.WHITE, new Coordinate(3, 9)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLUE, new Coordinate(8, 3)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.GREEN, new Coordinate(6, 6)));
      allBuildingist.add(bl);

      // 7, 7, simple
      bl = new ArrayList<>();
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLUE, new Coordinate(0, 1)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.WHITE, new Coordinate(4, 2)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.WHITE, new Coordinate(5, 5)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.GREEN, new Coordinate(4, 6)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.GREEN, new Coordinate(4, 11)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLUE, new Coordinate(6, 1)));
      allBuildingist.add(bl);

      // 8, 8, simple
      bl = new ArrayList<>();
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.WHITE, new Coordinate(0, 7)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.GREEN, new Coordinate(2, 7)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.GREEN, new Coordinate(7, 0)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLUE, new Coordinate(8, 3)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.WHITE, new Coordinate(8, 4)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLUE, new Coordinate(6, 9)));
      allBuildingist.add(bl);

      // 9, 9, simple
      bl = new ArrayList<>();
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLUE, new Coordinate(2, 11)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.GREEN, new Coordinate(3, 4)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.GREEN, new Coordinate(5, 0)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.WHITE, new Coordinate(5, 1)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLUE, new Coordinate(6, 8)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.WHITE, new Coordinate(8, 8)));
      allBuildingist.add(bl);

      // 10, 10, simple
      bl = new ArrayList<>();
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.GREEN, new Coordinate(2, 11)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLUE, new Coordinate(4, 5)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.WHITE, new Coordinate(5, 2)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.GREEN, new Coordinate(5, 5)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLUE, new Coordinate(4, 8)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.WHITE, new Coordinate(5, 10)));
      allBuildingist.add(bl);

      // 11, 11, simple
      bl = new ArrayList<>();
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLUE, new Coordinate(0, 1)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.WHITE, new Coordinate(2, 3)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.WHITE, new Coordinate(2, 5)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.GREEN, new Coordinate(0, 11)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLUE, new Coordinate(8, 4)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.GREEN, new Coordinate(6, 9)));
      allBuildingist.add(bl);

      // 12, 12, simple
      bl = new ArrayList<>();
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.WHITE, new Coordinate(1, 1)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLUE, new Coordinate(0, 7)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.GREEN, new Coordinate(2, 10)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.GREEN, new Coordinate(4, 5)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.WHITE, new Coordinate(6, 4)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLUE, new Coordinate(6, 11)));
      allBuildingist.add(bl);

      // 13, 13, simple
      bl = new ArrayList<>();
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.WHITE, new Coordinate(1, 0)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLUE, new Coordinate(1, 4)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.GREEN, new Coordinate(2, 5)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.GREEN, new Coordinate(4, 0)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLUE, new Coordinate(3, 11)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.WHITE, new Coordinate(6, 6)));
      allBuildingist.add(bl);

      // 14, 14, simple
      bl = new ArrayList<>();
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLUE, new Coordinate(2, 0)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.WHITE, new Coordinate(2, 10)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.GREEN, new Coordinate(3, 4)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.GREEN, new Coordinate(5, 11)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.WHITE, new Coordinate(7, 1)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLUE, new Coordinate(6, 7)));
      allBuildingist.add(bl);

      // 15, 15, simple
      bl = new ArrayList<>();
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.GREEN, new Coordinate(1, 5)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.WHITE, new Coordinate(2, 2)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.GREEN, new Coordinate(5, 0)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLUE, new Coordinate(5, 4)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.WHITE, new Coordinate(8, 3)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLUE, new Coordinate(8, 5)));
      allBuildingist.add(bl);

      // 16, 16, simple
      bl = new ArrayList<>();
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLUE, new Coordinate(3, 1)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLUE, new Coordinate(5, 5)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.WHITE, new Coordinate(4, 6)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.GREEN, new Coordinate(6, 4)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.GREEN, new Coordinate(7, 4)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.WHITE, new Coordinate(7, 6)));
      allBuildingist.add(bl);

      // 17, 17, simple
      bl = new ArrayList<>();
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLUE, new Coordinate(0, 8)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.GREEN, new Coordinate(1, 11)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.GREEN, new Coordinate(2, 6)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLUE, new Coordinate(3, 6)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.WHITE, new Coordinate(5, 7)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.WHITE, new Coordinate(7, 9)));
      allBuildingist.add(bl);

      // 18, 18, simple
      bl = new ArrayList<>();
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.WHITE, new Coordinate(1, 11)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLUE, new Coordinate(3, 10)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.WHITE, new Coordinate(5, 9)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.GREEN, new Coordinate(7, 2)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.GREEN, new Coordinate(8, 7)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLUE, new Coordinate(8, 9)));
      allBuildingist.add(bl);

      // 19, 0, Advanced
      bl = new ArrayList<>();
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.GREEN, new Coordinate(0, 2)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLACK, new Coordinate(1, 0)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.GREEN, new Coordinate(2, 7)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLACK, new Coordinate(3, 6)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.WHITE, new Coordinate(4, 9)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.WHITE, new Coordinate(4, 11)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLUE, new Coordinate(6, 0)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLUE, new Coordinate(7, 10)));
      allBuildingist.add(bl);

      // 20, 1, Advanced
      bl = new ArrayList<>();
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLUE, new Coordinate(2, 0)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.GREEN, new Coordinate(2, 5)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLACK, new Coordinate(2, 8)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.GREEN, new Coordinate(7, 0)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLACK, new Coordinate(7, 1)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.WHITE, new Coordinate(8, 3)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.WHITE, new Coordinate(7, 6)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLUE, new Coordinate(7, 9)));
      allBuildingist.add(bl);

      // 21, 2, Advanced
      bl = new ArrayList<>();
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.WHITE, new Coordinate(0, 5)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.GREEN, new Coordinate(2, 5)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLACK, new Coordinate(2, 7)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLUE, new Coordinate(2, 10)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLACK, new Coordinate(4, 2)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.GREEN, new Coordinate(4, 5)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.WHITE, new Coordinate(7, 4)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLUE, new Coordinate(7, 5)));
      allBuildingist.add(bl);

      // 22, 3, Advanced
      bl = new ArrayList<>();
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.GREEN, new Coordinate(0, 0)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLUE, new Coordinate(1, 7)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.WHITE, new Coordinate(3, 11)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.WHITE, new Coordinate(7, 3)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.GREEN, new Coordinate(8, 2)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLACK, new Coordinate(6, 10)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLACK, new Coordinate(7, 6)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLUE, new Coordinate(7, 8)));
      allBuildingist.add(bl);

      // 23, 4, Advanced
      bl = new ArrayList<>();
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.WHITE, new Coordinate(1, 7)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLUE, new Coordinate(1, 11)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.GREEN, new Coordinate(2, 6)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLACK, new Coordinate(3, 1)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.GREEN, new Coordinate(5, 2)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLUE, new Coordinate(8, 5)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.WHITE, new Coordinate(7, 10)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLACK, new Coordinate(8, 9)));
      allBuildingist.add(bl);

      // 24, 5, Advanced
      bl = new ArrayList<>();
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLUE, new Coordinate(0, 9)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.GREEN, new Coordinate(3, 1)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLUE, new Coordinate(5, 0)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLACK, new Coordinate(4, 9)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.WHITE, new Coordinate(8, 3)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLACK, new Coordinate(6, 6)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.GREEN, new Coordinate(6, 8)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.WHITE, new Coordinate(8, 10)));
      allBuildingist.add(bl);

      // 25, 6, Advanced
      bl = new ArrayList<>();
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.WHITE, new Coordinate(1, 2)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLACK, new Coordinate(0, 8)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.GREEN, new Coordinate(2, 8)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLUE, new Coordinate(3, 5)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.WHITE, new Coordinate(4, 3)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLACK, new Coordinate(8, 0)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLUE, new Coordinate(8, 5)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.GREEN, new Coordinate(6, 11)));
      allBuildingist.add(bl);

      // 26, 7, Advanced
      bl = new ArrayList<>();
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.GREEN, new Coordinate(0, 6)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.WHITE, new Coordinate(1, 6)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLACK, new Coordinate(1, 11)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLUE, new Coordinate(2, 7)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.WHITE, new Coordinate(3, 7)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.GREEN, new Coordinate(4, 6)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLUE, new Coordinate(8, 3)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLACK, new Coordinate(6, 6)));
      allBuildingist.add(bl);

      // this is  Advanced number 8,index = 27
      // 27, 8,Advanced
      bl = new ArrayList<>();
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLACK, new Coordinate(0, 7)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.GREEN, new Coordinate(2, 6)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLUE, new Coordinate(2, 8)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.WHITE, new Coordinate(3, 5)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLUE, new Coordinate(5, 1)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.GREEN, new Coordinate(8, 2)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLACK, new Coordinate(8, 7)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.WHITE, new Coordinate(8, 11)));
      allBuildingist.add(bl);

      // 28, 9,Advanced
      bl = new ArrayList<>();
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLUE, new Coordinate(1, 10)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.GREEN, new Coordinate(0, 11)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.WHITE, new Coordinate(4, 1)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLACK, new Coordinate(4, 5)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLACK, new Coordinate(3, 6)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLUE, new Coordinate(5, 7)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.WHITE, new Coordinate(4, 11)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.GREEN, new Coordinate(6, 5)));
      allBuildingist.add(bl);

      // 29, 10,Advanced
      bl = new ArrayList<>();
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.GREEN, new Coordinate(0, 5)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.GREEN, new Coordinate(2, 9)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLUE, new Coordinate(3, 5)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLACK, new Coordinate(4, 4)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLUE, new Coordinate(3, 8)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.WHITE, new Coordinate(4, 7)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.WHITE, new Coordinate(3, 11)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLACK, new Coordinate(8, 5)));
      allBuildingist.add(bl);

      // 30, 11,Advanced
      bl = new ArrayList<>();
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.WHITE, new Coordinate(1, 6)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.GREEN, new Coordinate(2, 9)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.WHITE, new Coordinate(4, 0)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.GREEN, new Coordinate(4, 5)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLACK, new Coordinate(6, 0)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLUE, new Coordinate(6, 1)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLACK, new Coordinate(7, 4)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLUE, new Coordinate(7, 7)));
      allBuildingist.add(bl);

      // 31, 12,Advanced
      bl = new ArrayList<>();
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.WHITE, new Coordinate(2, 3)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLUE, new Coordinate(0, 8)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLACK, new Coordinate(4, 2)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.GREEN, new Coordinate(5, 4)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLACK, new Coordinate(3, 7)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.WHITE, new Coordinate(6, 0)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.GREEN, new Coordinate(7, 4)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLUE, new Coordinate(6, 9)));
      allBuildingist.add(bl);

      // 32, 13,Advanced
      bl = new ArrayList<>();
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLACK, new Coordinate(0, 4)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLUE, new Coordinate(2, 2)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.WHITE, new Coordinate(0, 6)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLACK, new Coordinate(5, 0)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.WHITE, new Coordinate(3, 9)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.GREEN, new Coordinate(6, 1)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLUE, new Coordinate(6, 4)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.GREEN, new Coordinate(7, 8)));
      allBuildingist.add(bl);

      // 33, 14,Advanced
      bl = new ArrayList<>();
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.GREEN, new Coordinate(1, 11)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLACK, new Coordinate(4, 5)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLUE, new Coordinate(4, 7)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLUE, new Coordinate(4, 9)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.GREEN, new Coordinate(5, 11)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLACK, new Coordinate(7, 0)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.WHITE, new Coordinate(7, 1)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.WHITE, new Coordinate(7, 10)));
      allBuildingist.add(bl);

      // 34, 15,Advanced
      bl = new ArrayList<>();
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLACK, new Coordinate(1, 3)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.GREEN, new Coordinate(2, 6)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLACK, new Coordinate(1, 10)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.GREEN, new Coordinate(2, 10)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLUE, new Coordinate(3, 8)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.WHITE, new Coordinate(7, 4)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLUE, new Coordinate(8, 5)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.WHITE, new Coordinate(8, 11)));
      allBuildingist.add(bl);

      // 35, 16,Advanced
      bl = new ArrayList<>();
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.GREEN, new Coordinate(2, 6)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLACK, new Coordinate(0, 8)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLUE, new Coordinate(3, 2)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.WHITE, new Coordinate(4, 5)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLUE, new Coordinate(6, 2)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.GREEN, new Coordinate(6, 3)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.WHITE, new Coordinate(7, 3)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLACK, new Coordinate(6, 8)));
      allBuildingist.add(bl);

      // 36, 17,Advanced
      bl = new ArrayList<>();
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.GREEN, new Coordinate(0, 4)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLUE, new Coordinate(2, 9)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.WHITE, new Coordinate(3, 1)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.WHITE, new Coordinate(3, 8)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLACK, new Coordinate(5, 9)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLUE, new Coordinate(7, 1)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLACK, new Coordinate(6, 5)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.GREEN, new Coordinate(8, 6)));
      allBuildingist.add(bl);

      // 37, 18,Advanced
      bl = new ArrayList<>();
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLUE, new Coordinate(0, 6)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLACK, new Coordinate(1, 9)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.WHITE, new Coordinate(2, 9)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.WHITE, new Coordinate(5, 2)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.GREEN, new Coordinate(5, 7)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLACK, new Coordinate(6, 4)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.GREEN, new Coordinate(8, 6)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLUE, new Coordinate(8, 11)));
      allBuildingist.add(bl);

      // 38, 19,Advanced
      bl = new ArrayList<>();
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.WHITE, new Coordinate(1, 2)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLACK, new Coordinate(2, 5)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLUE, new Coordinate(1, 10)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLUE, new Coordinate(1, 11)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.WHITE, new Coordinate(3, 6)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.GREEN, new Coordinate(5, 6)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLACK, new Coordinate(7, 4)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.GREEN, new Coordinate(7, 6)));
      allBuildingist.add(bl);

      // 39, 20,Advanced
      bl = new ArrayList<>();
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.WHITE, new Coordinate(1, 2)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.GREEN, new Coordinate(5, 6)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLACK, new Coordinate(7, 7)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLUE, new Coordinate(8, 9)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLACK, new Coordinate(3, 0)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLUE, new Coordinate(4, 6)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.GREEN, new Coordinate(4, 7)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.WHITE, new Coordinate(7, 3)));
      allBuildingist.add(bl);

      // 40, 21,Advanced
      bl = new ArrayList<>();
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.GREEN, new Coordinate(5, 1)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLACK, new Coordinate(7, 7)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.WHITE, new Coordinate(8, 8)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLUE, new Coordinate(5, 10)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.GREEN, new Coordinate(3, 2)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLACK, new Coordinate(4, 2)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLUE, new Coordinate(5, 5)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.WHITE, new Coordinate(0, 6)));
      allBuildingist.add(bl);

      // 41, 22,Advanced
      bl = new ArrayList<>();
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.GREEN, new Coordinate(1, 7)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLUE, new Coordinate(2, 9)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLACK, new Coordinate(7, 8)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.WHITE, new Coordinate(2, 11)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.WHITE, new Coordinate(2, 1)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLACK, new Coordinate(0, 7)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.GREEN, new Coordinate(4, 7)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLUE, new Coordinate(7, 5)));
      allBuildingist.add(bl);

      // 42, 23,Advanced
      bl = new ArrayList<>();
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLUE, new Coordinate(3, 3)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLACK, new Coordinate(7, 3)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.GREEN, new Coordinate(4, 5)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.WHITE, new Coordinate(8, 10)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLACK, new Coordinate(3, 0)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLUE, new Coordinate(2, 3)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.WHITE, new Coordinate(4, 7)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.GREEN, new Coordinate(8, 8)));
      allBuildingist.add(bl);

      // 43, 24,Advanced
      bl = new ArrayList<>();
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.GREEN, new Coordinate(2, 4)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.WHITE, new Coordinate(7, 5)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLACK, new Coordinate(1, 7)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLUE, new Coordinate(4, 8)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.WHITE, new Coordinate(4, 2)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLUE, new Coordinate(7, 2)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.GREEN, new Coordinate(1, 5)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLACK, new Coordinate(5, 5)));
      allBuildingist.add(bl);

      // 44, 25,Advanced
      bl = new ArrayList<>();
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLACK, new Coordinate(6, 4)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.GREEN, new Coordinate(5, 7)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.WHITE, new Coordinate(2, 9)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLUE, new Coordinate(8, 11)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.WHITE, new Coordinate(5, 2)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLUE, new Coordinate(0, 6)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.GREEN, new Coordinate(8, 6)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLACK, new Coordinate(1, 9)));
      allBuildingist.add(bl);

      // 45, 26,Advanced
      bl = new ArrayList<>();
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLACK, new Coordinate(4, 1)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.WHITE, new Coordinate(7, 4)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.GREEN, new Coordinate(4, 5)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLUE, new Coordinate(1, 9)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLUE, new Coordinate(2, 0)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.WHITE, new Coordinate(7, 6)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLACK, new Coordinate(8, 10)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.GREEN, new Coordinate(6, 11)));
      allBuildingist.add(bl);

      // 46, 27,Advanced
      bl = new ArrayList<>();
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.WHITE, new Coordinate(2, 1)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.GREEN, new Coordinate(8, 2)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLACK, new Coordinate(7, 3)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLUE, new Coordinate(4, 8)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLACK, new Coordinate(3, 1)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.GREEN, new Coordinate(2, 4)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLUE, new Coordinate(1, 7)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.WHITE, new Coordinate(2, 11)));
      allBuildingist.add(bl);

      // 47, 28,Advanced
      bl = new ArrayList<>();
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.GREEN, new Coordinate(4, 1)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLACK, new Coordinate(4, 2)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.WHITE, new Coordinate(0, 4)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLUE, new Coordinate(6, 4)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.WHITE, new Coordinate(3, 2)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.GREEN, new Coordinate(1, 4)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLUE, new Coordinate(2, 4)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLACK, new Coordinate(4, 7)));
      allBuildingist.add(bl);

      // 48, 29,Advanced
      bl = new ArrayList<>();
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLUE, new Coordinate(0, 3)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.GREEN, new Coordinate(5, 8)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.WHITE, new Coordinate(7, 10)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLACK, new Coordinate(8, 11)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.WHITE, new Coordinate(6, 0)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLACK, new Coordinate(1, 8)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.GREEN, new Coordinate(3, 8)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLUE, new Coordinate(4, 9)));
      allBuildingist.add(bl);

      // 49, 30,Advanced
      bl = new ArrayList<>();
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.WHITE, new Coordinate(8, 2)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.GREEN, new Coordinate(3, 3)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLUE, new Coordinate(7, 7)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLACK, new Coordinate(8, 7)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLACK, new Coordinate(0, 1)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.GREEN, new Coordinate(1, 2)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLUE, new Coordinate(2, 9)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.WHITE, new Coordinate(8, 11)));
      allBuildingist.add(bl);

      // 50, 31,Advanced
      bl = new ArrayList<>();
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.WHITE, new Coordinate(5, 3)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLACK, new Coordinate(5, 7)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.GREEN, new Coordinate(2, 8)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLUE, new Coordinate(7, 11)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.GREEN, new Coordinate(7, 1)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLUE, new Coordinate(3, 6)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLACK, new Coordinate(8, 6)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.WHITE, new Coordinate(7, 10)));
      allBuildingist.add(bl);

      // 51, 32,Advanced
      bl = new ArrayList<>();
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.GREEN, new Coordinate(1, 0)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.WHITE, new Coordinate(8, 2)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLUE, new Coordinate(4, 10)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLACK, new Coordinate(7, 11)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLUE, new Coordinate(0, 2)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.WHITE, new Coordinate(8, 4)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLACK, new Coordinate(8, 8)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.GREEN, new Coordinate(8, 9)));
      allBuildingist.add(bl);

      // 52, 33,Advanced
      bl = new ArrayList<>();
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.GREEN, new Coordinate(7, 2)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.WHITE, new Coordinate(7, 6)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLUE, new Coordinate(1, 8)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLACK, new Coordinate(5, 10)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.WHITE, new Coordinate(2, 0)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLACK, new Coordinate(1, 9)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.GREEN, new Coordinate(2, 9)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLUE, new Coordinate(7, 11)));
      allBuildingist.add(bl);

      // 53, 34,Advanced
      bl = new ArrayList<>();
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLACK, new Coordinate(2, 1)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.BLUE, new Coordinate(2, 5)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.GREEN, new Coordinate(1, 7)));
      bl.add(
          new Building(
              Building.BuildingType.STONE, Building.BuildingColor.WHITE, new Coordinate(8, 7)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.GREEN, new Coordinate(0, 3)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLUE, new Coordinate(7, 4)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.WHITE, new Coordinate(1, 6)));
      bl.add(
          new Building(
              Building.BuildingType.HUT, Building.BuildingColor.BLACK, new Coordinate(6, 7)));
      allBuildingist.add(bl);

      // ... add others ...

    }

    return allBuildingist.get(id);
  }
}
