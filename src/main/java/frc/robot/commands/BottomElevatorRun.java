package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Intake;
public class BottomElevatorRun extends CommandBase {
        
Intake intake;

public VictorSPX BottomElevator = new VictorSPX(20);

public void BottomElevatorRun(Intake intake) {
    this.intake = intake;
    addRequirements(intake);
}

@Override
public void initialize(){
   super.initialize();
  
   BottomElevator.set(ControlMode.PercentOutput,(Constants.kBOTTOM_ELEVATOR));
 }
}
