package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

public class FlywheelShooter extends SubsystemBase {
    public TalonFX shootmotor = new TalonFX(kSHOOTER_A_NODE_ID);

    public void shooterSpeed(double speed) {
        //shootmotor.set(ControlMode.Velocity,speed);
        shootmotor.set(ControlMode.PercentOutput, speed);
    }
    
}
