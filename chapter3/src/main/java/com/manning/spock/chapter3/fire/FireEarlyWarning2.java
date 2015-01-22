package com.manning.spock.chapter3.fire;

public class FireEarlyWarning2 {
	
	private int sensorsDetectingFire = 0;
	private int totalSensors=0;

	public void feedData(int triggeredFireSensors, int allSensors)
	{
		sensorsDetectingFire = triggeredFireSensors;
		totalSensors = allSensors;
	}
	
	public WarningStatus2 getCurrentStatus()
	{
		return new WarningStatus2(sensorsDetectingFire>0,
				sensorsDetectingFire > totalSensors/ 2.0,sensorsDetectingFire,totalSensors);
	}
}
