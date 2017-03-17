package org.usfirst.frc.team818.robot.commands;

public class DoorCommand extends CommandBase {
	public double desiredangle;

	public DoorCommand() {
		requires(door);
	}

	protected void initialize() {
		door.close();
		door.setMotor(0);
	}

	protected void execute() {
		door.setMotor(oi.getGamepadRightY() * 0.2);
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
