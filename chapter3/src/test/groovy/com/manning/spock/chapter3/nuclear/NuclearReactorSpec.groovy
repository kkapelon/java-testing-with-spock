package com.manning.spock.chapter3.nuclear

import spock.lang.*

class NuclearReactorSpec extends spock.lang.Specification{
	
	@Unroll
	def "Complete test of all nuclear scenarios"() {
		given: "a nuclear reactor and sensor data"
		NuclearReactorMonitor nuclearReactorMonitor =new NuclearReactorMonitor()
		
		when: "we examine the sensor data"
		nuclearReactorMonitor.feedFireSensorData(triggeredFireSensors)
		nuclearReactorMonitor.feedRadiationSensorData(radiationSensors)
		NuclearReactorStatus status = nuclearReactorMonitor.getCurrentStatus()

		then: "we act according to safety requirements"
		status.alarmActive == alarmStatus 
		status.shutDownNeeded == shutDownOrder
		
		where:
		triggeredFireSensors |radiationSensors || alarmStatus | shutDownOrder
		0 | [] || false | false 
		1 | [] || true | false
		0 | [110.4f ,0.3f] || true | true
	}
	
	
	
}

