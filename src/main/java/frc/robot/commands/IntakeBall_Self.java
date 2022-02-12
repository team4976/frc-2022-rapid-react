package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake_Self;

public class IntakeBall_Self extends CommandBase {
    
    private Intake_Self intake;

    public IntakeBall_Self(Intake_Self intake) {
        this.intake = intake;
        addRequirements(intake);
    }

    @Override
    public void initialize() {
        intake.collectBall();
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