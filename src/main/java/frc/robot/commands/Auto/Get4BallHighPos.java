package frc.robot.commands.Auto;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Delay;
import frc.robot.commands.HomeAndZero;
import frc.robot.commands.HorizontalAim;
import frc.robot.commands.IntakeBall;
import frc.robot.commands.stopIntake;
import frc.robot.subsystems.FlywheelShooter;
import frc.robot.commands.Shooting2Balls;
import frc.robot.commands.StopShooter;
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
            new stopIntake(intake),
            //new Delay(200),
            new ParallelDeadlineGroup(new Delay(200), new HorizontalAim(aim, robotDrive, shooter)),
            new Shooting2Balls(elevator),
            //new AutoDrivePos(robotDrive, 12000),
            new StopShooter(shooter),
            new AutoTurn(robotDrive, 1300),
            new IntakeBall(intake),
            new AutoDrivePos(robotDrive, 45000),
            new stopIntake(intake),
            new AutoDrivePos(robotDrive, -46000),
            new SpoolHighCommand(shooter),
            new AutoTurn(robotDrive, -1300),
            new ParallelDeadlineGroup(new Delay(600), new HorizontalAim(aim, robotDrive, shooter)),
            new Shooting2Balls(elevator)
        );
    }
}
