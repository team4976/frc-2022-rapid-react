package frc.robot.commands.intake;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Intake;

public class IntakeBall extends CommandBase {
    
    Intake intake;

    public IntakeBall(Intake intake) {
        this.intake = intake;
        addRequirements(intake);
    }
    
    @Override
    public void initialize(){
       super.initialize();
       intake.intakeBall();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
