package org.usfirst.frc.team818.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class IntakeSubsystem extends Subsystem {
	
	private Talon jag;
	private boolean intakeEnabled;

	public IntakeSubsystem(int intakePort, boolean intakeEnabled){
		
		this.intakeEnabled = intakeEnabled;
		
		if(intakeEnabled) {
			jag = new Talon(intakePort);
		}
		
	}
	
    public void initDefaultCommand() {
    }
    
    public void in() {
    	if(intakeEnabled) {
    		jag.set(-1);	
    	}
    }
    
    public void out() {
    	if(intakeEnabled) {
    		jag.set(1);	
    	}
    }
    
    public void stop() {
    	if(intakeEnabled) {
    		jag.set(0);	
    	}
    }
}	