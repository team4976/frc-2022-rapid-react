package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class Delay extends CommandBase {
    long startTime;
    int duration;

    public Delay (int duration){
        this.duration = duration;
    }
    @Override
    public void initialize() {
        startTime = System.currentTimeMillis();
    }
    @Override
    public boolean isFinished() {
        return System.currentTimeMillis() - startTime >= duration;
    }
    
}
