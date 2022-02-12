package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.CommandBase;


public class RunIndexer extends CommandBase{
    
    private Shooter shooter;

    public RunIndexer(Shooter shooter){
        this.shooter = shooter;
    }

    @Override
    public boolean isFinished(){
        return false;
    }

    @Override
    public void initialize(){
         shooter.setIndexerSpeed(1);
    }

    @Override 
    public void end(boolean interupted){
        shooter.setIndexerSpeed(0);
    }


}
