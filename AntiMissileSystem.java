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
