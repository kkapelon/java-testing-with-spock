package com.manning.spock.chapter3.fire

import spock.lang.*

class FireSensor2Spec extends spock.lang.Specification{
	
	def "If all sensors are inactive everything is ok"() {
		given: "that all fire sensors are off"
		FireEarlyWarning2 fireEarlyWarning =new FireEarlyWarning2()
		int triggeredSensors = 0
		int totalSensors = 10
		
		when: "we ask the status of fire control"
		fireEarlyWarning.feedData(triggeredSensors,totalSensors)
		WarningStatus2 status = fireEarlyWarning.getCurrentStatus()

		then: "no alarm/notification should be triggered"
		!status.alarmActive 
		status.fireDepartmentNotified == status.activeSensors > status.totalSensors /2.0 
	}
	
	def "If less than half of sensors are active the alarm should sound as a precaution"() {
		given: "that three fire sensors are active"
		FireEarlyWarning2 fireEarlyWarning =new FireEarlyWarning2()
		int triggeredSensors = 3
		int totalSensors = 10
		
		when: "we ask the status of fire control"
		fireEarlyWarning.feedData(triggeredSensors,totalSensors)
		WarningStatus2 status = fireEarlyWarning.getCurrentStatus()

		then: "only the alarm should be triggered"
		status.alarmActive
		status.fireDepartmentNotified == status.activeSensors > status.totalSensors /2.0
	}
	
	def "If more than half of sensors are active then we have a fire"() {
		given: "that seven fire sensors are active"
		FireEarlyWarning2 fireEarlyWarning =new FireEarlyWarning2()
		int triggeredSensors = 7
		int totalSensors = 10
		
		when: "we ask the status of fire control"
		fireEarlyWarning.feedData(triggeredSensors,totalSensors)
		WarningStatus2 status = fireEarlyWarning.getCurrentStatus()

		then: "alarm is triggered and the fire department is notified"
		status.alarmActive
		status.fireDepartmentNotified == status.activeSensors > status.totalSensors /2.0
	}
	
}

