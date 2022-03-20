package frc.robot.commands.Auto;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.RobotDrive;

public class AutoDrivePos extends CommandBase{
    RobotDrive robotDrive;
    double position;
    int duration;
    long startTime;
    int rotation;
    public AutoDrivePos(RobotDrive robotDrive, double position){
        this.robotDrive=robotDrive;
        addRequirements(robotDrive);
        this.position=position;
    }
    @Override
    public void initialize() {
        System.out.println("begin auto drive");
        robotDrive.driveToPosition(position);// position
        //startTime=System.currentTimeMillis();// wheel to wheel distance ~ 2 feet
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

        double leftError = Math.abs(position - robotDrive.left.getSelectedSensorPosition());
        double rightError = Math.abs(position - robotDrive.right.getSelectedSensorPosition());

        boolean inDeadband = Math.max(leftError, rightError) < 200;

        boolean hasStopped = Math.abs(robotDrive.left.getSelectedSensorVelocity()) < 1 
        && Math.abs(robotDrive.right.getSelectedSensorVelocity()) < 1; 



        return inDeadband && hasStopped;
    }
    
}

