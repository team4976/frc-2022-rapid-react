package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.FlywheelShooter;
import static frc.robot.Constants.*;

import com.ctre.phoenix.motorcontrol.ControlMode;

public class SpoolLow extends CommandBase {

    FlywheelShooter shootmotor;

    public SpoolLow(FlywheelShooter FShooter) {
        this.shootmotor = FShooter;
        addRequirements(FShooter);
    
}
    @Override
    public void initialize(){
    shootmotor.shooterSpeed(kSHOOTER_LOW_SPEED);
    //shootmotor.hoodOn();
    shootmotor.setHoodPosition(7950);

    super.initialize();
}
@Override
    public boolean isFinished() {
        return false;
}
@Override
    public void end(boolean interrupted) {
        shootmotor.shootmotor.set(ControlMode.PercentOutput, 0);
        //shootmotor.hoodOff();
    }
}
