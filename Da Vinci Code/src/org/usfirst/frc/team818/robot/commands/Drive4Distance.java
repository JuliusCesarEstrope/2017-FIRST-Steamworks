package org.usfirst.frc.team818.robot.commands;

import org.usfirst.frc.team818.robot.Constants;
import org.usfirst.frc.team818.robot.utilities.MathUtil;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Drive4Distance extends CommandBase {

	double d, speed;
	int leftTicks, rightTicks;

	public Drive4Distance(double speed, double distance) {
		// Use requires() here to declare subsystem dependencies
		requires(drive);
		d = distance;
		this.speed = speed;
		if (d < 0) {
			this.speed = -speed;
		}
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		drive.setBoth(0);
		drive.resetBothEncoders();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		leftTicks = drive.getLeftRotation();
		rightTicks = drive.getRightRotation();
		
		SmartDashboard.putNumber("Data1", leftTicks);
		SmartDashboard.putNumber("Data2", rightTicks);

		if (leftTicks == 0 || rightTicks == 0)
			drive.setBoth(speed);
		else
			drive.setBoth(MathUtil.setLimits((rightTicks / leftTicks) * speed, -1.0, 1.0),
					MathUtil.setLimits((leftTicks / rightTicks) * speed, -1.0, 1.0));

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
			if (Math.abs(Constants.cycleDistance * ((leftTicks+rightTicks/2) / 360)) >= Math.abs(d)) {
				return true;
			} else
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
