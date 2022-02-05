package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
    
    TalonSRX intakeMotor = new TalonSRX(50);
    Solenoid pneumatic = new Solenoid(10,PneumaticsModuleType.CTREPCM,6);
    Compressor compressor = new Compressor(10, PneumaticsModuleType.CTREPCM);
    
    public void compressorCheck() {
        compressor.enableDigital();
    }
    
    public void intakeBall() {
        intakeMotor.set(ControlMode.PercentOutput, -0.8);
    }

    public void extendSolenoid(){
        pneumatic.set(true);
    }

    public void intendSolenoid(){
        pneumatic.set(false);
    }

    public void ejectBall() {
        intakeMotor.set(ControlMode.PercentOutput, 0.8);
    }

    public void stop() {
        intakeMotor.set(ControlMode.PercentOutput, 0);
    }

    public boolean isBallStored() {
        return false;
    }
}
