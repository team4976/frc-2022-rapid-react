package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Intake;

public class BottomElevatorEject extends CommandBase {
    
    public VictorSPX BottomElevator = new VictorSPX(20);

Intake intake;
public void BottomElevatorStop(Intake intake) {
    this.intake = intake;
    addRequirements(intake);
}

@Override
public void initialize(){
   super.initialize();
  
   BottomElevator.set(ControlMode.PercentOutput,(Constants.kBOTTOM_ELEVATOR_STOP));

 }
}
