package frc.robot.commands.intake;

//import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.CommandBase;
//import frc.robot.Constants;
import frc.robot.subsystems.Intake;

public class extendBumper extends CommandBase {
    
    Intake intake;
    Intake extendBumper;
     
    public extendBumper(Intake intake){
        this.intake = intake; 
        addRequirements(intake);
    }
    
@Override
    public void initialize(){
       super.initialize();
      intake.extendBumper();
 }
}
