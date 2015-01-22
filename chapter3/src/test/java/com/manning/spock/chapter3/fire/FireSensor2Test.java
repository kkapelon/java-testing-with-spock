package com.manning.spock.chapter3.fire;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FireSensor2Test {

	@Test
	public void everythingIsOk() {
		FireEarlyWarning2 fireEarlyWarning = new FireEarlyWarning2();
		int triggeredSensors = 0;
		int totalSensors = 10;

		fireEarlyWarning.feedData(triggeredSensors, totalSensors);
		WarningStatus2 status = fireEarlyWarning.getCurrentStatus();

		assertFalse("Expected no alarm", status.isAlarmActive());
		assertEquals("Notify if more than half sensors are active",
				status.isFireDepartmentNotified(),
				status.getActiveSensors() > status.getTotalSensors() / 2.0);
	}

	@Test
	public void threeSensorsAreTriggered() {
		FireEarlyWarning2 fireEarlyWarning = new FireEarlyWarning2();
		int triggeredSensors = 3;
		int totalSensors = 10;

		fireEarlyWarning.feedData(triggeredSensors, totalSensors);
		WarningStatus2 status = fireEarlyWarning.getCurrentStatus();

		assertTrue("Alarm sounds", status.isAlarmActive());
		assertEquals("Notify if more than half sensors are active",
				status.isFireDepartmentNotified(),
				status.getActiveSensors() > status.getTotalSensors() / 2.0);
	}

	@Test
	public void sevenSensorsAreTriggered() {

		FireEarlyWarning2 fireEarlyWarning = new FireEarlyWarning2();
		int triggeredSensors = 7;
		int totalSensors = 10;

		fireEarlyWarning.feedData(triggeredSensors, totalSensors);
		WarningStatus2 status = fireEarlyWarning.getCurrentStatus();

		assertTrue("Alarm sounds", status.isAlarmActive());
		assertEquals("Notify if more than half sensors are active",
				status.isFireDepartmentNotified(),
				status.getActiveSensors() > status.getTotalSensors() / 2.0);
	}

	

}
