// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
//import frc.robot.commands.IntakeBall;
import frc.robot.commands.RunIndexer;
import frc.robot.commands.ShootHigh;
import frc.robot.commands.TeleopDrive;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.RobotDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.Shooter;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer extends SubsystemBase {

  // The robot's subsystems and commands are defined here...
  private final RobotDrive _robotDrive = new RobotDrive();
  private final Intake _intake = new Intake();
  private final Shooter _shooter = new Shooter();

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
   
    
   
    //new JoystickButton(_primaryController, XboxController.Button.kA.value)
      //.whenPressed(new IntakeBall(_intake));
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