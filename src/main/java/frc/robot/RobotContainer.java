// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.*;
import frc.robot.commands.aim.HomeAndZero;
import frc.robot.commands.aim.HorizontalAim;
import frc.robot.commands.auto.*;
import frc.robot.commands.elevator.Load_To_Shooter;
import frc.robot.commands.intake.IntakeAndLoad;
import frc.robot.commands.intake.extendBumper;
import frc.robot.commands.intake.retractBumper;
import frc.robot.commands.intake.stopIntake;
import frc.robot.commands.shooter.LowShootHood;
import frc.robot.commands.shooter.SpoolHigh;
import frc.robot.commands.shooter.SpoolLow;
import frc.robot.commands.shooter.StopShooter;
import frc.robot.commands.climber.RetractClimberHooks;
import frc.robot.subsystems.AutoAim;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.FlywheelShooter;
import frc.robot.subsystems.Intake;
import frc.robot.commands.drive.EngageTurbo;
import frc.robot.commands.drive.TeleopDrive;
import frc.robot.commands.climber.TeleopClimber;
import frc.robot.commands.climber.ExtendClimberHooks;
import frc.robot.subsystems.RobotDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

    // The robot's subsystems and commands are defined here...
    public static final RobotDrive robotDrive = new RobotDrive();
    public static final FlywheelShooter shooter = new FlywheelShooter();
    public static final Elevator elevator = new Elevator();
    public static final Intake intake = new Intake();
    public static final Climber climber = new Climber();
    public static final AutoAim autoaim = new AutoAim();

    private final XboxController _primaryController = new XboxController(0);
    private final XboxController _secondaryController = new XboxController(1);

    /**
     * The container for the robot. Contains subsystems, OI devices, and commands.
     */
    public RobotContainer() {

        climber.register();

        //void setBrakingMode(bool enabled)

        // Configure the button bindings
        configureButtonBindings();

        robotDrive.setDefaultCommand(
            new TeleopDrive(
                _primaryController::getLeftX,
                _primaryController::getRightTriggerAxis,
                _primaryController::getLeftTriggerAxis
            )
        );

        climber.setDefaultCommand(
            new TeleopClimber(
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
            .toggleWhenPressed(new IntakeAndLoad(elevator, intake));

        new JoystickButton(_primaryController, XboxController.Button.kX.value)
            .whenHeld(new Load_To_Shooter(elevator));

        new JoystickButton(_primaryController, XboxController.Button.kY.value)
            .whenHeld(new Eject(intake, elevator, shooter));

        new JoystickButton(_primaryController, XboxController.Button.kB.value)
            .whenPressed(new stopIntake(intake));

        new JoystickButton(_secondaryController, XboxController.Button.kB.value)
            .whenPressed(new stopIntake(intake));

        new JoystickButton(_secondaryController, XboxController.Button.kY.value)
            .whenPressed(new Eject(intake, elevator, shooter));

        new JoystickButton(_secondaryController, XboxController.Button.kLeftBumper.value)
            .whenPressed(new extendBumper(intake));

        new JoystickButton(_secondaryController, XboxController.Button.kRightBumper.value)
            .whenPressed(new retractBumper(intake));

        new JoystickButton(_primaryController, XboxController.Button.kBack.value)
            .whenPressed(new HomeAndZero(shooter));

        new JoystickButton(_primaryController, XboxController.Button.kStart.value)
            .whenPressed(new LowShootHood(shooter));


        new POVButton(_secondaryController, 0)
            .whenPressed(new SpoolHigh(shooter));

        new POVButton(_secondaryController, 180)
            .whenPressed(new SpoolLow(shooter));

        new POVButton(_secondaryController, 90)
            .whenPressed(new StopShooter(shooter));
        new POVButton(_secondaryController, 90)
            .whenPressed(new HomeAndZero(shooter));

        new JoystickButton(_secondaryController, XboxController.Button.kX.value)
            .whenPressed(new ExtendClimberHooks());

        new JoystickButton(_secondaryController, XboxController.Button.kA.value)
            .whenPressed(new RetractClimberHooks());

        new JoystickButton(_primaryController, XboxController.Button.kLeftBumper.value)
            .whileHeld(new HorizontalAim(autoaim, robotDrive, shooter));


        //new JoystickButton(_primaryController, XboxController.Button.kY.value)
        //  .whenPressed(new ShootHigh(_shooter));

        //new JoystickButton(_primaryController, XboxController.Button.kB.value)
        //.whileHeld(new RunIndexer(_shooter), false);
        //new JoystickButton(_primaryController, XboxController.Button.kLeftBumper.value)
        //  .whileHeld(new EngagePrecision(_robotDrive), false);
        new JoystickButton(_primaryController, XboxController.Button.kRightBumper.value)
            .whileHeld(new EngageTurbo());
    }

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public static NetworkTable table = NetworkTableInstance.getDefault().getTable("Auto");

    public Command getAutonomousCommand() {
        NetworkTableEntry entry = table.getEntry("SelectAuto");
        entry.setPersistent();


        int selection = (int) entry.getDouble(0);

        switch (selection) {
            case 1:
                return new Get2HighAuto(intake, shooter, robotDrive, elevator, autoaim);
            case 2:
                return new Get2LowAuto(intake, shooter, robotDrive, elevator, autoaim);
            case 3:
                return new Get4BallHighPos(intake, shooter, robotDrive, elevator, autoaim);
//      case 4:
//      return new Get2HighAutoPos(_intake, _shooter, _robotDrive, _elevator, _autoaim);
        }
        return null;

//    return new MoveToPos(_robotDrive);

    }

}
