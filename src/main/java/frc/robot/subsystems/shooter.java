package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.*;

public class Shooter extends SubsystemBase {

    DigitalInput indexSensor = new DigitalInput(1);

    TalonFX shooter = new TalonFX(kSHOOTER_A_NODE_ID);

    public void seShooterSpeed(double speed) {
        shooter.set(ControlMode.Velocity, speed);
    }

    public boolean ballAtIndexer(){
        return indexSensor.get()
    }

}