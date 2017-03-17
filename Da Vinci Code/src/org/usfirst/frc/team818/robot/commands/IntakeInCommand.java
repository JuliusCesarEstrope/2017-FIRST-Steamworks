package org.usfirst.frc.team818.robot.commands;


public class IntakeInCommand extends CommandBase {

    public IntakeInCommand() {
       	requires(intake);
    }

    protected void initialize() {
    	intake.stop();
    }

    protected void execute() {
    	intake.in();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	intake.stop();
    }

    protected void interrupted() {
    	intake.stop();
    }
}
