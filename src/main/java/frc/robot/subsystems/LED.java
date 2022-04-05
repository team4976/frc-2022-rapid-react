package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LED extends SubsystemBase {
    public AddressableLED led = new AddressableLED(0);//port 0
    public AddressableLEDBuffer ledBuffer = new AddressableLEDBuffer(24);
    int firstPixelHue = 5;


    public LED (int hue, int saturation, int value) {
        led.setLength(ledBuffer.getLength());
        led.setData(ledBuffer);
        led.start();
        for (int i=0; i< ledBuffer.getLength();i++){
            ledBuffer.setHSV(i, hue, saturation, value);
        }
    }
    public void ledRainbow (int hue) {
        for (int i=0; i< ledBuffer.getLength();i++){
            hue = (firstPixelHue + (i * 180 / ledBuffer.getLength())) % 180;
            ledBuffer.setHSV(i, hue, 255, 128);
        }
        firstPixelHue += 3;
        firstPixelHue %= 180;
    }

}
