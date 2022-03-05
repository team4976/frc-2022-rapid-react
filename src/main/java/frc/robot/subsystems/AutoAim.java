package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;



import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.networktables.*;


public class AutoAim extends SubsystemBase{
    
    public static PIDController controller = new PIDController(0.025, 0.002, 0.0);
    public static PIDController controller2 = new PIDController(0.05, 0.01, 0.5);
    public static NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");


    private static RobotDrive _drive;   


    public static boolean hasValidTarget(){
        double tv = table.getEntry("tv").getDouble(0);
        return tv > 0;
    }

    public static void target(RobotDrive _drive){   
        double tx  = table.getEntry("tx").getDouble(0);
        double ty = table.getEntry("ty").getDouble(0);
        System.out.println(tx + ", " + ty);
        if(hasValidTarget()){
        double horizontalAdjust = controller.calculate(tx,0);
        double verticalAdjust = controller2.calculate(ty, 0);
        if(horizontalAdjust > .6){horizontalAdjust = .6;}else if(horizontalAdjust < -0.6){horizontalAdjust = -0.6;}
        _drive.setArcadeDrive(0, -horizontalAdjust);
        System.out.println(horizontalAdjust);
    }else{
        _drive.setArcadeDrive(0, 0);
        System.out.println("Theres no target");

    }

    }
    
}
//AHHHHHHHHHH