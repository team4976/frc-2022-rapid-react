package frc.robot.commands.aim;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.FlywheelShooter;

public class HomeAndZero extends SequentialCommandGroup{

    public HomeAndZero(FlywheelShooter shooter){
addCommands(new GoToHome(shooter), new ZeroPos(shooter));
    }
    
}
