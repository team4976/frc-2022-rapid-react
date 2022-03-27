package frc.robot.commands.drive;
import edu.wpi.first.wpilibj2.command.CommandBase;

import static frc.robot.RobotContainer.robotDrive;

public class EngageTurbo extends CommandBase {

    @Override
    public boolean isFinished(){
        return false;
    }
    
    @Override
    public void initialize(){
       robotDrive.setTurboMode();
    }

    @Override
    public void end(boolean interupted){
      robotDrive.endTurboMode();
    }
}
