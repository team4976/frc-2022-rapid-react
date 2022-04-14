package frc.robot.commands.elevator;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator;

public class IndexBallAutoStop extends CommandBase {
 
    Elevator elevator;

    public IndexBallAutoStop(Elevator elevator) {
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
        return true;
    }
}
