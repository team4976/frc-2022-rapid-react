package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.AutoAim;
import frc.robot.subsystems.FlywheelShooter;
import frc.robot.subsystems.RobotDrive;

public class HorizontalAim extends CommandBase{

    private AutoAim autoaim;
    private RobotDrive robotDrive;
    private FlywheelShooter shooter;

    public HorizontalAim(AutoAim autoaim, RobotDrive robotDrive, FlywheelShooter shooter){
        this.autoaim = autoaim;
        this.robotDrive = robotDrive;
        this.shooter = shooter;
        addRequirements(autoaim, robotDrive);
    }

    @Override
    public void initialize(){
        AutoAim.table.getEntry("ledMode").setNumber(3);
        super.initialize();
    }

    @Override
    public boolean isFinished(){
        return false;
    }

    @Override
    public void execute(){
        AutoAim.target(robotDrive, shooter);
    }
    @Override
    public void end(boolean interrupted) {
        AutoAim.table.getEntry("ledMode").setNumber(1);
    }
}
