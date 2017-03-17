package org.usfirst.frc.team818.robot.commands;

public class DoorOpenCommand extends CommandBase {

	public DoorOpenCommand() {
		requires(door);
	}

	protected void initialize() {
		door.pause();
	}

	protected void execute() {
		door.open();
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		door.pause();
	}

	protected void interrupted() {
		door.pause();
	}
}
