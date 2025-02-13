package org.nagarro;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RobotTest {

  @Test
  void testDropMainLandingSite() {
    Robot robot = new Robot();
    robot.dropOnSurface(0, 0);

    assertThat(robot.getLatitude()).isEqualTo(0);
    assertThat(robot.getLongitude()).isEqualTo(0);
    assertThat(robot.getDirection()).isEqualTo(RobotDirection.NORTH);
  }

  @Test
  void testDropOnLongitude5AndLatitude3() {
    Robot robot = new Robot();
    robot.dropOnSurface(5, 3);

    assertThat(robot.getLatitude()).isEqualTo(3);
    assertThat(robot.getLongitude()).isEqualTo(5);
    assertThat(robot.getDirection()).isEqualTo(RobotDirection.NORTH);
  }

  @Test
  void moveRobotForward() {
    Robot robot = new Robot();
    robot.dropOnSurface(0, 0);

    robot.moveForward();
    assertThat(robot.getLatitude()).isEqualTo(1);
    assertThat(robot.getLongitude()).isEqualTo(0);
    assertThat(robot.getDirection()).isEqualTo(RobotDirection.NORTH);
  }

  @Test
  void moveRobotBackwards() {
    Robot robot = new Robot();
    robot.dropOnSurface(0, 0);

    robot.moveBackwards();
    assertThat(robot.getLatitude()).isEqualTo(-1);
    assertThat(robot.getLongitude()).isEqualTo(0);
    assertThat(robot.getDirection()).isEqualTo(RobotDirection.NORTH);
  }

  @Test
  void rotateRobotClockwise() {
    Robot robot = new Robot();
    robot.dropOnSurface(0, 0);

    robot.rotateClockwise();
    assertThat(robot.getDirection()).isEqualTo(RobotDirection.EAST);
    assertThat(robot.getLatitude()).isEqualTo(0);
    assertThat(robot.getLongitude()).isEqualTo(0);
  }



  @Test
  void rotateClockwiseTwoTimes(){
    Robot robot = new Robot();
    robot.dropOnSurface(0, 0);
    robot.rotateClockwise(); //north to east
    robot.rotateClockwise(); //east to south
    assertThat(robot.getDirection()).isEqualTo(RobotDirection.SOUTH);
    assertThat(robot.getLatitude()).isEqualTo(0);
    assertThat(robot.getLongitude()).isEqualTo(0);
  }

  @Test
  void rotateClockwiseThreeTimes(){
    Robot robot = new Robot();
    robot.dropOnSurface(0, 0);
    robot.rotateClockwise(); //north to east
    robot.rotateClockwise(); //east to south
    robot.rotateClockwise(); //south to west
    assertThat(robot.getDirection()).isEqualTo(RobotDirection.WEST);
    assertThat(robot.getLatitude()).isEqualTo(0);
    assertThat(robot.getLongitude()).isEqualTo(0);
  }

  @Test
  void rotateClockwiseFourTimes(){
    Robot robot = new Robot();
    robot.dropOnSurface(0, 0);
    robot.rotateClockwise(); //north to east
    robot.rotateClockwise(); //east to south
    robot.rotateClockwise(); //south to west
    robot.rotateClockwise(); //west to north (original position)
    assertThat(robot.getDirection()).isEqualTo(RobotDirection.NORTH);
    assertThat(robot.getLatitude()).isEqualTo(0);
    assertThat(robot.getLongitude()).isEqualTo(0);
  }

  //-------------------CounterClockwise Tests-------------------
  @Test
  void rotateRobotCounterClockwise() {
    Robot robot = new Robot();
    robot.dropOnSurface(0, 0);

    robot.rotateCounterClockwise();
    assertThat(robot.getDirection()).isEqualTo(RobotDirection.WEST);
    assertThat(robot.getLatitude()).isEqualTo(0);
    assertThat(robot.getLongitude()).isEqualTo(0);
  }



  @Test
  void rotateCounterClockwiseTwoTimes(){
    Robot robot = new Robot();
    robot.dropOnSurface(0, 0);
    robot.rotateCounterClockwise(); //north to east
    robot.rotateCounterClockwise(); //east to south
    assertThat(robot.getDirection()).isEqualTo(RobotDirection.SOUTH);
    assertThat(robot.getLatitude()).isEqualTo(0);
    assertThat(robot.getLongitude()).isEqualTo(0);
  }

  @Test
  void rotateCounterClockwiseThreeTimes(){
    Robot robot = new Robot();
    robot.dropOnSurface(0, 0);
    robot.rotateCounterClockwise(); //north to west
    robot.rotateCounterClockwise(); //west to south
    robot.rotateCounterClockwise(); //south to east
    assertThat(robot.getDirection()).isEqualTo(RobotDirection.EAST);
    assertThat(robot.getLatitude()).isEqualTo(0);
    assertThat(robot.getLongitude()).isEqualTo(0);
  }

  @Test
  void rotateCounterClockwiseFourTimes(){
    Robot robot = new Robot();
    robot.dropOnSurface(0, 0);
    robot.rotateCounterClockwise(); //north to west
    robot.rotateCounterClockwise(); //west to south
    robot.rotateCounterClockwise(); //south to east
    robot.rotateCounterClockwise(); //east to north (original position)
    assertThat(robot.getDirection()).isEqualTo(RobotDirection.NORTH);
    assertThat(robot.getLatitude()).isEqualTo(0);
    assertThat(robot.getLongitude()).isEqualTo(0);
  }

}
