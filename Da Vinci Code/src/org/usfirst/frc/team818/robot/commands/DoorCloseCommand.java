package org.usfirst.frc.team818.robot.commands;

public class DoorCloseCommand extends CommandBase {

	public DoorCloseCommand() {
		requires(door);
	}

	protected void initialize() {
		door.pause();
	}

	protected void execute() {
		if (door.getAngle() > 0) {

			door.close();

		}

	}

	protected boolean isFinished() {
		if (door.getAngle() == 0)
			return true;
		else
			return false;
	}

	protected void end() {
		door.pause();
	}

	protected void interrupted() {
		door.pause();
	}
}
