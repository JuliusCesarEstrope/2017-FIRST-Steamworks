package org.usfirst.frc.team818.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DropCommand extends CommandGroup {

	public DropCommand() {
		addSequential(new ClimberDropCommand());
		addSequential(new DoorCloseCommand());
	}
}
