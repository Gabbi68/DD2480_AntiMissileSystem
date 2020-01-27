import java.util.*;

public class ConditionTest{

  AntiMissileSystem run = new AntiMissileSystem();

  public static void main( String[] args ) {
    new ConditionTest();
  }

  ConditionTest(){
    /*
    -------Circle test---------------
    testInCirclePointInLineReturnsTrue();
    testInCirclePointInLineReturnsFalse();
    testInCirclePointInLineWithLengthAsDiameterReturnsTrue();
    testInCirclePointSmallRadiusReturnsFalse();
    testInCirclePointLittleLargerCCRadiusReturnsFalse();
    testInCirclePointLittleSmallerCCRadiusReturnsTrue();
    testInCirclePointAllPointTheSameReturnsTrue();
    testInCirclePointTwoPointsTheSameReturnsTrue();
    testInCirclePointTwoPointsTheSameReturnsFalse();
    */
    /*
    ----------LIC 8 tests-------------------------
    testLic8ReturnTrue();
    testLic8ReturnFalse();
    testLic8TooFewPointReturnFalse();
    testLic8ReturnTrue2();
    */
    /*
    ----------LIC 9 tests----------------*/
    testLic9PointCollideWithVertexReturnFalse();
    testLic9ReturnTrue();
    testLic9ReturnFalse();
    testLic9ReturnTrue2();
    testLic9NegativePointsReturnTrue();
    testLic9PiPlusEpsilonAngle();
    testLic9AngelEqualsPiReturnFalse();
  }

  //-------------------LIC9 tests -------------------------
  //first point collide with vertex, function returns false
  public void testLic9PointCollideWithVertexReturnFalse(){
    run.C_PTS = 1;
    run.D_PTS = 1;
    run.EPSILON = 0.5;
    run.NUMPOINTS = 5;
    run.points = new Point[5];
    run.points[0]= new Point(0.0,0.0);
    run.points[1]= new Point(0.0,0.0);
    run.points[2]= new Point(0.0,0.0);
    run.points[3]= new Point(0.0,0.0);
    run.points[4]= new Point(2.0,2.0);
    if(run.lic9()){
      System.out.println("testLic9PointCollideWithVertexReturnFalse = false");
    }else{
      System.out.println("testLic9PointCollideWithVertexReturnFalse = true");
    }
  }
  //45 degree angle is less than 90 degree, function returns true
  public void testLic9ReturnTrue(){
    run.C_PTS = 1;
    run.D_PTS = 1;
    run.EPSILON = run.PI/2;
    run.NUMPOINTS = 5;
    run.points = new Point[5];
    run.points[0]= new Point(1.0,1.0);
    run.points[1]= new Point(0.0,0.0);
    run.points[2]= new Point(0.0,0.0);
    run.points[3]= new Point(0.0,0.0);
    run.points[4]= new Point(1.0,0.0);
    if(run.lic9()){
      System.out.println("testLic9ReturnTrue = true");
    }else{
      System.out.println("testLic9ReturnTrue = false");
    }
  }
  //45 degree is larger than PI-3 degrees but less than PI+3 segrees, function return false
  public void testLic9ReturnFalse(){
    run.C_PTS = 1;
    run.D_PTS = 1;
    run.EPSILON = 3;
    run.NUMPOINTS = 5;
    run.points = new Point[5];
    run.points[0]= new Point(1.0,1.0);
    run.points[1]= new Point(0.0,0.0);
    run.points[2]= new Point(0.0,0.0);
    run.points[3]= new Point(0.0,0.0);
    run.points[4]= new Point(1.0,0.0);
    if(run.lic9()){
      System.out.println("testLic9ReturnFalse = false");
    }else{
      System.out.println("testLic9ReturnFalse = true");
    }
  }

  //In first set, a and b collide, second set follow the condition
  public void testLic9ReturnTrue2(){
    run.C_PTS = 1;
    run.D_PTS = 1;
    run.EPSILON = 1;
    run.NUMPOINTS = 6;
    run.points = new Point[6];
    run.points[0]= new Point(0.0,0.0);
    run.points[1]= new Point(1.0,1.0);
    run.points[2]= new Point(0.0,0.0);
    run.points[3]= new Point(0.0,0.0);
    run.points[4]= new Point(0.0,0.0);
    run.points[5]= new Point(1.0,0.0);
    if(run.lic9()){
      System.out.println("testLic9ReturnTrue2 = true");
    }else{
      System.out.println("testLic9ReturnTrue2 = false");
    }
  }

