package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class RunAuto extends SequentialCommandGroup {
    
    public RunAuto() {
        addCommands(
            new ParallelCommandGroup(
                // Start the Shooter
                // Start the intake
            )  
        );
    }
}
