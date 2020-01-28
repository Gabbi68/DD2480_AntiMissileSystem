import java.lang.*;

import java.util.*;


public class AntiMissileSystem{

//Global variables
double PI = Math.PI;
boolean[] lic = new boolean[15];

boolean[] cmv = cmv();

boolean[][] pum = pum();
boolean[] fuv = new boolean[15];
boolean[] puv = new boolean[15];

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

  //There exists at least one set of Q PTS consecutive data points that lie in more than QUADS
  //quadrants. Where there is ambiguity as to which quadrant contains a given point, priority
  //of decision will be by quadrant number, i.e., I, II, III, IV. For example, the data point (0,0)
  //is in quadrant I, the point (-l,0) is in quadrant II, the point (0,-l) is in quadrant III, the point
  //(0,1) is in quadrant I and the point (1,0) is in quadrant I.
  //(2 ≤ Q PTS ≤ NUMPOINTS), (1 ≤ QUADS ≤ 3) :issue #12

  public boolean lic4(){

    if((2 <= Q_PTS) & (Q_PTS <= NUMPOINTS)){
      return true;
    }

    if((1 <= QUADS) & (QUADS >= 3)){
      return true;
    }

    return true; //TODO change to variable when function is ready

  }

  //There exists at least one set of two consecutive data points, (X[i],Y[i]) and (X[j],Y[j]), such
  //that X[j] - X[i] < 0. (where i = j-1) :issue #13

  public boolean lic5(){
    Point point1,point2;

    for(int i = 0; i < points.length-1;i++){
      point1 = points[i];
      point2 = points[i+1];

      if(point1.x == point2.y-1){
        return true;
      }

    }
    return false;

    return true; //TODO change to variable when function is ready

  }

  //There exists at least one set of N PTS consecutive data points such that at least one of the
  //points lies a distance greater than DIST from the line joining the first and last of these N PTS
  //points. If the first and last points of these N PTS are identical, then the calculated distance
  //to compare with DIST will be the distance from the coincident point to all other points of
  //the N PTS consecutive points. The condition is not met when NUMPOINTS < 3.
  //(3 ≤ N PTS ≤ NUMPOINTS), (0 ≤ DIST) #16

  public boolean lic6(){

    if (N_PTS < 3){
      return true;
    }

    for(int i = 0; i < (NUMPOINTS - N_PTS) +1; i++){
      Point[] consectuativePoints = new Point[N_PTS];

      for(int j = 0; j < N_PTS; j++){
        consectuativePoints[j] = this.points[i+j];
      }

      Point first = consectuativePoints[0];
      Point last = consectuativePoints[N_PTS-1];


      if(first.x == last.x && first.y == first.y){
        for(int z = 0; z < (N_PTS-1); z++){
          Point p = consectuativePoints[z];
          double dist = Math.sqrt(Math.pow(p.y - first.y, 2) + Math.pow(p.x - first.x,2));
          if(dist > DIST){
            return true;
          }
        }
      }else {
        for(int g = 1; g < N_PTS; g++){
          Point p = consectuativePoints[g];

          double numi = Math.abs((last.y - first.y) * p.x - (last.x - first.x) * p.y + last.x * first.y - last.y * first.x);
          double denum = Math.sqrt(Math.pow(last.y - first.y,2) + Math.pow(last.x - last.y,2));

          double dist = numi/denum;

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
    return true; //TODO change to variable when function is ready

  }
  public boolean lic13(){
    return true; //TODO change to variable when function is ready

  }
  public boolean lic14(){
    return true; //TODO change to variable when function is ready

  }

  public boolean pointsInCircle(Point a, Point b, Point c, double radius){
    return true;  //TODO change to variable when function is ready

  }


}
