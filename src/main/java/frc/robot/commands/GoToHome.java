package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.FlywheelShooter;
import frc.robot.subsystems.Shooter;

public class GoToHome extends CommandBase{
    FlywheelShooter shooter;

    public GoToHome (FlywheelShooter shooter){
        this.shooter=shooter;
        addRequirements(shooter);
        
    }

    @Override
    public void initialize() {
        super.initialize();
        shooter.GoToHome(-.5);
    }

    @Override
    public void end(boolean interrupted) {
        shooter.GoToHome(0);
    }

    @Override
    public boolean isFinished() {
      return !this.shooter.HomePosition.get();
    }
    
}
