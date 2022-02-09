package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterCommand;
import  frc.robot.commands.*;
import static frc.robot.Constants.*;
public class ShootHigh extends CommandBase {

    ShooterCommand shooter;

    public ShootHigh(ShooterCommand shooter) {
        this.shooter = shooter;
        addRequirements(shooter);
    }

    @Override
    public void initialize(){


    super.initialize();
    }
}