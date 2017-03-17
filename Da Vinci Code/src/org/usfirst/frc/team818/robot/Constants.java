package org.usfirst.frc.team818.robot;

public class Constants {
	
	/**
	 * Set the subsystems to be enabled or disabled
	 * 
	 * These values are used to allow the code to run when parts of the robot are missing.
	 * Putting them here prevents the code from trying to reference non-existent motors and
	 * sensors, which would otherwise require commenting out large portions of the code.
	 * 
	 */
	public static final boolean cameraEnabled = true;
	public static final boolean climberEnabled = true;
	public static final boolean compressorEnabled = true;
	public static final boolean doorEnabled = true;
	public static final boolean driveEnabled = true;
	public static final boolean gearEnabled = true;
	public static final boolean intakeEnabled = true;
	public static final boolean shifterEnabled = true;
	
	//Joystick Ports
	public static final int leftJoystickPort = 0;
	public static final int rightJoystickPort = 1;
	public static final int gamepadPort = 2;
	
	//Used in the Climber Subsystem
	public static final int climberMotorPort = 4; //done
	public static final int[] climberPistonPort = { 6, 7 }; //done
	
	//Used in the Door Subsystem
	public static final int doorMotorPort = 6; //done
	public static final int doorGyroPort = 1; //done
	
	//Used in the Drive Subsystem
	public static final int[] leftMotorPorts = { 2, 3 }; //done
	public static final int[] rightMotorPorts = { 0, 1 }; //done
	public static final int gyroDrivePort = 0; //done
	public static final int[] leftEncoderPorts = { 2, 3 }; //done
	public static final int[] rightEncoderPorts = { 0, 1 }; //done
	public static final double cycleDistance = 12.56;
	
	//Used in the Gear Subsystem
	public static final int[] gearPistonPorts = { 4, 5 }; //done
	
	//Used in the Intake Subsystem
	public static final int intakeMotorPort = 5; //done
	
	//Used in the Shifter Subsystem
	public static final int[] driveLeftPistonPorts = { 2, 3 }; //done
	public static final int[] driveRightPistonPorts = { 0, 1 }; //done
}
