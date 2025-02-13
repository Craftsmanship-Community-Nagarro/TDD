package org.nagarro;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RobotTest {

    @Test
    void testDropOnSurface() {
        Robot robot = new Robot();
        robot.dropOnSurface(0,0);

        assertThat(robot.getLatitude()).isEqualTo(0);
        assertThat(robot.getLongitude()).isEqualTo(0);
        assertThat(robot.getDirection()).isEqualTo(RobotDirection.NORTH);
    }

}
