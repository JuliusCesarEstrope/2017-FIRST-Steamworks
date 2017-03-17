package org.usfirst.frc.team818.robot.commands;


public class GearOpenCommand extends CommandBase {

    public GearOpenCommand() {
       	requires(gear);
    }

    protected void initialize() {
    	gear.open();
    }

    protected void execute() {

    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	gear.off();
    }

    protected void interrupted() {
    	gear.off();
    }
}
