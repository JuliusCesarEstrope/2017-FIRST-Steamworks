package org.usfirst.frc.team818.robot.subsystems;

import org.usfirst.frc.team818.robot.commands.CompressorCommand;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class CompressorSubsystem extends Subsystem {

	Compressor compressor;

	private boolean compressorEnabled;

	public CompressorSubsystem(boolean compressorEnabled) {
		this.compressorEnabled = compressorEnabled;
		if (compressorEnabled)
			compressor = new Compressor();
	}

	public void initDefaultCommand() {
		setDefaultCommand(new CompressorCommand());
	}

	public void setCloseLoopControl(boolean compressorSwitch) {
		if (compressorEnabled) {
			compressor.setClosedLoopControl(compressorSwitch);
		}
	}

	public void startCompressor() {
		if (compressorEnabled) {
			compressor.start();
		}
	}

	public void stopCompressor() {
		if (compressorEnabled) {
			compressor.stop();
		}
	}

	public boolean getPressureSwitchValue() {
		if (compressorEnabled) {
			return compressor.getPressureSwitchValue();
		} else
			return false;
	}

}