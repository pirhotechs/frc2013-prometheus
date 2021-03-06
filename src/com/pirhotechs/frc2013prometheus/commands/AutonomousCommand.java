/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pirhotechs.frc2013prometheus.commands;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.Timer;


/**
 *
 * @author bdbayes
 */
public class AutonomousCommand extends CommandBase {
    public AutonomousCommand() {
        requires(drivetrain);
        requires(shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //Watchdog.getInstance().feed();
        drivetrain.arcadeDrive(0.5, 0.0);
        Timer.delay(3);
        drivetrain.arcadeDrive(0.0, 0.0);
        shooter.shooterOn();
        Timer.delay(3);
        shooter.cycleLoader();
        Timer.delay(1);
        shooter.shooterOff();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
