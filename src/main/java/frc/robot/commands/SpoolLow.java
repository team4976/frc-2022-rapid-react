package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.FlywheelShooter;
import static frc.robot.Constants.*;

public class SpoolLow extends CommandBase {

    FlywheelShooter shootmotor;

    public SpoolLow(FlywheelShooter FShooter) {
        this.shootmotor = FShooter;
        addRequirements(FShooter);
        FShooter.shooterSpeed(kSHOOTER_LOW_SPEED);
    
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
