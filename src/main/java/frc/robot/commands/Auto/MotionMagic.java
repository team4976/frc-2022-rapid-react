package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.RobotDrive;

public class MotionMagic extends CommandBase {
 
    RobotDrive robotDrive;

    public MotionMagic(RobotDrive robotDrive){
        this.robotDrive = robotDrive;
        addRequirements(robotDrive);
    }
    
    public void initialize(){
        robotDrive.driveToPosition(10000);
    }


}



class Foo {

    public Foo() {

    }

    public void func() {

    
    }
}