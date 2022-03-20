package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.FlywheelShooter;

public class MoveHood extends CommandBase{


    private final FlywheelShooter _shooter;
    private final DoubleSupplier _ext;



    public MoveHood(
        FlywheelShooter shooter,
        DoubleSupplier ext
    )
    {
        this._shooter = shooter;
        _ext=ext;
        addRequirements(shooter);
    }
      
    @Override
    public void execute() {
      _shooter.setHoodPosition(
        _ext.getAsDouble()
      );
}
}
