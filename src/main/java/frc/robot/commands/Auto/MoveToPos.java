package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.RobotDrive;

public class MoveToPos extends SequentialCommandGroup{
    public MoveToPos(RobotDrive robotDrive){
        addCommands(
            new AutoDrive(robotDrive, 0, 10000, 0.5)
            //new AutoDrivePos(robotDrive, -12000)
        );
    }
    
}
