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
  public boolean lic4(){

    if((2 <= Q_PTS) & (Q_PTS <= NUMPOINTS)){
      return true;
    }

    if((1 <= QUADS) & (QUADS >= 3)){
      return true;
    }

    return true; //TODO change to variable when function is ready

  }
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
  public boolean lic6(){
    return true; //TODO change to variable when function is ready

  }
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
