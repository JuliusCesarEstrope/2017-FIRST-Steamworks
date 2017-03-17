package org.usfirst.frc.team818.robot.commands;


public class CompressorCommand extends CommandBase {

    public CompressorCommand() {
       	requires(compressor);
    }

    protected void initialize() {
    	compressor.startCompressor();
    }

    protected void execute() {
    	if(compressor.getPressureSwitchValue()) compressor.stopCompressor();
    	else compressor.startCompressor();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	compressor.stopCompressor();
    }

    protected void interrupted() {
    	compressor.stopCompressor();
    }
}
