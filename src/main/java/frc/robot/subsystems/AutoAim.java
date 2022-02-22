package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.networktables.*;

public class AutoAim extends SubsystemBase{
    
    public static PIDController controller = new PIDController(0.1, 0.01, 0);
    public static NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");

    public static void target(){    
        double tx  = table.getEntry("tx").getDouble(0);
        double ty = table.getEntry("ty").getDouble(0);
        System.out.println(tx + ", " + ty);
        if(hasValidTarget()){
        double horizontalAdjust = controller.calculate(tx,0);
        double verticalAdjust = controller.calculate(ty, 0);
        RobotDrive.left.set(ControlMode.PercentOutput, horizontalAdjust + verticalAdjust);//It should autocalculate them both, it might freak the hell out
        RobotDrive.right.set(ControlMode.PercentOutput, -horizontalAdjust + verticalAdjust);


    }else{
        RobotDrive.left.set(ControlMode.PercentOutput, 0);
        RobotDrive.right.set(ControlMode.PercentOutput, 0);
        System.out.println("Theres no target");

    }

    }
    public static boolean hasValidTarget(){
        double tv = table.getEntry("tv").getDouble(0);
        System.out.println(tv);
        return tv > 0;
    }
}