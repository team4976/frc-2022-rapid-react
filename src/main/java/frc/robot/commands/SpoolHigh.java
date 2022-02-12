package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.FlywheelShooter;
import static frc.robot.Constants.*;

public class SpoolHigh extends CommandBase {
    
    FlywheelShooter shootmotor;

    public SpoolHigh(FlywheelShooter FShooter) {
        this.shootmotor = FShooter;
        addRequirements(FShooter);
        FShooter.shooterSpeed(kSHOOTER_HIGH_SPEED);
    }

    @Override
    public void initialize(){


    super.initialize();
}
@Override
    public boolean isFinished() {
        return false;
    }
}
