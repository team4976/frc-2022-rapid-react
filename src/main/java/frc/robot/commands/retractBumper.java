package frc.robot.commands;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class retractBumper extends CommandBase {
    
    Intake intake;
    Solenoid piston = new Solenoid(10, PneumaticsModuleType.CTREPCM, 98);
    
    Intake retractBumper;
     
    public retractBumper(Intake intake){
        this.intake = intake; 
        addRequirements(intake);
    }
@Override
    public void initialize(){
       super.initialize();
      piston.set(true);
 }
}
