package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
    
    TalonSRX intakeMotor = new TalonSRX(21);

    public void intakeBall() {
        intakeMotor.set(ControlMode.PercentOutput, 1);
    }

    public void ejectBall() {
        intakeMotor.set(ControlMode.PercentOutput, -1);
    }

    public void stop() {
        intakeMotor.set(ControlMode.PercentOutput, 0);
    }

    public bool isBallStored() {
        ///

        return false;
    }
}
