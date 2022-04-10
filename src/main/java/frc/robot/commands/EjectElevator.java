package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator;

public class EjectElevator extends CommandBase {
    Elevator elevator;
    public EjectElevator(Elevator elevator){
        this.elevator=elevator;
        addRequirements(elevator);
    }

    @Override
    public void initialize() {
        elevator.indexer.set(ControlMode.PercentOutput, 0.5);
        elevator.intakeRoller.set(ControlMode.PercentOutput, -0.5);
        super.initialize();
    }

    @Override
    public void end(boolean interrupted) {
        elevator.indexer.set(ControlMode.PercentOutput, 0);
        elevator.intakeRoller.set(ControlMode.PercentOutput, 0);
        //super.end(interrupted);
    }
}
