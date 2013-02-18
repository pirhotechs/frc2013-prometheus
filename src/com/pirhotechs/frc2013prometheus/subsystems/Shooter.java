/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pirhotechs.frc2013prometheus.subsystems;

import com.pirhotechs.frc2013prometheus.RobotMap;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Brandyn
 */
public class Shooter extends Subsystem {
    Jaguar shooter;
    Compressor shooterComp;
    Solenoid shooterLift;
    Solenoid shooterLower;
    Relay loader;
    DigitalInput loaderSwitch;
    
    public Shooter() {
        shooter = new Jaguar(RobotMap.shooterMotor);
        shooterComp = new Compressor(1, 2);
        shooterLift = new Solenoid(1);
        shooterLower = new Solenoid(2);
        loader = new Relay(1);
        loaderSwitch = new DigitalInput(2);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void setSpeed(double speed) {
        shooter.set(speed);
        SmartDashboard.putDouble("shooterSPD", speed);
        if(speed != 0) {
            SmartDashboard.putBoolean("shooterRunning", true);
        } else {
            SmartDashboard.putBoolean("shooterRunning", false);
        }
    }
    
    public boolean loaderCon() {
        return loaderSwitch.get();
    }
    
    public void startCompressor() {
        shooterComp.start();
    }
    
    public void monitorCompressor() {
        SmartDashboard.putBoolean("Pressure Switch", shooterComp.getPressureSwitchValue());
    }
    
    public void stopCompressor() {
        shooterComp.stop();
    }
    
    public void raiseShooter() {
        shooterLift.set(true);
        shooterLower.set(false);
    }
    
    public void lowerShooter() {
        shooterLift.set(false);
        shooterLower.set(true);
    }
    
    public void lockShooter() {
        shooterLift.set(false);
        shooterLower.set(false);
    }
    
    public void loaderOn() {
        loader.set(Relay.Value.kForward);
        //loader.setDirection(Relay.Direction.kForward);
        //loader.set(Relay.Value.kOn);
    }
    public void loaderOff() {
        loader.set(Relay.Value.kOff);
    }
}
