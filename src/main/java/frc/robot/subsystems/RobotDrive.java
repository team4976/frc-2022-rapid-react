package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.*;

public class RobotDrive extends SubsystemBase {
 
  public final TalonSRX left = new TalonSRX(kDRIVE_LEFT_A_NODE_ID);
  public final TalonSRX right = new TalonSRX(kDRIVE_LEFT_A_NODE_ID);

  public RobotDrive() {
    new VictorSPX(kDRIVE_LEFT_B_NODE_ID).follow(left);
    new VictorSPX(kDRIVE_RIGHT_B_NODE_ID).follow(right);
  }


  public void setArcadeDrive(double forward, double rotation) {
    left.set(ControlMode.PercentOutput, forward + rotation);
    right.set(ControlMode.PercentOutput, forward - rotation);
  }
}

