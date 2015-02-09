package com.manning.spock.chapter3.coolant;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

import com.manning.spock.chapter3.coolant2.ImprovedTemperatureMonitor;
import com.manning.spock.chapter3.coolant2.ReactorControl;

public class CoolantSensorTest {

	@Test
	public void temperatureWithinLimits() {
		TemperatureReadings prev = new TemperatureReadings();
		prev.setSensor1Data(20);
		prev.setSensor2Data(40);
		prev.setSensor3Data(80);
		
		TemperatureReadings current = new TemperatureReadings();
		current.setSensor1Data(30);
		current.setSensor2Data(45);
		current.setSensor3Data(73);
		
		TemperatureReader reader = mock(TemperatureReader.class);
		when(reader.getCurrentReadings()).thenReturn(prev,current);
		
		ReactorControl control = mock(ReactorControl.class);
		ImprovedTemperatureMonitor monitor = new ImprovedTemperatureMonitor(reader,control);
		
		monitor.readSensor();
		monitor.readSensor();

		verify(control,times(0)).activateAlarm();
		verify(control,times(0)).shutdownReactor();
	}

	@Test
	public void temperatureOutsideOfLimits() {
		TemperatureReadings prev = new TemperatureReadings();
		prev.setSensor1Data(20);
		prev.setSensor2Data(40);
		prev.setSensor3Data(80);
		
		TemperatureReadings current = new TemperatureReadings();
		current.setSensor1Data(30);
		current.setSensor2Data(10);
		current.setSensor3Data(73);
		
		TemperatureReader reader = mock(TemperatureReader.class);
		when(reader.getCurrentReadings()).thenReturn(prev,current);
		
		ReactorControl control = mock(ReactorControl.class);
		ImprovedTemperatureMonitor monitor = new ImprovedTemperatureMonitor(reader,control);
		
		monitor.readSensor();
		monitor.readSensor();

		verify(control,times(1)).activateAlarm();
		verify(control,times(0)).shutdownReactor();
	}

	@Test
	public void extremeTemperatureChanges() {
		TemperatureReadings prev = new TemperatureReadings();
		prev.setSensor1Data(20);
		prev.setSensor2Data(40);
		prev.setSensor3Data(80);
		
		TemperatureReadings current = new TemperatureReadings();
		current.setSensor1Data(30);
		current.setSensor2Data(10);
		current.setSensor3Data(160);
		
		TemperatureReader reader = mock(TemperatureReader.class);
		when(reader.getCurrentReadings()).thenReturn(prev,current);
		
		ReactorControl control = mock(ReactorControl.class);
		ImprovedTemperatureMonitor monitor = new ImprovedTemperatureMonitor(reader,control);
		
		monitor.readSensor();
		monitor.readSensor();

		verify(control,times(1)).activateAlarm();
		verify(control,times(1)).shutdownReactor();
	}

	

}
