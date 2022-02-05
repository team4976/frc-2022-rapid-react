package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class IntakeIntend extends CommandBase{
    
    private Intake intake;

    public IntakeIntend(Intake intake){
        this.intake = intake;
        addRequirements(intake);
    } 

    @Override
    public void initialize(){
        intake.stop();
        intake.intendSolenoid();
    }

    @Override
    public boolean isFinished(){
        return true;
    }
}
