package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class FlywheelShooter extends SubsystemBase {
   public DigitalInput HomePosition = new DigitalInput(5);

    public TalonFX shootmotor = new TalonFX(kSHOOTER_A_NODE_ID);

    public final TalonSRX hoodMotor = new TalonSRX(kHOOD_NODE_ID);

    public FlywheelShooter() {
        shootmotor.setInverted(true);
        hoodMotor.setInverted(true);
        hoodMotor.setSensorPhase(true);
        hoodMotor.configPeakOutputForward(0.5);
        hoodMotor.configPeakOutputReverse(-0.2);
    }
    public void setHoodPosition (double position) {
        hoodMotor.configMotionCruiseVelocity(6000);
        hoodMotor.configMotionAcceleration(6000);
        hoodMotor.set(ControlMode.MotionMagic, position);
    }

    public void GoToHome (double position){
        hoodMotor.set(ControlMode.PercentOutput, position);
    }

    public void shooterSpeed(double speed) {
        //shootmotor.set(ControlMode.Velocity,speed);
        shootmotor.set(ControlMode.Velocity, speed);
    }

    public void setShooterSpeed(double speed){
        shootmotor.set(ControlMode.Velocity, speed);
    }
}
