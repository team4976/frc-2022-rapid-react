package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.*;

public class Shooter extends SubsystemBase {

    TalonFX shooter = new TalonFX(kSHOOTER_A_NODE_ID);

    public void ShooterSpeed(double speed) {
        shooter.set(ControlMode.Velocity, speed);
      }

}