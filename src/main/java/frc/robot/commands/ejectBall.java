package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import frc.robot.Constants;
import frc.robot.subsystems.Intake;

public class ejectBall extends CommandBase{
    
Intake intake;

    Intake stopIntake;

    public ejectBall(Intake intake) {
        this.intake = intake;
        addRequirements(intake);
    }
    
@Override
    public void initialize(){
       super.initialize();
      intake.ejectBall();

 }
}
