package org.usfirst.frc.team818.robot.commands;

import edu.wpi.first.wpilibj.Timer;

public class GearOpenCommand4Time extends CommandBase {
	
	Timer timer;
	
	double time;

    public GearOpenCommand4Time(double time) {
       	requires(gear);
       	timer = new Timer();
       	this.time = time;
    }

    protected void initialize() {
    	gear.open();
    	timer.start();
    }

    protected void execute() {

    }

    protected boolean isFinished() {
        return timer.hasPeriodPassed(time);
    }

    protected void end() {
    	gear.off();
    }

    protected void interrupted() {
    	gear.off();
    }
}
