package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class ResetPosition extends CommandBase {

    @Override
    public void initialize() {
        RobotContainer.robotDrive.resetPos();
    }

    @Override
    public boolean isFinished() {
    return true;
    }
}
