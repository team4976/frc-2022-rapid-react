package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;

public class zeroencoder extends CommandBase{
    private final Climber _zero;


    
    public zeroencoder(
        Climber zero
    ){
        _zero = zero;
    }
    public void execute(){
        _zero.zeroencoder();
    }

}
