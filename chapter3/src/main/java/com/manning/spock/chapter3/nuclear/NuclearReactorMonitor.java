package com.manning.spock.chapter3.nuclear;

import java.util.ArrayList;
import java.util.List;

public class NuclearReactorMonitor {
	private int triggeredFireSensors = 0;
	private List<Float> radiationStatus = new ArrayList<>();
	private boolean coolantActive = true;
	private int currentPressure = 150;
	
 	public void feedFireSensorData(int triggeredFireSensors)
	{
 		this.triggeredFireSensors = triggeredFireSensors;
	}
	
	public void feedRadiationSensorData(List<Float> radiationStatus)
	{
		this.radiationStatus = radiationStatus;
	}
	
	public void feedCoolantStatus(boolean coolantActive)
	{
		this.coolantActive = coolantActive;
	}
	
	public void feedPressureInBar(int bar)
	{
		this.currentPressure = bar;
	}
	
	public NuclearReactorStatus getCurrentStatus()
	{
		boolean radiationPresent = false;
		for(Float radiationMeter:radiationStatus)
		{
			if(radiationMeter > 100)
			{
				radiationPresent = true;
				break;
			}
		}
		boolean alarmStatus = (triggeredFireSensors ==1) || !coolantActive | currentPressure > 150 || radiationPresent;
		boolean shutDownNeeded = (currentPressure> 160) || radiationPresent || (triggeredFireSensors >2 );
		int evacuationMinutes = 0;
		if(radiationPresent)
		{
			evacuationMinutes =1;
		}
		else if(currentPressure > 160)
		{
			evacuationMinutes = 3;
		}
		else if(!coolantActive)
		{
			evacuationMinutes = 15;
		}
		
		
		return new NuclearReactorStatus(alarmStatus, shutDownNeeded, evacuationMinutes);
	}
}
