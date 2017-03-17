package org.usfirst.frc.team818.robot.commands;

/**
 *
 */
public class CompressorStopCommand extends CommandBase {

    public CompressorStopCommand() {
    	requires(compressor);
    }

    protected void initialize() {
    	compressor.stopCompressor();
    }

    protected void execute() {
    	compressor.stopCompressor();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    	compressor.stopCompressor();
    }

    protected void interrupted() {
    	compressor.stopCompressor();
    }
}
