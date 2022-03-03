package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.FlywheelShooter;
import static frc.robot.Constants.*;

public class SpoolHigh extends CommandBase {
    
    FlywheelShooter shootmotor;

    public SpoolHigh(FlywheelShooter FShooter) {
        this.shootmotor = FShooter;
        addRequirements(FShooter);
    }

    @Override
    public void initialize(){
    shootmotor.shooterSpeed(kSHOOTER_HIGH_SPEED);
        System.out.println("This is running");
    super.initialize();
}
@Override
    public boolean isFinished() {
        return false;
    }
    @Override
    public void end(boolean interrupted) {
        shootmotor.shooterSpeed(0);
        //shootmotor.hoodOff();
    }
}
