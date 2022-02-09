package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Shooter extends SubsystemBase {

    TalonSRX shooter = new TalonSRX(KSHOOTER_NODE_ID); 
    TalonSRX indexMotor =new TalonSRX(kINDEX_NODE_ID); 
    DigitalInput indexSensor=new DigitalInput(1);

    public void shooterSpeed(double speed) {
        shooter.set(ControlMode.PercentOutput,speed); 

    } 

public void setIndexerSpeed(double speed){
    indexMotor.set(ControlMode.PercentOutput, speed);
}

    public boolean ballAtIndexer(){
        return indexSensor.get() ==false;
    }
}



  