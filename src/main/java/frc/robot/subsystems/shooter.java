package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.*;


public class shooter extends SubsystemBase {
    TalonFX shooterMotor = new TalonFX(kSHOOTER_A_NODE_ID);
    public void setShooterSpeed(double speed) {
        shooterMotor.set(ControlMode.Velocity, speed);
    }
}
