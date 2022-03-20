package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Intake;

public class IntakeAndLoad extends ParallelCommandGroup {
    
    public IntakeAndLoad(Elevator elevator, Intake intake) {
        addCommands(
            new IndexBall(elevator),
            new IntakeBall(intake),
            new Load_Balls(elevator)
        );  
    }
}
