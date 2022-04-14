package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;



import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.networktables.*;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.LED;



public class AutoAim extends SubsystemBase{
    
    public static PIDController controller = new PIDController(0.08, 0, 0);
    public static PIDController controller2 = new PIDController(0.1, 0, 0);
    public static NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");


    private static RobotDrive _drive;   


    public static boolean hasValidTarget(){
        double tv = table.getEntry("tv").getDouble(0);
        return tv > 0;
    }
    static int interval = 0;
    public static void target(RobotDrive _drive){ 
        if(interval++ % 3 != 0){
            return;
        } 
        double tx  = table.getEntry("tx").getDouble(0);
        double ty = table.getEntry("ty").getDouble(0);
        System.out.println(tx + ", " + ty);
        if(hasValidTarget()){
<<<<<<< Updated upstream
=======
            System.out.println(ty);
            if (ty >-10 && ty < -7.04) {
                shooter.setHoodPosition(7000);
                shooter.setShooterSpeed(11000);
                if (RobotContainer.shooter.shootmotor.getClosedLoopError()< 200){
                    Robot.led.setLed(120, 255, 255);
                }
                else{
                    Robot.led.setLed(30, 255, 255);
                }

            }

            else if(ty > -7.04 && ty < -6.20){
                shooter.setHoodPosition(6000);
                shooter.setShooterSpeed(10500);
                if (RobotContainer.shooter.shootmotor.getClosedLoopError()< 200){
                    Robot.led.setLed(120, 255, 255);
                }
                else{
                    Robot.led.setLed(30, 255, 255);
                }
            }
            else if(ty > -4.35 && ty < 0){
                shooter.setHoodPosition(6000);
                shooter.setShooterSpeed(10000);
                if (RobotContainer.shooter.shootmotor.getClosedLoopError()< 200){
                    Robot.led.setLed(120, 255, 255);
                }
                else{
                    Robot.led.setLed(30, 255, 255);
                }
            }
            else if(ty > 0 && ty < 2.76){
                shooter.setHoodPosition(5000);
                shooter.setShooterSpeed(9500);
                if (RobotContainer.shooter.shootmotor.getClosedLoopError()< 200){
                    Robot.led.setLed(120, 255, 255);
                }
                else{
                    Robot.led.setLed(30, 255, 255);
                }
            }
            else if(ty > 5.78){
                shooter.setHoodPosition(5000);
                shooter.setShooterSpeed(9000);
                if (RobotContainer.shooter.shootmotor.getClosedLoopError()< 200){
                    Robot.led.setLed(120, 255, 255);
                }
                else{
                    Robot.led.setLed(30, 255, 255);
                }
            }
>>>>>>> Stashed changes
        double horizontalAdjust = controller.calculate(tx,0);
        double verticalAdjust = controller2.calculate(ty, 0);
        if(horizontalAdjust > .6){horizontalAdjust = .6;}else if(horizontalAdjust < -0.6){horizontalAdjust = -0.6;}
        _drive.setArcadeDrive(-verticalAdjust, -horizontalAdjust);
        System.out.println(horizontalAdjust);
    }else{
        _drive.setArcadeDrive(0, 0);
        System.out.println("Theres no target");
        Robot.led.setLed(0, 255, 255);
    }

    }
    
}
//AHHHHHHHHHH