package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Intake;

public class IntakeBall extends CommandBase {
    
    Intake intake;
    public TalonFX IntakeBall = new TalonFX(31);
    public VictorSPX BottomElevator = new VictorSPX(20);

    public IntakeBall(Intake intake) {
        this.intake = intake;
        addRequirements(intake);
    }
    
@Override
    public void initialize(){
       super.initialize();
       IntakeBall.set(ControlMode.PercentOutput,(Constants.kINTAKE_RUN));
       BottomElevator.set(ControlMode.PercentOutput, (Constants.kBOTTOM_ELEVATOR));
 }
}