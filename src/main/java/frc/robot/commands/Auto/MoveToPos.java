package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.RobotDrive;

public class MoveToPos extends SequentialCommandGroup{
    public MoveToPos(RobotDrive robotDrive){
        addCommands(
            new AutoDrive(robotDrive, 0.5, 10000, 0)
            //new AutoDrivePos(robotDrive, -12000)
        );
    }
    
}
