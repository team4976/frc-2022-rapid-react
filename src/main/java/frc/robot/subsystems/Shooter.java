package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


public class Shooter extends SubsystemBase{
    
    DigitalInput IndexSensor = new DigitalInput(1);

    TalonFX shootMotor = new TalonFX(kSHOOTER_A_NODE_ID);
    TalonSRX indexMotor = new TalonSRX(kINDEX_NODE_ID);

    public void setShooterspeed(double speed){
        shootMotor.set(ControlMode.PercentOutput, speed);
        
    }
    
    public void setIndexerSpeed(double speed) {
        indexMotor.set(ControlMode.PercentOutput, speed);
    }

    public boolean ballAtIndexer(){
        return IndexSensor.get() == false; 
    }
}
