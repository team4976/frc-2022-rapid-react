package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LED;

public class Rainbow extends CommandBase {
    LED led;
    LED ledBuffer;
    public Rainbow (LED led, LED ledBuffer){
        this.led=led;
        this.ledBuffer=ledBuffer;
        //addRequirements(led, ledBuffer);
    }

    @Override
    public void initialize() {
        led.ledRainbow(5);
        led.led.setData(ledBuffer.ledBuffer);
        super.initialize();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}

