import java.lang.*;

import java.util.*;


public class AntiMissileSystem{

//Global variables
double PI = Math.PI;
boolean[] lic = new boolean[15];


boolean[] cmv = new boolean[15];

boolean[][] pum;
// final unlocking vector
boolean[] fuv = {true, true,true,true,true,true,true,true,true,true,true,true,true,true,true};// = fuv();
// array with numpoints
Point[] points = {new Point(0, 1), new Point(1, 2), new Point(3, 4), new Point(3, 4), new Point(3, 8)};

String[][] lcm = new String[15][15];


int NUMPOINTS = points.length;
double LENGTH1 = 1;
double RADIUS1 = 1;
double EPSILON = 1;
double AREA1 = 1;
int Q_PTS = 1;
int QUADS = 4;
double DIST = 1;
int N_PTS = 3;
int K_PTS = 2;
int A_PTS = 2;
int B_PTS = 2;
int C_PTS = 2;
int D_PTS = 2;
int E_PTS = 2;
int F_PTS = 2;
int G_PTS = 2;
double LENGTH2 = 3;
double RADIUS2 = 4;
double AREA2 = 2;



  public static void main( String[] args ) {
    AntiMissileSystem run = new AntiMissileSystem();
    run.decide();
  }

  // function that decides if missile should be launched
  public boolean decide(){
    cmv = cmv();
    pum = pum();

    for (int i = 0; i < 15; i++) {
      for (int j = 0; j < 15; j++) {
        lcm[i][j] = "ANDD";
      }
    }

    fuv = setFuv();

    for (int i = 0; i < 15; i++) {
      if (!fuv[i]) {
        System.out.println("NO");
        return false;
      }
    }
    System.out.println("YES");
    return true;
  }

  // function that creates and returns pum
  public boolean[][] pum(){
    pum = new boolean[15][15];
    for(int i=0; i<15; i++){
      for(int j=0; j<15; j++){
        if(lcm[i][j]=="NOTUSED"){
          pum[i][j]=true;
        }else if(lcm[i][j]=="ANDD"){
          if(cmv[i] && cmv[j]){
            pum[i][j]=true;
          }else{
            pum[i][j]=false;
          }
        }else if(lcm[i][j]=="ORR"){
          if(cmv[i] || cmv[j]){
            pum[i][j]=true;
          }else{
            pum[i][j]=false;
          }
        }
      }
    }
    return pum;
  }

  // function that creates cmv, every entry in cmv is the result from the corresponding lic
  public boolean[] cmv(){  
    cmv[0]=lic0();
    cmv[1]=lic1();
    cmv[2]=lic2();
    cmv[3]=lic3();
    cmv[4]=lic4();
    cmv[5]=lic5();
    cmv[6]=lic6();
    cmv[7]=lic7();
    cmv[8]=lic8();
    cmv[9]=lic9();
    cmv[10]=lic10();
    cmv[11]=lic11();
    cmv[12]=lic12();
    cmv[13]=lic13();
    cmv[14]=lic14();

    return cmv;
  }



  // Generates an array(boolean) that either contains true or false based on the input of PUV and PUM.
  //If PUV is false then FUV will we true, and if PUV is true and PUM row that is all true (PUV[0,x] x <=0 and > 15).
  //Then the FUV[0] will be true.
  //Based on FUV decide() will return YES if all are true and NO if any FUV is false.
  public void setFuv(){

    for(int i = 0; i < 14; i++){
      if (!puv[i]){
        fuv[i] = true;
      }else {
        int nrOfFalse = 0;
        for(int j = 0; j < 14; j++){
          if(!pum[i][j]){
            nrOfFalse++;
          }
        }
        if(nrOfFalse == 0){
          fuv[i] = true;
        }
      }
    }
  }

 // There exists at least one set of two consecutive data points that are a distance greater than the length, LENGTH1, apart
 public boolean lic0(){
  double dst;

  for (int i = 0; i < points.length-1; i++) {
      // distance formula
      dst = Math.sqrt(Math.pow(points[i+1].x - points[i].x, 2) + Math.pow(points[i+1].y - points[i].y, 2));
      if (dst > LENGTH1) {
          return true;
      }
  }
  return false;
}


