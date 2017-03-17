package org.usfirst.frc.team818.robot.subsystems;

import org.usfirst.frc.team818.robot.commands.DoorCommand;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DoorSubsystem extends Subsystem {
	
	private Talon window;
	private AnalogGyro doorGyro;
	private boolean doorEnabled;

	/*private static final double[] ROTATE_PID_VALUES = { 0.05, 0, 0.1 };
	private static final double[] ROTATE_PID_RANGE = { -0.4, 0.4 };
	
	private static final double ROTATE_PID_TOLERANCE = 1;
	
	private PIDController rotateController;
	private DoublePIDOutput pidOutput;*/
	
	public DoorSubsystem(int motorPort, int gyroPort, boolean doorEnabled){
		
		this.doorEnabled = doorEnabled;
		
		if(doorEnabled) {
			window = new Talon(motorPort);
			doorGyro = new AnalogGyro(gyroPort);
		}
		
		/*rotateController = new PIDController(ROTATE_PID_VALUES[0], ROTATE_PID_VALUES[1], ROTATE_PID_VALUES[2], doorGyro, pidOutput);
		rotateController.setOutputRange(ROTATE_PID_RANGE[0], ROTATE_PID_RANGE[1]);
		rotateController.setAbsoluteTolerance(ROTATE_PID_TOLERANCE);
		rotateController.setContinuous();*/
		
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new DoorCommand());
    }
    
    public void setMotor(double v) {
    	window.set(v);
    }
    
    public void DoorZAxis(double speed) {
    	if(doorEnabled) {
    		window.set(speed);
    	}
    }
    
    public void open() {
    	if(doorEnabled) {
    		window.set(0.3);	
    	}
    }
    
    public void close() {
    	if(doorEnabled) {
    		window.set(-0.3);	
    	}
    }
    
    public void pause() {
    	if(doorEnabled) {
    		window.set(0);	
    	}
    }
    
    public void slowOpen() {
    	if(doorEnabled) {
    		window.set(0.2);	
    	}
    }
    
    public void slowClose() {
    	if(doorEnabled) {
    		window.set(-0.2);	
    	}
    }
    
    public void resetGyro(){
    	if(doorEnabled) {
    		doorGyro.reset();
    	}
    }
    
    public double getAngle(){
    	if(doorEnabled) {
    		return doorGyro.getAngle();
    	} else return 0.0;
    }
    
}	