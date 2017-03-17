package org.usfirst.frc.team818.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DoorSetClosedCommand extends CommandGroup {

	public DoorSetClosedCommand() {

		addSequential(new DoorSetAngleCommand(0));

	}
}
