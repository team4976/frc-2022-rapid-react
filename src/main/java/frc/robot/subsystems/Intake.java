package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {

    //private static final int module =10;
    //private static final int channel =98;

    VictorSPX BottomElevator = new VictorSPX(20);
    TalonSRX intakeMotor = new TalonSRX(31);
    Solenoid piston = new Solenoid(10, PneumaticsModuleType.CTREPCM, 98);

    public void intakeBall() {
        intakeMotor.set(ControlMode.PercentOutput, 0.7);
    }

    public void ejectBall() {
        intakeMotor.set(ControlMode.PercentOutput, -0.7);
    }

    public void stopIntake() {
        intakeMotor.set(ControlMode.PercentOutput, 0);
      //  BottomElevator.set(ControlMode.PercentOutput,0);
    }
    
    public void BottomElevatorRun(){
        BottomElevator.set(ControlMode. PercentOutput, 0.5);
    }

    public void BottomElevatorEject(){
        BottomElevator.set(ControlMode. PercentOutput, -0.5);
    }

    public void BottomElevatorStop(){
        BottomElevator.set(ControlMode.PercentOutput, 0.5);
    }

    public void extendBumper(){
        piston.set(true);
    }
    
    public void retractBumper(){
        piston.set(false); 
    }

    public boolean isBallStored() {
        ///

        return false;
    }
}
