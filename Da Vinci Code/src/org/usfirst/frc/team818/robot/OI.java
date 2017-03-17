package org.usfirst.frc.team818.robot;

import org.usfirst.frc.team818.robot.commands.AutoAlignCommand;
import org.usfirst.frc.team818.robot.commands.ClimberSpinCommand;
import org.usfirst.frc.team818.robot.commands.ClimberSpinReverseCommand;
import org.usfirst.frc.team818.robot.commands.DomCommand;
import org.usfirst.frc.team818.robot.commands.DoorSetClosedCommand;
import org.usfirst.frc.team818.robot.commands.DoorSetGearCommand;
import org.usfirst.frc.team818.robot.commands.DoorSetOpenCommand;
import org.usfirst.frc.team818.robot.commands.DriveStraight;
import org.usfirst.frc.team818.robot.commands.DropCommand;
import org.usfirst.frc.team818.robot.commands.DynamicBraking;
import org.usfirst.frc.team818.robot.commands.GearCloseCommand;
import org.usfirst.frc.team818.robot.commands.GearOpenCommand;
import org.usfirst.frc.team818.robot.commands.IntakeInCommand;
import org.usfirst.frc.team818.robot.commands.IntakeOutCommand;
import org.usfirst.frc.team818.robot.commands.OverrideShiftCommand;
import org.usfirst.frc.team818.robot.commands.SlowReverseCommand;
import org.usfirst.frc.team818.robot.commands.ShiftLCommand;
import org.usfirst.frc.team818.robot.commands.ShiftHCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;

public class OI {

	private Joystick leftStick;
	private Joystick rightStick;
	private Joystick gamepad;
	private JoystickButton buttonOpen;
	private JoystickButton buttonClose;
	private JoystickButton buttonHopper;
	private JoystickButton buttonGearClose;
	private JoystickButton buttonGearOpen;
	private JoystickButton driveStright;
	private JoystickButton jogBack;
	private JoystickButton buttonClimber;
	private JoystickButton buttonDropClimber;
	private Trigger buttonClimberOverride;
	private Trigger buttonDom;
	private JoystickButton buttonShiftGear;
	private JoystickButton buttonShiftOverride;
	private JoystickButton buttonDynamicBrake;
	private JoystickButton buttonAlign;
	private JoystickButton backDrive;
	private JoystickButton intakeIn;
	private JoystickButton intakeOut;
	public static double k = 5450;

	public OI() {

		leftStick = new Joystick(Constants.leftJoystickPort);
		rightStick = new Joystick(Constants.rightJoystickPort);
		gamepad = new Joystick(Constants.gamepadPort);
		buttonOpen = new JoystickButton(gamepad, 4);
		buttonClose = new JoystickButton(gamepad, 2);
		buttonHopper = new JoystickButton(gamepad, 3);
		buttonGearClose = new JoystickButton(gamepad, 7);
		buttonGearOpen = new JoystickButton(gamepad, 8);
		driveStright = new JoystickButton(leftStick, 1);
		jogBack = new JoystickButton(leftStick, 4);
		buttonShiftGear = new JoystickButton(rightStick, 1);
		buttonDynamicBrake = new JoystickButton(leftStick, 2);
		buttonAlign = new JoystickButton(leftStick, 3);
		buttonShiftOverride = new JoystickButton(leftStick, 5);
		backDrive = new JoystickButton(gamepad, 1);
		intakeIn = new JoystickButton(gamepad, 5);
		intakeOut = new JoystickButton(gamepad, 6);
		// buttonClimber = new JoystickButton(gamepad, 9);

		buttonDropClimber = new JoystickButton(gamepad, 9);
		buttonClimber = new JoystickButton(gamepad, 10);
		
		
		buttonClimberOverride = new Trigger() {

			public boolean get() {
				return leftStick.getRawButton(6) && leftStick.getRawButton(7);
			}

		};
		
		buttonDom = new Trigger() {

			public boolean get() {
				return rightStick.getRawButton(6) && rightStick.getRawButton(7) && leftStick.getRawButton(8) && leftStick.getRawButton(9);
			}

		};

		// buttons
		buttonDynamicBrake.whileHeld(new DynamicBraking());
		buttonShiftGear.whenPressed(new ShiftLCommand());
		buttonShiftGear.whenReleased(new ShiftHCommand());
		buttonOpen.whenPressed(new DoorSetOpenCommand());
		buttonClose.whenPressed(new DoorSetClosedCommand());
		buttonHopper.whenPressed(new DoorSetGearCommand());
		buttonGearOpen.whenPressed(new GearOpenCommand());
		buttonGearClose.whenPressed(new GearCloseCommand());
		buttonAlign.whileHeld(new AutoAlignCommand());
		buttonShiftOverride.whileHeld(new OverrideShiftCommand());
		driveStright.whileHeld(new DriveStraight());
		jogBack.whileHeld(new SlowReverseCommand());
		backDrive.whileHeld(new ClimberSpinReverseCommand());
		IntakeInCommand incmd = new IntakeInCommand();
		IntakeOutCommand outcmd = new IntakeOutCommand();
		intakeIn.toggleWhenPressed(incmd);
		intakeOut.toggleWhenPressed(outcmd);
		// triggers
		ClimberSpinCommand spin = new ClimberSpinCommand();
		buttonClimber.whileHeld(spin);
		buttonDropClimber.whenPressed(new DropCommand());
		buttonClimberOverride.whileActive(new ClimberSpinCommand(true));
		buttonDom.whileActive(new DomCommand());

	}

	public double getLeftY() {

		return (Math.abs(leftStick.getY()) > 0.1) ? -leftStick.getY() : 0;

	}

	public double getRightY() {

		return (Math.abs(rightStick.getY()) > 0.1) ? -rightStick.getY() : 0;

	}

	public double getGamepadLeftY() {

		return (Math.abs(gamepad.getRawAxis(1)) > 0.1) ? -gamepad.getRawAxis(1) : 0;
	}

	public double getGamepadRightY() {

		return (Math.abs(gamepad.getRawAxis(3)) > 0.1) ? -gamepad.getRawAxis(3) : 0;

	}

	public boolean getGamepadA() {
		return gamepad.getRawButton(2);
	}

	public boolean getGamepadB() {
		return gamepad.getRawButton(3);
	}

	public boolean getGamepadX() {
		return gamepad.getRawButton(1);
	}

	public boolean getGamepadY() {
		return gamepad.getRawButton(4);
	}

	public boolean getGamepadLeftBumper() {
		return gamepad.getRawButton(5);
	}

	public boolean getGamepadRightBumper() {
		return gamepad.getRawButton(6);
	}

	public boolean getGamepadLeftTrigger() {
		return gamepad.getRawButton(7);
	}

	public boolean getGamepadRightTrigger() {
		return gamepad.getRawButton(8);
	}

}
