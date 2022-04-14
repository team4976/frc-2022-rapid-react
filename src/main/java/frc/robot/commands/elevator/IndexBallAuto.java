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
        if (!elevator.ballAtIndexer()) {
            elevator.setIndexSpeed(-0.3);
        }

        // TODO Auto-generated method stub
        super.initialize();
    }


    @Override
    public boolean isFinished() {
        //return elevator.ballAtIndexer();
        return true;
    }
}
