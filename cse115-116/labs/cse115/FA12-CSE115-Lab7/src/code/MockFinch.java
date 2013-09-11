package code;

import java.awt.Color;

import cse115.graphics.Ellipse;

import edu.cmu.ri.createlab.terk.robot.finch.Finch;
import edu.cmu.ri.createlab.terk.robot.finch.FinchInterface;

public class MockFinch extends Ellipse implements FinchInterface {

	public MockFinch() {
	}
	
	/**
	 * @param frequency
	 * @param duration
	 * @see edu.cmu.ri.createlab.terk.robot.finch.Finch#buzz(int, int)
	 */
	@Override public void buzz(int frequency, int duration) {
	    System.out.println("called: buzz(frequency="+frequency+", duration="+duration+")");
	}

	/**
	 * @param frequency
	 * @param duration
	 * @see edu.cmu.ri.createlab.terk.robot.finch.Finch#buzzBlocking(int, int)
	 */
	@Override public void buzzBlocking(int frequency, int duration) {
	    System.out.println("called: buzzBlocking(frequency="+frequency+", duration="+duration+")");
	}

	/**
	 * 
	 * @see edu.cmu.ri.createlab.terk.robot.finch.Finch#closeAccelerometerGraph()
	 */
	@Override public void closeAccelerometerGraph() {
	    System.out.println("called: closeAccelerometerGraph()");
	}

	/**
	 * 
	 * @see edu.cmu.ri.createlab.terk.robot.finch.Finch#closeLightSensorGraph()
	 */
	@Override public void closeLightSensorGraph() {
	    System.out.println("called: closeLightSensorGraph()");
	}

	/**
	 * 
	 * @see edu.cmu.ri.createlab.terk.robot.finch.Finch#closeTemperatureGraph()
	 */
	@Override public void closeTemperatureGraph() {
	    System.out.println("called: closeTemperatureGraph()");
	}

	/**
	 * @param obj
	 * @return
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override public boolean equals(Object obj) {
	    System.out.println("called: equals(obj="+obj+")");
	    return false;
	}

	/**
	 * @return
	 * @see edu.cmu.ri.createlab.terk.robot.finch.Finch#getAccelerations()
	 */
	@Override public double[] getAccelerations() {
	    System.out.println("called: getAccelerations()");
	    return new double[0];
	}

	/**
	 * @return
	 * @see edu.cmu.ri.createlab.terk.robot.finch.Finch#getLeftLightSensor()
	 */
	@Override public int getLeftLightSensor() {
	    System.out.println("called: getLeftLightSensor()");
//	    return _world.getLightReading(this.getLocation());
	    return 0;
	}

	/**
	 * @return
	 * @see edu.cmu.ri.createlab.terk.robot.finch.Finch#getLightSensors()
	 */
	@Override public int[] getLightSensors() {
	    System.out.println("called: getLightSensors()");
	    return new int[0];
	}

	/**
	 * @return
	 * @see edu.cmu.ri.createlab.terk.robot.finch.Finch#getObstacleSensors()
	 */
	@Override public boolean[] getObstacleSensors() {
	    System.out.println("called: getObstacleSensors()");
	    return new boolean[0];
	}

	/**
	 * @return
	 * @see edu.cmu.ri.createlab.terk.robot.finch.Finch#getRightLightSensor()
	 */
	@Override public int getRightLightSensor() {
	    System.out.println("called: getRightLightSensor()");
	    return 0;
	}

	/**
	 * @return
	 * @see edu.cmu.ri.createlab.terk.robot.finch.Finch#getTemperature()
	 */
	@Override public double getTemperature() {
	    System.out.println("called: getTemperature()");
	    return 0.0;
	}

	/**
	 * @return
	 * @see edu.cmu.ri.createlab.terk.robot.finch.Finch#getXAcceleration()
	 */
	@Override public double getXAcceleration() {
	    System.out.println("called: getXAcceleration()");
	    return 0.0;
	}

	/**
	 * @return
	 * @see edu.cmu.ri.createlab.terk.robot.finch.Finch#getYAcceleration()
	 */
	@Override public double getYAcceleration() {
	    System.out.println("called: getYAcceleration()");
	    return 0.0;
	}

	/**
	 * @return
	 * @see edu.cmu.ri.createlab.terk.robot.finch.Finch#getZAcceleration()
	 */
	@Override public double getZAcceleration() {
	    System.out.println("called: getZAcceleration()");
	    return 0.0;
	}

	/**
	 * @return
	 * @see java.lang.Object#hashCode()
	 */
	@Override public int hashCode() {
	    System.out.println("called: hashCode()");
	    return 0;
	}

	/**
	 * @return
	 * @see edu.cmu.ri.createlab.terk.robot.finch.Finch#isBeakDown()
	 */
	@Override public boolean isBeakDown() {
	    System.out.println("called: isBeakDown()");
	    return false;
	}

