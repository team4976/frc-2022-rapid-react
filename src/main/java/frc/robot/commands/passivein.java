package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;

public class passivein extends CommandBase{

    Climber passivein;
    
    public passivein(Climber passivein){
        this.passivein = passivein;
        addRequirements(passivein);
    }

    @Override
    public void initialize(){
       super.initialize();
       passivein.passivein();
    }
}
