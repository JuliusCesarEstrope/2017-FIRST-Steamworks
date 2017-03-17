package org.usfirst.frc.team818.robot.autonomi;

import org.usfirst.frc.team818.robot.commands.AutoAlignCommand;
import org.usfirst.frc.team818.robot.commands.CommandBase;
import org.usfirst.frc.team818.robot.commands.Drive4Distance;
import org.usfirst.frc.team818.robot.commands.GearOpenCommand4Time;
import org.usfirst.frc.team818.robot.commands.TurnAngleCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightGear extends CommandGroup {

    public RightGear() {
    	
    	addSequential(new Drive4Distance(0.4, 93));
    	addSequential(new TurnAngleCommand(60));
    	addSequential(new AutoAlignCommand());
    	addSequential(new Drive4Distance(0.4, CommandBase.camera.getDistance()));
    	addSequential(new GearOpenCommand4Time(1.0));
    	addSequential(new Drive4Distance(0.4, -10));

    }
   
}
