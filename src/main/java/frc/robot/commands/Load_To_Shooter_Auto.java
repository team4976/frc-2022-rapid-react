package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator;
import static frc.robot.Constants.*;

/*
This Code runs to send balls to shooter
*/

public class Load_To_Shooter_Auto extends CommandBase{
    
    private Elevator elevator;
    long startTime;
    int duration;

    public Load_To_Shooter_Auto(Elevator elevator, int duration){
        this.elevator = elevator;
        this.startTime = startTime;
        this.duration = duration;
        addRequirements(elevator);
    }

    @Override
    public boolean isFinished() {
        return System.currentTimeMillis()-startTime >= duration;
    }

    @Override
    public void initialize() {
        elevator.setMotorSpeeds(kLOAD_SHOOT_SPEED);
        startTime=System.currentTimeMillis();
    }

    @Override
    public void end(boolean interrupted) {
        elevator.setMotorSpeeds(kSTOP_SPEED);
    }
}