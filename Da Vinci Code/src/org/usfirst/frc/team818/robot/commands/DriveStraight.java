package org.usfirst.frc.team818.robot.commands;

import org.usfirst.frc.team818.robot.utilities.MathUtil;

public class DriveStraight extends CommandBase {
	double startAngle, speed;
	int leftTicks, rightTicks;
	boolean leftWasGreater = false;

	double pLeft;

	double pRight;

	public DriveStraight() {
		requires(drive);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		// startAngle = drive.getAngle();
		drive.resetBothEncoders();
		pLeft = speed;
		pRight = speed;
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

		speed = oi.getLeftY();

		leftTicks = drive.getLeftRotation();
		rightTicks = drive.getRightRotation();

		/*
		 * if (startAngle == drive.getAngle()) { drive.setBoth(oi.getLeftY()); }
		 * else if (startAngle < drive.getAngle()) { if (oi.getLeftY() > 0)
		 * drive.setBoth(oi.getLeftY(), .9 * oi.getLeftY()); else drive.setBoth(
		 * .9 * oi.getLeftY(),oi.getLeftY()); } else if (startAngle >
		 * drive.getAngle()) { if (oi.getLeftY() > 0)
		 * drive.setBoth(oi.getLeftY(), .9 * oi.getLeftY()); else
		 * drive.setBoth(.9 * oi.getLeftY(), oi.getLeftY()); }
		 */
		if (leftTicks == 0 || rightTicks == 0)
			drive.setBoth(speed);
		else
			drive.setBoth(MathUtil.setLimits((rightTicks / leftTicks) * speed, -1.0, 1.0),
					MathUtil.setLimits((leftTicks / rightTicks) * speed, -1.0, 1.0));

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
