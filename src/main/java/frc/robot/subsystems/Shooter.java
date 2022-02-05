package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.*;


public class Shooter extends SubsystemBase{
    
    DigitalInput indexSensor = new DigitalInput(1);

    TalonFX shooter = new TalonFX(kSHOOTER_A_NODE_ID);
    TalonSRX indexMotor = new TalonSRX(kINDEX_NODE_ID);



    public void shooterSpeed(double speed) {

            //shootMotor.set(ControlMode.PercentOutput, kSHOOT_HIGH_SPEED);
        shooter.set(ControlMode.Velocity, speed);
    }

    public void setIndexSpeed(double speed) {
        indexMotor.set(ControlMode.PercentOutput, speed);
    }


    public boolean ballAtIndexer(){
        return indexSensor.get() == false;
    }




}
