package org.nagarro;

public class Robot {

  private int latitude;
  private int longitude;
  private RobotDirection direction = RobotDirection.NORTH;

  private final static int MAX_LATITUDE_EXCLUSIVE = 9;
  private final static int MIN_LATITUDE_EXCLUSIVE = 0;
  private final static int MAX_LONGITUDE_EXCLUSIVE = 9;
  private final static int MIN_LONGITUDE_EXCLUSIVE = 0;

  /**
   * Drop the robot on the surface.
   * Longitude and latitude are the coordinates of the surface.
   *
   * @param longitude is the movement left and right.
   * @param latitude  is the movement up and down.
   */
  public void dropOnSurface(int longitude, int latitude) {
    this.latitude = latitude;
    this.longitude = longitude;
  }

  public int getLatitude() {
    return this.latitude;
  }

  public int getLongitude() {
    return this.longitude;
  }

  public RobotDirection getDirection() {
    return this.direction;
  }

  public void moveForward() {
    if (direction == RobotDirection.NORTH && latitude < MAX_LATITUDE_EXCLUSIVE) {
      latitude++;
    }
    if (direction == RobotDirection.EAST) {
      longitude++;
    }
    if (direction == RobotDirection.SOUTH) {
      latitude--;
    }
    if (direction == RobotDirection.WEST && longitude > MIN_LONGITUDE_EXCLUSIVE) {
      longitude--;
    }
  }

  public void moveBackwards() {
    if (direction == RobotDirection.NORTH && (latitude > MIN_LATITUDE_EXCLUSIVE)) {
      latitude--;
    }
  }

  public void rotateClockwise() {
    direction = switch (direction) {
      case NORTH -> RobotDirection.EAST;
      case EAST -> RobotDirection.SOUTH;
      case SOUTH -> RobotDirection.WEST;
      case WEST -> RobotDirection.NORTH;
    };
  }

  public void rotateCounterClockwise() {
    direction = switch (direction) {
      case NORTH -> RobotDirection.WEST;
      case WEST -> RobotDirection.SOUTH;
      case SOUTH -> RobotDirection.EAST;
      case EAST -> RobotDirection.NORTH;
    };
  }
}