	/**
	 * @return
	 * @see edu.cmu.ri.createlab.terk.robot.finch.Finch#isBeakUp()
	 */
	@Override public boolean isBeakUp() {
	    System.out.println("called: isBeakUp()");
	    return false;
	}

	/**
	 * @return
	 * @see edu.cmu.ri.createlab.terk.robot.finch.Finch#isFinchLevel()
	 */
	@Override public boolean isFinchLevel() {
	    System.out.println("called: isFinchLevel()");
	    return false;
	}

	/**
	 * @return
	 * @see edu.cmu.ri.createlab.terk.robot.finch.Finch#isFinchUpsideDown()
	 */
	@Override public boolean isFinchUpsideDown() {
	    System.out.println("called: isFinchUpsideDown()");
	    return false;
	}

	/**
	 * @param limit
	 * @return
	 * @see edu.cmu.ri.createlab.terk.robot.finch.Finch#isLeftLightSensor(int)
	 */
	@Override public boolean isLeftLightSensor(int limit) {
	    System.out.println("called: isLeftLightSensor(limit="+limit+")");
	    return false;
	}

	/**
	 * @return
	 * @see edu.cmu.ri.createlab.terk.robot.finch.Finch#isLeftWingDown()
	 */
	@Override public boolean isLeftWingDown() {
	    System.out.println("called: isLeftWingDown()");
	    return false;
	}

	/**
	 * @return
	 * @see edu.cmu.ri.createlab.terk.robot.finch.Finch#isObstacle()
	 */
	@Override public boolean isObstacle() {
	    System.out.println("called: isObstacle()");
	    return false;
	}

	/**
	 * @return
	 * @see edu.cmu.ri.createlab.terk.robot.finch.Finch#isObstacleLeftSide()
	 */
	@Override public boolean isObstacleLeftSide() {
	    System.out.println("called: isObstacleLeftSide()");
	    return false;
	}

	/**
	 * @return
	 * @see edu.cmu.ri.createlab.terk.robot.finch.Finch#isObstacleRightSide()
	 */
	@Override public boolean isObstacleRightSide() {
	    System.out.println("called: isObstacleRightSide()");
	    return false;
	}

	/**
	 * @param limit
	 * @return
	 * @see edu.cmu.ri.createlab.terk.robot.finch.Finch#isRightLightSensor(int)
	 */
	@Override public boolean isRightLightSensor(int limit) {
	    System.out.println("called: isRightLightSensor(limit="+limit+")");
	    return false;
	}

	/**
	 * @return
	 * @see edu.cmu.ri.createlab.terk.robot.finch.Finch#isRightWingDown()
	 */
	@Override public boolean isRightWingDown() {
	    System.out.println("called: isRightWingDown()");
	    return false;
	}

	/**
	 * @return
	 * @see edu.cmu.ri.createlab.terk.robot.finch.Finch#isShaken()
	 */
	@Override public boolean isShaken() {
	    System.out.println("called: isShaken()");
	    return false;
	}

	/**
	 * @return
	 * @see edu.cmu.ri.createlab.terk.robot.finch.Finch#isTapped()
	 */
	@Override public boolean isTapped() {
	    System.out.println("called: isTapped()");
	    return false;
	}

	/**
	 * @param limit
	 * @return
	 * @see edu.cmu.ri.createlab.terk.robot.finch.Finch#isTemperature(double)
	 */
	@Override public boolean isTemperature(double limit) {
	    System.out.println("called: isTemperature(limit="+limit+")");
	    return false;
	}

	/**
	 * @param arg0
	 * @see edu.cmu.ri.createlab.terk.robot.finch.Finch#playClip(java.lang.String)
	 */
	@Override public void playClip(String arg0) {
	    System.out.println("called: playClip(arg0"+arg0+")");
	}

	/**
	 * @param frequency
	 * @param volume
	 * @param duration
	 * @see edu.cmu.ri.createlab.terk.robot.finch.Finch#playTone(int, int, int)
	 */
	@Override public void playTone(int frequency, int volume, int duration) {
	    System.out.println("called: playTone(frequency="+frequency+", volume="+volume+", duration="+duration+")");
	}

	/**
	 * @param frequency
	 * @param duration
	 * @see edu.cmu.ri.createlab.terk.robot.finch.Finch#playTone(int, int)
	 */
	@Override public void playTone(int frequency, int duration) {
	    System.out.println("called: playTone(frequency="+frequency+", duration="+duration+")");
	}

