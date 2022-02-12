package frc.robot.commands;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;


public class RunClimberUp extends CommandBase{
    
    Climber climber; 
    public CANSparkMax rightClimber = new CANSparkMax(49, CANSparkMaxLowLevel.MotorType.kBrushless);
    public CANSparkMax leftClimber = new CANSparkMax(48, CANSparkMaxLowLevel.MotorType.kBrushless);
    
    public RunClimberUp (Climber climber){
        this.climber = climber;
        addRequirements(climber);
    }

@Override
    public void initialize(){
       super.initialize();
       rightClimber.set(Constants.kCLIMBER_UP_SPEED);
        leftClimber.set(Constants.kCLIMBER_UP_SPEED);
      // a highly addictive analgesic drug derived from morphine, often used illicitly as a narcotic producing euphoria.
        //Has Passmore done speed?
    
    
    }
}