  //Points on the 3rd quadrant satisfy conditions
  public void testLic9NegativePointsReturnTrue(){
    run.C_PTS = 1;
    run.D_PTS = 1;
    run.EPSILON = 1;
    run.NUMPOINTS = 6;
    run.points = new Point[6];
    run.points[0]= new Point(0.0,0.0);
    run.points[1]= new Point(-1.0,-1.0);
    run.points[2]= new Point(0.0,0.0);
    run.points[3]= new Point(0.0,0.0);
    run.points[4]= new Point(0.0,0.0);
    run.points[5]= new Point(-1.0,0.0);
    if(run.lic9()){
      System.out.println("testLic9NegativePointsReturnTrue = true");
    }else{
      System.out.println("testLic9NegativePointsReturnTrue = false");
    }
  }

  //test angel that satify angle>PI+EPSILON
  public void testLic9PiPlusEpsilonAngle(){
    run.C_PTS = 1;
    run.D_PTS = 1;
    run.EPSILON = 0.5;
    run.NUMPOINTS = 6;
    run.points = new Point[6];
    run.points[0]= new Point(1.0,0.0);
    run.points[1]= new Point(-1.0,-1.0);
    run.points[2]= new Point(0.0,0.0);
    run.points[3]= new Point(1.0,0.0);
    run.points[4]= new Point(0.0,-1.0);
    run.points[5]= new Point(-1.0,0.0);
    if(run.lic9()){
      System.out.println("testLic9PiPlusEpsilonAngle = true");
    }else{
      System.out.println("testLic9PiPlusEpsilonAngle = false");
    }
  }

  //Test if angle is equal to PI+EPSILON and PI-EPSILON, return false
  public void testLic9AngelEqualsPiReturnFalse(){
    run.C_PTS = 1;
    run.D_PTS = 1;
    run.EPSILON = 0.0;
    run.NUMPOINTS = 5;
    run.points = new Point[5];
    run.points[0]= new Point(1.0,0.0);
    run.points[1]= new Point(-1.0,-1.0);
    run.points[2]= new Point(0.0,0.0);
    run.points[3]= new Point(1.0,0.0);
    run.points[4]= new Point(-1.0,0.0);
    if(run.lic9()){
      System.out.println("testLic9AngelEqualsPiReturnFalse = false");
    }else{
      System.out.println("testLic9AngelEqualsPiReturnFalse = true");
    }
  }


  //-------------------LIC8 tests -------------------------
  //a set of three points that satify all the contraints
  public void testLic8ReturnTrue(){
    run.A_PTS = 1;
    run.B_PTS = 1;
    run.RADIUS1 = 1;
    run.NUMPOINTS = 5;
    run.points = new Point[5];
    run.points[0]= new Point(0.0,0.0);
    run.points[1]= new Point(0.0,0.0);
    run.points[2]= new Point(1.0,1.0);
    run.points[3]= new Point(0.0,0.0);
    run.points[4]= new Point(2.0,2.0);
    if(run.lic8()){
      System.out.println("testLic8ReturnTrue = true");
    }else{
      System.out.println("testLic8ReturnTrue = false");
    }
  }

  //set of points that do not satisfy the constraints, a line with length>diameter
  public void testLic8ReturnFalse(){
    run.A_PTS = 1;
    run.B_PTS = 1;
    run.RADIUS1 = 2;
    run.NUMPOINTS = 5;
    run.points = new Point[5];
    run.points[0]= new Point(0.0,0.0);
    run.points[1]= new Point(0.0,0.0);
    run.points[2]= new Point(1.0,1.0);
    run.points[3]= new Point(0.0,0.0);
    run.points[4]= new Point(2.0,2.0);
    if(run.lic8()){
      System.out.println("testLic8ReturnFalse= false");
    }else{
      System.out.println("testLic8ReturnFalse = true");
    }
  }

  //too few points in the test case
  public void testLic8TooFewPointReturnFalse(){
    run.A_PTS = 1;
    run.B_PTS = 1;
    run.RADIUS1 = 2;
    run.points = new Point[4];
    run.NUMPOINTS = 4;
    run.points[0]= new Point(0.0,0.0);
    run.points[1]= new Point(0.0,0.0);
    run.points[2]= new Point(1.0,1.0);
    run.points[3]= new Point(0.0,0.0);
    if(run.lic8()){
      System.out.println("testLic8TooFewPointReturnFalse= false");
    }else{
      System.out.println("testLic8TooFewPointReturnFalse = true");
    }
  }

//test that first set is wrong, but second set satisfy the conditions
  public void testLic8ReturnTrue2(){
    run.A_PTS = 1;
    run.B_PTS = 1;
    run.RADIUS1 = 2;
    run.points = new Point[6];
    run.NUMPOINTS = 6;
    run.points[0]= new Point(0.0,0.0);
    run.points[1]= new Point(0.0,0.0);
    run.points[2]= new Point(1.0,1.0);
    run.points[3]= new Point(0.0,0.0);
    run.points[4]= new Point(2.0,3.0);
    run.points[5]= new Point(5.0,0.0);
    if(run.lic8()){
      System.out.println("testLic8ReturnTrue2= true");
    }else{
      System.out.println("testLic8ReturnTrue2 = false");
    }
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
}
