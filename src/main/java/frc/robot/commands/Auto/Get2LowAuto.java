package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Delay;
import frc.robot.commands.IntakeBall;
import frc.robot.commands.Shooting2Balls;
import frc.robot.commands.StopShooter;
import frc.robot.commands.stopIntake;
import frc.robot.subsystems.AutoAim;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.FlywheelShooter;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.RobotDrive;

public class Get2LowAuto extends SequentialCommandGroup {
    public Get2LowAuto (Intake intake, FlywheelShooter shooter, RobotDrive robotDrive, Elevator elevator, AutoAim aim){
        addCommands(
            new IntakeBall(intake), 
            new SpoolLowCommand(shooter),
            new AutoDrive(robotDrive, -0.6, 1500,0),//(robot, speed, and duration in millis, rotation in degrees)
            new stopIntake(intake),
            new AutoDrive(robotDrive, 0.6, 2450,0),//(robot, speed, and duration in millis, rotation in degrees)
            new Delay(1000),
            new AutoAimAuto(aim, robotDrive, 1000),//aims for 1 second
            new Shooting2Balls(elevator),
            new AutoDrive(robotDrive, -0.6, 2000,0),//(robot, speed, and duration in millis, rotation in degrees)
            new StopShooter(shooter)
        );
    }
    
}
