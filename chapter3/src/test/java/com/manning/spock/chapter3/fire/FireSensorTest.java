package com.manning.spock.chapter3.fire;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FireSensorTest {

	@Test
	public void everythingIsOk() {
		FireEarlyWarning fireEarlyWarning = new FireEarlyWarning();
		int triggeredSensors = 0;

		fireEarlyWarning.feedData(triggeredSensors);
		WarningStatus status = fireEarlyWarning.getCurrentStatus();

		assertFalse("Expected no alarm", status.isAlarmActive());
		assertFalse("No notifications", status.isFireDepartmentNotified());
	}

	@Test
	public void oneSensorIsTriggered() {
		FireEarlyWarning fireEarlyWarning = new FireEarlyWarning();
		int triggeredSensors = 1;

		fireEarlyWarning.feedData(triggeredSensors);
		WarningStatus status = fireEarlyWarning.getCurrentStatus();

		assertTrue("Alarm sounds", status.isAlarmActive());
		assertFalse("No notifications", status.isFireDepartmentNotified());
	}

	@Test
	public void twoSensorsAreTriggered() {

		FireEarlyWarning fireEarlyWarning = new FireEarlyWarning();
		int triggeredSensors = 2;

		fireEarlyWarning.feedData(triggeredSensors);
		WarningStatus status = fireEarlyWarning.getCurrentStatus();

		assertTrue("Alarm sounds", status.isAlarmActive());
		assertTrue("Fire Department is notified",
				status.isFireDepartmentNotified());
	}

	/**
	 * This unit test has multiple assert phases and actually
	 * tests two scenarios. DO NOT DO this. I show it
	 * as an anti-pattern.
	 */
	@Test
	public void sensorsAreTriggered() {

		FireEarlyWarning fireEarlyWarning = new FireEarlyWarning();

		fireEarlyWarning.feedData(1);
		WarningStatus status = fireEarlyWarning.getCurrentStatus();

		assertTrue("Alarm sounds", status.isAlarmActive());
		assertFalse("No notifications", status.isFireDepartmentNotified());
		fireEarlyWarning.feedData(2);

		WarningStatus status2 = fireEarlyWarning.getCurrentStatus();
		assertTrue("Alarm sounds", status2.isAlarmActive());
		assertTrue("Fire Department is notified",
				status2.isFireDepartmentNotified());
	}

}
