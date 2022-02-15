package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.FlywheelShooter;
import frc.robot.subsystems.ShooterCommand;

public class RunIndexer extends CommandBase {
    private FlywheelShooter shooter;

    public RunIndexer(FlywheelShooter _shooter){
        this.shooter = _shooter;

    }

    @Override
    public boolean isFinished(){
        return false;
    }
    
    @Override
    public void initialize() {
        shooter.setIndexerSpeed(1);
    }
}
