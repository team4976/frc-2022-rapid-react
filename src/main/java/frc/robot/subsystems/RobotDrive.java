package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.*;

public class RobotDrive extends SubsystemBase {
  //public void setPrecisionMode(){
    //precisionMode = 0.1;
    //System.out.println("Yes");
 // }
  public final TalonSRX left = new TalonSRX(kDRIVE_LEFT_B_NODE_ID);
  public final TalonSRX right = new TalonSRX(kDRIVE_RIGHT_B_NODE_ID);
  public final Solenoid gearbox = new Solenoid(kDRIVE_PCM_NODE_ID,PneumaticsModuleType.CTREPCM, kDRIVE_GEARBOX_PNEUMATIC_PORT_ID);
  public RobotDrive() {
    left.setNeutralMode(NeutralMode.Brake);
    right.setNeutralMode(NeutralMode.Brake);
    new VictorSPX(kDRIVE_LEFT_A_NODE_ID).follow(left);
    new VictorSPX(kDRIVE_RIGHT_A_NODE_ID).follow(right);
  }
  double steer = 0.0;
    public void setArcadeDrive(double forward, double rotation) {

      if (Math.abs(rotation) > 0.1 || Math.abs(forward) > 0.05) {
        left.set(ControlMode.PercentOutput, (forward-rotation) );
        right.set(ControlMode.PercentOutput,(-forward-rotation) );
      } else {
        left.set(ControlMode.PercentOutput, 0);
        right.set(ControlMode.PercentOutput, 0);
      }
      

      // if ( Math.abs(steer) > 0.10){
      //   steer = 0;
      // }
      // else{
      //   steer = rotation*Math.abs(forward*kDRIVE_SENSITIVITY_LEVEL*precisionMode);
      // }
    //steer = rotation*Math.abs(forward*kDRIVE_SENSITIVITY_LEVEL*precisionMode);
   } 
   public void setTurboMode(){
    gearbox.set(true);
    System.out.print("I'm running!");
  }

  public void endTurboMode(){
    gearbox.set(false);
  }
  
  /*
  public void endPrecisionMode(){
    precisionMode = 1;
  }

  */
}