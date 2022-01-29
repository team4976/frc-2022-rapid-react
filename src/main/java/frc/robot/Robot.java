// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;

public class Robot extends TimedRobot {
 
  // Make a reference to the Motor Controller
  public static TalonSRX motor = new TalonSRX(44);
  public static TalonSRX motor2 = new TalonSRX(46); 
  public static TalonSRX motor3 = new TalonSRX(07);
  public static TalonSRX motor4 = new TalonSRX(04);
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

    double reverse = controller.getLeftTriggerAxis(); 
   double forward = controller.getRightTriggerAxis();
   double output = forward - reverse;
   double output2 = output*-1;
   double per=0;
  
   double side = controller.getLeftX();

    // Set the output of the motor controller to 100% in the forward direction
    if (Math.abs(side) > .1) {
      per = output*side;
    }
       
    
        if (output!=0 && Math.abs(side) <.1){
           output = output+0;
           output2 = output2+0;
           
           
    
          
       }
    
       else if (.1 < Math.abs(side)) { // truning
    
       if (side > 0 && output > 0){
          output = output-per; // right trun fow
         }
       else if (side < 0 && output2 < 0){
         output2 = output2+per; // left trun fow
        }
       else if (side > 0 && output < 0){
        output = output+per; // right turn back
        }
      else if (side < 0 && output2 > 0){
       output2 = output2-per; // left trun back
        }
    
        else if (side != 0 && output == 0){
          output2 = side*-1;// Right or left trun spot 
          output = side*-1; 
    /*
           if side is -1
           -1*-1=1  LF is Back and RI is Fow
           if side is 1
           1*-1= -1  LF is Fow and RI is Back
    */
        }
        }
        else {
            output=0; // don't move
            output2=0;
            
    }
    motor.set(ControlMode.PercentOutput, output);

    motor2.set(ControlMode.PercentOutput, output);
 
    motor3.set(ControlMode.PercentOutput, output2);
 
    motor4.set(ControlMode.PercentOutput, output2);

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
