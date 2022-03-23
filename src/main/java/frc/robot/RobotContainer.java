// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.Eject_Balls;
import frc.robot.subsystems.AutoAim;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.FlywheelShooter;
import frc.robot.subsystems.Intake;
import frc.robot.commands.EngagePrecision;
import frc.robot.commands.EngageTurbo;
import frc.robot.commands.GoToHome;
import frc.robot.commands.HomeAndZero;
import frc.robot.commands.HorizontalAim;
import frc.robot.commands.IntakeAndLoad;
import frc.robot.commands.IntakeBall;
import frc.robot.commands.Load_Balls;
import frc.robot.commands.Load_To_Shooter;
import frc.robot.commands.LowShootHood;
import frc.robot.commands.MoveHood;
import frc.robot.commands.RunIndexer;
import frc.robot.commands.ShootHigh;
import frc.robot.commands.SpoolHigh;
import frc.robot.commands.SpoolLow;
import frc.robot.commands.StopShooter;
import frc.robot.commands.TeleopDrive;
import frc.robot.commands.ZeroPos;
import frc.robot.commands.ejectBall;
import frc.robot.commands.extendBumper;
import frc.robot.commands.extendarm;
import frc.robot.commands.passivein;
import frc.robot.commands.passiveout;
import frc.robot.commands.retractBumper;
import frc.robot.commands.stopIntake;
import frc.robot.commands.Auto.Get2HighAuto;
import frc.robot.commands.Auto.Get2HighAutoPos;
import frc.robot.commands.Auto.Get2LowAuto;
import frc.robot.commands.Auto.MoveToPos;
//import frc.robot.subsystems.Intake;
import frc.robot.subsystems.RobotDrive;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;

import static frc.robot.Constants.*;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  // The robot's subsystems and commands are defined here...
  private final RobotDrive _robotDrive = new RobotDrive();
 // private final Intake _intake = new Intake();
  private final FlywheelShooter _shooter = new FlywheelShooter();
  private final Elevator _elevator = new Elevator();
  private final Intake _intake = new Intake();
  private final Climber _climb = new Climber();
  private final AutoAim _autoaim = new AutoAim();
  boolean flag = false;

  private final XboxController _primaryController = new XboxController(0);
  private final XboxController _secondaryController = new XboxController(1);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    //void setBrakingMode(bool enabled)

    // Configure the button bindings
    configureButtonBindings();
    
    _robotDrive.setDefaultCommand(
      new TeleopDrive(
        _robotDrive, 
        _primaryController::getLeftX, 
        _primaryController::getRightTriggerAxis,
        _primaryController::getLeftTriggerAxis
        )
    );

    _climb.setDefaultCommand(
      new extendarm(
        _climb, 
        _secondaryController::getRightTriggerAxis,
        _secondaryController::getLeftTriggerAxis
        )
    );
    //_shooter.setDefaultCommand(new MoveHood(_shooter, _primaryController::getRightY));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
      //Elevator
    new JoystickButton(_primaryController, XboxController.Button.kA.value)
    .toggleWhenPressed(new IntakeAndLoad(_elevator, _intake));

  new JoystickButton(_primaryController, XboxController.Button.kX.value)
    .whenHeld(new Load_To_Shooter(_elevator));

  new JoystickButton(_primaryController, XboxController.Button.kY.value)
    .whenHeld(new Eject_Balls(_elevator));

  new JoystickButton(_primaryController, XboxController.Button.kB.value)
    .whenPressed(new stopIntake(_intake));

 new JoystickButton(_secondaryController, XboxController.Button.kB.value)
   .whenPressed(new stopIntake(_intake));

  new JoystickButton(_secondaryController, XboxController.Button.kY.value)
      .whenPressed(new ejectBall(_intake));

  new JoystickButton(_secondaryController, XboxController.Button.kLeftBumper.value)
      .whenPressed(new extendBumper(_intake));

  new JoystickButton(_secondaryController, XboxController.Button.kRightBumper.value)
      .whenPressed(new retractBumper(_intake));

      new JoystickButton(_primaryController, XboxController.Button.kBack.value)
      .whenPressed(new HomeAndZero(_shooter));

      new JoystickButton(_primaryController, XboxController.Button.kStart.value)
        .whenPressed(new LowShootHood(_shooter));
      

      new POVButton(_secondaryController, 0)
      .whenPressed(new SpoolHigh(_shooter));
      
      new POVButton(_secondaryController, 180)
      .whenPressed(new SpoolLow(_shooter));

      new POVButton(_secondaryController, 90)
      .whenPressed(new StopShooter(_shooter));
      
      new JoystickButton(_secondaryController, XboxController.Button.kX.value)
      .whenPressed(new passiveout(_climb));

      new JoystickButton(_secondaryController, 
      XboxController.Button.kA.value)
      .whenPressed(new passivein(_climb));

      new JoystickButton(_primaryController, XboxController.Button.kLeftBumper.value)
      .whileHeld(new HorizontalAim(_autoaim, _robotDrive, _shooter));


   //new JoystickButton(_primaryController, XboxController.Button.kY.value)
    //  .whenPressed(new ShootHigh(_shooter));

    //new JoystickButton(_primaryController, XboxController.Button.kB.value)
    //.whileHeld(new RunIndexer(_shooter), false);
    //new JoystickButton(_primaryController, XboxController.Button.kLeftBumper.value)
    //  .whileHeld(new EngagePrecision(_robotDrive), false);
      new JoystickButton(_primaryController, XboxController.Button.kRightBumper.value)
       .whileHeld(new EngageTurbo(_robotDrive));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public static NetworkTable table = NetworkTableInstance.getDefault().getTable("Auto");

  public Command getAutonomousCommand() 
    {
      NetworkTableEntry entry = table.getEntry("SelectAuto");
      entry.setPersistent();


      int selection = (int) entry.getDouble(0);

    switch(selection){
      case 1:
        return new Get2HighAuto(_intake, _shooter, _robotDrive, _elevator, _autoaim);
      case 2:
      return new Get2LowAuto(_intake, _shooter, _robotDrive, _elevator, _autoaim);
      case 3:
      return new Get2HighAutoPos(_intake, _shooter, _robotDrive, _elevator, _autoaim);
      case 4:
      return new Get2HighAutoPos(_intake, _shooter, _robotDrive, _elevator, _autoaim);
    }
    return null;

    //return new MoveToPos(_robotDrive);
    
  }

}
