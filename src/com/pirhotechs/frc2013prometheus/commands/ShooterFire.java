/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pirhotechs.frc2013prometheus.commands;

import edu.wpi.first.wpilibj.Preferences;

/**
 *
 * @author Brandyn
 */
public class ShooterFire extends CommandBase {
    
    Preferences prefs;
    
    double shooterSPD;
    
    public ShooterFire() {
        requires(shooter);
        shooterSPD = -1.0;
        prefs = Preferences.getInstance();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        shooterSPD = prefs.getDouble("ShooterSpeed", -1.0);
        shooter.shooterOn();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
        //shooter.setSpeed(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        //shooter.setSpeed(0.0);
    }
}
