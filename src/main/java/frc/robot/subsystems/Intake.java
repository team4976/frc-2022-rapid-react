package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.*;

public class Intake extends SubsystemBase {

    private static final int module =10;
    private static final int channel =98;
    private static final TalonSRX BottomElevator = null;

    TalonSRX intakeMotor = new TalonSRX(21); 
    Solenoid piston = new Solenoid(module, PneumaticsModuleType.CTREPCM, channel);
VictorSPX bottomelevator = new VictorSPX(kELEVATOR_BOTTOM_NODE_ID); 

    public void intakeBall() { 
        intakeMotor.set(ControlMode.PercentOutput, 1);
        bottomelevator.set(ControlMode. PercentOutput, 1);
        piston.set(true); 
    }

    public void ejectBall() { 
        intakeMotor.set(ControlMode.PercentOutput, -1); 
        bottomelevator.set(ControlMode.PercentOutput,-1);
        piston.set(true); 
    }

    public void stop() {
        intakeMotor.set(ControlMode.PercentOutput, 0); 
        bottomelevator.set(ControlMode.PercentOutput,0);
        piston.set(false); 
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
