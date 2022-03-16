package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class FlywheelShooter extends SubsystemBase {
    DigitalInput indexSensor = new DigitalInput(1);
   public DigitalInput HomePosition = new DigitalInput(2);

    public TalonFX shootmotor = new TalonFX(kSHOOTER_A_NODE_ID);
    TalonSRX indexMotor = new TalonSRX(kINDEX_NODE_ID);

    public final TalonSRX hoodMotor = new TalonSRX(kHOOD_NODE_ID);

    public FlywheelShooter() {
        shootmotor.setInverted(true);
        hoodMotor.setInverted(true);
        hoodMotor.setSensorPhase(true);
        hoodMotor.configPeakOutputForward(0.2);
        hoodMotor.configPeakOutputReverse(-0.1);
    }
    public void setHoodPosition (double position) {
        hoodMotor.configMotionCruiseVelocity(2000);
        hoodMotor.configMotionAcceleration(4000);
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

    public void setIndexerSpeed(double speed){
        shootmotor.set(ControlMode.Velocity, speed);
    }

    public boolean ballAtIndexer() {
        return indexSensor.get() == false;
    }    
    
}
