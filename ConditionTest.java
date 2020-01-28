import java.util.*;

public class ConditionTest{

  AntiMissileSystem run = new AntiMissileSystem();

  public static void main( String[] args ) {
    new ConditionTest();
  }

  ConditionTest(){
    testInCirclePointInLineReturnsTrue();
    testInCirclePointInLineReturnsFalse();
    testInCirclePointInLineWithLengthAsDiameterReturnsTrue();
    testInCirclePointSmallRadiusReturnsFalse();
    testInCirclePointLittleLargerCCRadiusReturnsFalse();
    testInCirclePointLittleSmallerCCRadiusReturnsTrue();
    testInCirclePointAllPointTheSameReturnsTrue();
    testInCirclePointTwoPointsTheSameReturnsTrue();
    testInCirclePointTwoPointsTheSameReturnsFalse();

  }

  //--------------------Circle test---------------

  //three point that form a line with length less than diameter is in the circle
  public void testInCirclePointInLineReturnsTrue(){
    Point p1 = new Point(0.0,0.0);
    Point p2 = new Point(1.0,1.0);
    Point p3 = new Point(2.0,2.0);
    double r = 2.0;
    if(run.pointsInCircle(p1, p2, p3, r)){
      System.out.println("testInCirclePointInLineReturnsTrue = True");
    }else{
      System.out.println("testInCirclePointInLineReturnsTrue = False");
    }
  }

  //three point that form a line with length larger than diameter is not in the circle
  public void testInCirclePointInLineReturnsFalse(){
    Point p1 = new Point(0.0,0.0);
    Point p2 = new Point(1.0,1.0);
    Point p3 = new Point(2.0,2.0);
    double r = 1.0;
    if(run.pointsInCircle(p1, p2, p3, r)){
      System.out.println("testInCirclePointInLineReturnsFalse = false");
    }else{
      System.out.println("testInCirclePointInLineReturnsFalse = true");
    }
  }

  //three point that form a line with length exactly like diameter, returns true
  public void testInCirclePointInLineWithLengthAsDiameterReturnsTrue(){
    Point p1 = new Point(0.0,0.0);
    Point p2 = new Point(1.0,0.0);
    Point p3 = new Point(2.0,0.0);
    double r = 1.0;
    if(run.pointsInCircle(p1, p2, p3, r)){
      System.out.println("testInCirclePointInLineWithLengthAsDiameterReturnsTrue = true");
    }else{
      System.out.println("testInCirclePointInLineWithLengthAsDiameterReturnsTrue = false");
    }
  }

  //three points that do not fit in a circle
  public void testInCirclePointSmallRadiusReturnsFalse(){
    Point p1 = new Point(0.0,0.0);
    Point p2 = new Point(1.0,0.0);
    Point p3 = new Point(0.0,5.0);
    double r = 1.0;
    if(run.pointsInCircle(p1, p2, p3, r)){
      System.out.println("testInCirclePointSmallRadiusReturnsFalse = false");
    }else{
      System.out.println("testInCirclePointSmallRadiusReturnsFalse = true");
    }
  }

  //three points that have a CC-radius larger than radius
  public void testInCirclePointLittleLargerCCRadiusReturnsFalse(){
    Point p1 = new Point(0.0,0.0);
    Point p2 = new Point(1.0,0.0);
    Point p3 = new Point(0.0,5.0);
    double r = 2.5;
    if(run.pointsInCircle(p1, p2, p3, r)){
      System.out.println("testInCirclePointLittleLargerCCRadiusReturnsFalse = false");
    }else{
      System.out.println("testInCirclePointLittleLargerCCRadiusReturnsFalse = true");
    }
  }

  //three points that have a CC-radius smaller than radius
  public void testInCirclePointLittleSmallerCCRadiusReturnsTrue(){
    Point p1 = new Point(0.0,0.0);
    Point p2 = new Point(1.0,0.0);
    Point p3 = new Point(0.0,5.0);
    double r = 2.6;
    if(run.pointsInCircle(p1, p2, p3, r)){
      System.out.println("testInCirclePointLittleSmallerCCRadiusReturnsTrue = true");
    }else{
      System.out.println("testInCirclePointLittleSmallerCCRadiusReturnsTrue = false");
    }
  }

  //if all the points is the same, they fit in any circle
  public void testInCirclePointAllPointTheSameReturnsTrue(){
    Point p1 = new Point(5.0,1.0);
    Point p2 = new Point(5.0,1.0);
    Point p3 = new Point(5.0,1.0);
    double r = 2.6;
      if(run.pointsInCircle(p1, p2, p3, r)){
        System.out.println("testInCirclePointAllPointTheSameReturnsTrue = true");
      }else{
        System.out.println("testInCirclePointAllPointTheSameReturnsTrue = false");
      }
  }

  //two points are the same point, and the distance to the third one is smaller than diameter
  public void testInCirclePointTwoPointsTheSameReturnsTrue(){
    Point p1 = new Point(5.0,1.0);
    Point p2 = new Point(5.0,1.0);
    Point p3 = new Point(9.0,2.0);
    double r = 3.0;
    if(run.pointsInCircle(p1, p2, p3, r)){
      System.out.println("testInCirclePointTwoPointsTheSameReturnsTrue = True");
    }else{
      System.out.println("testInCirclePointTwoPointsTheSameReturnsTrue = false");
    }
  }

