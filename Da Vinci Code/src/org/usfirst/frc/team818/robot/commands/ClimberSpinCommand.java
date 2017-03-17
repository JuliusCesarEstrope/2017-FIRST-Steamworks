package org.usfirst.frc.team818.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ClimberSpinCommand extends CommandBase {
	
	Timer timer = new Timer(); //calls timer 
	double[] storeCurrent = new double[8]; // makes a new double array with 8 indexes called storeCurrent.
	double currentAverage = 0; // currentAverage is a universal double that stores the average of all the currents
	boolean override = false;
	
    public ClimberSpinCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(climber);//requires the climber class from CommandBase
    }
    
    public ClimberSpinCommand(boolean override) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(climber);//requires the climber class from CommandBase
    	this.override = override;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	climber.setSpeed(); // begin at set speed 
    	timer.start(); //command to begin timer
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if((timer.get() * 1000) % 100 == 0 ){
    		
    		// timer value (in milliseconds) has a remainder when divided by 100. % is the symbol for modulus (returns remainder, not whole value)  
    		
    		for(int i = 0; i < storeCurrent.length; i++){ //it goes through the entire array
    			if(storeCurrent[i] == 0){//
    				storeCurrent[i] = climber.getClimberCurrent();//
    				break;                                  
    			} else if (i == 7){// if i equals 7 it runs this code
    				for(int j = 0; j < storeCurrent.length - 1; j++){// this replaces the oldest index with the index after it and replaces the most recent index with the new value
    					storeCurrent[j] = storeCurrent[j + 1]; //it sets the index to what the index was after it
    					
    				}
    				storeCurrent[i] = climber.getClimberCurrent(); //sets the storeCurrent array to the current value of the current
    			}
    			
    		}
    	}
    	if(timer.get() > 1){ // gets the average of all the indexes
    		double currentSum = 0;//makes a new double called the currentSum; it stores the sum of all the values in the storeCurrent array
    		for(int i = 0; i < storeCurrent.length; i++){//if i is less than the storeCurrent, add 1 to i until values become equal
    			currentSum = storeCurrent[i] + currentSum ;//currentSum is equal to the sum of all values of the index and the sum of all currents 
    		}
    		currentAverage = currentSum / storeCurrent.length;// takes the average
    	}

		SmartDashboard.putNumber("Number3", currentAverage);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() { 
    	if (override) 
    		return false;
    	else 
    		return climber.getClimberCurrent() > currentAverage + 1; //stops when current is greater the current average plus 1
        
    }

    // Called once after isFinished returns true
    protected void end() {
    	climber.setSpeedOff(); //runs climber.off
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	climber.setSpeedOff(); //runs climber.off
    }
}
