package org.usfirst.frc.team818.robot.subsystems;

import java.util.ArrayList;

import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team818.robot.Constants;
import org.usfirst.frc.team818.robot.OI;
import org.usfirst.frc.team818.robot.utilities.RobotLog;
import org.usfirst.frc.team818.robot.utilities.ViableVision;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Camera {

	ViableVision vb;
	Thread visionThread;
	UsbCamera camera;
	boolean canEnable;

	double target;
	double distance;

	public void init() {
		vb = new ViableVision();
		RobotLog.init();

		target = 320.0;
		
		if (!Constants.cameraEnabled) return;

		visionThread = new Thread(() -> {
			UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
			camera.setResolution(640, 480);

			CvSink cvSink = CameraServer.getInstance().getVideo();
			CvSource outputStream = CameraServer.getInstance().putVideo("Rectangle", 640, 480);

			Mat mat = new Mat();
			while (!Thread.interrupted()) {
				if (cvSink.grabFrame(mat) == 0) {
					outputStream.notifyError(cvSink.getError());
					continue;
				}
				outputStream.putFrame(joshFilter(mat));
			}
		});
		visionThread.setDaemon(true);
		visionThread.start();
	}
	
	public double getTarget() {
		return target;
	}
	
	public double getDistance() {
		return distance;
	}

	private Mat joshFilter(Mat mat) {

		vb.process(mat);
		
		if (vb.filterContoursOutput().size() != 2) return mat;

		ArrayList<Double> xVal = new ArrayList<Double>();

		for (int i = 0; i < vb.filterContoursOutput().size(); i++) {
			Point[] points = vb.filterContoursOutput().get(i).toArray();

			int furthestX = 0;
			int nearestX = 999;

			for (Point p : points) {
				if ((int) p.x > furthestX)
					furthestX = (int) p.x;
				if ((int) p.x < nearestX)
					nearestX = (int) p.x;
			}
			double avg = (furthestX + nearestX) / 2;
			xVal.add(avg);
			Imgproc.line(mat, new Point(avg, 479), new Point(avg, 1), new Scalar(new double[] { 0.0, 0.0, 255.0 }));
		}

		double sum = 0.0;
		for (double d : xVal) {
			sum += d;
		}

		double cross = sum / vb.filterContoursOutput().size();
		target = cross;
		Imgproc.line(mat, new Point(cross, 479), new Point(cross, 1), new Scalar(new double[] { 255.0, 0.0, 0.0 }));
		
		

		try {
			distance = OI.k / Math.abs(xVal.get(0) - xVal.get(1));
			SmartDashboard.putNumber("Distance", distance);
		} catch (Exception ex) {

		}
		
		return mat;
	}
}
