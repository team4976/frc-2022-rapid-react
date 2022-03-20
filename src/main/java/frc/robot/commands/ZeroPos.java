package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.FlywheelShooter;

public class ZeroPos extends CommandBase{
    
    FlywheelShooter shooter;

    public ZeroPos (FlywheelShooter shooter){
        this.shooter=shooter;
        addRequirements(shooter);
        
    }

    @Override
    public void initialize() {
        super.initialize();
        shooter.GoToHome(.2);
    }

    @Override
    public void end(boolean interrupted) {
        shooter.GoToHome(0);
        shooter.hoodMotor.setSelectedSensorPosition(0);
    }

    @Override
    public boolean isFinished() {
      return this.shooter.HomePosition.get();
    }
}
