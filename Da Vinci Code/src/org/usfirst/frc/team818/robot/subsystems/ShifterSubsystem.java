package org.usfirst.frc.team818.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ShifterSubsystem extends Subsystem {

	// DoubleSolenoid gearShiftLeft, gearShiftRight;
	Solenoid gearShiftLeftForward, gearShiftLeftReverse, gearShiftRightForward, gearShiftRightReverse;
	private boolean shifterEnabled;

	public ShifterSubsystem(int[] gearLeftPorts, int[] gearRightPorts, boolean shifterEnabled) {

		this.shifterEnabled = shifterEnabled;

		if (shifterEnabled) {
			gearShiftLeftForward = new Solenoid(gearLeftPorts[0]);
			gearShiftLeftReverse = new Solenoid(gearLeftPorts[1]);
			gearShiftRightForward = new Solenoid(gearRightPorts[0]);
			gearShiftRightReverse = new Solenoid(gearRightPorts[1]);

			// gearShiftLeft = new DoubleSolenoid(gearLeftPorts[0],
			// gearLeftPorts[1]);
			// gearShiftRight = new DoubleSolenoid(gearRightPorts[0],
			// gearRightPorts[1]);
		}
	}

	public void initDefaultCommand() {
		// setDefaultCommand(new ShiftHighCommand());
	}

	public void lowGear() {
		if (shifterEnabled) {
			gearShiftLeftForward.set(false);
			gearShiftLeftReverse.set(true);
			gearShiftRightForward.set(false);
			gearShiftRightReverse.set(true);
			// gearShiftLeft.set(DoubleSolenoid.Value.kForward);
			// gearShiftRight.set(DoubleSolenoid.Value.kForward);
		}
	}

	public void highGear() {
		if (shifterEnabled) {
			gearShiftLeftForward.set(true); // sets to true
			gearShiftLeftReverse.set(false);
			gearShiftRightForward.set(true);
			gearShiftRightReverse.set(false);
			// gearShiftLeft.set(DoubleSolenoid.Value.kReverse);
			// gearShiftRight.set(DoubleSolenoid.Value.kReverse);
		}
	}

	public void offGear() {
		if (shifterEnabled) {
			gearShiftLeftForward.set(false);
			gearShiftLeftReverse.set(false);
			gearShiftRightForward.set(false);
			gearShiftRightReverse.set(false);
			// gearShiftLeft.set(DoubleSolenoid.Value.kOff);
			// gearShiftRight.set(DoubleSolenoid.Value.kOff);
		}
	}

}