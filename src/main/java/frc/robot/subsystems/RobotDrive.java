package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.*;

public class RobotDrive extends SubsystemBase {

    public final TalonSRX left = new TalonSRX(kDRIVE_LEFT_B_NODE_ID);
    public final VictorSPX leftSecondary = new VictorSPX(kDRIVE_LEFT_A_NODE_ID);
    public final TalonSRX right = new TalonSRX(kDRIVE_RIGHT_B_NODE_ID);
    public final VictorSPX rightSecondary = new VictorSPX(kDRIVE_RIGHT_A_NODE_ID);



    public final Solenoid gearbox = new Solenoid(kPCM_NODE_ID, kPCM_TYPE, kSHIFT_SOLENOID_CHANNEL);

    public RobotDrive() {
        leftSecondary.follow(this.left);
        rightSecondary.follow(this.right);

        leftSecondary.setInverted(true);
        left.setInverted(true);

        rightSecondary.setInverted(false);
        right.setInverted(false);
    }

    public void setCoastMode() {
        left.setNeutralMode(NeutralMode.Coast);
        right.setNeutralMode(NeutralMode.Coast);

        leftSecondary.setNeutralMode(NeutralMode.Coast);
        rightSecondary.setNeutralMode(NeutralMode.Coast);
    }

    public void setBreakingMode() {
        left.setNeutralMode(NeutralMode.Brake);
        right.setNeutralMode(NeutralMode.Brake);

        leftSecondary.setNeutralMode(NeutralMode.Coast);
        rightSecondary.setNeutralMode(NeutralMode.Coast);
    }


    public void setArcadeDrive(double forward, double rotation) {

        if (Math.abs(rotation) < 0.1) rotation = 0;
        else rotation = rotation * rotation * (Math.abs(rotation) / rotation);

        left.set(ControlMode.PercentOutput, forward + rotation);
        right.set(ControlMode.PercentOutput, forward - rotation);
    }

    public void setTurboMode() {
        gearbox.set(true);
    }

    public void endTurboMode() {
        gearbox.set(false);
    }

    public void driveToPosition(double position) {//position in pulses(2048) per...
        right.setSelectedSensorPosition(0);
        right.configMotionCruiseVelocity(2800);
        right.configMotionAcceleration(2800);
        right.set(ControlMode.MotionMagic, position);
        left.setSelectedSensorPosition(0);
        left.configMotionCruiseVelocity(2800);
        left.configMotionAcceleration(2800);
        left.set(ControlMode.MotionMagic, position);

    }

    public void rotateOnPosition(double rotation) {
        right.configMotionCruiseVelocity(2000);
        right.configMotionAcceleration(2000);
        right.set(ControlMode.MotionMagic, -rotation);
        left.configMotionCruiseVelocity(2000);
        left.configMotionAcceleration(2000);
        left.set(ControlMode.MotionMagic, rotation);
    }
    public void resetPos () {
        right.setSelectedSensorPosition(0);
        left.setSelectedSensorPosition(0);
    }
  
  /*
  public void endPrecisionMode(){
    precisionMode = 1;
  }

  */
}