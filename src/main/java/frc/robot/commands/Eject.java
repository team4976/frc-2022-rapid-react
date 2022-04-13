package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.FlywheelShooter;
import frc.robot.subsystems.Intake;

public class Eject extends ParallelCommandGroup {
    public Eject (Intake intake, Elevator elevator, FlywheelShooter shooter){
        addCommands(
                new EjectIntake(intake),
                new SequentialCommandGroup(
                    new Delay(300),
                    new EjectElevator(elevator)
                ),
                new EjectShooter(shooter)
        );
    }

    @Override
    public void end(boolean interrupted) {
        RobotContainer.elevator.setMotorSpeeds(0);
        RobotContainer.shooter.shootmotor.set(ControlMode.PercentOutput, 0);
        RobotContainer.intake.stopIntake();
    }
}
