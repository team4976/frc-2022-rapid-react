// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.io.Console;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();

public static TalonSRX motor = new TalonSRX(44);
public static TalonSRX motor2 = new TalonSRX(46); 
public static TalonSRX motor3 = new TalonSRX(07);
public static TalonSRX motor4 = new TalonSRX(04);
//intake
public static TalonSRX motor5 = new TalonSRX(49);

public static XboxController controller = new XboxController(0);
  
  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {}

  /**
   * This autonomous (along with the chooser code above) shows how to select between different
   * autonomous modes using the dashboard. The sendable chooser code works with the Java
   * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the chooser code and
   * uncomment the getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to the switch structure
   * below with additional strings. If using the SendableChooser make sure to add them to the
   * chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    switch (m_autoSelected) {
      case kCustomAuto:
        // Put custom auto code here
        break;
      case kDefaultAuto:
      default:
        // Put default auto code here
        break;
    }
  }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {}

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
   double reverse = controller.getLeftTriggerAxis(); 
   double forward = controller.getRightTriggerAxis();
   double output = forward - reverse;
   double output2 = output*-1;
   double per=0;
    

   boolean intake = controller.getAButton();
   boolean outtake = controller.getBButton();
   
   double side = controller.getLeftX();
// percent of the acc. comapered to turning
if ((side) > .1) {
  per = Math.abs(output)*-1*side-.1;
}
else if ((side) < -.1) {
  per = Math.abs(output)*-1*side+.1;
}
   

    if (output!=0 && Math.abs(side) <.1){
       output = output+0;
       output2 = output2+0;
   }

   else if (.2 < Math.abs(side)) { // truning

   if (side > 0 && output > 0){
      output2= output2-per; // right trun fow
     }
   else if (side < 0 && output2 < 0){
    output = output-per; // left trun fow
    }
   else if (side > 0 && output < 0){
    output2 = output2+per; // right turn back
    }
  else if (side < 0 && output2 > 0){
   output = output+per; // left trun back
    }

    else if (side != 0 && output == 0){
      output2 = side*-1;// Right or left trun spot 
      output = side*-1; 
    }
/*
       if side is -1
       -1*-1=1  LF is Back and RI is Fow
       if side is 1
       1*-1= -1  LF is Fow and RI is Back
    }
*/
    
    }
    else {
        output=0; // don't move
        output2=0;
        
}

 if (intake == true){
 motor5.set(ControlMode.PercentOutput, .8);
}
else if (outtake == true){
  motor5.set(ControlMode.PercentOutput, -.8);
}
else{
  motor5.set(ControlMode.PercentOutput, 0);
}

 
  motor.set(ControlMode.PercentOutput, output);

  motor2.set(ControlMode.PercentOutput, output);

  motor3.set(ControlMode.PercentOutput, output2);

  motor4.set(ControlMode.PercentOutput, output2);

  System.out.println(output+" yes");
  System.out.println(output2+" no");
  System.out.println(per+" per");
}



 



  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {}

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {}

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}
}

