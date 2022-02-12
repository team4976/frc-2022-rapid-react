package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Climber extends SubsystemBase {

    //Fix CAN IDs
    public CANSparkMax rightClimber = new CANSparkMax(49, CANSparkMaxLowLevel.MotorType.kBrushless);
    public CANSparkMax leftClimber = new CANSparkMax(48, CANSparkMaxLowLevel.MotorType.kBrushless);


    Solenoid climberBrake = new Solenoid(10, PneumaticsModuleType.CTREPCM, 4);

    //current encoder values are placeholders
    public void runClimberUp(double speed){
        rightClimber.set(speed);
        leftClimber.set(speed);
    }

    public void runClimberDown(double speed){
        rightClimber.set(-speed);
        leftClimber.set(-speed);
    }

    public void stopClimber(){
        rightClimber.set(-0.02);
        leftClimber.set(-0.02);
        System.out.println("Current Draw Right: " + rightClimber.getOutputCurrent() + " Current Draw Left: " + leftClimber.getOutputCurrent());
    }

    public void turnBrakeOff(){
        climberBrake.set(true);
    }

    public void turnBrakeOn(){
        climberBrake.set(false);
    }


}
