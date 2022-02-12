package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.*;

public class RobotDrive extends SubsystemBase {
 
  public final TalonSRX left = new TalonSRX(kDRIVE_LEFT_A_NODE_ID);
  public final TalonSRX right = new TalonSRX(kDRIVE_RIGHT_A_NODE_ID);
  public final Solenoid gearbox = new Solenoid(kDRIVE_GEARBOX_PNEUMATIC_NODE_ID,PneumaticsModuleType.CTREPCM, kDRIVE_GEARBOX_PNEUMATIC_PORT_ID);

  public RobotDrive() {
    new VictorSPX(kDRIVE_LEFT_B_NODE_ID).follow(left);
    new VictorSPX(kDRIVE_RIGHT_B_NODE_ID).follow(right);
  }
  
  public void setArcadeDrive(double forward, double rotation) {
    if (rotation > .2){
    double steer;
   steer = rotation*Math.abs(forward*kDRIVE_SENSITIVITY_LEVEL);


    left.set(ControlMode.PercentOutput, (-forward-steer) );
    right.set(ControlMode.PercentOutput,(-forward+steer) );
    }
  }
  public void setPrecisionMode(){
    kDRIVE_SENSITIVITY_LEVEL = (kDRIVE_SENSITIVITY_LEVEL)/2;
  }

  public void endPrecisionMode(){
    kDRIVE_SENSITIVITY_LEVEL = (kDRIVE_SENSITIVITY_LEVEL*2);
  }

  public void setTurboMode(){
    gearbox.set(true);
  }

  public void endTurboMode(){
    gearbox.set(false);
  }
}