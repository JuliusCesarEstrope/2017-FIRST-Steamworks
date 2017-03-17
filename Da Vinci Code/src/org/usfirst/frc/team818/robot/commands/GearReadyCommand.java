package org.usfirst.frc.team818.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GearReadyCommand extends CommandGroup {

	public GearReadyCommand() {
		addSequential(new SlowReverseCommand());
		addSequential(new DoorSetGearCommand());
	}
}
