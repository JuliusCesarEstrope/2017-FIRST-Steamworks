package org.usfirst.frc.team818.robot.commands;

/**
 *
 */
public class ClimberExtendCommand extends CommandBase {

    public ClimberExtendCommand() {
    	requires(climber);
    }

    protected void initialize() {
    	climber.open();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
