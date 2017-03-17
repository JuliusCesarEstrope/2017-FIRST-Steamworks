package org.usfirst.frc.team818.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class DomCommand extends CommandGroup {

	public DomCommand() {

		addSequential(new DoorSetAngleCommand(100));
		addSequential(new GearOpenCommand());
		addSequential(new WaitCommand(2.0));

		addSequential(new DoorCloseCommand());
		addSequential(new GearCloseCommand());
		addSequential(new WaitCommand(2.0));

		addSequential(new DoorSetAngleCommand(100));
		addSequential(new GearOpenCommand());
		addSequential(new WaitCommand(2.0));

		addSequential(new DoorCloseCommand());
		addSequential(new GearCloseCommand());
		addSequential(new WaitCommand(2.0));

	}
}
