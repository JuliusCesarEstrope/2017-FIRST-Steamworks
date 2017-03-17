package org.usfirst.frc.team818.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DoorSetGearCommand extends CommandGroup {

	public DoorSetGearCommand() {

		addSequential(new DoorSetAngleCommand(30));

	}
}
