package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterHood;

public class HighHood extends CommandBase{
    private final ShooterHood shooterHood;

    public HighHood(ShooterHood shooterHood)  {  
        this.shooterHood = shooterHood;
        addRequirements(shooterHood);
     }
     @Override
     public void initialize(){
        super.initialize();
        shooterHood.LowHood();
     }
}
