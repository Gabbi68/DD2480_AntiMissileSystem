import java.lang.*;

import java.util.*;


public class AntiMissileSystem{

//Global variables
double PI = Math.PI;
boolean[] lic = new boolean[15];

boolean[] cmv;// = cmv();

boolean[][] pum; //= pum();
boolean[] fuv; // = fuv();

Point[] points;

String[][] lcm = new String[15][15];

int NUMPOINTS;
double LENGTH1;
double RADIUS1 ;
double EPSILON;
double AREA1;
int Q_PTS ;
int QUADS;
double DIST;
int N_PTS;
int K_PTS;
int A_PTS;
int B_PTS;
int C_PTS;
int D_PTS;
int E_PTS;
int F_PTS;
int G_PTS;
double LENGTH2;
double RADIUS2;
double AREA2;


  public static void main( String[] args ) {
    AntiMissileSystem run = new AntiMissileSystem();
  }

  public void decide(){
    System.out.println("NO");
  }


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

  public boolean[] cmv(){
    boolean[] cmv = new boolean[15];
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

  public boolean[] fuv(){
    boolean[] fuv = new boolean[15];
    return fuv;

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

  public boolean lic4(){
    return true; //TODO change to variable when function is ready

  }
  public boolean lic5(){
    return true; //TODO change to variable when function is ready

  }
  public boolean lic6(){
    return true; //TODO change to variable when function is ready

  }
  public boolean lic7(){
    return true; //TODO change to variable when function is ready

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
      Point b = points[i + A_PTS + B_PTS + 2];
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

/*Function that determines if three points is in or on a circle with a given radius*/
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
