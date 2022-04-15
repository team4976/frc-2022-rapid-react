package frc.robot.commands.auto;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Delay;
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

public class Get2HighAutoPos extends SequentialCommandGroup{
    public Get2HighAutoPos(Intake intake, FlywheelShooter shooter, RobotDrive robotDrive, Elevator elevator, AutoAim aim) {
        addCommands(
            new HomeAndZero(shooter),
            new IntakeBall(intake), 
            new SpoolHighCommand(shooter),
            new AutoDrivePos(robotDrive, 12000),
            new stopIntake(intake),
            new ParallelDeadlineGroup(new Delay(2000), new HorizontalAim()),
            new Shooting2Balls(elevator, 600),
            new AutoDrivePos(robotDrive, 12000),
            new StopShooter(shooter),
            new AutoTurn(robotDrive, -1700),
            new IntakeBall(intake),
            new AutoDrivePos(robotDrive, 40000),
            new stopIntake(intake),
            new AutoDrivePos(robotDrive, -45000),
            new SpoolHighCommand(shooter),
            new AutoTurn(robotDrive, 2000),
            new ParallelDeadlineGroup(new Delay(2000), new HorizontalAim()),
            new Shooting2Balls(elevator, 600)
        );
    }
}
