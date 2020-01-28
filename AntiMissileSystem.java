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
  public boolean lic8(){
    return true; //TODO change to variable when function is ready

  }
  public boolean lic9(){
    return true; //TODO change to variable when function is ready

  }
  public boolean lic10(){
    return true; //TODO change to variable when function is ready

  }
  public boolean lic11(){
    return true; //TODO change to variable when function is ready

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
