package frc.robot.commands.climber;

import edu.wpi.first.wpilibj2.command.CommandBase;

import static frc.robot.RobotContainer.climber;

public class ExtendClimberHooks extends CommandBase {

    @Override
    public void initialize() {
        climber.setHooksExtended(true);
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
