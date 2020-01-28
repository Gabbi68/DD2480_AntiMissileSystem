import java.lang.*;

import java.util.*;


public class AntiMissileSystem{

//Global variables
double PI = Math.PI;
boolean[] lic = new boolean[15];

boolean[] cmv = cmv();

boolean[][] pum = pum();
boolean[] fuv = fuv();

Point[] points;

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
    boolean[][] pum = new boolean[15][15];
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

  public boolean lic0(){
    return true; //TODO change to variable when function is ready

  }
  public boolean lic1(){
    return true; //TODO change to variable when function is ready

  }
  public boolean lic2(){
    return true; //TODO change to variable when function is ready

  }
  public boolean lic3(){
    return true; //TODO change to variable when function is ready

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
    return true; //TODO change to variable when function is ready

  }
  public boolean lic13(){
    return true; //TODO change to variable when function is ready

  }
  public boolean lic14(){
    return true; //TODO change to variable when function is ready

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
