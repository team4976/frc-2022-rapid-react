package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator;

public class IndexBall extends CommandBase {
 
    Elevator elevator;

    public IndexBall(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void initialize() {
        if (!elevator.ballAtIndexer()) {
            elevator.setIndexSpeed(-0.3);
        }

        // TODO Auto-generated method stub
        super.initialize();
    }

    @Override
    public void end(boolean interrupted) {
        elevator.setIndexSpeed(0);
    }

    @Override
    public boolean isFinished() { 
        return elevator.ballAtIndexer();
    }
}
