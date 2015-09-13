package com.manning.spock.chapter8.spies

import javax.imageio.ImageIO

import spock.lang.*

import com.manning.spock.chapter8.nuker.CameraFeed
import com.manning.spock.chapter8.nuker.SmartHardDriveNuker

@Subject(SmartHardDriveNuker.class)
class SimpleSpySpec extends spock.lang.Specification{

	def "automatic deletion of hard disk when agents are here"() {
		given: "a camera feed"
		CameraFeed cameraFeed = new CameraFeed()
		
		and: "the auto-nuker program"
		SmartHardDriveNuker nuker = Spy(SmartHardDriveNuker)
		nuker.deleteHardDriveNow() >> {println "Hard disk is cleared"}
		
		when:"agents are knocking the door"
		cameraFeed.setCurrentFrame(ImageIO.read(getClass().getResourceAsStream("agents.jpg")))
		nuker.activate(cameraFeed);

		then: "all files of hard drive should be deleted"
		1 * nuker.deleteHardDriveNow() 
	}
	
	
	
}

