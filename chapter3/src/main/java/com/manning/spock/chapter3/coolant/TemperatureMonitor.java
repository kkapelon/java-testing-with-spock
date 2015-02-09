package com.manning.spock.chapter3.coolant;

public class TemperatureMonitor {
	
	private final TemperatureReader reader;
	private TemperatureReadings lastReadings;
	private TemperatureReadings currentReadings;

	public TemperatureMonitor(final TemperatureReader reader)
	{
		this.reader = reader;
	}
	
	public boolean isTemperatureNormal()
	{
		boolean firstSensorOK = Math.abs(lastReadings.getSensor1Data() - currentReadings.getSensor1Data()) < 20;
		boolean secondSensorOK = Math.abs(lastReadings.getSensor2Data() - currentReadings.getSensor2Data()) < 20;
		boolean thirdSensorOK = Math.abs(lastReadings.getSensor3Data() - currentReadings.getSensor3Data()) < 20;
		return firstSensorOK && secondSensorOK && thirdSensorOK;
	}
	
	public void readSensor()
	{
		lastReadings = currentReadings;
		currentReadings = reader.getCurrentReadings();
	}

}
