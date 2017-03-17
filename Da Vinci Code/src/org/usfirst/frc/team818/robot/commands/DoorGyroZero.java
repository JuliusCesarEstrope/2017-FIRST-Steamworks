package org.usfirst.frc.team818.robot.commands;

public class DoorGyroZero extends CommandBase {

	public DoorGyroZero() {
		requires(door);
	}

	protected void initialize() {
		door.resetGyro();
	}

	protected void execute() {
		
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		
	}

	protected void interrupted() {
		
	}
}
