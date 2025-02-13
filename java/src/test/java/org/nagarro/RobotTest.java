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
  void moveRobotForward(){
    Robot robot = new Robot();
    robot.dropOnSurface(0, 0);

    robot.moveForward();
    assertThat(robot.getLatitude()).isEqualTo(1);
    assertThat(robot.getLongitude()).isEqualTo(0);
    assertThat(robot.getDirection()).isEqualTo(RobotDirection.NORTH);
  }


}