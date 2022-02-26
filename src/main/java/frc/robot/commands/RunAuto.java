package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

public class RunAuto extends SequentialCommandGroup {
    
    public RunAuto() {
        Intake intake;
        Shooter shoot;
        Elevator elv;
        FlywheelShooter fly;
        addCommands(
            new ParallelCommandGroup(
                // Start the Shooter
                new SpoolHigh(fly),

                // Start the intake
                new IntakeBall(intake)
            )  
        );
    }
}
