package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxRelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


public class Climber extends SubsystemBase {
    
private RelativeEncoder m_encoder;


public Solenoid solenoidclimber = new Solenoid(kCLIMBER_MODLE_A_NODE_ID, PneumaticsModuleType.CTREPCM, kCLIMBER_CHANNEL_A_NODE_ID);

public CANSparkMax rightClimber = new CANSparkMax(kCLIMBER_LEFT_A_NODE_ID, CANSparkMaxLowLevel.MotorType.kBrushless);//CANSparkMaxLowLevel.MotorType.kBrushless);
public CANSparkMax leftClimber = new CANSparkMax(kCLIMBER_RIGHT_A_NODE_ID, CANSparkMaxLowLevel.MotorType.kBrushless);


public void zeroencoder(){
    m_encoder = rightClimber.getEncoder(SparkMaxRelativeEncoder.Type.kQuadrature, 4096);
    m_encoder.setPosition(0);
}


public void extendarm(double ext, double ret){

double Height = m_encoder.getPosition();

solenoidclimber.set(true);
if ((Height >= 100 && ext-ret > 0) || (Height <= 0 && ext-ret < 0)){
}
else {
rightClimber.set(ext-ret);
leftClimber.set(-(ext-ret));
}


}

}