  // There exists at least one set of three consecutive data points that cannot all
  // be contained within or on a circle of radius RADIUS1.
  public boolean lic1(){
    // not enough data points, just return false
    if (points.length <= 2) {
        return false;
    }

    for (int i = 0; i < points.length-2; i++) {
        // if points cannot be contained within a circle of radius RADIUS1
        if (pointsInCircle(points[i], points[i+1], points[i+2], RADIUS1) == false) {
            return true;
        }
    }
    return false;
  }


  // There exists at least one set of three consecutive data points which form an angle such that:
  // angle < (PI−EPSILON) or angle > (PI+EPSILON)
  public boolean lic2(){
  // assumption: angle should be in radians
  double angle;
  double ab;
  double bc;
  double ca;

  for (int i = 0; i < points.length-2; i++) {
      // if not enough data points, just return false
      if (points.length <= 2) {
          return false;
      }
      // if first or last point coincides with vertex, the angle is undefiend
      else if (points[i].x == points[i+1].x && points[i].y == points[i+1].y || points[i+2].x == points[i].x && points[i+2].y == points[i].y) {
          continue;
      }

      // check if three points create a line
      // http://mathworld.wolfram.com/Collinear.html
      if (((points[i].x * (points[i+1].y - points[i+2].y)) + (points[i+1].x * (points[i+2].y - points[i].y)) + (points[i+2].x * (points[i].y - points[i+1].y))) == 0) {
          angle = PI;
      } else {
            // calculate line ab
          ab = Math.sqrt(Math.pow(points[i+1].x - points[i].x, 2) + Math.pow(points[i+1].y - points[i].y, 2));
          // calculate line bc
          bc = Math.sqrt(Math.pow(points[i+1].x - points[i+2].x, 2) + Math.pow(points[i+1].y - points[i+2].y, 2));
          // calculate line ca
          ca = Math.sqrt(Math.pow(points[i].x - points[i+2].x, 2) + Math.pow(points[i].y - points[i+2].y, 2));
          // calculate angle for B
          // https://en.wikipedia.org/wiki/Law_of_cosines
          angle = Math.acos((Math.pow(ca,2) - Math.pow(bc,2) - Math.pow(ab,2)) /(-2*bc * ab));
      }

      if ((angle < (PI - EPSILON)) || (angle > (PI + EPSILON))) {
          return true;
      }
  }
  return false;
  }



  // There exists at least one set of three consecutive data points that are
  // the vertices of a triangle with area greater than AREA1.
  public boolean lic3(){
    double triangle_area;
    double ab;
    double bc;
    double ca;
    double s;

    for (int i = 0; i < points.length-2; i++) {
        // if less than 3 points it's not possible to create a triangle
        if (points.length <= 2) {
            return false;
        }
        // check if three points create a line
        // http://mathworld.wolfram.com/Collinear.html
        if (((points[i].x * (points[i+1].y - points[i+2].y)) + (points[i+1].x * (points[i+2].y - points[i].y)) + (points[i+2].x * (points[i].y - points[i+1].y))) == 0) {
            continue;
        }

        // calculate line ab
        ab = Math.sqrt(Math.pow(points[i+1].x - points[i].x, 2) + Math.pow(points[i+1].y - points[i].y, 2));
        // calculate line bc
        bc = Math.sqrt(Math.pow(points[i+1].x - points[i+2].x, 2) + Math.pow(points[i+1].y - points[i+2].y, 2));
        // calculate line ca
        ca = Math.sqrt(Math.pow(points[i].x - points[i+2].x, 2) + Math.pow(points[i].y - points[i+2].y, 2));
        // Semiperimeter
        s = (ab + bc + ca) / 2;
        // https://en.wikipedia.org/wiki/Heron%27s_formula
        triangle_area = Math.sqrt(s * (s-ab) * (s-bc) * (s-ca));

        if (triangle_area > AREA1) {
            return true;
        }
    }
    return false;
  }

  
    //There exists at least one set of Q PTS consecutive data points that lie in more than QUADS
  //quadrants. Where there is ambiguity as to which quadrant contains a given point, priority
  //of decision will be by quadrant number, i.e., I, II, III, IV. For example, the data point (0,0)
  //is in quadrant I, the point (-l,0) is in quadrant II, the point (0,-l) is in quadrant III, the point
  //(0,1) is in quadrant I and the point (1,0) is in quadrant I.
  //(2 ≤ Q PTS ≤ NUMPOINTS), (1 ≤ QUADS ≤ 3) :issue #12
  
