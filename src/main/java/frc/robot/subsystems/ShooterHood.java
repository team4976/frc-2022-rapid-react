package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterHood extends SubsystemBase{

    public final TalonSRX hood = new TalonSRX(0);

    public void LowHood() { 
      hood.setSelectedSensorPosition(0);
      hood.configMotionCruiseVelocity(1500);
      hood.configMotionAcceleration(1500);
      hood.set(ControlMode.MotionMagic, 1500);
    }

    public void HighHood() { 
        hood.setSelectedSensorPosition(0);
        hood.configMotionCruiseVelocity(1500);
        hood.configMotionAcceleration(1500);
        hood.set(ControlMode.MotionMagic, 1000);
    }
    public void FeildHood() { 
        hood.setSelectedSensorPosition(0);
        hood.configMotionCruiseVelocity(1500);
        hood.configMotionAcceleration(1500);
        hood.set(ControlMode.MotionMagic, 750);
    }
    public void FarHood() { 
        hood.setSelectedSensorPosition(0);
        hood.configMotionCruiseVelocity(1500);
        hood.configMotionAcceleration(1500);
        hood.set(ControlMode.MotionMagic, 150);
    }
    
}
