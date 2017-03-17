
package org.usfirst.frc.team818.robot;

import org.usfirst.frc.team818.robot.commands.CommandBase;
import org.usfirst.frc.team818.robot.utilities.RobotLog;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	
	Command autonomous;
	
	public void robotInit() {
		
		CommandBase.init();
		RobotLog.init();
		try{
			NetworkTable.getTable("Root").putBoolean("autonStarted", true);
			NetworkTable.getTable("Root").putNumber("allianceStation", DriverStation.getInstance().getAlliance().ordinal());
		} catch(Exception e){
			
		}
	}
	
	public void autonomousInit() {
		
		autonomous = AutonomousSelector.getSelectedAutonomous();
        if (autonomous != null) autonomous.start();
        
	}
	
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}
	
	public void teleopInit() {
		
		if (autonomous != null) autonomous.cancel();
		
		
	}
	
	public void teleopPeriodic() {

		Scheduler.getInstance().run();
		SmartDashboard.putNumber("Data1", CommandBase.drive.getLeftRotation());
		SmartDashboard.putNumber("Data2", CommandBase.drive.getRightRotation());
	}
	
	public void disabledInit() {
		CommandBase.disable();
	}
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}
	
	public void testPeriodic() {
		LiveWindow.run();
	}
	
	
}
