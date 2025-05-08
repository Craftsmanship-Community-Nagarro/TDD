package org.nagarro;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class BoundaryTest {

  @Test
  void shouldNotLeaveTheGridAfterMovingMaximumStepsBackward() {
    final Robot robot = new Robot();
    robot.dropOnSurface(0, 0);
    robot.moveBackwards();

    final int longitude = robot.getLongitude();
    final int latitude = robot.getLatitude();

    assertThat(longitude).isEqualTo(0);
    assertThat(latitude).isEqualTo(0);
  }

  @Test
  void shouldNotLeaveTheGridAfterMoving_a_StepsForward() {
    final Robot robot = new Robot();
    robot.dropOnSurface(9,9);
    robot.moveForward();

    final int longitude = robot.getLongitude();
    final int latitude = robot.getLatitude();

    assertThat(longitude).isEqualTo(9);
    assertThat(latitude).isEqualTo(9);
  }
}
