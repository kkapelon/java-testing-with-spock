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
		nuclearReactorMonitor.feedPressureInBar(pressure)
		NuclearReactorStatus status = nuclearReactorMonitor.getCurrentStatus()

		then: "we act according to safety requirements"
		status.alarmActive == alarmStatus 
		status.shutDownNeeded == shutDownOrder
		status.evacuationMinutes == minutesToEvacuation
		
		where:
		pressure | triggeredFireSensors | radiationSensors || alarmStatus | shutDownOrder | minutesToEvacuation
		150| 0 | [] || false | false | -1
		150| 1 | [] || true | false | -1
		150| 3 | [] || true | true | -1
		150| 0 | [110.4f ,0.3f, 0.0f] || true | true | 1
		150| 0 | [45.3f ,10.3f, 47.7f] || false | false | -1
		155| 0 | [0.0f ,0.0f, 0.0f] || true | false | -1
		170| 0 | [0.0f ,0.0f, 0.0f] || true | true | 3
	}
	
	
	
}

