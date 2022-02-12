package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.FlywheelShooter;
import static frc.robot.Constants.*;

public class EjectBall extends CommandBase {

    FlywheelShooter shootmotor;

    public EjectBall(FlywheelShooter FShooter) {
        this.shootmotor = FShooter;
        addRequirements(FShooter);
        FShooter.shooterSpeed(kSHOOTER_EEJECT_SPEED);
    
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
