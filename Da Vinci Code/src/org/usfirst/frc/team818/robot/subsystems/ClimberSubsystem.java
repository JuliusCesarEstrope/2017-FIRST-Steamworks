package org.usfirst.frc.team818.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ClimberSubsystem extends Subsystem {

	private Talon victor;
	private int TalonPort;
	private DoubleSolenoid piston;
	private PowerDistributionPanel pdp;
	private boolean climberEnabled;

	public ClimberSubsystem(int climberMotorPort, int[] climberPistonPort, boolean climberEnabled) {

		this.climberEnabled = climberEnabled;

		if (climberEnabled) {

			victor = new Talon(climberMotorPort);
			piston = new DoubleSolenoid(climberPistonPort[0], climberPistonPort[1]);
			pdp = new PowerDistributionPanel();

		}

		TalonPort = climberMotorPort;

	}

	public void initDefaultCommand() {
	}

	public void open() {
		if (climberEnabled) {
			piston.set(DoubleSolenoid.Value.kForward);
		}
	}

	public void close() {
		if (climberEnabled) {
			piston.set(DoubleSolenoid.Value.kReverse);
		}
	}

	public void off() {
		if (climberEnabled) {
			piston.set(DoubleSolenoid.Value.kOff);
		}
	}

	public void setSpeed() {
		if (climberEnabled) {
			victor.set(1);
		}
	}

	public void setSpeedReverse() {
		if (climberEnabled) {
			victor.set(-0.25);
		}
	}

	public void setSpeedOff() {
		if (climberEnabled) {
			victor.set(0);
		}
	}

	public double getClimberCurrent() {
		return (climberEnabled) ? Math.abs(pdp.getCurrent(TalonPort)) : -1;
	}

}