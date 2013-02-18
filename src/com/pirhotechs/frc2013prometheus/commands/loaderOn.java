/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pirhotechs.frc2013prometheus.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Brandyn
 */
public class loaderOn extends CommandBase {
    
    public loaderOn() {
        requires(shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        shooter.loaderOn();
        Timer.delay(0.3);
        while(shooter.loaderCon()) {
            shooter.loaderOn();
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
        shooter.loaderOff();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        shooter.loaderOff();
    }
}
