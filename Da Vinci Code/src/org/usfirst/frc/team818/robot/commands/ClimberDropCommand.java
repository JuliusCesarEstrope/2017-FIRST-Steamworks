package org.usfirst.frc.team818.robot.commands;

/**
 *
 */
public class ClimberDropCommand extends CommandBase {

    public ClimberDropCommand() {
    	requires(climber);
    }

    protected void initialize() {
    }

    protected void execute() {
    	climber.close();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
