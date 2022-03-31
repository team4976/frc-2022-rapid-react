package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.FlywheelShooter;
import frc.robot.subsystems.Intake;

public class Eject extends ParallelCommandGroup {
    public Eject (Intake intake, Elevator elevator, FlywheelShooter shooter){
        addCommands(
                new EjectIntake(intake),
                new EjectElevator(elevator),
                new EjectShooter(shooter)
        );
    }
}
