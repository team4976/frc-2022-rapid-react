package frc.robot.commands.Auto;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Delay;
import frc.robot.commands.HomeAndZero;
import frc.robot.commands.HorizontalAim;
import frc.robot.commands.IntakeBall;
import frc.robot.commands.Auto.SpoolHighCommand;
import frc.robot.commands.stopIntake;
import frc.robot.subsystems.FlywheelShooter;
import frc.robot.commands.Load_To_Shooter_Auto;
import frc.robot.commands.Shooting2Balls;
import frc.robot.commands.StopShooter;
import frc.robot.commands.ZeroPos;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.AutoAim;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.RobotDrive;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.AutoAim;

public class Get2HighAuto extends SequentialCommandGroup{
    public Get2HighAuto(Intake intake, FlywheelShooter shooter, RobotDrive robotDrive, Elevator elevator, AutoAim aim) {
        addCommands(
            new HomeAndZero(shooter),
            new IntakeBall(intake), 
            new SpoolHighCommand(shooter),
            new AutoDrive(robotDrive, 0.6, 1500,0),//(robot, speed, and duration in millis, rotation in degrees)
            new stopIntake(intake),
            new AutoDrive(robotDrive, -0.6, 1000,0),//(robot, speed, and duration in millis, rotation in degrees)
            new ParallelDeadlineGroup(new Delay(2000), new HorizontalAim(aim, robotDrive, shooter)),
            new Shooting2Balls(elevator),
            new AutoDrive(robotDrive, 0.6, 1000,0),//(robot, speed, and duration in millis, rotation in degrees)
            new StopShooter(shooter)
        );
    }
}