  public boolean lic4(){

    if(2 < Q_PTS || Q_PTS > NUMPOINTS || QUADS < 1 || QUADS > 3){
      return false;
    }




    for (int i = 0; i <= (NUMPOINTS-Q_PTS); i++) {
      ArrayList<Point> consecPoints = new ArrayList<>();
      for (int j = i; j < (Q_PTS+i); j++) {
        consecPoints.add(points[j]);
      }
      boolean[] diffQuads = new boolean[4];
      int nrInDiffQuads = 0;

      for (int z = 0; z < consecPoints.toArray().length;) {

        if (consecPoints.get(z).x >= 0){
          if(consecPoints.get(z).y >= 0){
            diffQuads[0] = true;

          }else if (consecPoints.get(z).x == 0 && (consecPoints.get(z).y < 0){
            diffQuads[2] = true;

          }else {
            diffQuads[3] = true;
          }

        }else {
          if (consecPoints.get(z).y >= 0) {
            diffQuads[1] = true;

          }else {
            diffQuads[2] = true;
          }
        }
        z++;
      }


      for (int j = 0; j < diffQuads.length;) {
        if (diffQuads[j]) {
          nrInDiffQuads++;
        }
        if (nrInDiffQuads > QUADS) {
          return true;
        }
        j++;
      }
    }

    return false;


  }


  //There exists at least one set of two consecutive data points, (X[i],Y[i]) and (X[j],Y[j]), such
  //that X[j] - X[i] < 0. (where i = j-1) :issue #13
  
  public boolean lic5(){
    Point point1;
    Point point2;

    for(int i = 0; i < (points.length - 1);i++){
      point1 = points[i];
      point2 = points[i+1];

      if((point2.x - point1.x) < 0){
        return true;
      }

    }
    return false;
  }

  //There exists at least one set of N PTS consecutive data points such that at least one of the
  //points lies a distance greater than DIST from the line joining the first and last of these N PTS
  //points. If the first and last points of these N PTS are identical, then the calculated distance
  //to compare with DIST will be the distance from the coincident point to all other points of
  //the N PTS consecutive points. The condition is not met when NUMPOINTS < 3.
  //(3 ≤ N PTS ≤ NUMPOINTS), (0 ≤ DIST) #16

  public boolean lic6(){

    if (NUMPOINTS < 3){
      return false;
    }

    for(int i = 0; i < (NUMPOINTS - N_PTS) +1; i++){
      Point[] consectuativePoints = new Point[N_PTS];
      Point first, last;


      for(int j = 0; j < N_PTS; j++){
        consectuativePoints[j] = this.points[i+j];
      }

      first = consectuativePoints[0];
      last = consectuativePoints[N_PTS-1];


      if(first.x == last.x){
        if(first.y == last.y){
          for(int z = 0; z < (N_PTS-1); z++){
            Point p = consectuativePoints[z];
            double dist = Math.sqrt(Math.pow(p.y - first.y, 2) + Math.pow(p.x - first.x,2));
            if(dist > DIST){
              return true;
            }
          }
        }
      }else {
        for(int g = 1; g < N_PTS; g++){
          Point p = consectuativePoints[g];
          double dist = (Math.abs((last.y - first.y) * p.x - (last.x - first.x) * p.y + last.x * first.y - last.y * first.x))/(Math.sqrt(Math.pow(last.y - first.y,2) + Math.pow(last.x - last.y,2))) ;

          if(dist > DIST){
            return true;
          }

        }
      }


    }

    return false;
  }

  //There exists at least one set of two data points separated by exactly K PTS consecutive intervening points that are a distance greater than the length, LENGTH1, apart. The condition
  //is not met when NUMPOINTS < 3.
  //1 ≤ K PTS ≤ (NUMPOINTS−2) :issue #18

  public boolean lic7(){
    if(NUMPOINTS < 3){
      return false;
    }else {
      for(int i = 0;i < NUMPOINTS - 1 - K_PTS;){

        Point X = points[i];
        Point Y = points[i+1];
        double CIT = Math.sqrt(Math.pow((X.x - Y.x),2)+Math.pow((X.y-Y.y),2));


        if(CIT > LENGTH1){
          return true;
        }

        i++;
      }
      return false;
    }
  }

  /*Returns true if there exists at least one set of three data points who are
  separated by exactly A_PTS and P_PTS consecutive intervening points, that
  cannot be contained within or on a circle of radius RADIUS1*/
  public boolean lic8(){
    if(NUMPOINTS<5 || 1>A_PTS || 1>B_PTS || A_PTS+B_PTS>NUMPOINTS-3 || RADIUS1<0){
      return false;
    }

    for(int i=0; i<NUMPOINTS -(2+A_PTS+B_PTS); i++){
      Point a = points[i];
      Point b = points[i+A_PTS+1];
      Point c = points[i+A_PTS+B_PTS+2];

      if(!pointsInCircle(a, b, c, RADIUS1)){
        return true;
      }
    }
    //if no set of three points is not in circle, return false
    return false;
  }

  /*Returns true if there exists at least one set of three data points separated
  by exactly C_PTS and D_PTS consecutive intervening points, than form an angle
  such that angel<(PI-EPSILON) or angle>(PI+EPSILON)*/
  public boolean lic9(){
    if(NUMPOINTS<5 || C_PTS<1 || D_PTS<1){
      return false;
    }

    for(int i=0; i<NUMPOINTS -(2+C_PTS+D_PTS); i++){
      Point a = points[i];
      Point b = points[i+C_PTS+1];
      Point c = points[i+C_PTS+D_PTS+2];

      //if either a or c concide with the vertex, the lic is not satisfied and we need to continue the search
      if((a.x==b.x && a.y==b.y) || (c.x==b.x && c.y==b.y)){
        continue;
      }

      Point vectorBA = new Point(a.x-b.x, a.y-b.y);
      Point vectorBC = new Point(c.x-b.x, c.y-b.y);
      double lengthBA = Math.sqrt(Math.pow(vectorBA.x, 2) + Math.pow(vectorBA.y, 2));
      double lengthBC = Math.sqrt(Math.pow(vectorBC.x, 2) + Math.pow(vectorBC.y, 2));
      double dotProduct = vectorBA.x * vectorBC.x + vectorBA.y*vectorBC.y;

      double angle = Math.acos(dotProduct/(lengthBA*lengthBC));

      if(angle<PI-EPSILON || angle>PI+EPSILON){
        return true;
      }
    }
    return false;
  }

  /*Returns true if there exists at lest one set of three data points separated
  by exactly E_PTS and F_PTS consecutive intervening points, that are the vertices
  of a triangel with area greater than AREA1*/
  public boolean lic10(){
    if(NUMPOINTS<5 || E_PTS<1 || F_PTS<1 ){
      return false;
    }

    for(int i=0; i< NUMPOINTS-(E_PTS+F_PTS+2); i++){
      Point a = points[i];
      Point b = points[i+E_PTS+1];
      Point c = points[i+E_PTS+F_PTS+2];

      double areaTriangel = Math.abs((a.x*(b.y-c.y) + b.x*(c.y-a.y) + c.x*(a.y-b.y))/2);
      if(areaTriangel>AREA1){
        return true;
      }
    }
    return false;
  }

  /*Returns true if there exists at least one set of two data points,
  (X[i],Y[i]) and (X[j],Y[j]), separeated by exactly G_PTS consecutive intervening
  points, such that X[j]-X[i]<0 (i<j)*/
  public boolean lic11(){
    if(NUMPOINTS<3 || G_PTS<1 || G_PTS>NUMPOINTS-2){
      return false;
    }
    for(int i=0; i< NUMPOINTS-G_PTS-1; i++){
      Point a = points[i];
      Point b = points[i+G_PTS+1];
      if( (b.x-a.x) < 0){
        return true;
      }
    }
    return false;
  }

  public boolean lic12(){
    if (NUMPOINTS < 3 || (K_PTS + 2) > NUMPOINTS) {
      return false;
    }

    boolean first = false;
    boolean second = false;

    for (int i = 0; i < (NUMPOINTS - K_PTS - 1); i++) {
      Point a = points[i];
      Point b = points[i + K_PTS + 1];
      double length = Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
      if (length > LENGTH1) {
        first = true;
      }
      if (length < LENGTH2) {
        second = true;
      }
    }

    if (first && second) {
      return true;
    }

    return false; //TODO change to variable when function is ready

  }

  public boolean lic13(){
    if (NUMPOINTS < 5 || (A_PTS + B_PTS + 3) > NUMPOINTS) {
      return false;
    }

    boolean first = false;
    boolean second = false;

    for (int i = 0; i < (NUMPOINTS - A_PTS - B_PTS - 2); i++) {
      Point a = points[i];
      Point b = points[i + A_PTS + 1];
      Point c = points[i + A_PTS + B_PTS + 2];
      if (!pointsInCircle(a, b, c, RADIUS1)) {
        first = true;
      }
      if (pointsInCircle(a, b, c, RADIUS2)) {
        second = true;
      }
    }

    if (first && second) {
      return true;
    }

    return false; //TODO change to variable when function is ready

  }

  public boolean lic14(){
    if (NUMPOINTS < 5 || (E_PTS + F_PTS + 3) > NUMPOINTS) {
      return false;
    }

    boolean first = false;
    boolean second = false;

    for (int i = 0; i < (NUMPOINTS - E_PTS - F_PTS - 2); i++) {
      Point a = points[i];
      Point b = points[i + E_PTS + 1];
      Point c = points[i + E_PTS + F_PTS + 2];
      double area = Math.abs(a.x*(b.y-c.y) + b.x*(c.y-a.y) + c.x*(a.y-b.y))/2;
      if (area > AREA1) {
        first = true;
      }
      if (area < AREA2) {
        second = true;
      }
    }

    if (first && second) {
      return true;
    }

    return false; //TODO change to variable when function is ready
  }

/*Function that determines if three points is in or on a circle with a given radius
 https://www.mathopenref.com/trianglecircumcircle.html*/
  public boolean pointsInCircle(Point a, Point b, Point c, double radius){
    double lengthAB = Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    double lengthAC = Math.sqrt(Math.pow(a.x - c.x, 2) + Math.pow(a.y - c.y, 2));
    double lengthBC = Math.sqrt(Math.pow(b.x - c.x, 2) + Math.pow(b.y - c.y, 2));

    double diameter = radius*2;

    //check if they form a straight line, they are collinear. Then the line must be shorter than diameter
    double collinear = a.x*(b.y-c.y) + b.x*(c.y-a.y) + c.x*(a.y-b.y);
    if(collinear==0){
      if(lengthAB+lengthBC<=diameter || lengthAC+lengthAB<=diameter || lengthBC+lengthAC<=diameter){
        return true;
      }
    }
    //if all the points are the same point, then they fit within the circle
    if(lengthAB==0 && lengthAC==0 && lengthBC==0){
      return true;
    }
    //check if some of the points are the same and the other line is less than the diameter
    if(lengthAB==0 && lengthAC <= diameter){
      return true;
    }
    if(lengthAC==0 && lengthAB <= diameter){
      return true;
    }
    if(lengthBC==0 && lengthAB <= diameter){
      return true;
    }
    //calculate the radius of the circum circle, if that radius is larger than radius then the points is not within the circle
    double radiusCircumCircle =
      (lengthAB*lengthAC*lengthBC)/
      (Math.sqrt((lengthAB+lengthAC+lengthBC)*
      (lengthAB+lengthAC-lengthBC)*
      (lengthAC+lengthBC-lengthAB)*
      (lengthBC+lengthAB-lengthAC)));

    if(radiusCircumCircle <= radius){
      return true;
    }
    return false;
  }


}
