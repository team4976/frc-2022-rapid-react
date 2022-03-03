package frc.robot.commands.Auto;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.IntakeBall;
import frc.robot.commands.RunIndexer;
import frc.robot.commands.SpoolHigh;
import frc.robot.commands.stopIntake;
import frc.robot.subsystems.FlywheelShooter;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.RobotDrive;
import frc.robot.subsystems.Shooter;

public class Autonomous extends SequentialCommandGroup{
    public Autonomous(Intake intakeSub, FlywheelShooter shooterSub, RobotDrive robotDrive) {
        addCommands(
            new IntakeBall(intakeSub), 
            new SpoolHigh(shooterSub),
            new AutoDrive(robotDrive, 0.6, 1000),//speed, and duration in millis
            new stopIntake(intakeSub),
            new AutoDrive(robotDrive, -0.6, 1000),//speed, and duration in millis
            new RunIndexer(shooterSub),
            new AutoDrive(robotDrive, 0.6, 1000)
        );
    }
}
