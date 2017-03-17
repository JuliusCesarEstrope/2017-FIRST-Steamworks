package org.usfirst.frc.team818.robot.subsystems;

import org.usfirst.frc.team818.robot.commands.TankCommand;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveSubsystem extends Subsystem {

	Talon[] leftMotors;
	Talon[] rightMotors;

	AnalogGyro driveGyro;

	Encoder leftEncoder, rightEncoder;
	
	public double rampFactor;
	
	/*private static final double[] STRAIGHT_PID_VALUES = { 0.1, 0.001, 0 };
	private static final double[] STRAIGHT_PID_RANGE = { -0.2, 0.2 };
	private static final double[] ROTATE_PID_VALUES = { 0.05, 0, 0.1 };
	private static final double[] ROTATE_PID_RANGE = { -0.4, 0.4 };
	
	private static final double ROTATE_PID_TOLERANCE = 1;
	
	private PIDController straightController, rotateController;
	private DoublePIDOutput pidOutput;*/

	private boolean driveEnabled;

	public DriveSubsystem(int[] leftMotorPorts, int[] rightMotorPorts, int gyroPort, int[] leftEncoderPorts,
			int[] rightEncoderPorts, boolean driveEnabled) {

		this.driveEnabled = driveEnabled;

		if (driveEnabled) {
			leftMotors = new Talon[leftMotorPorts.length];
			rightMotors = new Talon[rightMotorPorts.length];

			leftEncoder = new Encoder(leftEncoderPorts[0], leftEncoderPorts[1]);
			rightEncoder = new Encoder(rightEncoderPorts[0], rightEncoderPorts[1]);

			for (int i = 0; i < leftMotorPorts.length; i++)
				leftMotors[i] = new Talon(leftMotorPorts[i]);

			for (int i = 0; i < rightMotorPorts.length; i++)
				rightMotors[i] = new Talon(rightMotorPorts[i]);

			driveGyro = new AnalogGyro(gyroPort);
			rampFactor = 0.03;
		}
		
		/*pidOutput = new DoublePIDOutput();
		
		straightController = new PIDController(STRAIGHT_PID_VALUES[0], STRAIGHT_PID_VALUES[1], STRAIGHT_PID_VALUES[2], driveGyro, pidOutput);
		straightController.setOutputRange(STRAIGHT_PID_RANGE[0], STRAIGHT_PID_RANGE[1]);
		straightController.setSetpoint(0);
		straightController.setContinuous(false);
		
		rotateController = new PIDController(ROTATE_PID_VALUES[0], ROTATE_PID_VALUES[1], ROTATE_PID_VALUES[2], driveGyro, pidOutput);
		rotateController.setOutputRange(ROTATE_PID_RANGE[0], ROTATE_PID_RANGE[1]);
		rotateController.setAbsoluteTolerance(ROTATE_PID_TOLERANCE);
		rotateController.setContinuous();*/

	}

	public void initDefaultCommand() {
		setDefaultCommand(new TankCommand());
	}

	public void setLeft(double speed) {
		if (driveEnabled) {
			for (int i = 0; i < leftMotors.length; i++)
				leftMotors[i].set(-speed);
		}
	}

	public void setRight(double speed) {
		if (driveEnabled) {
			for (int i = 0; i < rightMotors.length; i++)
				rightMotors[i].set(speed);
		}
	}

	public void setBoth(double speedLeft, double speedRight) {
		if (driveEnabled) {
			setLeft(speedLeft);
			setRight(speedRight);
		}
	}

	public void setBoth(double speed) {
		if (driveEnabled) {
			setLeft(speed);
			setRight(speed);
		}
	}

	public void resetGyro() {
		if (driveEnabled) {
			driveGyro.reset();
		}
	}

	public double getAngle() {
		if (driveEnabled) {
			return driveGyro.getAngle() % 360;
		} else
			return 0;
	}

	public int getLeftRotation() {
		if (driveEnabled) {
			return leftEncoder.get();
		} else
			return 0;
	}

	public int getRightRotation() {
		if (driveEnabled) {
			return rightEncoder.get();
		} else
			return 0;
	}

	public void resetBothEncoders() {
		if (driveEnabled) {
			rightEncoder.reset();
			leftEncoder.reset();
		}
	}

	public boolean getLeftDirection() {
		if (driveEnabled) {
			return leftEncoder.getDirection();
		} else
			return false;

	}

	public boolean getRightDirection() {
		if (driveEnabled) {
			return rightEncoder.getDirection();
		} else
			return false;

	}
}