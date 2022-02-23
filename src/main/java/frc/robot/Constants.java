// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
//Drive Code
    public static int kDRIVE_LEFT_A_NODE_ID = 41;
    public static int kDRIVE_LEFT_B_NODE_ID = 43;

    public static int kDRIVE_RIGHT_A_NODE_ID = 45;
    public static int kDRIVE_RIGHT_B_NODE_ID = 46;

    public static int kDRIVE_GEARBOX_PNEUMATIC_NODE_ID = 40;
    public static int kDRIVE_GEARBOX_PNEUMATIC_PORT_ID = 4;
    public static double kDRIVE_SENSITIVITY_LEVEL = 0.9;

    public static int kSHOOTER_A_NODE_ID = 52;
    public static double kSHOOT_LOW_SPEED = 0.2;
    public static double kSHOOT_HIGH_SPEED = 0.8;

    public static double precisionMode = 1;
    
    /*public static double kINTAKE_RUN = 0.75;
    public static double kSTOP_INTAKE = 0;
    public static double kEJECT_INTAKE = -0.75;

    public static double kBOTTOM_ELEVATOR = 0.5;
    public static double kBOTTOM_ELEVATOR_EJECT = -0.5;
    public static double kBOTTOM_ELEVATOR_STOP = 0;

    public static double kSHOOTER_LOW_SPEEED = 0.2;
    public static double kSHOOTER_HIGH_SPEEED = 0.8;
    public static int kINDEX_NODE_ID = 0; 
*/
//Elevator Code
    public static int kDIGITAL_INPUT = 0; // node for the button to stop motor
    public static int kINTAKE_MOTOR_NODE = 20; // the bottom motor that pushes the ball up, port 20
    public static int kINDEX_NODE = 21; // the top motor (index) port 21

    public static double kINTAKE_SPEED = 0.4;//Bottom Roller Speed
    public static double kINDEX_SPEED = 0.6;//Top Roller Speed
    public static double kINITIAL_SPEED = 0.4;//Speed the motors go while starting
    public static double kSTOP_SPEED = 0;//Sets the motor speeds to 0
//intake code
    public static double kINTAKE_RUN = 0.75;
    public static double kSTOP_INTAKE = 0;
    public static double kEJECT_INTAKE = -0.75;

    public static double kBOTTOM_ELEVATOR = 0.5;
    public static double kBOTTOM_ELEVATOR_EJECT = -0.5;
    public static double kBOTTOM_ELEVATOR_STOP = 0;

    public static double kSHOOTER_LOW_SPEEED = 0.2;
    public static double kSHOOTER_HIGH_SPEEED = 0.8;
    public static int kINDEX_NODE_ID = 0; 
    
    public static double kFALCON_UNITS_TO_RPM = 0.001;
}
