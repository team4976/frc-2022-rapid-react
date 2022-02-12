package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake_Self;

public class RemoveBall extends CommandBase {
    
    private Intake_Self remove;

    public RemoveBall(Intake_Self remove) {
        this.remove = remove;
        addRequirements(remove);
    }

    @Override
    public void initialize() {
        remove.removeBall();
        super.initialize();
    }

    @Override
    public void end(boolean interrupted) {
        remove.stop();
        super.end(interrupted);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}