package frc.robot.commands.elevator;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator;
import static frc.robot.Constants.*;

/*
This Code runs while Intake is on
*/

public class StartLoadBallsAuto extends CommandBase{
    
    private Elevator elevator;
    
    public StartLoadBallsAuto(Elevator elevator){
        this.elevator = elevator;
        addRequirements(elevator);
    }


    @Override
    public void initialize() {
        elevator.setIndexSpeed(-0.2);
        elevator.setRollerSpeed(0.4);
    }
    @Override
    public boolean isFinished() {
        // TODO Auto-generated method stub
        return true;
    }

}
