package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;

public class retract extends CommandBase{


    private final Climber _climb;
    private final DoubleSupplier _ret;

    public retract(
         Climber climb,
        DoubleSupplier ret
    )
    {
        _climb=climb;
        _ret=ret;
        addRequirements(climb);

    }

    @Override
    public void execute() {
      _climb.retract(
        _ret.getAsDouble()
      );
    }
}
    



