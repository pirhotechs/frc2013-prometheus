/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pirhotechs.frc2013prometheus.subsystems;

import com.pirhotechs.frc2013prometheus.RobotMap;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Brandyn
 */
public class Shooter extends Subsystem {
    Jaguar shooter;
    
    public Shooter() {
        shooter = new Jaguar(RobotMap.shooterMotor);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void setSpeed(double speed) {
        shooter.set(speed);
    }
}
