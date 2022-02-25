package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.RobotDrive;
public class EngagePrecision extends CommandBase {
    private RobotDrive robotDrive;
    
    public EngagePrecision(RobotDrive robotDrive){
        this.robotDrive = robotDrive;
        addRequirements(robotDrive);
    }

    @Override
    public void initialize(){
        super.initialize();
     //   robotDrive.setPrecisionMode();
    }

    @Override
    public void end(boolean interupted){
        super.initialize();
      //  robotDrive.endPrecisionMode();
    }

    public boolean isFinished(){
        return false;
    }
}

