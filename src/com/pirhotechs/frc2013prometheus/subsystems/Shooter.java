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
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Brandyn
 */
public class Shooter extends Subsystem {
    Jaguar shooter;
    Compressor shooterComp;
    Solenoid shooterUp;
    Solenoid shooterDown;
    Relay loaderRelay;
    DigitalInput loaderSwitch;
    double shooterSpeed;
    
    public Shooter() {
        shooter = new Jaguar(RobotMap.shooterMotor);
        shooterComp = new Compressor(RobotMap.compressorSwitch, RobotMap.compressorRelay);
        shooterUp = new Solenoid(RobotMap.shooterUpSolenoid);
        shooterDown = new Solenoid(RobotMap.shooterDownSolenoid);
        loaderRelay = new Relay(RobotMap.shooterLoaderRelay);
        loaderSwitch = new DigitalInput(RobotMap.shooterLoaderSwitch);
        shooterSpeed = RobotMap.shooterSpeed;
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    private void setSpeed(double speed) {
        shooter.set(speed);
        SmartDashboard.putDouble("shooterSPD", -speed);
        if(speed != 0) {
            SmartDashboard.putBoolean("shooterRunning", true);
        } else {
            SmartDashboard.putBoolean("shooterRunning", false);
        }
    }
    
    public void shooterOn() {
        shooter.set(shooterSpeed);
    }
    
    public void shooterOff() {
        shooter.set(0.0);
    }
    
    public boolean loaderCon() {
        return loaderSwitch.get();
    }
    
    public void cycleLoader() {
        loaderOn();
        Timer.delay(0.3);
        while(loaderCon()) {
            loaderOn();
        }
        loaderOff();
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
        shooterUp.set(true);
        shooterDown.set(false);
    }
    
    public void lowerShooter() {
        shooterUp.set(false);
        shooterDown.set(true);
    }
    
    public void lockShooter() {
        shooterUp.set(false);
        shooterDown.set(false);
    }
    
    public void loaderOn() {
        loaderRelay.set(Relay.Value.kForward);
        //loader.setDirection(Relay.Direction.kForward);
        //loader.set(Relay.Value.kOn);
    }
    public void loaderOff() {
        loaderRelay.set(Relay.Value.kOff);
    }
    
    public void speedUp() {
        if(shooterSpeed < -0.4) {
            shooterSpeed += 0.05;
            setSpeed(shooterSpeed);
        }
    }
    
    public void speedDown() {
        if(shooterSpeed > -1.0) {
            shooterSpeed -= 0.05;
            setSpeed(shooterSpeed);
        }
    }
}
