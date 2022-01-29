// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;

public class Robot extends TimedRobot {
 
  // Make a reference to the Motor Controller
  public static TalonFX motor = new TalonFX(10);
                                      //    ^ set this number to the ID in Phoenix tuner

  // Make a reference to the Xbox Controller
  public static XboxController controller = new XboxController(0);
                                                         //    ^ set this number to the index in driverstation
  @Override
  public void robotInit() {
    //comment added

  }
  
  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {}
  
  @Override
  public void teleopPeriodic() {

    double forward = controller.getRightTriggerAxis();
    double reverse = controller.getLeftTriggerAxis();

    double output = forward - reverse;

    // Set the output of the motor controller to 100% in the forward direction
    motor.set(ControlMode.PercentOutput, output);
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}
}
