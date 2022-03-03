package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

public class FlywheelShooter extends SubsystemBase {
    public TalonFX shootmotor = new TalonFX(kSHOOTER_A_NODE_ID);
    Solenoid hood = new Solenoid(kDRIVE_PCM_NODE_ID, PneumaticsModuleType.CTREPCM, kSHOOTER_HOOD_ID);
    public FlywheelShooter(){
        shootmotor.setInverted(true);
    }   
    public void shooterSpeed(double speed) {
        shootmotor.set(ControlMode.Velocity,speed);
    }
    public void hoodOn(){
        hood.set(true);
    }
    public void hoodOff(){
        hood.set(false);
    }
}
