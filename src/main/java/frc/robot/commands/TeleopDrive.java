// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.RobotDrive;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class TeleopDrive extends CommandBase {
    
  private final RobotDrive _drive;
  private final DoubleSupplier _forward;
  private final DoubleSupplier _reverse;
  private final DoubleSupplier _rotation;

  public TeleopDrive(
    RobotDrive drive, 
    DoubleSupplier rotation,
    DoubleSupplier forward, 
    DoubleSupplier reverse 
  ) {
    _drive = drive;
    _forward = forward;
    _reverse = reverse;
    _rotation = rotation;

    addRequirements(drive);
  }


  @Override
  public void execute() {
    _drive.setArcadeDrive(
      _forward.getAsDouble() - _reverse.getAsDouble(),
      _rotation.getAsDouble()
    );
  }
}
