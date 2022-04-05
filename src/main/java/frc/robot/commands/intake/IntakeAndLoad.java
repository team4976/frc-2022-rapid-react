package frc.robot.commands.intake;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.commands.elevator.IndexBall;
import frc.robot.commands.elevator.Load_Balls;
import frc.robot.commands.intake.IntakeBall;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Intake;

import java.util.stream.Stream;

public class IntakeAndLoad extends ParallelCommandGroup {
    
    public IntakeAndLoad(Elevator elevator, Intake intake) {
        addCommands(
            new IndexBall(elevator),
            new IntakeBall(intake),
            new Load_Balls(elevator)
        );  
    }
}
