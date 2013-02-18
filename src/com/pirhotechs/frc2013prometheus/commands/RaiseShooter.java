/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pirhotechs.frc2013prometheus.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author Brandyn
 */
public class RaiseShooter extends CommandBase {
    
    public RaiseShooter() {
        requires(shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        shooter.raiseShooter();
        Timer.delay(.25);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
        shooter.lockShooter();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        shooter.lockShooter();
    }
}
