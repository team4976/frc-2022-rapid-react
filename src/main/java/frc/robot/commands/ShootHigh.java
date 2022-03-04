package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Shooter;

public class ShootHigh extends CommandBase {
    Shooter shooter;


    public ShootHigh(Shooter shooter) {
        this.shooter = shooter;

        addRequirements(shooter);
    }
    
    @Override
    public void initialize() {
        shooter.setShooterSpeed(Constants.kSHOOTER_HIGH_SPEED);
        super.initialize();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
