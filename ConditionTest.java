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

    // LIC0 tests
	testLic0ReturnTrue();
	testLic0ReturnFalse();

  // LIC1 tests
	testLic1ReturnTrue();
  testLic1ReturnFalse();
  
  // LIC2 tests
	testLic2ReturnTrue();
  testLic2ReturnFalse();
  
  // LIC3 tests
	testLic3ReturnTrue();
	testLic3ReturnFalse();
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

  //--------------LIC0-----------------
	public void testLic0ReturnTrue(){
		// points will be more than 1 apart
		run.LENGTH1 = 1;
		run.points = new Point[2];
		run.points[0]= new Point(0, 0);
		run.points[1]= new Point(5, 5);

		if(run.lic0()){
			System.out.println("testLic0ReturnTrue = true");
		}else{
			System.out.println("testLic0ReturnTrue = false");
		}
	}

	public void testLic0ReturnFalse(){
		// points will be less than 5 apart
		run.LENGTH1 = 5;
		run.points = new Point[2];
		run.points[0]= new Point(0, 0);
		run.points[1]= new Point(1, 1);

		if(run.lic0()){
			System.out.println("testLic0ReturnFalse = false");
		}else{
			System.out.println("testLic0ReturnFalse = true");
		}
  }
  
  //--------------LIC1-----------------
	public void testLic1ReturnTrue(){
		// all points can not be in or on circle
		run.RADIUS1 = 2;
		run.points = new Point[3];
		run.points[0]= new Point(0, 0);
		run.points[1]= new Point(6, 6);
		run.points[2]= new Point(-10, -10);

		if(run.lic1()){
			System.out.println("testLic1ReturnTrue = true");
		}else{
			System.out.println("testLic1ReturnTrue = false");
		}
	}

	public void testLic1ReturnFalse(){
		// all points will be in circle
		run.RADIUS1 = 4;
		run.points = new Point[3];
		run.points[0]= new Point(0, 0);
		run.points[1]= new Point(1, 1);
		run.points[2]= new Point(-1, -1);


		if(run.lic1()){
			System.out.println("testLic1ReturnFalse = false");
		}else{
			System.out.println("testLic1ReturnFalse = true");
		}
  }
  
  //--------------LIC2-----------------
	public void testLic2ReturnTrue(){
		// angle will be less than pi-0
		run.EPSILON = 0;
		run.points = new Point[3];
		run.points[0]= new Point(-1, 1);
		run.points[1]= new Point(0, 0);
		run.points[2]= new Point(1, 1);

		if(run.lic2()){
			System.out.println("testLic2ReturnTrue = true");
		}else{
			System.out.println("testLic2ReturnTrue = false");
		}
	}

	public void testLic2ReturnFalse(){
		// first point coincides with vertex, angle is undefined
		run.EPSILON = 0;
		run.points = new Point[3];
		run.points[0]= new Point(1, 1);
		run.points[1]= new Point(1, 1);
		run.points[2]= new Point(3, 3);

		if(run.lic2()){
			System.out.println("testLic2ReturnFalse = false");
		}else{
			System.out.println("testLic2ReturnFalse = true");
		}
  }
  
  	//--------------LIC3-----------------
	public void testLic3ReturnTrue(){
		// area will be 28, bigger than AREA1
		run.AREA1 = 1;
		run.points = new Point[3];
		run.points[0]= new Point(-2, -2);
		run.points[1]= new Point(4, 3);
		run.points[2]= new Point(-6, 4);

		if(run.lic2()){
			System.out.println("testLic3ReturnTrue = true");
		}else{
			System.out.println("testLic3ReturnTrue = false");
		}
	}

	public void testLic3ReturnFalse(){
		// collinear should fail
		run.AREA1 = 1;
		run.points = new Point[3];
		run.points[0]= new Point(1, 2);
		run.points[1]= new Point(2, 3);
		run.points[2]= new Point(5, 6);

		if(run.lic2()){
			System.out.println("testLic3ReturnFalse = false");
		}else{
			System.out.println("testLic3ReturnFalse = true");
		}
	}


}
