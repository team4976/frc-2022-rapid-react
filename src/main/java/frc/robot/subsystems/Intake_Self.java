package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake_Self extends SubsystemBase{

    TalonSRX intakeM = new TalonSRX(21);

    public void collectBall() {
        intakeM.set(ControlMode.PercentOutput, 1);
    }

    public void removeBall() {
        intakeM.set(ControlMode.PercentOutput, -1);
    }

    public void stop() {
        intakeM.set(ControlMode.PercentOutput, 0);
    }

    public boolean isBallHeld() {
        return false;
    }








}
