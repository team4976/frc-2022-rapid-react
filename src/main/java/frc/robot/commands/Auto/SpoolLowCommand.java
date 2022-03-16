package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.FlywheelShooter;
import static frc.robot.Constants.*;

public class SpoolLowCommand extends CommandBase{
    FlywheelShooter shootmotor;

    public SpoolLowCommand(FlywheelShooter FShooter) {
        this.shootmotor = FShooter;
        addRequirements(FShooter);
    }

    @Override
    public void initialize(){
    shootmotor.shooterSpeed(kSHOOTER_LOW_SPEED);

    super.initialize();
}
@Override
public boolean isFinished() {
    // TODO Auto-generated method stub
    return true;
}
}
