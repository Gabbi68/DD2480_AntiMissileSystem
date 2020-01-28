# DD2480_AntiMissileSystem
DD2480 assignment 1 - Group 16
Aditya Budithi, Martin Gabrielsen, Nicolai Hellesnes & Stina Långström

##Introduction
This a hypothetical anti-ballistic missile system based on material in *“An experimental evaluation of the
assumption of independence in multiversion programming”* by J. C. Knight and
N. G. Leveson, IEEE Transactions on Software Engineering 12(1):96–109, January 1986.

##Overview
The program will use a function Decide(), which is the function that will generate a boolean signal which determines whether an interceptor should be launched or not. This is based upon input radar tracking information, that is evaluated according to 15 conditions (LIC0-LIC14).

###AntiMissileSystem
The main file that implements the decide()-method. 
Input is NUMPOINTS, Points, Parameters, Logical Connector Matric (LCM) & Preliminary Unlocking Vector (PUV).
Output is LAUNCH, Conditions Met Vector (CMV), Preliminary Unlocking Matrix (PUM) & Final Unlocking Vector (FUV).

###Test
ConditionTest is the file that tests every function of the program.

###Point
A class that defines a point in the cartesian map.

##Contributions
..* Code skeleton: Martin, Nicolai & Stina
..* Testing: all
..* Documentation: all
..* README: Nicolai & Stina
..* LIC 0-3: Nicolai
..* LIC 4-7: Martin
..* LIC 8-11: Stina
..* LIC 12-14: Aditya
..* Decide(): Nicolai & Stina
..* Pum: Nicolai & Stina
..* Fuv: Martin
