package frc.robot.subsystems;
import com.revrobotics.SparkMaxRelativeEncoder;
import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.CANSparkMax.SoftLimitDirection;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalGlitchFilter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.*;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;


public class Climber extends SubsystemBase {

public CANSparkMax rightClimber = new CANSparkMax(kCLIMBER_RIGHT_A_NODE_ID, CANSparkMaxLowLevel.MotorType.kBrushless);
public CANSparkMax leftClimber = new CANSparkMax(kCLIMBER_LEFT_A_NODE_ID, CANSparkMaxLowLevel.MotorType.kBrushless);
 
public Solenoid solenoidclimber = new Solenoid(kCLIMBER_MODLE_A_NODE_ID, PneumaticsModuleType.CTREPCM, kCLIMBER_CHANNEL_A_NODE_ID);
public Solenoid solenoidpassive1 = new Solenoid(kCLIMBER_MODLE_A_NODE_ID, PneumaticsModuleType.CTREPCM, kPASSIVECLIMBER_CHANNEL_A_NODE_ID);
DigitalInput bottomSensor = new DigitalInput(3);

boolean hasZeroedPosition = false;

public Climber(){
    rightClimber.follow(leftClimber, true);
    leftClimber.setInverted(true);
    // leftClimber.setSoftLimit(SoftLimitDirection.kForward, 100);
    // leftClimber.setSoftLimit(SoftLimitDirection.kReverse, 50);


}
public boolean climberBottom(){
    return bottomSensor.get() == false;
}

public void passiveout(){
    solenoidpassive1.set(true);
}

public void passivein(){
    solenoidpassive1.set(false);
}


public void extendarm(double output){
    if (climberBottom()) {
        hasZeroedPosition = true;
        leftClimber.getEncoder().setPosition(0);
        rightClimber.getEncoder().setPosition(0);
    }
    // System.out.println(hasZeroedPosition);
    if (Math.abs(output) < 0.05) output = 0;
    if (output !=0) {
        solenoidpassive1.set(output > 0);

        System.out.println(output + " " + climberBottom());

        if (output < 0 && !climberBottom()) {
            leftClimber.set(output);
        }
        else if (output > 0){
            leftClimber.set(output);
        }
        else {
            leftClimber.getPIDController().setReference(0, ControlType.kVelocity);
        }
        solenoidclimber.set(true);
    }
    else {
        leftClimber.getPIDController().setReference(0, ControlType.kVelocity);
    }
    


}

}
