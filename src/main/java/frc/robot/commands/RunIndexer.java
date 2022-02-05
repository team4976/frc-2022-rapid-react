package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class RunIndexer extends CommandBase{

    private Shooter shooter;
    
    public RunIndexer(Shooter shooter) {
            this.shooter = shooter;
    }
    
    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void initialize() {
        shooter.setIndexerSpeed(1);
    }

    @Override
    public void end(boolean interrupted) {
        shooter.setIndexerSpeed(0);
    }
}
