package org.usfirst.frc.team818.robot.commands;


public class IntakeOutCommand extends CommandBase {

    public IntakeOutCommand() {
       	requires(intake);
    }

    protected void initialize() {
    	intake.stop();
    }

    protected void execute() {
    	intake.out();
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
