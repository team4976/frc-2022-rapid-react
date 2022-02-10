package frc.robot.commands;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterCommand;
import  frc.robot.commands.*;
import static frc.robot.Constants.*;
public class ShootHigh extends CommandBase {

    ShooterCommand shooter;
    
    public ShootHigh(ShooterCommand shooterCommand) {
        this.shooter = shooterCommand;
        addRequirements(shooterCommand);
        shooterCommand.shooterSpeed(kSHOOTER_HIGH_SPEED);
    }

    @Override
    public void initialize(){


    super.initialize();
    }
}