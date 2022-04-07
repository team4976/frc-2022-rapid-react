package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LED extends SubsystemBase {
    public AddressableLED led = new AddressableLED(0);//port 0
    public AddressableLEDBuffer ledBuffer = new AddressableLEDBuffer(24);
    int firstPixelHue = 5;


    public LED () {
        led.setLength(ledBuffer.getLength());
        led.start();
    }
    public void setLed (int hue, int saturation, int value){
        for (int i=0; i< ledBuffer.getLength();i++){
            ledBuffer.setHSV(i, hue, saturation, value);
        }

        led.setData(ledBuffer);
    }
    public void  ledRainbow (int hue) {
        for (int i=0; i< ledBuffer.getLength();i++){
            hue = (firstPixelHue + (i * 180 / ledBuffer.getLength())) % 180;
            ledBuffer.setHSV(i, hue, 255, 128);
        }
        firstPixelHue += 3;
        firstPixelHue %= 180;

        led.setData(ledBuffer);
    }

}
