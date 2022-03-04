package frc.robot.commands;

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
            shootmotor.shooterSpeed(0);
        }
        @Override
        public boolean isFinished() {
            return true;
        }
    
}
