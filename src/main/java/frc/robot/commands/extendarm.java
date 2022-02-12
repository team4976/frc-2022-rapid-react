package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;

public class extendarm extends CommandBase{


    private final Climber _climb;
    private final DoubleSupplier _ext;

    public extendarm(
         Climber climb,
        DoubleSupplier ext
    )
    {
        _climb=climb;
        _ext=ext;
        addRequirements(climb);

    }

    @Override
    public void execute() {
      _climb.extendarm(
        _ext.getAsDouble()
      );
}
}
