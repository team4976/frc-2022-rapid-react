package frc.robot.commands.aim;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.AutoAim;

public class HorizontalAim extends CommandBase{

    public HorizontalAim() {

        addRequirements(
            RobotContainer.autoaim,
            RobotContainer.robotDrive,
            RobotContainer.shooter
            );
    }

    @Override
    public void initialize(){
        RobotContainer.statusLight.breathing = false;
        AutoAim.table.getEntry("ledMode").setNumber(3);
        super.initialize();
    }

    @Override
    public boolean isFinished(){
        return false;
    }

    @Override
    public void execute(){
        AutoAim.target(RobotContainer.robotDrive, RobotContainer.shooter);
    }

    @Override
    public void end(boolean interrupted) {
        RobotContainer.statusLight.breathing = true;
        AutoAim.table.getEntry("ledMode").setNumber(1);
    }
}
