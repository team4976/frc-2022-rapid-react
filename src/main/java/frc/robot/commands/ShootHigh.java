package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;
import frc.robot.Constants;
import frc.robot.Constants.*;


public class ShootHigh extends CommandBase { 
    

    Shooter shooter; 

    public ShootHigh (Shooter shooter){ 
    this.shooter = shooter; 
    addRequirements(shooter); 
} 


@Override 
public void initialize() {
     shooter.shooterSpeed(Constants.kSHOOT_HIGH_SPEED);
     
}

@Override
public boolean isFinished(){
    return true;
  }  
}
