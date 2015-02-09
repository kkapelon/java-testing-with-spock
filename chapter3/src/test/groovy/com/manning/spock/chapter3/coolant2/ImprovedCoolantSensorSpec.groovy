package com.manning.spock.chapter3.coolant2

import spock.lang.*

import com.manning.spock.chapter3.coolant.TemperatureMonitor
import com.manning.spock.chapter3.coolant.TemperatureReader
import com.manning.spock.chapter3.coolant.TemperatureReadings

class ImprovedCoolantSensorSpec extends spock.lang.Specification{
	
	def "If current temperature difference is within limits everything is ok"() {
		given: "that temperature readings are within limits"
		TemperatureReadings prev = new TemperatureReadings(sensor1Data:20,sensor2Data:40,sensor3Data:80)
		TemperatureReadings current = new TemperatureReadings(sensor1Data:30,sensor2Data:45,sensor3Data:73);
		TemperatureReader reader = Stub(TemperatureReader)
		
		reader.getCurrentReadings() >>> [prev, current]
		
		ReactorControl control = Mock(ReactorControl)
		ImprovedTemperatureMonitor monitor = new ImprovedTemperatureMonitor(reader,control)
		
		when: "we ask the status of temperature control"
		monitor.readSensor()
		monitor.readSensor()

		then: "everything should be ok"
		0 * control.shutdownReactor()
		0 * control.activateAlarm()
	}
	
	def "If current temperature difference is more than 20 degrees the alarm sounds"() {
		given: "that temperature readings are not within limits"
		TemperatureReadings prev = new TemperatureReadings(sensor1Data:20,sensor2Data:40,sensor3Data:80)
		TemperatureReadings current = new TemperatureReadings(sensor1Data:30,sensor2Data:10,sensor3Data:73);
		TemperatureReader reader = Stub(TemperatureReader)
		
		reader.getCurrentReadings() >>> [prev,current]
		
		ReactorControl control = Mock(ReactorControl)
		ImprovedTemperatureMonitor monitor = new ImprovedTemperatureMonitor(reader,control)
		
		when: "we ask the status of temperature control"
		monitor.readSensor()
		monitor.readSensor()

		then: "the alarm should sound"
		0 * control.shutdownReactor()
		1 * control.activateAlarm()
	}
	
	def "If current temperature difference is more than 50 degrees the reactor shuts down"() {
		given: "that temperature readings are not within limits"
		TemperatureReadings prev = new TemperatureReadings(sensor1Data:20,sensor2Data:40,sensor3Data:80)
		TemperatureReadings current = new TemperatureReadings(sensor1Data:30,sensor2Data:10,sensor3Data:160);
		TemperatureReader reader = Stub(TemperatureReader)
		
		reader.getCurrentReadings() >>> [prev,current]
		
		ReactorControl control = Mock(ReactorControl)
		ImprovedTemperatureMonitor monitor = new ImprovedTemperatureMonitor(reader,control)
		
		when: "we ask the status of temperature control"
		monitor.readSensor()
		monitor.readSensor()

		then: "the alarm should sound and the reactor should shut down"
		1 * control.shutdownReactor()
		1 * control.activateAlarm()
	}
	
	
	
	
	
}

