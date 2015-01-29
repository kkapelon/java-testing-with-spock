package com.manning.spock.chapter3.nuclear;

public class NuclearReactorStatus {
	private final boolean alarmActive;
	private final boolean shutDownNeeded;
	private final int evacuationMinutes;
	
	public NuclearReactorStatus(boolean alarmActive,boolean shutDownNeeded, int evacuationMinutes)
	{
		this.alarmActive = alarmActive;
		this.shutDownNeeded = shutDownNeeded;
		this.evacuationMinutes = evacuationMinutes;
	}

	public boolean isAlarmActive() {
		return alarmActive;
	}

	public boolean isShutDownNeeded() {
		return shutDownNeeded;
	}

	public int getEvacuationMinutes() {
		return evacuationMinutes;
	}
	
	
}
