package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Delay;
import frc.robot.commands.Eject;
import frc.robot.commands.ResetPosition;
import frc.robot.commands.aim.HomeAndZero;
import frc.robot.commands.aim.HorizontalAim;
import frc.robot.commands.intake.IntakeBall;
import frc.robot.commands.intake.stopIntake;
import frc.robot.commands.shooter.Shooting2Balls;
import frc.robot.commands.shooter.StopShooter;
import frc.robot.subsystems.*;

public class Get2HighEject2Auto extends SequentialCommandGroup {
    public Get2HighEject2Auto(Intake intake, FlywheelShooter shooter, RobotDrive robotDrive, Elevator elevator, AutoAim aim) {
        addCommands(
                new HomeAndZero(shooter),
                new IntakeBall(intake),
                new SpoolHighCommand(shooter),
                new AutoDrive(robotDrive, 0.6, 1000,0),//(robot, speed, and duration in millis, rotation in degrees)
                new stopIntake(intake),
                //new AutoDrive(robotDrive, -0.6, 1000,0),//(robot, speed, and duration in millis, rotation in degrees)
                new ParallelDeadlineGroup(new Delay(2000), new HorizontalAim(aim, robotDrive, shooter)),
                new Shooting2Balls(elevator),
                new IntakeBall(intake),
                new ResetPosition(),
                new AutoTurn(robotDrive, 7500),
                new AutoDrive(robotDrive, 0.7, 1200,0),//(robot, speed, and duration in millis, rotation in degrees)
                new StopShooter(shooter),
                new AutoTurn(robotDrive, -1500),
                new AutoDrive(robotDrive, -1, 2300,0),//(robot, speed, and duration in millis, rotation in degrees)
                new ResetPosition(),
                new AutoTurn(robotDrive, -1200),
                new Eject(intake, elevator, shooter)
        );
    }

    }
