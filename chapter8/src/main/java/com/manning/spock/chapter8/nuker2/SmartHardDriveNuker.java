package com.manning.spock.chapter8.nuker2;

import com.manning.spock.chapter8.nuker.CameraFeed;
import com.manning.spock.chapter8.nuker.HardDriveNuker;

public class SmartHardDriveNuker{
	
	private final HardDriveNuker hardDriveNuker;
	
	public SmartHardDriveNuker(final HardDriveNuker hardDriveNuker)	{
		this.hardDriveNuker = hardDriveNuker;
	}

	public void activate(CameraFeed cameraFeed)	{
		if( physicalIntrusionDetected(cameraFeed))
		{
			hardDriveNuker.deleteHardDriveNow();
		}
	}
	
	
	private boolean physicalIntrusionDetected(CameraFeed cameraFeed) {
		System.out.println("Complex image recognition analysis - real code");
		return true;
	}

}
