package frc.robot.commands.Auto;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.RobotDrive;

public class AutoDrive extends CommandBase{
    RobotDrive robotDrive;
    double forwardSpeed;
    int duration;
    long startTime;
    int rotation;
    public AutoDrive(RobotDrive robotDrive, double forwardSpeed, int duration, int rotation){
        this.robotDrive=robotDrive;
        this.rotation = rotation;
        addRequirements(robotDrive);
        this.forwardSpeed=forwardSpeed;
        this.duration=duration;
    }
    @Override
    public void initialize() {
        System.out.println("begin auto drive");
        robotDrive.setArcadeDrive(forwardSpeed, rotation);// forward, and rotation
        startTime=System.currentTimeMillis();
        // TODO Auto-generated method stub
        super.initialize();
    }
    @Override
    public void end(boolean interrupted) {
        System.out.println("end auto drive");
        robotDrive.setArcadeDrive(0, 0);
        // TODO Auto-generated method stub
        super.end(interrupted);
    }
    @Override
    public boolean isFinished() {
        return System.currentTimeMillis()-startTime >= duration;
    }
    
}
