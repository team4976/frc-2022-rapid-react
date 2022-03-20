package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.FlywheelShooter;
import static frc.robot.Constants.*;

import com.ctre.phoenix.motorcontrol.ControlMode;

public class SpoolHigh extends CommandBase {
    
    FlywheelShooter shootmotor;

    public SpoolHigh(FlywheelShooter FShooter) {
        this.shootmotor = FShooter;
        addRequirements(FShooter);
    }

    // limelight ty / shooter speed / hood position
    // -7.04/10500/6000
    // -6.20/10500/6000
    // -4.35/10000/6000
    // -2.42/10000/6000
    // 0.20/9500/5000
    // 2.76/9500/5000
    // 5.78/9000/5000

    //fender speed/hood position
    // High - 9000/1500
    // Low - 4200/7950

    @Override
    public void initialize(){
        shootmotor.shooterSpeed(9500);
        shootmotor.setHoodPosition(5000);
    }
    
    @Override
    public void end(boolean interrupted) {
        shootmotor.shootmotor.set(ControlMode.PercentOutput, 0);
    }
}
