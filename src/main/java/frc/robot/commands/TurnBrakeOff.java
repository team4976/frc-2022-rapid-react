package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;


public class TurnBrakeOff extends CommandBase {
    
    Climber climber; 
    @Override
    public void initialize(){
        climber.turnBrakeOff();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
