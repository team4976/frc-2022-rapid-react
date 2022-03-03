package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;

public class passiveout extends CommandBase{

    Climber passiveout;
    
    public passiveout(Climber passiveout){
        this.passiveout = passiveout;
    }

    @Override
    public void initialize(){
       super.initialize();
       passiveout.passiveout();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
