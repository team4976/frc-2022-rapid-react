package frc.robot.commands.elevator;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator;

public class IndexBallAuto extends CommandBase {
 
    Elevator elevator;

    public IndexBallAuto(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void initialize() {
        System.out.println("Intializing...");
        if (!elevator.ballAtIndexer()) {
            elevator.setIndexSpeed(-0.3);
            System.out.println("Starting indexer");
        }

        // TODO Auto-generated method stub
        super.initialize();
    }

    @Override
    public void end(boolean interrupted) {
        elevator.setIndexSpeed(0);
        System.out.println("Indexer set to 0");
    }

    @Override
    public boolean isFinished() { 
        System.out.println("Ball is at the indexer");
        return elevator.ballAtIndexer()==false;
    }
}
