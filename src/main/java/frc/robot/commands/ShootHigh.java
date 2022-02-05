package frc.robot.commands;

import frc.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;


public class ShootHigh extends CommandBase {
    
    Shooter shooter;

    public ShootHigh (Shooter shooter){
        this.shooter = shooter;
        addRequirements(shooter);
    }

    @Override
    public void initialize(){
        super.initialize();
    }
}