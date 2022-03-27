package frc.robot.subsystems;

import edu.wpi.first.networktables.*;
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

  public long lastHookChange = 0;

  final private static NetworkTable table = NetworkTableInstance.getDefault().getTable("Climber");

  final private static NetworkTableEntry enableExtensionLimit = table.getEntry("EnableExtensionLimit");
  final private static NetworkTableEntry extensionLimit = table.getEntry("ExtensionLimit");
  final private static NetworkTableEntry moveDelay = table.getEntry("MoveDelay");
  final private static NetworkTableEntry position = table.getEntry("Position");

  public Climber() {

    enableExtensionLimit.setPersistent();
    if (!enableExtensionLimit.exists()) enableExtensionLimit.setBoolean(true);
    enableExtensionLimit.addListener(
        (e) -> primary.enableSoftLimit(CANSparkMax.SoftLimitDirection.kForward, e.value.getBoolean()),
        EntryListenerFlags.kNew | EntryListenerFlags.kUpdate
    );

    extensionLimit.setPersistent();
    if (!extensionLimit.exists()) extensionLimit.setDouble(160);
    enableExtensionLimit.addListener(
        (e) -> primary.setSoftLimit(CANSparkMax.SoftLimitDirection.kForward, (float) e.value.getDouble()),
        EntryListenerFlags.kNew | EntryListenerFlags.kUpdate
    );

    moveDelay.setPersistent();
    if (!moveDelay.exists()) moveDelay.setDouble(100);

    primary.restoreFactoryDefaults();
    primary.setInverted(true);
    primary.setIdleMode(CANSparkMax.IdleMode.kBrake);
    primary.enableSoftLimit(CANSparkMax.SoftLimitDirection.kForward, enableExtensionLimit.getBoolean(true));
    primary.setSoftLimit(CANSparkMax.SoftLimitDirection.kForward, (float) extensionLimit.getDouble(160));
    primary.burnFlash();

    secondary.restoreFactoryDefaults();
    secondary.follow(primary);
    secondary.setIdleMode(CANSparkMax.IdleMode.kBrake);
    secondary.burnFlash();

  }

  @Override
  public void periodic() {
    position.setDouble(primary.getEncoder().getPosition());
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
      primary.set(0);
      return;
    }

    setHooksExtended(output > 0);
    disableExtensionBrake();

    if (timeSinceLastHookChange() >= moveDelay.getDouble(0)) primary.set(output);
    else primary.set(0);
  }
}
