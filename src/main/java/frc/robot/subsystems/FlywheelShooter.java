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

    public TalonFX shootmotor = new TalonFX(kSHOOTER_A_NODE_ID);
    TalonSRX indexMotor = new TalonSRX(kINDEX_NODE_ID);
    Solenoid hood = new Solenoid(kDRIVE_PCM_NODE_ID, PneumaticsModuleType.CTREPCM, kSHOOTER_HOOD_ID);


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
    

    public FlywheelShooter(){
        shootmotor.setInverted(true);
    }   

    public void hoodOn(){
        hood.set(true);
    }
    public void hoodOff(){
        hood.set(false);
    }
}
