package com.manning.spock.chapter3.fire;

public class WarningStatus2 {
	private final boolean alarmActive;
	private final boolean fireDepartmentNotified;
	private final int activeSensors;
	private final int totalSensors;
	
	public WarningStatus2(boolean alarmActive,boolean fireDepartmentNotified,int active,int total)
	{
		this.alarmActive = alarmActive;
		this.fireDepartmentNotified = fireDepartmentNotified;
		this.activeSensors = active;
		this.totalSensors = total;
	}
	
	public boolean isAlarmActive() {
		return alarmActive;
	}

	public boolean isFireDepartmentNotified() {
		return fireDepartmentNotified;
	}

	public int getActiveSensors() {
		return activeSensors;
	}

	public int getTotalSensors() {
		return totalSensors;
	}
	
	

	

	
}
