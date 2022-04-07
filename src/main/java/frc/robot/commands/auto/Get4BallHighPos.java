package frc.robot.commands.auto;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Delay;
import frc.robot.commands.ResetPosition;
import frc.robot.commands.aim.HomeAndZero;
import frc.robot.commands.aim.HorizontalAim;
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
            new IntakeBall(intake), 
            new SpoolHighCommand(shooter),
            new AutoDrivePos(robotDrive, 12000),
            new ResetPosition(),
            new stopIntake(intake),
            //new Delay(200),
            new ParallelDeadlineGroup(new Delay(1000), new HorizontalAim(aim, robotDrive, shooter)),
            new Shooting2Balls(elevator),
            //new AutoDrivePos(robotDrive, 12000),
            new StopShooter(shooter),
            new AutoTurn(robotDrive, 2600),
            new IntakeBall(intake),
            new AutoDrivePos(robotDrive, 48500),
            new AutoDrivePos(robotDrive, -41000),
            new stopIntake(intake),
            new SpoolHighCommand(shooter),
            new ResetPosition(),
            new AutoTurn(robotDrive, -1300),
            new ParallelDeadlineGroup(new Delay(600), new HorizontalAim(aim, robotDrive, shooter)),
            new Shooting2Balls(elevator)
        );
    }
}
