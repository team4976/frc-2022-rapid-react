package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.FlywheelShooter;

public class LowShootHood extends CommandBase {

    FlywheelShooter shooter;

    public LowShootHood(FlywheelShooter shooter){
        this.shooter=shooter;
        addRequirements(shooter);
    }

    @Override
    public void initialize() {
        super.initialize();
        //shooter.setHoodPosition(4000); tarmac shot
        shooter.setHoodPosition(862);
    }

    @Override
    public boolean isFinished() {
        return true;
    }
    
    
}
