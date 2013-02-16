/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pirhotechs.frc2013prometheus.commands;

/**
 *
 * @author Brandyn
 */
public class LowerShooter extends CommandBase {
    
    public LowerShooter() {
        requires(shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        shooter.lowerShooter();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
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
