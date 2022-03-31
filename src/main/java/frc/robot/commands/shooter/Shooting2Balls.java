package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.elevator.Load_To_Shooter_Auto;
import frc.robot.subsystems.Elevator;

public class Shooting2Balls extends SequentialCommandGroup{
    public Shooting2Balls (Elevator elevator){
        addCommands(
            new Load_To_Shooter_Auto(elevator, 250)
            //new Delay(250),
            //new Load_To_Shooter_Auto(elevator, 250),
            //new Delay(250),
            //new Load_To_Shooter_Auto(elevator, 250)
        );
    }
    
}
