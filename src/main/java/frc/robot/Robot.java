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
  public static TalonFX motor = new TalonFX(1);
                                      //    ^ set this number to the ID in Phoenix tuner

  // Make a reference to the Xbox Controller
  public static XboxController controller = new XboxController(0);
                                                         //    ^ set this number to the index in driverstation
  int ID;
  public static TalonFX motor2 = new TalonFX(45);
  public static TalonFX motor3 = new TalonFX(10);
  double percent = .4;

  @Override
  public void robotInit() {}
  
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
    motor3.set(ControlMode.PercentOutput, output);
    if(controller.getAButton()){
    motor.set(ControlMode.PercentOutput, -percent);
    motor2.set(ControlMode.PercentOutput, percent);
    int pov = controller.getPOV();
    if(pov == 0){
      percent = percent + 0.01;
      if(percent > 1){percent = 1;}
    }else if(pov == 180){
      percent = percent - 0.01;
      if(percent < -1){percent = -1;}
    }
    }else{
      motor.set(ControlMode.PercentOutput, 0);
      motor2.set(ControlMode.PercentOutput, 0);
    }
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}
  //AHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH
}
