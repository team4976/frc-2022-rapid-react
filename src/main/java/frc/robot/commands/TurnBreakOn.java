package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;


public class TurnBreakOn extends CommandBase {
    
    Climber climber; 
    @Override
    public void initialize(){
        climber.turnBrakeOn();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
