package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.*;

public class Shooter extends SubsystemBase {
    
    TalonFX shootMotor = new TalonFX(kSHOOTER_A_NODE_ID);

    public void setShooterSpeed(double speed){
        shootMotor.set(ControlMode.PercentOutput, speed);
    }
}
