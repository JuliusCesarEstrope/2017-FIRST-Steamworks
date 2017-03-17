package org.usfirst.frc.team818.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DoorSetOpenCommand extends CommandGroup {

	public DoorSetOpenCommand() {

		addSequential(new DoorSetAngleCommand(100));

	}
}
