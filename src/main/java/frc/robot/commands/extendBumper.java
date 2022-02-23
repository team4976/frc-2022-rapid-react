package frc.robot.commands;

//import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.CommandBase;
//import frc.robot.Constants;
import frc.robot.subsystems.Intake;

public class extendBumper extends CommandBase {
    
    Intake intake;
    Solenoid piston = new Solenoid(40, PneumaticsModuleType.CTREPCM, 4);
    Intake extendBumper;
     
    public extendBumper(Intake intake){
        this.intake = intake; 
        addRequirements(intake);
    }
    
@Override
    public void initialize(){
       super.initialize();
      piston.set(true);
 }
}
