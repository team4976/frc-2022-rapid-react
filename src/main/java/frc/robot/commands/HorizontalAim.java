package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.AutoAim;
import frc.robot.subsystems.RobotDrive;

public class HorizontalAim extends CommandBase{

    private AutoAim autoaim;
    private RobotDrive robotDrive;

    public HorizontalAim(AutoAim autoaim, RobotDrive robotDrive){
        this.autoaim = autoaim;
        this.robotDrive = robotDrive;
        addRequirements(autoaim, robotDrive);
    }

    @Override
    public void initialize(){
        RobotDrive.left.setNeutralMode(NeutralMode.Brake);
        RobotDrive.right.setNeutralMode(NeutralMode.Brake);
        AutoAim.table.getEntry("ledMode").setNumber(3);
        AutoAim.table.getEntry("camMode").setNumber(0);
        super.initialize();
    }

    @Override
    public boolean isFinished(){
        return false;
    }

    @Override
    public void execute(){
        AutoAim.target(robotDrive);
    }
    @Override
    public void end(boolean interrupted) {
        RobotDrive.left.setNeutralMode(NeutralMode.Coast);
        RobotDrive.right.setNeutralMode(NeutralMode.Coast);
        AutoAim.table.getEntry("ledMode").setNumber(1);
        AutoAim.table.getEntry("camMode").setNumber(1);
    }
}
