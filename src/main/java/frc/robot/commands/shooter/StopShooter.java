package frc.robot.commands.shooter;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.FlywheelShooter;

public class StopShooter extends CommandBase{

    FlywheelShooter shootmotor;
    
    public StopShooter(FlywheelShooter FShooter) {
        this.shootmotor = FShooter;
        addRequirements(FShooter);
    
}
        @Override
        public void initialize(){
            super.initialize();
            shootmotor.shootmotor.set(ControlMode.PercentOutput, 0);
        }
        @Override
        public boolean isFinished() {
            return true;
        }
    
}
