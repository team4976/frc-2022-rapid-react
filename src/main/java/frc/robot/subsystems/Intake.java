package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {

    //private static final int module =10;
    //private static final int channel =98;

    VictorSPX BottomElevator = new VictorSPX(20);
    TalonFX intakeMotor = new TalonFX(31);
    Solenoid piston = new Solenoid(40, PneumaticsModuleType.CTREPCM, 4);

    public void intakeBall() {
        intakeMotor.set(ControlMode.PercentOutput, 0.7);
        BottomElevator.set(ControlMode.PercentOutput, 0.5);
        piston.set(true);
    }

    public void ejectBall() {
        intakeMotor.set(ControlMode.PercentOutput, -0.7);
        BottomElevator.set(ControlMode.PercentOutput, -0.5);
        piston.set(true);
    }

    public void stopIntake() {
        intakeMotor.set(ControlMode.PercentOutput, 0);
        BottomElevator.set(ControlMode.PercentOutput,0);
        piston.set(false);
    }
    

    public void extendBumper(){
        piston.set(true);
    }
    
    public void retractBumper(){
        piston.set(false); 
    }
}
