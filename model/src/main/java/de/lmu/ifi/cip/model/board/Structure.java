package de.lmu.ifi.cip.model.board;

import java.util.ArrayList;
import java.util.Random;

/** This class implements the structure of the board pieces in a specific map. */
public enum Structure {
  SimpleZero(
      true,
      new int[] {4, 1, 6, 8, 11, 9},
      new int[] {15, 12, 1},
      new int[] {27, 16, 15, 4},
      new int[] {39, 43, 15, 26, 4},
      0),
  SimpleOne(
      true,
      new int[] {2, 7, 10, 5, 9, 12},
      new int[] {1, 18, 43},
      new int[] {30, 5, 2, 27},
      new int[] {39, 5, 33, 16, 38},
      1),
  SimpleTwo(
      true,
      new int[] {2, 3, 6, 7, 5, 10},
      new int[] {1, 4, 23},
      new int[] {7, 4, 30, 37},
      new int[] {31, 7, 33, 15, 18},
      2),
  SimpleThree(
      true,
      new int[] {2, 5, 10, 7, 6, 3},
      new int[] {43, 0, 16},
      new int[] {26, 33, 37, 16},
      new int[] {16, 23, 39, 33, 4},
      3),
  SimpleFour(
      true,
      new int[] {2, 1, 11, 4, 3, 6},
      new int[] {1, 30, 2},
      new int[] {12, 7, 2, 15},
      new int[] {16, 2, 37, 4, 15},
      4),
  SimpleFive(
      true,
      new int[] {5, 8, 3, 12, 4, 1},
      new int[] {43, 2, 30},
      new int[] {23, 39, 37, 15},
      new int[] {43, 12, 31, 5, 18},
      5),
  SimpleSix(
      true,
      new int[] {5, 2, 10, 7, 3, 12},
      new int[] {1, 4, 30},
      new int[] {38, 32, 12, 2},
      new int[] {10, 38, 26, 45, 32},
      6),
  SimpleSeven(
      true,
      new int[] {10, 9, 5, 2, 7, 12},
      new int[] {4, 2, 26},
      new int[] {37, 18, 45, 2},
      new int[] {43, 38, 27, 39, 5},
      7),
  SimpleEigth(
      true,
      new int[] {9, 2, 1, 5, 4, 6},
      new int[] {16, 10, 1},
      new int[] {18, 0, 37, 16},
      new int[] {18, 45, 37, 16, 5},
      8),
  SimpleNine(
      true,
      new int[] {9, 7, 8, 6, 4, 5},
      new int[] {16, 4, 0},
      new int[] {43, 15, 0, 39},
      new int[] {26, 5, 39, 38, 43},
      9),
  SimpleTen(
      true,
      new int[] {6, 7, 3, 5, 8, 4},
      new int[] {0, 32, 1},
      new int[] {33, 37, 32, 26},
      new int[] {39, 38, 1, 23, 45},
      10),
  SimpleEleven(
      true,
      new int[] {7, 5, 12, 9, 2, 4},
      new int[] {23, 4, 31},
      new int[] {33, 15, 10, 37},
      new int[] {1, 18, 16, 12, 5},
      11),
  SimpleTwelve(
      true,
      new int[] {4, 11, 3, 8, 6, 1},
      new int[] {15, 32, 7},
      new int[] {31, 23, 16, 38},
      new int[] {37, 16, 32, 26, 23},
      12),
  SimpleThirteen(
      true,
      new int[] {6, 1, 11, 4, 9, 2},
      new int[] {43, 15, 37},
      new int[] {37, 27, 5, 4},
      new int[] {30, 43, 32, 31, 5},
      13),
  SimpleFourteen(
      true,
      new int[] {6, 3, 11, 4, 2, 7},
      new int[] {32, 10, 39},
      new int[] {26, 32, 15, 27},
      new int[] {39, 32, 23, 26, 38},
      14),
  SimpleFifteen(
      true,
      new int[] {6, 4, 11, 1, 9, 8},
      new int[] {15, 45, 4},
      new int[] {30, 5, 38, 37},
      new int[] {39, 5, 16, 18, 37},
      15),
  SimpleSixteen(
      true,
      new int[] {4, 3, 6, 11, 7, 8},
      new int[] {5, 30, 1},
      new int[] {5, 1, 39, 23},
      new int[] {18, 5, 0, 16, 43},
      16),
  SimpleSeventeen(
      true,
      new int[] {3, 10, 7, 2, 11, 12},
      new int[] {33, 43, 4},
      new int[] {38, 0, 2, 5},
      new int[] {39, 37, 5, 2, 23},
      17),
  SimpleEighteen(
      true,
      new int[] {2, 12, 1, 10, 9, 11},
      new int[] {37, 4, 43},
      new int[] {23, 45, 0, 37},
      new int[] {16, 37, 30, 5, 15},
      18),
  AdvancedZero(
      false,
      new int[] {4, 2, 1, 3, 5, 12},
      new int[] {11, 20, 28},
      new int[] {44, 31, 1, 9},
      new int[] {14, 12, 4, 33, 10},
      19),
  AdvancedOne(
      false,
      new int[] {3, 11, 4, 7, 8, 12},
      new int[] {7, 38, 28},
      new int[] {25, 34, 37, 22},
      new int[] {10, 17, 9, 28, 32},
      20),
  AdvancedTwo(
      false,
      new int[] {3, 10, 7, 5, 2, 12},
      new int[] {4, 44, 12},
      new int[] {9, 42, 19, 0},
      new int[] {26, 5, 15, 16, 2},
      21),
  AdvancedThree(
      false,
      new int[] {3, 1, 6, 11, 4, 8},
      new int[] {42, 13, 20},
      new int[] {20, 15, 11, 30},
      new int[] {22, 26, 34, 23, 28},
      22),
  AdvancedFour(
      false,
      new int[] {3, 4, 12, 8, 11, 7},
      new int[] {35, 33, 38},
      new int[] {18, 38, 31, 32},
      new int[] {37, 16, 39, 21, 19},
      23),
  AdvancedFive(
      false,
      new int[] {3, 5, 1, 8, 4, 12},
      new int[] {1, 15, 9},
      new int[] {42, 27, 9, 28},
      new int[] {40, 14, 25, 17, 20},
      24),
  AdvancedSix(
      false,
      new int[] {2, 12, 7, 11, 3, 10},
      new int[] {19, 10, 32},
      new int[] {29, 39, 43, 14},
      new int[] {47, 14, 6, 5, 21},
      25),
  AdvancedSeven(
      false,
      new int[] {7, 8, 6, 4, 3, 11},
      new int[] {9, 19, 11},
      new int[] {29, 4, 15, 22},
      new int[] {1, 24, 12, 42, 25},
      26),
  AdvancedEight(
      false,
      new int[] {7, 12, 10, 8, 5, 3},
      new int[] {35, 15, 32},
      new int[] {38, 28, 24, 11},
      new int[] {40, 24, 16, 13, 5},
      27),
  AdvancedNine(
      false,
      new int[] {8, 7, 5, 6, 10, 9},
      new int[] {4, 23, 1},
      new int[] {37, 4, 24, 27},
      new int[] {4, 23, 14, 46, 17},
      28),
  AdvancedTen(
      false,
      new int[] {8, 11, 4, 9, 6, 1},
      new int[] {10, 26, 28},
      new int[] {41, 20, 34, 19},
      new int[] {15, 32, 0, 42, 13},
      29),
  AdvancedEleven(
      false,
      new int[] {8, 12, 11, 9, 4, 7},
      new int[] {43, 35, 2},
      new int[] {14, 19, 22, 43},
      new int[] {26, 42, 4, 29, 35},
      30),
  AdvancedTwelve(
      false,
      new int[] {7, 8, 5, 6, 10, 9},
      new int[] {0, 11, 43},
      new int[] {1, 42, 0, 9},
      new int[] {38, 24, 1, 12, 4},
      31),
  AdvancedThirteen(
      false,
      new int[] {6, 5, 3, 4, 8, 1},
      new int[] {28, 38, 7},
      new int[] {11, 35, 28, 19},
      new int[] {7, 44, 45, 14, 9},
      32),
  AdvancedFourteen(
      false,
      new int[] {4, 8, 7, 3, 11, 12},
      new int[] {2, 44, 41},
      new int[] {46, 32, 16, 42},
      new int[] {47, 18, 38, 45, 23},
      33),
  AdvancedFifteen(
      false,
      new int[] {6, 1, 3, 11, 8, 4},
      new int[] {9, 4, 45},
      new int[] {28, 21, 11, 13},
      new int[] {18, 39, 5, 37, 16},
      34),
  AdvancedSixteen(
      false,
      new int[] {5, 6, 10, 9, 1, 8},
      new int[] {43, 1, 15},
      new int[] {25, 41, 12, 20},
      new int[] {3, 18, 5, 21, 9},
      35),
  AdvancedSeventeen(
      false,
      new int[] {5, 6, 10, 2, 3, 1},
      new int[] {41, 2, 35},
      new int[] {2, 35, 38, 47},
      new int[] {34, 0, 15, 1, 9},
      36),
  AdvancedEighteen(
      false,
      new int[] {10, 3, 6, 2, 7, 5},
      new int[] {7, 41, 34},
      new int[] {44, 12, 9, 5},
      new int[] {23, 29, 8, 24, 15},
      37),
  AdvancedNineteen(
      false,
      new int[] {10, 11, 2, 9, 1, 12},
      new int[] {19, 27, 9},
      new int[] {17, 34, 22, 4},
      new int[] {47, 14, 30, 1, 11},
      38),
  AdvancedTwenty(
      false,
      new int[] {11, 4, 3, 1, 2, 12},
      new int[] {30, 1, 32},
      new int[] {29, 14, 7, 42},
      new int[] {28, 43, 45, 9, 19},
      39),
  AdvancedTwentyOne(
      false,
      new int[] {5, 12, 10, 7, 3, 8},
      new int[] {35, 4, 32},
      new int[] {21, 13, 19, 32},
      new int[] {5, 39, 38, 32, 23},
      40),
  AdvancedTwentyTwo(
      false,
      new int[] {9, 10, 12, 5, 1, 8},
      new int[] {20, 21, 33},
      new int[] {39, 25, 9, 23},
      new int[] {3, 40, 4, 19, 25},
      41),
  AdvancedTwentyThree(
      false,
      new int[] {9, 12, 2, 7, 10, 5},
      new int[] {10, 42, 1},
      new int[] {40, 12, 19, 14},
      new int[] {15, 33, 11, 43, 29},
      42),
  AdvancedTwentyFour(
      false,
      new int[] {10, 1, 5, 8, 6, 9},
      new int[] {20, 12, 44},
      new int[] {16, 42, 10, 29},
      new int[] {43, 47, 37, 38, 24},
      43),
  AdvancedTwentyFive(
      false,
      new int[] {10, 3, 6, 2, 7, 5},
      new int[] {35, 0, 34},
      new int[] {10, 19, 40, 35},
      new int[] {14, 11, 10, 47, 29},
      44),
  AdvancedTwentySix(
      false,
      new int[] {10, 7, 5, 6, 8, 9},
      new int[] {5, 20, 38},
      new int[] {24, 7, 5, 37},
      new int[] {15, 24, 8, 42, 32},
      45),
  AdvancedTwentySeven(
      false,
      new int[] {10, 7, 8, 12, 9, 11},
      new int[] {38, 28, 42},
      new int[] {25, 33, 29, 9},
      new int[] {42, 28, 17, 23, 18},
      46),
  AdvancedTwentyEight(
      false,
      new int[] {10, 8, 11, 1, 9, 6},
      new int[] {44, 36, 19},
      new int[] {12, 2, 31, 21},
      new int[] {15, 47, 9, 1, 35},
      47),
  AdvancedTwentyNine(
      false,
      new int[] {2, 11, 3, 4, 12, 1},
      new int[] {43, 26, 41},
      new int[] {16, 1, 34, 15},
      new int[] {30, 0, 43, 10, 41},
      48),
  AdvancedThirty(
      false,
      new int[] {2, 7, 11, 6, 3, 10},
      new int[] {28, 44, 11},
      new int[] {41, 35, 5, 33},
      new int[] {36, 41, 19, 5, 38},
      49),
  AdvancedThirtyOne(
      false,
      new int[] {2, 6, 3, 7, 4, 11},
      new int[] {2, 44, 12},
      new int[] {34, 45, 16, 0},
      new int[] {17, 36, 9, 21, 41},
      50),
  AdvancedThirtyTwo(
      false,
      new int[] {2, 3, 1, 4, 11, 6},
      new int[] {35, 2, 33},
      new int[] {33, 37, 28, 32},
      new int[] {17, 6, 28, 32, 8},
      51),
  AdvancedThirtyThree(
      false,
      new int[] {1, 2, 6, 5, 4, 9},
      new int[] {43, 32, 10},
      new int[] {45, 41, 23, 25},
      new int[] {34, 46, 5, 1, 2},
      52),
  AdvancedThirtyFour(
      false,
      new int[] {4, 7, 3, 11, 12, 8},
      new int[] {19, 44, 11},
      new int[] {25, 4, 7, 10},
      new int[] {6, 27, 5, 13, 38},
      53);

