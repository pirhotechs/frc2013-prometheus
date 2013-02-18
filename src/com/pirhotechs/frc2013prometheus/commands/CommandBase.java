package com.pirhotechs.frc2013prometheus.commands;

import com.pirhotechs.frc2013prometheus.OI;
import com.pirhotechs.frc2013prometheus.subsystems.Camera;
import com.pirhotechs.frc2013prometheus.subsystems.DriveTrain;
import com.pirhotechs.frc2013prometheus.subsystems.Shooter;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use
 * CommandBase.exampleSubsystem
 *
 * @author Author
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    // Create a single static instance of all of your subsystem
    public static DriveTrain drivetrain = new DriveTrain();
    public static Shooter shooter = new Shooter();
    public static Camera camera = new Camera();
    public static CompressorStart compStart = new CompressorStart();
    public static CompressorStop compStop = new CompressorStop();
    public static RaiseShooter shooterRaise = new RaiseShooter();
    public static LowerShooter shooterLower = new LowerShooter();

    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();
        
        SmartDashboard.putData("Start Compressor", compStart);
        SmartDashboard.putData("Stop Compressor", compStop);
        SmartDashboard.putData("Raise Shooter", shooterRaise);
        SmartDashboard.putData("Lower Shooter", shooterLower);
        
        //SmartDashboard.putData("Start Compressor",CompressorStart);

        // Show what command your subsystem is running on the SmartDashboard
        //SmartDashboard.putData(drivetrain);
        //SmartDashboard.putData(shooter);
        //SmartDashboard.putData(camera);
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
