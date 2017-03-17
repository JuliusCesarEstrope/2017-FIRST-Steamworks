package org.usfirst.frc.team818.robot.commands;

import org.usfirst.frc.team818.robot.Constants;
import org.usfirst.frc.team818.robot.OI;
import org.usfirst.frc.team818.robot.subsystems.Camera;
import org.usfirst.frc.team818.robot.subsystems.ClimberSubsystem;
import org.usfirst.frc.team818.robot.subsystems.CompressorSubsystem;
import org.usfirst.frc.team818.robot.subsystems.DoorSubsystem;
import org.usfirst.frc.team818.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team818.robot.subsystems.GearSubsystem;
import org.usfirst.frc.team818.robot.subsystems.IntakeSubsystem;
import org.usfirst.frc.team818.robot.subsystems.ShifterSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public abstract class CommandBase extends Command{

	public static ClimberSubsystem climber;
	public static CompressorSubsystem compressor;
	public static DoorSubsystem door;
	public static DriveSubsystem drive;
	public static GearSubsystem gear;
	public static IntakeSubsystem intake;
	public static ShifterSubsystem shifter;
	public static Camera camera;
	public static OI oi;
	
	public static void init(){
		
		climber = new ClimberSubsystem(Constants.climberMotorPort, Constants.climberPistonPort, Constants.climberEnabled);
		compressor = new CompressorSubsystem(Constants.compressorEnabled);
		door = new DoorSubsystem(Constants.doorMotorPort, Constants.doorGyroPort, Constants.doorEnabled);
		drive = new DriveSubsystem(Constants.leftMotorPorts, Constants.rightMotorPorts, Constants.gyroDrivePort, 
					Constants.leftEncoderPorts, Constants.rightEncoderPorts, Constants.driveEnabled);
		gear = new GearSubsystem(Constants.gearPistonPorts, Constants.gearEnabled);
		intake = new IntakeSubsystem(Constants.intakeMotorPort, Constants.intakeEnabled);
		shifter = new ShifterSubsystem(Constants.driveLeftPistonPorts, Constants.driveRightPistonPorts, Constants.shifterEnabled);
		camera = new Camera();
		
		oi = new OI();		
		
		drive.resetGyro();
		door.resetGyro();
		
		compressor.startCompressor();
		camera.init();
		climber.open();
		/*drive.startCompressor();
		drive.setBoth(0);
		intake.stop();
		door.pause();
		climber.setSpeedOff();*/
	}

	public static void disable(){
		
		drive.setBoth(0);
		//compressor.stopCompressor();
		intake.stop();
		door.pause();
		climber.setSpeedOff();
		
	}
	
}
