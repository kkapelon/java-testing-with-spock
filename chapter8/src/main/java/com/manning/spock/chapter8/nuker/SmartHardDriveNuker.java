package com.manning.spock.chapter8.nuker;

public class SmartHardDriveNuker extends HardDriveNuker{

	public void activate(CameraFeed cameraFeed)	{
		if( physicalIntrusionDetected(cameraFeed)) {
			deleteHardDriveNow();
		}
	}
	
	
	private boolean physicalIntrusionDetected(CameraFeed cameraFeed) {
		System.out.println("Complex image recognition analysis - real code");
		return true;
	}

}
