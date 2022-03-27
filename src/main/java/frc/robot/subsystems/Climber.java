package frc.robot.subsystems;

import edu.wpi.first.util.sendable.Sendable;
import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.*;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;


public class Climber extends SubsystemBase implements Sendable {

  public CANSparkMax primary = new CANSparkMax(kCLIMBER_RIGHT_A_NODE_ID, CANSparkMaxLowLevel.MotorType.kBrushless);
  public CANSparkMax secondary = new CANSparkMax(kCLIMBER_LEFT_A_NODE_ID, CANSparkMaxLowLevel.MotorType.kBrushless);

  public Solenoid extensionBrake = new Solenoid(kPCM_NODE_ID, kPCM_TYPE, kCLIMBER_CHANNEL_A_NODE_ID);
  public Solenoid hookPosition = new Solenoid(kPCM_NODE_ID, kPCM_TYPE, kPASSIVECLIMBER_CHANNEL_A_NODE_ID);

  public double moveDelay = 100;
  public long lastHookChange = 0;

  public Climber() {

    primary.restoreFactoryDefaults();
    primary.setInverted(true);
    primary.setIdleMode(CANSparkMax.IdleMode.kBrake);
    primary.burnFlash();

    secondary.restoreFactoryDefaults();
    secondary.follow(primary);
    secondary.setIdleMode(CANSparkMax.IdleMode.kBrake);
    secondary.burnFlash();
  }

  @Override
  public void initSendable(SendableBuilder builder) {

    builder.addBooleanProperty(
      "EnableExtensionLimit",
      () -> primary.isSoftLimitEnabled(CANSparkMax.SoftLimitDirection.kForward),
      (enable) -> primary.enableSoftLimit(CANSparkMax.SoftLimitDirection.kForward, enable)
    );

    builder.addDoubleProperty(
      "ExtensionLimit",
      () -> primary.getSoftLimit(CANSparkMax.SoftLimitDirection.kForward),
      (limit) -> primary.setSoftLimit(CANSparkMax.SoftLimitDirection.kForward, (float) limit)
    );

    builder.addDoubleProperty(
      "MoveDelay",
      () -> moveDelay,
      (newDelay) -> moveDelay = newDelay
    );

    builder.addDoubleProperty(
      "Position",
      () -> primary.getEncoder().getPosition(),
      (newPosition) -> { }
    );
  }

  public void disableExtensionBrake() {
    extensionBrake.set(true);
  }

  public void setHooksExtended(boolean extended) {
    if (hookPosition.get() == extended) return;
    lastHookChange = System.currentTimeMillis();
    hookPosition.set(extended);
  }
  
  public long timeSinceLastHookChange() {
    return System.currentTimeMillis() - lastHookChange;
  }

  public void extendArm(double output) {

    if (Math.abs(output) < 0.05) {
      moveDelay = System.currentTimeMillis();
      primary.set(0);
      return;
    }

    setHooksExtended(output > 0);
    disableExtensionBrake();

    if (timeSinceLastHookChange() >= moveDelay) primary.set(output);
    else primary.set(0);
  }
}
