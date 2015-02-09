package com.manning.spock.chapter3.coolant

import spock.lang.*

class CoolantSensorSpec extends spock.lang.Specification{
	
	def "If current temperature difference is within limits everything is ok"() {
		given: "that temperature readings are within limits"
		TemperatureReadings prev = new TemperatureReadings(sensor1Data:20,sensor2Data:40,sensor3Data:80)
		TemperatureReadings current = new TemperatureReadings(sensor1Data:30,sensor2Data:45,sensor3Data:73);
		TemperatureReader reader = Stub(TemperatureReader)
		
		reader.getCurrentReadings() >>> [prev, current]
		
		TemperatureMonitor monitor = new TemperatureMonitor(reader)
		
		when: "we ask the status of temperature control"
		monitor.readSensor()
		monitor.readSensor()

		then: "everything should be ok"
		monitor.isTemperatureNormal()
	}
	
	def "If current temperature difference is more than 20 degrees the alarm should sound"() {
		given: "that temperature readings are not within limits"
		TemperatureReadings prev = new TemperatureReadings(sensor1Data:20,sensor2Data:40,sensor3Data:80)
		TemperatureReadings current = new TemperatureReadings(sensor1Data:30,sensor2Data:10,sensor3Data:73);
		TemperatureReader reader = Stub(TemperatureReader)
		
		reader.getCurrentReadings() >>> [prev,current]
		
		TemperatureMonitor monitor = new TemperatureMonitor(reader)
		
		when: "we ask the status of temperature control"
		monitor.readSensor()
		monitor.readSensor()

		then: "the alarm should sound"
		!monitor.isTemperatureNormal()
	}
	
	
	
	
	
}

