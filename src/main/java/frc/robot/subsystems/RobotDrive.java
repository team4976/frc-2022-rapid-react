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
  public final Solenoid gearbox = new Solenoid(10,PneumaticsModuleType.CTREPCM, 5);

  public RobotDrive() {
    new VictorSPX(kDRIVE_LEFT_B_NODE_ID).follow(left);
    new VictorSPX(kDRIVE_RIGHT_B_NODE_ID).follow(right);
  }
  public void fireGearbox(){
    gearbox.set(true);
  }

  public void firentGearbox(){
    gearbox.set(false);
  }
  

  public void setArcadeDrive(double forward, double rotation) {

    double output2=0;
    double output=0;
    double per = 0;
    rotation = -rotation;

    if (.1 < Math.abs(rotation)){

    if (rotation > .1){
     per = Math.abs(forward)*-1*rotation+.1;
    }
    else if (rotation < -.1){
     per = Math.abs(forward)*-1*rotation-.1;
      }

      output2=-forward;
      output=forward;


      if (rotation > 0 && forward > 0){
        output2= output2-per;
      }
      else if (rotation < 0 && forward < 0){
        output= output+per;
      }
      else if (rotation > 0 && forward < 0){
        output2 = output2+per;
      }
      else if (rotation < 0 && forward > 0){
        output = output-per;
      }
      else if (forward == 0 && rotation != 0){
       output2 = -rotation;
       output = -rotation;
      }







    left.set(ControlMode.PercentOutput, (-output));
    right.set(ControlMode.PercentOutput, (-output2));


    }

   
    else {
      left.set(ControlMode.PercentOutput, (-forward));
    right.set(ControlMode.PercentOutput, (forward));
    }
  }
}