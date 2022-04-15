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

public class Get2HighAuto extends SequentialCommandGroup{
    public Get2HighAuto(Intake intake, FlywheelShooter shooter, RobotDrive robotDrive, Elevator elevator, AutoAim aim) {
        addCommands(
            new HomeAndZero(shooter),
            new IntakeBall(intake), 
            new SpoolHighCommand(shooter),
            new AutoDrive(robotDrive, 0.6, 1500,0),//(robot, speed, and duration in millis, rotation in degrees)
            new stopIntake(intake),
            new AutoDrive(robotDrive, -0.6, 1000,0),//(robot, speed, and duration in millis, rotation in degrees)
            new ParallelDeadlineGroup(new Delay(2000), new HorizontalAim()),
            new Shooting2Balls(elevator),
            new AutoDrive(robotDrive, 0.6, 1000,0),//(robot, speed, and duration in millis, rotation in degrees)
            new StopShooter(shooter)
        );
    }
}