  private boolean isSimple;
  private int[] order;
  private int[] threePlayerHints;
  private int[] fourPlayerHints;
  private int[] fivePlayerHints;
  private static Random random = new Random();

  public ArrayList<Building> buildingList = new ArrayList<>();

  Structure(
      Boolean isSimple,
      int[] order,
      int[] threePlayerHints,
      int[] fourPlayerHints,
      int[] fivePlayerHints,
      int id) {
    this.isSimple = isSimple;
    this.order = order;
    this.threePlayerHints = threePlayerHints;
    this.fourPlayerHints = fourPlayerHints;
    this.fivePlayerHints = fivePlayerHints;
    this.buildingList = BuildingList.getBuildingList(id);
  }

  /**
   * Method to return a map structure of the normal game mode.
   *
   * @return a random structure of the normal game mode.
   */
  public static Structure randomSimple() {
    Structure[] simples = values();
    int n = random.nextInt(19);
    return simples[n];
  }

  /**
   * Method to return a map structure of the advanced game mode.
   *
   * @return a random structure of the advanced game mode.
   */
  public static Structure randomAdvanced() {
    Structure[] advanceds = values();
    int n = 19 + random.nextInt(35);
    return advanceds[n];
  }

  public ArrayList<Building> getBuildingList() {
    return buildingList;
  }

  public int[] getOrder() {
    return order;
  }

  public int[] getThreePlayerHints() {
    return threePlayerHints;
  }

  public int[] getFourPlayerHints() {
    return fourPlayerHints;
  }

  public int[] getFivePlayerHints() {
    return fivePlayerHints;
  }
}
