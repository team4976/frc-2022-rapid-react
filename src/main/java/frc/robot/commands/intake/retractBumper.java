package frc.robot.commands.intake;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class retractBumper extends CommandBase {
    
    Intake intake;
    Intake retractBumper;
     
    public retractBumper(Intake intake){
        this.intake = intake; 
        addRequirements(intake);
    }
@Override
    public void initialize(){
       super.initialize();
      intake.retractBumper();
 }
}
