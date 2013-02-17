
package com.pirhotechs.frc2013prometheus;

import com.pirhotechs.frc2013prometheus.commands.CompressorStart;
import com.pirhotechs.frc2013prometheus.commands.CompressorStop;
import com.pirhotechs.frc2013prometheus.commands.LowerShooter;
import com.pirhotechs.frc2013prometheus.commands.RaiseShooter;
import com.pirhotechs.frc2013prometheus.commands.ShooterFire;
import com.pirhotechs.frc2013prometheus.commands.loaderOn;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    Joystick leftJoy = new Joystick(1);
    Button ltBtn2 = new JoystickButton(leftJoy, 2);
    Button ltBtn3 = new JoystickButton(leftJoy, 3);
    Button ltBtn4 = new JoystickButton(leftJoy, 4);
    Button ltBtn5 = new JoystickButton(leftJoy, 5);
    Button ltBtn7 = new JoystickButton(leftJoy, 7);
    Button ltBtn8 = new JoystickButton(leftJoy, 8);
    
    public double getLeftJoyX() {
        //SmartDashboard.putDouble("leftJoyX", leftJoy.getX());
        return leftJoy.getX();
    }
    
    public double getLeftJoyY() {
        //SmartDashboard.putDouble("leftJoyY", leftJoy.getY());
        return leftJoy.getY();
    }
    
    public OI() {
        ltBtn2.whenPressed(new LowerShooter());
        ltBtn3.whenPressed(new RaiseShooter());
        ltBtn4.whenPressed(new CompressorStart());
        ltBtn5.whenPressed(new loaderOn());
        ltBtn7.whenPressed(new CompressorStop());
        ltBtn8.whileHeld(new ShooterFire());
    }
    // Another type of button you can create is a DigitalIOButton, which is
    // a button or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button button = new DigitalIOButton(1);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}

