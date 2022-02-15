// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
//import frc.robot.commands.EngagePrecision;
//import frc.robot.commands.EngageTurbo;
import frc.robot.commands.IntakeBall;
import frc.robot.commands.IntakeIntend;
import frc.robot.commands.RunIndexer;
import frc.robot.commands.ShootHigh;
import frc.robot.commands.TeleopDrive;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.RobotDrive;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  // The robot's subsystems and commands are defined here...
  private final RobotDrive _robotDrive = new RobotDrive();
  private final Intake _intake = new Intake();
  private final Shooter _shooter = new Shooter();
  boolean flag = false;

  private final XboxController _primaryController = new XboxController(0);
  // private final XboxController _secondaryController = new XboxController(1);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    // Configure the button bindings
    configureButtonBindings();
    
    _robotDrive.setDefaultCommand(
      new TeleopDrive(
        _robotDrive, 
        _primaryController::getLeftX, 
        _primaryController::getLeftTriggerAxis,
        _primaryController::getRightTriggerAxis
        )
    );
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
   //new JoystickButton(_primaryController, XboxController.Button.kY.value)
    //  .whenPressed(new ShootHigh(_shooter));

    //new JoystickButton(_primaryController, XboxController.Button.kB.value)
    //.whileHeld(new RunIndexer(_shooter), false);
    new JoystickButton(_primaryController, XboxController.Button.kA.value)
      .whenPressed(new IntakeBall(_intake));
    new JoystickButton(_primaryController, XboxController.Button.kX.value)
      .whenPressed(new IntakeIntend(_intake));
    //new JoystickButton(_primaryController, XboxController.Button.kLeftBumper.value)
      //.whileHeld(new EngagePrecision(_robotDrive));
     //new JoystickButton(_primaryController, XboxController.Button.kRightBumper.value)
      //.whileHeld(new EngageTurbo(_robotDrive));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return null;
  }

}
