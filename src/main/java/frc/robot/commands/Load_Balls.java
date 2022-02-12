package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator;
import static frc.robot.Constants.*;

/*
This Code runs while Intake is on
*/

public class Load_Balls extends CommandBase{
    
    private Elevator elevator;

    public Load_Balls(Elevator elevator){
        this.elevator = elevator;
        addRequirements(elevator);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void initialize() {
        elevator.setMotorSpeeds(kINITIAL_SPEED);
    }

    @Override
    public void execute(){
        if (elevator.ballAtIndexer()){
            elevator.setIndexSpeed(kSTOP_SPEED);
        }
    }

    @Override
    public void end(boolean interrupted) {
        elevator.setMotorSpeeds(kSTOP_SPEED);
    }

}
