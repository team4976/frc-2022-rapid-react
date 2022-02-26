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


public Solenoid solenoidclimber = new Solenoid(kCLIMBER_MODLE_A_NODE_ID, PneumaticsModuleType.CTREPCM, kCLIMBER_CHANNEL_A_NODE_ID);
public CANSparkMax rightClimber = new CANSparkMax(kCLIMBER_RIGHT_A_NODE_ID, CANSparkMaxLowLevel.MotorType.kBrushless);
public CANSparkMax leftClimber = new CANSparkMax(kCLIMBER_LEFT_A_NODE_ID, CANSparkMaxLowLevel.MotorType.kBrushless);


public void extendarm(double ext, double ret){
solenoidclimber.set(true);
rightClimber.set(ext-ret);
leftClimber.set(-(ext-ret));
System.out.println(ext-ret);
if((ext-ret) == 0){
    rightClimber.set(0.02);
    leftClimber.set(-0.02);
}
}

}
