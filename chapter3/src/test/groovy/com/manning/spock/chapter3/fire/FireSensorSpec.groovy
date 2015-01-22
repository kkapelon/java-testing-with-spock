package com.manning.spock.chapter3.fire

import spock.lang.*

class FireSensorSpec extends spock.lang.Specification{
	
	def "If all sensors are inactive everything is ok"() {
		given: "that all fire sensors are off"
		FireEarlyWarning fireEarlyWarning =new FireEarlyWarning()
		int triggeredSensors = 0
		
		when: "we ask the status of fire control"
		fireEarlyWarning.feedData(triggeredSensors)

		then: "no alarm/notification should be triggered"
		WarningStatus status = fireEarlyWarning.getCurrentStatus()
		!status.alarmActive 
		!status.fireDepartmentNotified
	}
	
	def "If one sensor is active the alarm should sound as a precaution"() {
		given: "that only fire sensor is active"
		FireEarlyWarning fireEarlyWarning =new FireEarlyWarning()
		int triggeredSensors = 1
		
		when: "we ask the status of fire control"
		fireEarlyWarning.feedData(triggeredSensors)

		then: "only the alarm should be triggered"
		WarningStatus status = fireEarlyWarning.getCurrentStatus()
		status.alarmActive
		!status.fireDepartmentNotified
	}
	
	def "If more than one sensors are active then we have a fire"() {
		given: "that two fire sensors is active"
		FireEarlyWarning fireEarlyWarning =new FireEarlyWarning()
		int triggeredSensors = 2
		
		when: "we ask the status of fire control"
		fireEarlyWarning.feedData(triggeredSensors)

		then: "alarm is triggered and the fire department is notified"
		WarningStatus status = fireEarlyWarning.getCurrentStatus()
		status.alarmActive
		status.fireDepartmentNotified
	}
	
}

