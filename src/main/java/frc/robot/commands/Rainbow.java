package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LED;

public class Rainbow extends CommandBase {
    LED led;
    public Rainbow (LED led, LED ledBuffer){
        this.led=led;
        //addRequirements(led, ledBuffer);
    }

    @Override
    public void initialize() {
        led.setLed(30, 100, 100);
        led.led.setData(led.ledBuffer);
    }

    @Override
    public void end(boolean interrupted) {
        //led.setLed(0,0,0);
        super.end(interrupted);
    }
}

