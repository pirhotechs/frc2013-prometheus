/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.pirhotechs.frc2013prometheus;


import com.pirhotechs.frc2013prometheus.commands.AutonomousCommand;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import com.pirhotechs.frc2013prometheus.commands.CommandBase;
import com.pirhotechs.frc2013prometheus.commands.CompressorMonitor;
import com.pirhotechs.frc2013prometheus.commands.DriveWithJoysticks;
import com.pirhotechs.frc2013prometheus.commands.CompressorStart;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class FRC2013Prometheus extends IterativeRobot {

    Command autonomousCommand;
    Command DriveRobot;
    Command startCompressor;
    Command monitorCompressor;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        // instantiate the command used for the autonomous period
        DriveRobot = new DriveWithJoysticks();
        startCompressor = new CompressorStart();
        monitorCompressor = new CompressorMonitor();
        

        // Initialize all subsystems
        CommandBase.init();
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
        //startCompressor.start();
        autonomousCommand.start();
        
        DriveRobot.cancel();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        //startCompressor.start();  //only use for testing diagnostics
	DriveRobot.start();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        monitorCompressor.start();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
