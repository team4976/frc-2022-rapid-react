package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.*;

public class Intake extends SubsystemBase {

    //private static final int module =10;
    //private static final int channel =98;

    boolean intaking = false;

    VictorSPX BottomElevator = new VictorSPX(kINTAKE_MOTOR_NODE);
    VictorSPX TopElevator  = new VictorSPX(kINDEX_NODE);
    TalonFX intakeMotor = new TalonFX(kINTAKE_NODE);
    Solenoid piston = new Solenoid(kPCM_NODE_ID, kPCM_TYPE, kINTAKE_SOLENOID_CHANNEL);

    public void intakeBall() {
        intaking = true;
        intakeMotor.set(ControlMode.PercentOutput, kINTAKE_RUN);
        BottomElevator.set(ControlMode.PercentOutput, kBOTTOM_ELEVATOR);
        piston.set(true);
    }

    public void ejectBall() {
        intakeMotor.set(ControlMode.PercentOutput, kEJECT_INTAKE);
        BottomElevator.set(ControlMode.PercentOutput, kBOTTOM_ELEVATOR_EJECT);
        TopElevator.set(ControlMode.PercentOutput, kTOP_ELEVATOR_EJECT);
        piston.set(true);
    }

    public void stopIntake() {
        TopElevator.set(ControlMode.PercentOutput, 0);
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
