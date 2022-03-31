package frc.robot.commands.auto;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Delay;
import frc.robot.commands.intake.IntakeBall;
import frc.robot.commands.intake.stopIntake;
import frc.robot.subsystems.FlywheelShooter;
import frc.robot.commands.shooter.Shooting2Balls;
import frc.robot.commands.shooter.StopShooter;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.RobotDrive;

public class Autonomous extends SequentialCommandGroup{
    public Autonomous(Intake intakeSub, FlywheelShooter shooterSub, RobotDrive robotDrive, Elevator elevator) {
        addCommands(
            new IntakeBall(intakeSub), 
            new SpoolHighCommand(shooterSub),
            new AutoDrive(robotDrive, 0.6, 1500, 0),//speed, duration in millis, and rotation
            new stopIntake(intakeSub),
            new AutoDrive(robotDrive, -0.6, 1450, 0),//speed, duration in millis, and rotation
            new Delay(1000),
            new Shooting2Balls(elevator),
            new AutoDrive(robotDrive, 0.6, 2000, 0),  
            new StopShooter(shooterSub)
        );
    }
}
