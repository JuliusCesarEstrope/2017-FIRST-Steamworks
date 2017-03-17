package org.usfirst.frc.team818.robot.autonomi;

import org.usfirst.frc.team818.robot.commands.Drive4Distance;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class BaseLine extends CommandGroup {

    private static final double distance = 93.25;
    
    private static final double speed = .4;
    
    public BaseLine() {
    	
        addSequential(new Drive4Distance(speed, distance));
        //addSequential(new DriveStraight4Time(5.0));
        
    }
}
