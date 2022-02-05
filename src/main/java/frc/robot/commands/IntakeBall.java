package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class IntakeBall extends CommandBase {
    
    private Intake intake;

    public IntakeBall(Intake intake) {
        this.intake = intake;
        addRequirements(intake);
    }

    @Override
    public void initialize() {
        intake.intakeBall();
        super.initialize();
    }

    @Override
    public void end(boolean interrupted) {
        intake.stop();
        super.end(interrupted);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}