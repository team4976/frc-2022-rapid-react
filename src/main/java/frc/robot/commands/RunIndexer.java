package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.FlywheelShooter;

public class RunIndexer extends CommandBase {
    private FlywheelShooter shooter;

    public RunIndexer(FlywheelShooter shooter) {
            this.shooter = shooter;
    }

    @Override
    public boolean isFinished(){
        return true;
    }
    
    @Override
    public void initialize() {
        shooter.setIndexerSpeed(1);
    }
}
