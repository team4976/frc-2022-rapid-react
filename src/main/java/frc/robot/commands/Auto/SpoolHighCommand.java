package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.FlywheelShooter;
import static frc.robot.Constants.*;

public class SpoolHighCommand extends CommandBase{
    FlywheelShooter shootmotor;

    public SpoolHighCommand(FlywheelShooter FShooter) {
        this.shootmotor = FShooter;
        addRequirements(FShooter);
    }

    @Override
    public void initialize(){
    shootmotor.shooterSpeed(kSHOOTER_HIGH_SPEED);
    shootmotor.setHoodPosition(4000);

    super.initialize();
}
@Override
public boolean isFinished() {
    // TODO Auto-generated method stub
    return true;
}
}
