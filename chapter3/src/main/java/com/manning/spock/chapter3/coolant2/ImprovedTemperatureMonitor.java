package com.manning.spock.chapter3.coolant2;

import com.manning.spock.chapter3.coolant.TemperatureReader;
import com.manning.spock.chapter3.coolant.TemperatureReadings;

public class ImprovedTemperatureMonitor {
	
	private final TemperatureReader reader;
	private TemperatureReadings lastReadings;
	private TemperatureReadings currentReadings;
	private final ReactorControl reactorControl;

	public ImprovedTemperatureMonitor(final TemperatureReader reader, final ReactorControl reactorControl)
	{
		this.reactorControl = reactorControl;
		this.reader = reader;
	}
	
	private boolean isTemperatureDiffMoreThan(long degrees)
	{
		boolean firstSensorTriggered = Math.abs(lastReadings.getSensor1Data() - currentReadings.getSensor1Data()) > degrees;
		boolean secondSensorTriggered = Math.abs(lastReadings.getSensor2Data() - currentReadings.getSensor2Data()) > degrees;
		boolean thirdSensorTriggered = Math.abs(lastReadings.getSensor3Data() - currentReadings.getSensor3Data()) > degrees;
		return firstSensorTriggered || secondSensorTriggered || thirdSensorTriggered;
	}
	
	public void readSensor()
	{
		lastReadings = currentReadings;
		currentReadings = reader.getCurrentReadings();
		
		// The first time we do nothing until a second reading is present
		if(lastReadings == null)
		{
			return;
		}
		
		if(isTemperatureDiffMoreThan(20))
		{
			reactorControl.activateAlarm();
		}
		if(isTemperatureDiffMoreThan(50))
		{
			reactorControl.shutdownReactor();
		}
	}

}
