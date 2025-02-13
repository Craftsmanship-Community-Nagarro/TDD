package org.nagarro;

public class Robot {

  private int latitude;
  private int longitude;
  private RobotDirection direction = RobotDirection.NORTH;

  /**
   * Drop the robot on the surface.
   * Longitude and latitude are the coordinates of the surface.
   *
   * @param longitude is the movement left and right.
   * @param latitude is the movement up and down.
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
    if (direction == RobotDirection.NORTH){
      latitude++;
    }

  }
}
