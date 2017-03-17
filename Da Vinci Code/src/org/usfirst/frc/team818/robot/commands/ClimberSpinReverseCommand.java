package org.usfirst.frc.team818.robot.commands;


/**
 *
 */
public class ClimberSpinReverseCommand extends CommandBase {
	
	
    public ClimberSpinReverseCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(climber);//requires the climber class from CommandBase
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	climber.setSpeedReverse(); // begin at set speed 
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() { 
        return false; //stops when current is greater the current average plus 1
        
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
