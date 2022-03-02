package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class FlywheelShooter extends SubsystemBase {
    DigitalInput indexSensor = new DigitalInput(1);

    public TalonFX shootmotor = new TalonFX(kSHOOTER_A_NODE_ID);
    TalonSRX indexMotor = new TalonSRX(kINDEX_NODE_ID);
    public void shooterSpeed(double speed) {
        //shootmotor.set(ControlMode.Velocity,speed);
        shootmotor.set(ControlMode.PercentOutput, speed);
    }

    public void setShooterSpeed(double speed){
        shootmotor.set(ControlMode.PercentOutput, speed);
    }

    public void setIndexerSpeed(double speed){
        shootmotor.set(ControlMode.PercentOutput, speed);
    }

    public boolean ballAtIndexer() {
        return indexSensor.get() == false;
    }    
    
}
