package frc.robot.commands.auto;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Delay;
import frc.robot.commands.ResetPosition;
import frc.robot.commands.aim.HomeAndZero;
import frc.robot.commands.aim.HorizontalAim;
import frc.robot.commands.elevator.StopLoadBallsAuto;
import frc.robot.commands.intake.IntakeAndLoad;
import frc.robot.commands.intake.IntakeAndLoadAuto;
import frc.robot.commands.intake.IntakeBall;
import frc.robot.commands.intake.stopIntake;
import frc.robot.subsystems.FlywheelShooter;
import frc.robot.commands.shooter.Shooting2Balls;
import frc.robot.commands.shooter.StopShooter;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.AutoAim;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.RobotDrive;

public class Get4BallHighPos extends SequentialCommandGroup{
    public Get4BallHighPos(Intake intake, FlywheelShooter shooter, RobotDrive robotDrive, Elevator elevator, AutoAim aim) {
        addCommands(
            new HomeAndZero(shooter),
            new IntakeAndLoadAuto(elevator, intake), 
            new SpoolHighCommand(shooter),
            new AutoDrivePos(robotDrive, 12000),
            new ResetPosition(),
            new StopLoadBallsAuto(elevator),
            new stopIntake(intake),
            new ParallelDeadlineGroup(new Delay(1000), new HorizontalAim()),
            new Shooting2Balls(elevator, 600),
            new StopShooter(shooter),
            new AutoTurn(robotDrive, 1050),
            new IntakeAndLoadAuto(elevator, intake),
            new AutoDrivePos(robotDrive, 45000),
            new AutoDrivePos(robotDrive, -43000),
            new StopLoadBallsAuto(elevator),
            new stopIntake(intake),
            new SpoolHighCommand(shooter),
            new ResetPosition(),
            new AutoTurn(robotDrive, -1300),
            new ParallelDeadlineGroup(new Delay(800), new HorizontalAim()),
            new Shooting2Balls(elevator, 2000)
        );
    }
}
