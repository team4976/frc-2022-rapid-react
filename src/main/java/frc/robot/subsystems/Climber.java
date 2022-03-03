package frc.robot.subsystems;
import com.revrobotics.SparkMaxRelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

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

public void passiveout(){
    solenoidpassive1.set(true);
}

public void passivein(){
    solenoidpassive1.set(false);
}


public void extendarm(double ext, double ret){
double climb = ext-ret;
solenoidclimber.set(true);
System.out.println(ext-ret);
if((climb) == 0){
    rightClimber.set(-0.05);
    leftClimber.set(0.05);
}
else{
    solenoidpassive1.set(climb>0);
    rightClimber.set(climb);
    leftClimber.set(-(climb));
 }

}

}
