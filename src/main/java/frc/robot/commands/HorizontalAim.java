package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.AutoAim;

public class HorizontalAim extends CommandBase{

    private AutoAim autoaim;

    public HorizontalAim(AutoAim autoaim){
        this.autoaim = autoaim;
        addRequirements(autoaim);
    }

    @Override
    public void initialize(){
        AutoAim.target();
        super.initialize();
    }

    @Override
    public boolean isFinished(){
        return false;
    }
}
