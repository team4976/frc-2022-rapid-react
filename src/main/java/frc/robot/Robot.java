// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel; 
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {
 
  public static TalonSRX motor1 = new TalonSRX(55);
  public static TalonFX motor2 = new TalonFX(46);
  public CANSparkMax rightClimber = new CANSparkMax(49, CANSparkMaxLowLevel.MotorType.kBrushless);
  public CANSparkMax leftClimber = new CANSparkMax(48, CANSparkMaxLowLevel.MotorType.kBrushless);
  Solenoid climberBrake = new Solenoid(10,PneumaticsModuleType.CTREPCM,4);
  Compressor compressor = new Compressor(10, PneumaticsModuleType.CTREPCM);
  public static TalonSRX motor = new TalonSRX(41);
  public static XboxController controller = new XboxController(0);
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

    //double forward = controller.getRightTriggerAxis();
  //double reverse = controller.getLeftTriggerAxis();
  //double output = forward - reverse;
 // motor2.set(ControlMode.PercentOutput, output);
 compressor.enableDigital();
 var output = controller.getLeftY();
  if(Math.abs(output) > 0.10) {
    rightClimber.set(-(output*0.90));
    leftClimber.set(-(output*0.90));
    climberBrake.set(true);
  } 
  else{
    rightClimber.set(-0.02);
    leftClimber.set(-0.02);
    climberBrake.set(false);
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