	/**
	 * 
	 * @see edu.cmu.ri.createlab.terk.robot.finch.Finch#quit()
	 */
	@Override public void quit() {
	    System.out.println("called: quit()");
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @see edu.cmu.ri.createlab.terk.robot.finch.Finch#saySomething(java.lang.String, int)
	 */
	@Override public void saySomething(String arg0, int arg1) {
	    System.out.println("called: saySomething(arg0="+arg0+", arg1="+arg1+")");
	}

	/**
	 * @param arg0
	 * @see edu.cmu.ri.createlab.terk.robot.finch.Finch#saySomething(java.lang.String)
	 */
	@Override public void saySomething(String arg0) {
	    System.out.println("called: saySomething(arg0="+arg0+")");
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @see edu.cmu.ri.createlab.terk.robot.finch.Finch#setLED(java.awt.Color, int)
	 */
	@Override public void setLED(Color arg0, int arg1) {
	    System.out.println("called: setLED(arg0="+arg0+", arg1="+arg1+")");
	}

	/**
	 * @param arg0
	 * @see edu.cmu.ri.createlab.terk.robot.finch.Finch#setLED(java.awt.Color)
	 */
	@Override public void setLED(Color arg0) {
	    System.out.println("called: setLED(arg0="+arg0+")");
	}

	/**
	 * @param red
	 * @param green
	 * @param blue
	 * @param duration
	 * @see edu.cmu.ri.createlab.terk.robot.finch.Finch#setLED(int, int, int, int)
	 */
	@Override public void setLED(int red, int green, int blue, int duration) {
	    System.out.println("called: setLED(red="+red+", green="+green+", blue="+blue+", duration="+duration+")");
	}

	/**
	 * @param red
	 * @param green
	 * @param blue
	 * @see edu.cmu.ri.createlab.terk.robot.finch.Finch#setLED(int, int, int)
	 */
	@Override public void setLED(int red, int green, int blue) {
	    System.out.println("called: setLED(red="+red+", green="+green+", blue="+blue+")");
	}

	/**
	 * @param leftVelocity
	 * @param rightVelocity
	 * @param timeToHold
	 * @see edu.cmu.ri.createlab.terk.robot.finch.Finch#setWheelVelocities(int, int, int)
	 */
        @Override public void setWheelVelocities(int leftVelocity, int rightVelocity, int timeToHold) {
	     System.out.println("called: setWheelVelocities(leftVelocity="+leftVelocity+", rightVelocity="+rightVelocity+", timeToHold="+timeToHold+")");
	}

	/**
	 * @param leftVelocity
	 * @param rightVelocity
	 * @see edu.cmu.ri.createlab.terk.robot.finch.Finch#setWheelVelocities(int, int)
	 */
	@Override public void setWheelVelocities(int leftVelocity, int rightVelocity) {
	     System.out.println("called: setWheelVelocities(leftVelocity="+leftVelocity+", rightVelocity="+rightVelocity+")");
	}

	/**
	 * 
	 * @see edu.cmu.ri.createlab.terk.robot.finch.Finch#showAccelerometerGraph()
	 */
	@Override public void showAccelerometerGraph() {
	    System.out.println("called: showAccelerometerGraph()");
	}

	/**
	 * 
	 * @see edu.cmu.ri.createlab.terk.robot.finch.Finch#showLightSensorGraph()
	 */
	@Override public void showLightSensorGraph() {
	    System.out.println("called: showLightSensorGraph()");
	}

	/**
	 * 
	 * @see edu.cmu.ri.createlab.terk.robot.finch.Finch#showTemperatureGraph()
	 */
	@Override public void showTemperatureGraph() {
	    System.out.println("called: showTemperatureGraph()");
	}

	/**
	 * @param arg0
	 * @see edu.cmu.ri.createlab.terk.robot.finch.Finch#sleep(int)
	 */
	@Override public void sleep(int arg0) {
	    System.out.println("called: sleep(arg0="+arg0+")");
	}

	/**
	 * 
	 * @see edu.cmu.ri.createlab.terk.robot.finch.Finch#stopWheels()
	 */
	@Override public void stopWheels() {
	    System.out.println("called: stopWheels()");
	}

	/**
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override public String toString() {
	    System.out.println("called: toString()");
	    return "MOCK FINCH";
	}

	/**
	 * @param xVal
	 * @param yVal
	 * @param zVal
	 * @see edu.cmu.ri.createlab.terk.robot.finch.Finch#updateAccelerometerGraph(double, double, double)
	 */
	@Override public void updateAccelerometerGraph(double xVal, double yVal, double zVal) {
	    System.out.println("called: updateAccelerometerGraph(xVal="+xVal+", yVal="+yVal+", zVal="+zVal+")");
	}

	/**
	 * @param leftSensor
	 * @param rightSensor
	 * @see edu.cmu.ri.createlab.terk.robot.finch.Finch#updateLightSensorGraph(int, int)
	 */
	@Override public void updateLightSensorGraph(int leftSensor, int rightSensor) {
	    System.out.println("called: updateLightSensorGraph(leftSensor="+leftSensor+", rightSensor="+rightSensor+")");
	}

	/**
	 * @param temp
	 * @see edu.cmu.ri.createlab.terk.robot.finch.Finch#updateTemperatureGraph(double)
	 */
	@Override public void updateTemperatureGraph(double temp) {
	    System.out.println("called: updateTemperatureGraph(temp="+temp+")");
	}
}