  //two points are the same point, and the distance to the third one is larger than diameter
  public void testInCirclePointTwoPointsTheSameReturnsFalse(){
    Point p1 = new Point(5.0,1.0);
    Point p2 = new Point(5.0,1.0);
    Point p3 = new Point(9.0,2.0);
    double r = 2.0;
    if(run.pointsInCircle(p1, p2, p3, r)){
      System.out.println("testInCirclePointTwoPointsTheSameReturnsFalse = False");
    }else{
      System.out.println("testInCirclePointTwoPointsTheSameReturnsFalse = true");
    }
  }

  public void testLic12ReturnTrue(){
    // there exist points seperated by K_PTS farther than LENGTH1 and closer than LENGTH2
    run.NUMPOINTS = 3;
    run.K_PTS = 1;
    run.LENGTH1 = 2;
    run.LENGTH2 = 3;

		run.points = new Point[5];
		run.points[0]= new Point(0, 0);
		run.points[1]= new Point(6, 6);
		run.points[2]= new Point(2, 2);

		if (run.lic12()) {
			System.out.println("testLic12ReturnTrue = true");
		} else {
			System.out.println("testLic12ReturnTrue = false");
		}
	}

  public void testLic12ReturnFalse(){
		// there do not exist points seperated by K_PTS farther than LENGTH1 and closer than LENGTH2
    run.NUMPOINTS = 3;
    run.K_PTS = 1;
    run.LENGTH1 = 2;
    run.LENGTH2 = 3;

		run.points = new Point[5];
		run.points[0]= new Point(0, 0);
		run.points[1]= new Point(0, 0);
		run.points[2]= new Point(0, 0);

		if (run.lic12()) {
			System.out.println("testLic12ReturnFalse = true");
		} else {
			System.out.println("testLic12ReturnFalse = false");
		}
	}

  public void testLic13ReturnTrue(){
		// there exist points seperated by A_PTS and B_PTS that lie outside a circle of RADIUS1 and inside a circle of RADIUS2
    run.NUMPOINTS = 5;
    run.A_PTS = 1;
    run.B_PTS = 1;
    run.RADIUS1 = 1;
    run.RADIUS2 = 3;

		run.points = new Point[5];
		run.points[0]= new Point(0, 0);
		run.points[1]= new Point(0, 0);
		run.points[2]= new Point(2, 0);
    run.points[3]= new Point(0, 0);
    run.points[4]= new Point(0, 2);

		if (run.lic13()) {
			System.out.println("testLic13ReturnTrue = true");
		} else {
			System.out.println("testLic13ReturnTrue = false");
		}
	}

  public void testLic13ReturnFalse(){
    // there do not exist points seperated by A_PTS and B_PTS that lie outside a circle of RADIUS1 and inside a circle of RADIUS2
    run.NUMPOINTS = 5;
    run.A_PTS = 1;
    run.B_PTS = 1;
    run.RADIUS1 = 1;
    run.RADIUS2 = 3;

		run.points = new Point[5];
		run.points[0]= new Point(0, 0);
		run.points[1]= new Point(0, 0);
		run.points[2]= new Point(0, 0);
    run.points[3]= new Point(0, 0);
    run.points[4]= new Point(0, 0);

		if (run.lic13()) {
			System.out.println("testLic1ReturnFalse = true");
		} else {
			System.out.println("testLic1ReturnFalse = false");
		}
	}

  public void testLic14ReturnTrue(){
    // there exist points seperated by E_PTS and F_PTS that create a triangle with area greater than AREA1 and less than AREA2
    run.NUMPOINTS = 5;
    run.E_PTS = 1;
    run.F_PTS = 1;
    run.AREA1 = 1;
    run.AREA2 = 3;

		run.points = new Point[5];
		run.points[0]= new Point(0, 0);
		run.points[1]= new Point(0, 0);
		run.points[2]= new Point(2, 0);
    run.points[3]= new Point(0, 0);
    run.points[4]= new Point(0, 2);

		if (run.lic14()) {
			System.out.println("testLic14ReturnTrue = true");
		} else {
			System.out.println("testLic14ReturnTrue = false");
		}
	}

  public void testLic14ReturnTrue(){
    // there exist points seperated by E_PTS and F_PTS that create a triangle with area greater than AREA1 and less than AREA2
    run.NUMPOINTS = 5;
    run.E_PTS = 1;
    run.F_PTS = 1;
    run.AREA1 = 1;
    run.AREA2 = 3;

		run.points = new Point[5];
		run.points[0]= new Point(0, 0);
		run.points[1]= new Point(0, 0);
		run.points[2]= new Point(0, 0);
    run.points[3]= new Point(0, 0);
    run.points[4]= new Point(0, 0);

		if (run.lic14()) {
			System.out.println("testLic14ReturnFalse = true");
		} else {
			System.out.println("testLic14ReturnFalse = false");
		}
	}

}
