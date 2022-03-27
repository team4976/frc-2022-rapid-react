package frc.robot.commands.climber;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

import static frc.robot.RobotContainer.climber;

public class TeleopClimber extends CommandBase {

  private final DoubleSupplier _ext;
  private final DoubleSupplier _ret;


  public TeleopClimber(
    DoubleSupplier ext,
    DoubleSupplier ret
  ) {
    _ext = ext;
    _ret = ret;
    addRequirements(climber);
  }

  @Override
  public void execute() {
    climber.extendArm(
      _ext.getAsDouble() - _ret.getAsDouble()
    );
  }
}
