package org.usfirst.frc.team818.robot.commands;

/**
 * This is a good example of how to use commands. It is necessary that each of
 * these commands extends CommandBase, as this we are otherwise unable to
 * reference the required subsystem "drive".
 *
 */
public class AutoAlignCommand extends CommandBase {

	double speed, targetAngle, target;

	public AutoAlignCommand() {
		requires(drive);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		drive.setBoth(0);
		drive.resetGyro();

		speed = 0.1;
		
		if (!(camera.getTarget() > 300 && camera.getTarget() < 340)) {
			if (camera.getTarget() > 320)
				target = -(camera.getTarget() - 320);
			else
				target = camera.getTarget();
			
			targetAngle = target/240;
		} else {
			targetAngle = drive.getAngle();
		}
		
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		
		if (targetAngle > 5) {
			drive.setBoth(-speed, speed);
		} else if (targetAngle < -5) {
			drive.setBoth(speed, -speed);
		}
		
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return targetAngle > drive.getAngle()-5 && targetAngle < drive.getAngle()+5;
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
