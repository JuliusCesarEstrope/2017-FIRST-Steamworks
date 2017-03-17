package org.usfirst.frc.team818.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearSubsystem extends Subsystem {
	
	private DoubleSolenoid gearPiston;
	private boolean gearEnabled;

	public GearSubsystem(int[] pistonPorts, boolean gearEnabled){
		
		this.gearEnabled = gearEnabled;
		
		if(gearEnabled) {
			gearPiston = new DoubleSolenoid(pistonPorts[0], pistonPorts[1]);
		}
		
	}
	
    public void initDefaultCommand() {
    	
    }
    
    public void open() {
    	if(gearEnabled) {
    		gearPiston.set(DoubleSolenoid.Value.kForward);	
    	}
    }
    
    public void close() {
    	if(gearEnabled) {
    		gearPiston.set(DoubleSolenoid.Value.kReverse);
    	}
    }
    
    public void off() {
    	if(gearEnabled) {
    		gearPiston.set(DoubleSolenoid.Value.kOff);
    	}
    }
    
}	