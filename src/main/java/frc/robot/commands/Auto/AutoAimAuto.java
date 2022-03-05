package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.commands.HorizontalAim;
import frc.robot.subsystems.AutoAim;
import frc.robot.subsystems.RobotDrive;

public class AutoAimAuto extends CommandBase{
    private final HorizontalAim aim;
    int duration;
    long startTime;
    public AutoAimAuto (AutoAim autoaim, RobotDrive robotDrive, int duration){
        aim = new HorizontalAim(autoaim, robotDrive);
        this.duration = duration;
        addRequirements(autoaim);
    }
    
    @Override
    public boolean isFinished() {
        return System.currentTimeMillis()-startTime >= duration;
    }
    @Override
    public void initialize() {
        aim.schedule();
        startTime=System.currentTimeMillis();
    }
    @Override
    public void end(boolean interrupted) {
        aim.cancel();
    }
}
