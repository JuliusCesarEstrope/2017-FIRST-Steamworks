package org.usfirst.frc.team818.robot.commands;

public class SlowReverseCommand extends CommandBase {
	double startAngle, speed;
	int leftTicks, rightTicks;
	boolean leftWasGreater = false;

	public SlowReverseCommand() {
		requires(drive);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	//	startAngle = drive.getAngle();
		drive.resetBothEncoders();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		
		speed = -0.1125;
		
		leftTicks = drive.getLeftRotation();
		rightTicks = drive.getRightRotation();

		/*if (startAngle == drive.getAngle()) {
			drive.setBoth(oi.getLeftY());
		} else if (startAngle < drive.getAngle()) {
			if (oi.getLeftY() > 0)
				drive.setBoth(oi.getLeftY(), .9 * oi.getLeftY());
			else
				drive.setBoth( .9 * oi.getLeftY(),oi.getLeftY());
		} else if (startAngle > drive.getAngle()) {
			if (oi.getLeftY() > 0)
				drive.setBoth(oi.getLeftY(), .9 * oi.getLeftY());
			else
				drive.setBoth(.9 * oi.getLeftY(), oi.getLeftY());
		}*/
		
		if ((Math.abs(leftTicks) == Math.abs(rightTicks)) || (leftTicks == 0 || rightTicks == 0)) {
			drive.setBoth(speed);
		} else if (Math.abs(leftTicks) > Math.abs(rightTicks)) {
			drive.setBoth(rightTicks/leftTicks * speed, speed);

		} else if (Math.abs(leftTicks) < Math.abs(rightTicks)) {
			drive.setBoth(speed, leftTicks/rightTicks * speed);

		}

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		drive.setBoth(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		drive.setBoth(0);
	}
}
