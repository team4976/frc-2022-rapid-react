package frc.robot.commands.elevator;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator;
import static frc.robot.Constants.*;

/*
This Code runs while Intake is on
*/

public class StopLoadBallsAuto extends CommandBase{
    
    private Elevator elevator;
    
    public StopLoadBallsAuto(Elevator elevator){
        this.elevator = elevator;
        addRequirements(elevator);
    }


    @Override
    public void initialize() {
        elevator.setIndexSpeed(0);
        elevator.setRollerSpeed(0);
    }
    @Override
    public boolean isFinished() {
        return true;
    }

}
