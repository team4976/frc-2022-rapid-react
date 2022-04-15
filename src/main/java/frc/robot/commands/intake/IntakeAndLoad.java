package frc.robot.commands.intake;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.commands.elevator.IndexBall;
import frc.robot.commands.elevator.LoadBalls;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Intake;

public class IntakeAndLoad extends ParallelCommandGroup {
    
    public IntakeAndLoad(Elevator elevator, Intake intake) {
        addCommands(
            new IndexBall(elevator),
            new IntakeBall(intake),
            new LoadBalls(elevator)
        );  
    }
}
