// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.drive;

import static frc.robot.RobotContainer.robotDrive;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class TeleopDrive extends CommandBase {
    
  private final DoubleSupplier _forward;
  private final DoubleSupplier _reverse;
  private final DoubleSupplier _rotation;

  public TeleopDrive(
    DoubleSupplier rotation,
    DoubleSupplier forward, 
    DoubleSupplier reverse 
  ) {
    _rotation = rotation;
    _reverse = reverse;
    _forward = forward;

    addRequirements(robotDrive);
  }


  @Override
  public void execute() {
    robotDrive.setArcadeDrive(
      _forward.getAsDouble() - _reverse.getAsDouble(),
      _rotation.getAsDouble()
    );
  }
}
