package org.nagarro;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
        robot.dropOnSurface(9, 9);
        robot.moveForward();

        final int longitude = robot.getLongitude();
        final int latitude = robot.getLatitude();

        assertThat(longitude).isEqualTo(9);
        assertThat(latitude).isEqualTo(9);
    }

    @Test
    void shouldNotLeaveTheGridAfterMovingMultipleStepsForward() {
        final Robot robot = new Robot();
        robot.dropOnSurface(0, 0);

        for (int i = 0; i < 11; i++) {
            robot.moveForward();
        }
        final int longitude = robot.getLongitude();
        final int latitude = robot.getLatitude();

        assertThat(longitude).isEqualTo(0);
        assertThat(latitude).isEqualTo(9);
    }

    @Test
    void shouldRotateAndMoveForwardAndStillNotCrossTheBoundary() {
        final Robot robot = new Robot();
        robot.dropOnSurface(0, 0);

        robot.rotateCounterClockwise();
        robot.moveForward();

        final int longitude = robot.getLongitude();
        final int latitude = robot.getLatitude();

        assertThat(longitude).isEqualTo(0);
        assertThat(latitude).isEqualTo(0);
    }

    @Test
    void shouldRotateAndMoveBackwardAndStillNotCrossTheBoundary() {
        final Robot robot = new Robot();
        robot.dropOnSurface(1, 1);

        robot.rotateClockwise();
        robot.moveBackwards();
        robot.moveBackwards();

        assertThat(robot.getLongitude()).isEqualTo(0);
        assertThat(robot.getLatitude()).isEqualTo(1);
    }



}
