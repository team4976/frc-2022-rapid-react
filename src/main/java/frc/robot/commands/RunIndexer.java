package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.FlywheelShooter;

public class RunIndexer extends CommandBase {
    private Elevator shooter;
    long startTime;
    int duration;

    public RunIndexer(Elevator shooter, int duration) {
            this.shooter = shooter;
            this.duration = duration;
    }

    @Override
    public boolean isFinished(){
        return System.currentTimeMillis()-startTime >= duration;
    }
    
    @Override
    public void initialize() {
        shooter.setMotorSpeeds(1);
        startTime=System.currentTimeMillis();


    }
}
