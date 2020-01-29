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
    ----------LIC 9 tests----------------
    testLic9PointCollideWithVertexReturnFalse();
    testLic9ReturnTrue();
    testLic9ReturnFalse();
    testLic9ReturnTrue2();
    testLic9NegativePointsReturnTrue();
    testLic9PiPlusEpsilonAngle();
    testLic9AngelEqualsPiReturnFalse();
    */
    /*
    ------------LIC 10 tests-------------
    testLic10LargerAreaReturnTrue();
    testLic10EqualAreaReturnFalse();
    testLic10LargeTriangelReturnTrue();
    testLic10SecondTriangelLargerReturnTrue();
    testLic10TooFewPointsReturnFalse();
    */
    /*
    -------------LIC 11 tests-------------

    testLic11NegativeXReturnFalse();
    testLic11NegativeXReturnTrue();
    testLic11ReturnTrue();
    testLic11TooFewPointsReturnFalse();

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
  */

  // LIC12 tests
  //testLic12ReturnTrue();
  //testLic12ReturnFalse();

  // LIC13 tests
  //testLic13ReturnTrue();
  //testLic13ReturnFalse();

  // LIC14 tests
  //testLic14ReturnTrue();
  //testLic14ReturnTrue2();

  /*---------------PUM test---------
  testPUMTrue();
  testPUMTrueCmvAllFalse();
  testPUMFalse();
  testPUMAndFalse();*/

  /*-----------Test Decide-------------*/
  //TestDecideFalse1();
  //TestDecideTrue1();
  TestDecideFalseTooFewPointsForSomeLic();

  }

  //--------------Test Decide-----------
  //Tests that all the functions can handle a small amount of points.
  public void TestDecideFalseTooFewPointsForSomeLic(){
    run.points = new Point[2];
    run.points[0] = new Point(0.0,0.0);
    run.points[1] = new Point(8.0,0.0);
    run.NUMPOINTS = 2;
    run.LENGTH1 = 1;
    run.RADIUS1 = 10;
    run.EPSILON = 1;
    run.AREA1 = 12;
    run.Q_PTS = 1;
    run.QUADS = 4;
    run.DIST = 1;
    run.N_PTS = 3;
    run.K_PTS = 2;
    run.A_PTS = 2;
    run.B_PTS = 2;
    run.C_PTS = 2;
    run.D_PTS = 2;
    run.E_PTS = 2;
    run.F_PTS = 2;
    run.G_PTS = 2;
    run.LENGTH2 = 3;
    run.RADIUS2 = 6;
    run.AREA2 = 2;

    for(int i=0; i<15; i++){
      for(int j=0; j<15; j++){
        run.lcm[i][j] = "ORR";
      }
      run.puv[i]=true;
    }

    if(run.decide()){
      System.out.println("TestDecideFalseTooFewPointsForSomeLic = false");
    }else{
      System.out.println("TestDecideFalseTooFewPointsForSomeLic = true");
    }

}
  //Test that the function returns true when all the entries in puv than corresponds
  //to a false lic is set to false
  public void TestDecideTrue1(){
    run.points = new Point[10];
    run.points[0] = new Point(0.0,0.0);
    run.points[1] = new Point(8.0,0.0);
    run.points[2] = new Point(3.0,0.0);
    run.points[3] = new Point(5.0,2.0);
    run.points[4] = new Point(-1.0,-3.0);
    run.points[5] = new Point(10.0,5.0);
    run.points[6] = new Point(0.0,-5.0);
    run.points[7] = new Point(2.0,4.0);
    run.points[8] = new Point(24.0,1.0);
    run.points[9] = new Point(0.0,7.0);
    run.NUMPOINTS = 10;
    run.LENGTH1 = 1;
    run.RADIUS1 = 10;
    run.EPSILON = 1;
    run.AREA1 = 12;
    run.Q_PTS = 1;
    run.QUADS = 4;
    run.DIST = 1;
    run.N_PTS = 3;
    run.K_PTS = 2;
    run.A_PTS = 2;
    run.B_PTS = 2;
    run.C_PTS = 2;
    run.D_PTS = 2;
    run.E_PTS = 2;
    run.F_PTS = 2;
    run.G_PTS = 2;
    run.LENGTH2 = 3;
    run.RADIUS2 = 6;
    run.AREA2 = 2;

    for(int i=0; i<15; i++){
      for(int j=0; j<15; j++){
        run.lcm[i][j] = "ORR";
      }
      run.puv[i]=true;
    }
    run.lcm[4][5]="NOTUSED";
    run.lcm[5][4]="NOTUSED";

    run.puv[5]=false;
    run.puv[12]=false;
    run.puv[14]=false;

    if(run.decide()){
      System.out.println("TestDecideTrue1 = true");
    }else{
      System.out.println("TestDecideTrue1 = false");
    }
}

  //test that a function that commands all to be correct returns false when all lics are not correct.
  public void TestDecideFalse1(){
    run.points = new Point[10];
    run.points[0] = new Point(0.0,0.0);
    run.points[1] = new Point(8.0,0.0);
    run.points[2] = new Point(3.0,0.0);
    run.points[3] = new Point(5.0,2.0);
    run.points[4] = new Point(-1.0,-3.0);
    run.points[5] = new Point(10.0,5.0);
    run.points[6] = new Point(0.0,-5.0);
    run.points[7] = new Point(2.0,4.0);
    run.points[8] = new Point(24.0,1.0);
    run.points[9] = new Point(0.0,7.0);
    run.NUMPOINTS = 10;
    run.LENGTH1 = 1;
    run.RADIUS1 = 10;
    run.EPSILON = 1;
    run.AREA1 = 12;
    run.Q_PTS = 1;
    run.QUADS = 4;
    run.DIST = 1;
    run.N_PTS = 3;
    run.K_PTS = 2;
    run.A_PTS = 2;
    run.B_PTS = 2;
    run.C_PTS = 2;
    run.D_PTS = 2;
    run.E_PTS = 2;
    run.F_PTS = 2;
    run.G_PTS = 2;
    run.LENGTH2 = 3;
    run.RADIUS2 = 6;
    run.AREA2 = 2;

    for(int i=0; i<15; i++){
      for(int j=0; j<15; j++){
        run.lcm[i][j] = "ANDD";
      }
      run.puv[i]=true;
    }
    run.puv[14]=false;

    if(run.decide()){
      System.out.println("TestDecideFalse1 = false");
    }else{
      System.out.println("TestDecideFalse1 = true");
    }

/*  See how every vector and matrix behaves
    for(int j=0; j<15; j++){
      System.out.println(run.cmv[j]);
    }
    System.out.println("\n");
    for(int i=0; i<15; i++){
      for(int j=0; j<15; j++){
        System.out.println(run.pum[i][j]);
      }
    }

    System.out.println("\n");
    for(int j=0; j<15; j++){
      System.out.println(run.fuv[j]);
    }

    System.out.println("\n");
    for(int j=0; j<15; j++){
      System.out.println(run.puv[j]);
    }*/
  }



  ///---------------PUM test---------
  //Pum contains only true, should output true
  public void testPUMTrue(){
    boolean[][] testPum = new boolean[15][15];
    run.cmv = new boolean[15];
    for(int i=0; i<15; i++){
      for(int j=0; j<15; j++){
        run.lcm[i][j] = "ANDD";
        testPum[i][j] = true;
      }
    }
    for(int j=0; j<15; j++){
      run.cmv[j] = true;
    }
    run.pum();
    if(Arrays.deepEquals(run.pum, testPum)){
      System.out.println("testPUM = true");
    }else{
      System.out.println("testPUM = false");
    }
  }

  //test that pum is true even if all cmv is false
  public void testPUMTrueCmvAllFalse(){
    boolean[][] testPum = new boolean[15][15];
    run.cmv = new boolean[15];
    for(int i=0; i<15; i++){
      for(int j=0; j<15; j++){
        run.lcm[i][j] = "NOTUSED";
        testPum[i][j] = true;
      }
    }
    for(int j=0; j<15; j++){
      run.cmv[j] = false;
    }
    run.pum();
    if(Arrays.deepEquals(run.pum, testPum)){
      System.out.println("testPUMTrueCmvAllFalse = true");
    }else{
      System.out.println("testPUMTrueCmvAllFalse = false");
    }
  }

  //test that pum has false entries, return false
  public void testPUMFalse(){
    boolean[][] testPum = new boolean[15][15];
    run.cmv = new boolean[15];
    for(int i=0; i<15; i++){
      for(int j=0; j<15; j++){
        run.lcm[i][j] = "ORR";
        testPum[i][j] = true;
      }
    }
    boolean flag = true;
    for(int j=0; j<15; j++){
      if(flag){
        run.cmv[j]=true;
        flag = false;
      }else{
        run.cmv[j] = false;
        flag=true;
      }
    }
    run.pum();
    if(Arrays.deepEquals(run.pum, testPum)){
      System.out.println("testPUMFalse = false");
    }else{
      System.out.println("testPUMFalse = true");
    }
  }

  //test that pum is not true for all entries when one entrie in cmv is false
  public void testPUMAndFalse(){
    boolean[][] testPum = new boolean[15][15];
    run.cmv = new boolean[15];
    for(int i=0; i<15; i++){
      for(int j=0; j<15; j++){
        run.lcm[i][j] = "ANDD";
        testPum[i][j] = true;
      }
    }
    testPum[14][14] = false;
    boolean flag = true;
    for(int j=0; j<14; j++){
      run.cmv[j]=true;
    }
    run.cmv[14]=false;
    run.pum();
    if(Arrays.deepEquals(run.pum, testPum)){
      System.out.println("testPUMAndFalse = false");
    }else{
      System.out.println("testPUMAndFalse = true");
    }
  }


  //-------------------LIC11 tests -------------------------
  //test no set is true due to 0 !< 0 and double negation (-2--3=1), returns false
  public void testLic11NegativeXReturnFalse(){
    run.G_PTS=2;
    run.NUMPOINTS = 5;
    run.points = new Point[5];
    run.points[0]= new Point(0.0,0.0);
    run.points[1]= new Point(-3.0,0.0);
    run.points[2]= new Point(0.0,0.0);
    run.points[3]= new Point(0.0,0.0);
    run.points[4]= new Point(-2.0,2.0);
    if(run.lic11()){
      System.out.println("testLic11NegativeXReturnFalse = false");
    }else{
      System.out.println("testLic11NegativeXReturnFalse = true");
    }
  }
  //test where a double negative gives a negative answer, returns true
  public void testLic11NegativeXReturnTrue(){
    run.G_PTS=2;
    run.NUMPOINTS = 5;
    run.points = new Point[5];
    run.points[0]= new Point(0.0,0.0);
    run.points[1]= new Point(-1.0,0.0);
    run.points[2]= new Point(0.0,0.0);
    run.points[3]= new Point(0.0,0.0);
    run.points[4]= new Point(-2.0,2.0);
    if(run.lic11()){
      System.out.println("testLic11NegativeXReturnTrue = true");
    }else{
      System.out.println("testLic11NegativeXReturnTrue = false");
    }
  }

  //test when first set is false but second is true, returns true
  public void testLic11ReturnTrue(){
    run.G_PTS=2;
    run.NUMPOINTS = 5;
    run.points = new Point[5];
    run.points[0]= new Point(1.0,0.0);
    run.points[1]= new Point(0.0,0.0);
    run.points[2]= new Point(0.0,0.0);
    run.points[3]= new Point(-2.0,0.0);
    run.points[4]= new Point(0.0,2.0);
    if(run.lic11()){
      System.out.println("testLic11ReturnTrue = true");
    }else{
      System.out.println("testLic11XReturnTrue = false");
    }
  }

  //test with too few points, return false
  public void testLic11TooFewPointsReturnFalse(){
    run.G_PTS=2;
    run.NUMPOINTS = 3;
    run.points = new Point[3];
    run.points[0]= new Point(1.0,0.0);
    run.points[1]= new Point(0.0,0.0);
    run.points[2]= new Point(0.0,0.0);
    if(run.lic11()){
      System.out.println("testLic11TooFewPointsReturnFalse = false");
    }else{
      System.out.println("testLic11TooFewPointsReturnFalse = true");
    }
  }
  //-------------------LIC10 tests -------------------------
  //test that the area of a triangel with vertices (-1,0), (1,0) and (0,1) is greater than 0.5, returns true
  public void testLic10LargerAreaReturnTrue(){
    run.E_PTS=1;
    run.F_PTS=1;
    run.AREA1=0.5;
    run.NUMPOINTS=5;
    run.points = new Point[5];
    run.points[0]= new Point(-1.0,0.0);
    run.points[1]= new Point(-3.0,0.0);
    run.points[2]= new Point(1.0,0.0);
    run.points[3]= new Point(0.0,0.0);
    run.points[4]= new Point(0.0,1.0);
    if(run.lic10()){
      System.out.println("testLic10LargerAreaReturnTrue = true");
    }else{
      System.out.println("testLic10LargerAreaReturnTrue = false");
    }
  }

  //test that a triangel of equal area as AREA1 returns false
  public void testLic10EqualAreaReturnFalse(){
    run.E_PTS=1;
    run.F_PTS=1;
    run.AREA1=0.5;
    run.NUMPOINTS=5;
    run.points = new Point[5];
    run.points[0]= new Point(0.0,0.0);
    run.points[1]= new Point(-3.0,0.0);
    run.points[2]= new Point(1.0,0.0);
    run.points[3]= new Point(0.0,0.0);
    run.points[4]= new Point(0.0,1.0);
    if(run.lic10()){
      System.out.println("testLic10EqualAreaReturnFalse = false");
    }else{
      System.out.println("testLic10EqualAreaReturnFalse = true");
    }
  }
  //test that a large triangel of size 317 is larger than 316, returns true
  public void testLic10LargeTriangelReturnTrue(){
    run.E_PTS=1;
    run.F_PTS=2;
    run.AREA1=316;
    run.NUMPOINTS=7;
    run.points = new Point[7];
    run.points[0]= new Point(0.0,0.0);
    run.points[1]= new Point(18.0,-7.0);
    run.points[2]= new Point(1.0,0.0);
    run.points[3]= new Point(35.0,14.0);
    run.points[4]= new Point(0.0,1.0);
    run.points[5]= new Point(0.0,1.0);
    run.points[6]= new Point(49.0,-6.0);
    if(run.lic10()){
      System.out.println("testLic10LargeTriangelReturnTrue = true");
    }else{
      System.out.println("testLic10LargeTriangelReturnTrue = false");
    }
  }
  //Test that first triangel is smaller than AREA1, but second is larger, function returns true
  public void testLic10SecondTriangelLargerReturnTrue(){
    run.E_PTS=1;
    run.F_PTS=2;
    run.AREA1=11.5;
    run.NUMPOINTS=7;
    run.points = new Point[7];
    run.points[0]= new Point(0.0,0.0);
    run.points[1]= new Point(1.0,5.0);
    run.points[2]= new Point(1.0,0.0);
    run.points[3]= new Point(-3.0,1.0);
    run.points[4]= new Point(0.0,1.0);
    run.points[5]= new Point(0.0,1.0);
    run.points[6]= new Point(-2.0,8.0);
    if(run.lic10()){
      System.out.println("testLic10SecondTriangelLargerReturnTrue = true");
    }else{
      System.out.println("testLic10SecondTriangelLargerReturnTrue = false");
    }
  }
  //test too few points, return false
  public void testLic10TooFewPointsReturnFalse(){
    run.E_PTS=1;
    run.F_PTS=2;
    run.AREA1=3;
    run.NUMPOINTS=5;
    run.points = new Point[5];
    run.points[0]= new Point(0.0,0.0);
    run.points[1]= new Point(1.0,5.0);
    run.points[2]= new Point(1.0,0.0);
    run.points[3]= new Point(-3.0,1.0);
    run.points[4]= new Point(0.0,1.0);
    if(run.lic10()){
      System.out.println("testLic10TooFewPointsReturnFalse = false");
    }else{
      System.out.println("testLic10TooFewPointsReturnFalse = true");
    }
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

  public void testLic14ReturnTrue2(){
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
