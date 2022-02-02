// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;

public class Robot extends TimedRobot {
 
  // Make a reference to the Motor Controller - Test 123
  public static TalonFX motor = new TalonFX(10);
                                      //    ^ set this number to the ID in Phoenix tuner

  // Make a reference to the Xbox Controller
  public static XboxController controller = new XboxController(0);
                                                         //    ^ set this number to the index in driverstation
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
    //motor.set(ControlMode.PercentOutput, output);

    System.out.println(motor.getSelectedSensorVelocity());
    int pov = controller.getPOV();
    int speed = 0;
    if(controller.getAButton()){
      motor.set(ControlMode.Velocity,-speed);
    }
    else{
      motor.set(ControlMode.Velocity,0);

    }
    if(pov == 0){
      speed += 1000;
    }
    else if(pov == 180){
      speed -=1000;
    }
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
}
