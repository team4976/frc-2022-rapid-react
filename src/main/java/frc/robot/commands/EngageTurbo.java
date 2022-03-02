package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.RobotDrive;
public class EngageTurbo extends CommandBase {

    private RobotDrive robotDrive;

    public EngageTurbo(RobotDrive robotDrive){
        this.robotDrive = robotDrive;
    }

    @Override
    public boolean isFinished(){
        return false;
    }
    
    @Override
    public void initialize(){
        super.initialize();
       robotDrive.setTurboMode();
    }

    @Override
    public void end(boolean interupted){
      robotDrive.endTurboMode();
    }
}
