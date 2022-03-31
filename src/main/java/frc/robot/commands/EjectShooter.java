package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.FlywheelShooter;

public class EjectShooter extends CommandBase {
    FlywheelShooter shooter;
    public EjectShooter(FlywheelShooter shooter){
        this.shooter=shooter;
        addRequirements(shooter);
    }

    @Override
    public void initialize() {
        shooter.shootmotor.set(ControlMode.PercentOutput, -0.25);
        super.initialize();
    }

    @Override
    public void end(boolean interrupted) {
        shooter.shootmotor.set(ControlMode.PercentOutput, 0);
    }
}
