package org.usfirst.frc.team818.robot.commands;

public class DoorSetAngleCommand extends CommandBase {
	public double desiredangle;

	public DoorSetAngleCommand(double angle) {
		requires(door);
		desiredangle = angle;
	}

	protected void initialize() {

	}

	protected void execute() {

		if (desiredangle < door.getAngle() + 5 && desiredangle > door.getAngle() - 5) {
			door.pause();
		} else if (desiredangle > door.getAngle()) {
			if (door.getAngle() > desiredangle - 5)
				door.slowOpen();
			else
				door.open();
		} else if (desiredangle < door.getAngle()) {
			if (door.getAngle() < door.getAngle() + 5)
				door.slowClose();
			else
				door.close();
		}

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
