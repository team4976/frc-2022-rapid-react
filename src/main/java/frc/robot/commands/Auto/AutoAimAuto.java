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
    }
    
    @Override
    public boolean isFinished() {
        return System.currentTimeMillis()-startTime >= duration;
    }
    @Override
    public void initialize() {
        startTime=System.currentTimeMillis();
        aim.schedule();
    }
    @Override
    public void end(boolean interrupted) {
        aim.cancel();
    }
}
