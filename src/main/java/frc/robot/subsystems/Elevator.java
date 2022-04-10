package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.*;

public class Elevator extends SubsystemBase {

    public VictorSPX indexer = new VictorSPX(kINDEX_NODE); // second motor to come in contact with the ball (placed at top of shooter)
    public VictorSPX intakeRoller = new VictorSPX(kINTAKE_MOTOR_NODE); // first motor to come in contact with the ball (furthest away from the center of the module)
    public DigitalInput indexSensor = new DigitalInput(kDIGITAL_INPUT);//Sensor conection placement thingie
    

    //Sets Bottom Motors Speed
    public void setRollerSpeed(double speed) {
        intakeRoller.set(ControlMode.PercentOutput, speed);
    }

    //Sets Top Motors Speed
    public void setIndexSpeed(double speed){
        indexer.set(ControlMode.PercentOutput, speed);
    }


    //Button Digital Input
    public boolean ballAtIndexer(){
        return indexSensor.get() == false;
    }

    //Sets Both Motors Speed
    public void setMotorSpeeds(double speed){
        indexer.set(ControlMode.PercentOutput, -speed);
        intakeRoller.set(ControlMode.PercentOutput, (speed));
    }

    //Ejects Balls from elevator
    public void eject(double speed){
        indexer.set(ControlMode.PercentOutput, -speed);
        intakeRoller.set(ControlMode.PercentOutput, -speed);
    }
}