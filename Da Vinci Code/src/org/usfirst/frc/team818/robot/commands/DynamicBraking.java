package org.usfirst.frc.team818.robot.commands;

public class DynamicBraking extends CommandBase {

	double leftSpeed, rightSpeed, speed, angle;
	int leftTicks, rightTicks, ticks;

	public DynamicBraking() {
		requires(drive);
	}

	protected void initialize() {
		leftSpeed = 0;
		rightSpeed = 0;
		speed = 0;
		angle = drive.getAngle();
		/* shifter.lowGear(); */ // switch to low gear before dynamic breaking
									// or somehow during dynamic breaking to get
									// more power?
		drive.setBoth(0);
		drive.resetBothEncoders();

	}

	protected void execute() {

		// get direction
		leftTicks = drive.getLeftRotation();
		rightTicks = drive.getRightRotation();

		ticks = (drive.getLeftRotation() + drive.getLeftRotation()) / 2;

		if (drive.getAngle() < angle + 15 && drive.getAngle() > angle - 15) {
			if ((ticks <= 10) && (ticks >= -10)) {
				speed = 0;
				drive.setRight(speed);

			} else if (ticks > 10) {
				if (speed > -1.0)
					speed = speed - 0.1; // ??is this the most efficient way to
											// decrease speed to a minimum of
											// -1.0? any flaws in this?
				drive.setBoth(speed);

			} else if (ticks < -10) {
				if (speed < 1.0)
					speed = speed + 0.1; // ??is this the most efficient way to
											// increase speed to a maximum of
											// 1.0? any flaws in this?
				drive.setBoth(speed);

			}

		} else {

			// right side
			if ((rightTicks <= 10) && (rightTicks >= -10)) {
				rightSpeed = 0;
				drive.setRight(rightSpeed);

			} else if (rightTicks > 10) {
				if (rightSpeed > -1.0)
					rightSpeed = rightSpeed - 0.1; // ??is this the most
													// efficient way to decrease
													// speed to a minimum of
													// -1.0? any flaws in this?
				drive.setRight(rightSpeed);

			} else if (rightTicks < -10) {
				if (rightSpeed < 1.0)
					rightSpeed = rightSpeed + 0.1; // ??is this the most
													// efficient way to increase
													// speed to a maximum of
													// 1.0? any flaws in this?
				drive.setRight(rightSpeed);

			}

			// left side
			if ((leftTicks <= 10) && (leftTicks >= -10)) {
				leftSpeed = 0;
				drive.setLeft(leftSpeed);

			} else if (leftTicks > 10) {
				if (leftSpeed > -1.0)
					leftSpeed = leftSpeed - 0.1; // ??is this the most efficient
													// way to decrease speed to
													// a minimum of -1.0? any
													// flaws in this?
				drive.setLeft(leftSpeed);

			} else if (leftTicks < 10) {
				if (leftSpeed < 1.0)
					leftSpeed = leftSpeed + 0.1; // ??is this the most efficient
													// way to increase speed to
													// a maximum of 1.0? any
													// flaws in this?
				drive.setLeft(leftSpeed);
			}

		}

	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		// "address this problem at a later date" -coach barber on the issue of
		// switching gears. in end switch to high gear?
		drive.setBoth(0);
	}

	protected void interrupted() {
		drive.setBoth(0);
	}
}
