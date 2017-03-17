package org.usfirst.frc.team818.robot.autonomi;

import org.usfirst.frc.team818.robot.commands.Drive4Distance;
import org.usfirst.frc.team818.robot.commands.GearOpenCommand4Time;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class MiddleGear extends CommandGroup {
    
    public MiddleGear() {
    	
        addSequential(new Drive4Distance(0.4, 100));
        addSequential(new WaitCommand(1.0));
        addSequential(new GearOpenCommand4Time(1.0));
        addSequential(new Drive4Distance(0.4, -10));
        
    }
}
