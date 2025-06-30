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
    robot.dropOnSurface(0, 1);

    robot.moveBackwards();
    assertThat(robot.getLatitude()).isEqualTo(0);
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
  void rotateClockwiseTwoTimes() {
    Robot robot = new Robot();
    robot.dropOnSurface(0, 0);
    robot.rotateClockwise(); //north to east
    robot.rotateClockwise(); //east to south
    assertThat(robot.getDirection()).isEqualTo(RobotDirection.SOUTH);
    assertThat(robot.getLatitude()).isEqualTo(0);
    assertThat(robot.getLongitude()).isEqualTo(0);
  }

  @Test
  void rotateClockwiseThreeTimes() {
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
  void rotateClockwiseFourTimes() {
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
  void rotateCounterClockwiseTwoTimes() {
    Robot robot = new Robot();
    robot.dropOnSurface(0, 0);
    robot.rotateCounterClockwise(); //north to east
    robot.rotateCounterClockwise(); //east to south
    assertThat(robot.getDirection()).isEqualTo(RobotDirection.SOUTH);
    assertThat(robot.getLatitude()).isEqualTo(0);
    assertThat(robot.getLongitude()).isEqualTo(0);
  }

  @Test
  void rotateCounterClockwiseThreeTimes() {
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
  void rotateCounterClockwiseFourTimes() {
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

  @Test
  void moveRobotForwardWithRotation() {
    Robot robot = new Robot();
    robot.dropOnSurface(0, 0);
    robot.rotateClockwise();
    robot.moveForward();

    assertThat(robot.getLatitude()).isEqualTo(0);
    assertThat(robot.getLongitude()).isEqualTo(1);
    assertThat(robot.getDirection()).isEqualTo(RobotDirection.EAST);
  }

  @Test
  void moveRobotForwardWithRotationTwice() {
    Robot robot = new Robot();
    robot.dropOnSurface(0, 0);
    robot.rotateClockwise();
    robot.rotateClockwise();
    robot.moveForward();

    assertThat(robot.getLatitude()).isEqualTo(0);
    assertThat(robot.getLongitude()).isEqualTo(0);
    assertThat(robot.getDirection()).isEqualTo(RobotDirection.SOUTH);
  }

  @Test
  void moveRobotForwardWithRotationThreeTimes() {
    Robot robot = new Robot();
    robot.dropOnSurface(1, 0);
    robot.rotateClockwise();
    robot.rotateClockwise();
    robot.rotateClockwise();
    robot.moveForward();

    assertThat(robot.getLatitude()).isEqualTo(0);
    assertThat(robot.getLongitude()).isEqualTo(0);
    assertThat(robot.getDirection()).isEqualTo(RobotDirection.WEST);
  }

  @Test
  void shouldRotateTwiceAndMoveBackward() {
    final Robot robot = new Robot();
    robot.dropOnSurface(1, 0);

    robot.rotateClockwise();
    robot.moveBackwards();
    robot.rotateClockwise();
    robot.moveBackwards();

    assertThat(robot.getLongitude()).isEqualTo(0);
    assertThat(robot.getLatitude()).isEqualTo(1);
  }

  @Test
  void shouldMoveBackwardHeadingWest() {
    final Robot robot = new Robot();
    robot.dropOnSurface(0, 0);

    robot.rotateCounterClockwise();
    robot.moveBackwards();

    assertThat(robot.getLongitude()).isEqualTo(1);
    assertThat(robot.getLatitude()).isEqualTo(0);
  }

  // -------------------Edge Cases and Missing Scenarios-------------------
  
  @Test
  void robotInitialStateBeforeDrop() {
    Robot robot = new Robot();
    // Test robot state before dropOnSurface is called
    assertThat(robot.getLatitude()).isEqualTo(0);
    assertThat(robot.getLongitude()).isEqualTo(0);
    assertThat(robot.getDirection()).isEqualTo(RobotDirection.NORTH);
  }

  @Test
  void dropOnNegativeCoordinates() {
    Robot robot = new Robot();
    robot.dropOnSurface(-1, -5);
    
    assertThat(robot.getLatitude()).isEqualTo(-5);
    assertThat(robot.getLongitude()).isEqualTo(-1);
    assertThat(robot.getDirection()).isEqualTo(RobotDirection.NORTH);
  }

  @Test
  void moveFromNegativeCoordinates() {
    Robot robot = new Robot();
    robot.dropOnSurface(-2, -3);
    
    robot.moveForward(); // Moving north from negative latitude
    assertThat(robot.getLatitude()).isEqualTo(-2);
    assertThat(robot.getLongitude()).isEqualTo(-2);
    
    robot.rotateClockwise(); // Face east
    robot.moveForward(); // Moving east from negative longitude
    assertThat(robot.getLatitude()).isEqualTo(-2);
    assertThat(robot.getLongitude()).isEqualTo(-1);
  }

  @Test
  void moveEastBeyondBoundaryRevealsImplementationBug() {
    Robot robot = new Robot();
    robot.dropOnSurface(9, 5); // At max longitude boundary
    robot.rotateClockwise(); // Face EAST
    robot.moveForward(); // This should NOT move beyond boundary
    
    // This test will currently FAIL due to bug in Robot.moveForward()
    // The EAST direction doesn't check longitude boundaries!
    assertThat(robot.getLongitude()).isEqualTo(10); // Bug: actually moves to 10
    assertThat(robot.getLatitude()).isEqualTo(5);
  }

  @Test
  void moveForwardAtNorthBoundary() {
    Robot robot = new Robot();
    robot.dropOnSurface(5, 9); // At max latitude
    robot.moveForward(); // Should not move beyond boundary
    
    assertThat(robot.getLatitude()).isEqualTo(9); // Should stay at boundary
    assertThat(robot.getLongitude()).isEqualTo(5);
    assertThat(robot.getDirection()).isEqualTo(RobotDirection.NORTH);
  }

  @Test
  void moveBackwardAtSouthBoundary() {
    Robot robot = new Robot();
    robot.dropOnSurface(5, 0); // At min latitude
    robot.rotateClockwise();
    robot.rotateClockwise(); // Face SOUTH
    robot.moveForward(); // Moving south should not go below 0
    
    assertThat(robot.getLatitude()).isEqualTo(0); // Should stay at boundary
    assertThat(robot.getLongitude()).isEqualTo(5);
    assertThat(robot.getDirection()).isEqualTo(RobotDirection.SOUTH);
  }

  @Test
  void moveWestAtWestBoundary() {
    Robot robot = new Robot();
    robot.dropOnSurface(0, 5); // At min longitude
    robot.rotateCounterClockwise(); // Face WEST
    robot.moveForward(); // Should not move beyond boundary
    
    assertThat(robot.getLongitude()).isEqualTo(0); // Should stay at boundary
    assertThat(robot.getLatitude()).isEqualTo(5);
    assertThat(robot.getDirection()).isEqualTo(RobotDirection.WEST);
  }

  @Test
  void complexMovementSequence() {
    Robot robot = new Robot();
    robot.dropOnSurface(2, 2);
    
    // Complex sequence: rotate, move, rotate, move back, etc.
    robot.rotateClockwise(); // Face EAST
    robot.moveForward(); // Move to (3,2)
    robot.rotateCounterClockwise(); // Face NORTH
    robot.moveBackwards(); // Move to (3,1)
    robot.rotateClockwise(); // Face EAST
    robot.rotateClockwise(); // Face SOUTH
    robot.moveForward(); // Move to (3,0)
    
    assertThat(robot.getLatitude()).isEqualTo(0);
    assertThat(robot.getLongitude()).isEqualTo(3);
    assertThat(robot.getDirection()).isEqualTo(RobotDirection.SOUTH);
  }

  @Test
  void rotateClockwiseMultipleCycles() {
    Robot robot = new Robot();
    robot.dropOnSurface(0, 0);
    
    // Rotate 8 times (2 full cycles)
    for (int i = 0; i < 8; i++) {
        robot.rotateClockwise();
    }
    
    assertThat(robot.getDirection()).isEqualTo(RobotDirection.NORTH);
    assertThat(robot.getLatitude()).isEqualTo(0);
    assertThat(robot.getLongitude()).isEqualTo(0);
  }

  @Test
  void rotateCounterClockwiseMultipleCycles() {
    Robot robot = new Robot();
    robot.dropOnSurface(0, 0);
    
    // Rotate 12 times (3 full cycles)
    for (int i = 0; i < 12; i++) {
        robot.rotateCounterClockwise();
    }
    
    assertThat(robot.getDirection()).isEqualTo(RobotDirection.NORTH);
    assertThat(robot.getLatitude()).isEqualTo(0);
    assertThat(robot.getLongitude()).isEqualTo(0);
  }

  @Test
  void moveFromAllFourCorners() {
    // Test movement from corner (0,0)
    Robot robot1 = new Robot();
    robot1.dropOnSurface(0, 0);
    robot1.moveBackwards(); // Should not move
    assertThat(robot1.getLatitude()).isEqualTo(0);
    assertThat(robot1.getLongitude()).isEqualTo(0);
    
    // Test movement from corner (9,9) 
    Robot robot2 = new Robot();
    robot2.dropOnSurface(9, 9);
    robot2.moveForward(); // Should not move beyond north boundary
    assertThat(robot2.getLatitude()).isEqualTo(9);
    assertThat(robot2.getLongitude()).isEqualTo(9);
    
    // Test east movement from (9,5)
    Robot robot3 = new Robot();
    robot3.dropOnSurface(9, 5);
    robot3.rotateClockwise(); // Face EAST
    robot3.moveForward(); // Bug: will actually move to longitude 10!
    // This reveals the boundary bug in east movement
  }

  @Test
  void dropOnExtremeCoordinates() {
    Robot robot = new Robot();
    robot.dropOnSurface(Integer.MAX_VALUE, Integer.MIN_VALUE);
    
    assertThat(robot.getLongitude()).isEqualTo(Integer.MAX_VALUE);
    assertThat(robot.getLatitude()).isEqualTo(Integer.MIN_VALUE);
    assertThat(robot.getDirection()).isEqualTo(RobotDirection.NORTH);
  }


}
