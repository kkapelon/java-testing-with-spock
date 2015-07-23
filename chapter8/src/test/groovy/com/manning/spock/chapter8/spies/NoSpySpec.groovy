package com.manning.spock.chapter8.spies

import javax.imageio.ImageIO

import spock.lang.*

import com.manning.spock.chapter8.nuker.CameraFeed
import com.manning.spock.chapter8.nuker.HardDriveNuker
import com.manning.spock.chapter8.nuker2.SmartHardDriveNuker

@Subject(SmartHardDriveNuker.class)
class NoSpySpec extends spock.lang.Specification{

	def "automatic deletion of hard disk when agents are here"() {
		given: "a camera feed and a fake nuker"
		CameraFeed cameraFeed = new CameraFeed()
		HardDriveNuker nuker = Mock(HardDriveNuker)
		
		and: "the auto-nuker program"
		SmartHardDriveNuker smartNuker = new SmartHardDriveNuker(nuker)
		
		when:"agents are knocking the door"
		cameraFeed.setCurrentFrame(ImageIO.read(getClass().getResourceAsStream("agents.jpg")))
		smartNuker.activate(cameraFeed);

		then: "all files of hard drive should be deleted"
		1 * nuker.deleteHardDriveNow() 
	}
	
	
	
}

