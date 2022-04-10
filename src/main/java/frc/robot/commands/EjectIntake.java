package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class EjectIntake extends CommandBase {
    Intake intake;
    public EjectIntake(Intake intake){
        this.intake=intake;
        addRequirements(intake);
    }

    @Override
    public void initialize() {
        intake.piston.set(true);
        intake.intakeMotor.set(ControlMode.PercentOutput, 0.5);
        super.initialize();
    }

    @Override
    public void end(boolean interrupted) {
        intake.piston.set(false);
    }
}
