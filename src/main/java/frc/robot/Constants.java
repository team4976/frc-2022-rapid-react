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

    public static int kDIGITAL_INPUT = 0; // node for the button to stop motor
    public static int kINTAKE_MOTOR_NODE = 20; // the bottom motor that pushes the ball up, port 20
    public static int kINDEX_NODE = 21; // the top motor (index) port 21

    public static double kINTAKE_SPEED = 0.4;//Bottom Roller Speed
    public static double kINDEX_SPEED = 0.6;//Top Roller Speed
    public static double kINITIAL_SPEED = 0.4;//Speed the motors go while starting
    public static double kSTOP_SPEED = 0;//Sets the motor speeds to 0

}