package org.usfirst.frc.team818.robot.commands;


public class GearCloseCommand extends CommandBase {

    public GearCloseCommand() {
       	requires(gear);
    }

    protected void initialize() {
    	gear.close();
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
