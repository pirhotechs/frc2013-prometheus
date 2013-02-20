
package com.pirhotechs.frc2013prometheus;

import com.pirhotechs.frc2013prometheus.commands.CompressorStart;
import com.pirhotechs.frc2013prometheus.commands.CompressorStop;
import com.pirhotechs.frc2013prometheus.commands.LowerShooter;
import com.pirhotechs.frc2013prometheus.commands.RaiseShooter;
import com.pirhotechs.frc2013prometheus.commands.ShooterDown;
import com.pirhotechs.frc2013prometheus.commands.ShooterFire;
import com.pirhotechs.frc2013prometheus.commands.ShooterStop;
import com.pirhotechs.frc2013prometheus.commands.ShooterUp;
import com.pirhotechs.frc2013prometheus.commands.loaderOn;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;

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
    Joystick rightJoy = new Joystick(2);
    Button ltBtn2 = new JoystickButton(leftJoy, 2);
    Button ltBtn3 = new JoystickButton(leftJoy, 3);
    Button ltBtn4 = new JoystickButton(leftJoy, 4);
    Button ltBtn5 = new JoystickButton(leftJoy, 5);
    Button ltBtn6 = new JoystickButton(leftJoy, 6);
    Button ltBtn7 = new JoystickButton(leftJoy, 7);
    Button ltBtn8 = new JoystickButton(leftJoy, 8);
    Button ltBtn9 = new JoystickButton(leftJoy, 9);
    Button ltBtn10 = new JoystickButton(leftJoy, 10);
    Button ltBtn11 = new JoystickButton(leftJoy, 11);
    Trigger ltTrigger = new Trigger() {

        public boolean get() {
            return leftJoy.getTrigger();
        }
    };
    Button rtBtn2 = new JoystickButton(rightJoy, 2);
    Button rtBtn3 = new JoystickButton(rightJoy, 3);
    Button rtBtn4 = new JoystickButton(rightJoy, 4);
    Button rtBtn5 = new JoystickButton(rightJoy, 5);
    Button rtBtn6 = new JoystickButton(rightJoy, 6);
    Button rtBtn7 = new JoystickButton(rightJoy, 7);
    Button rtBtn8 = new JoystickButton(rightJoy, 8);
    Button rtBtn9 = new JoystickButton(rightJoy, 9);
    Button rtBtn10 = new JoystickButton(rightJoy, 10);
    Button rtBtn11 = new JoystickButton(rightJoy, 11);
    Trigger rtTrigger = new Trigger() {
        public boolean get() {
            return rightJoy.getTrigger();
        }
    };
    
    public double getLeftJoyX() {
        //SmartDashboard.putDouble("leftJoyX", leftJoy.getX());
        return leftJoy.getX();
    }
    
    public double getLeftJoyY() {
        //SmartDashboard.putDouble("leftJoyY", leftJoy.getY());
        return leftJoy.getY();
    }
    
    public double getRightJoyX() {
        return rightJoy.getX();
    }
    
    public double getRightJoyY() {
        return rightJoy.getY();
    }
    
    public OI() {
        ltTrigger.whenActive(new loaderOn());
        ltBtn2.whenPressed(new LowerShooter());
        ltBtn3.whenPressed(new RaiseShooter());
        ltBtn10.whenPressed(new ShooterDown());
        ltBtn11.whenPressed(new ShooterUp());
        rtBtn6.whenPressed(new CompressorStart());
        rtBtn7.whenPressed(new CompressorStop());
        rtBtn8.whenPressed(new ShooterFire());
        rtBtn9.whenPressed(new ShooterStop());
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

