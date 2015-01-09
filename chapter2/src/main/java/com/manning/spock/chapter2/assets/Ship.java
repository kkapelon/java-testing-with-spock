package com.manning.spock.chapter2.assets;

import java.util.ArrayList;
import java.util.List;

public class Ship {
	private String name;
	private List<CrewMember> crewMembers = new ArrayList<>();
	private String destination;
	private List<Cargo> cargos= new ArrayList<>();
	

	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<CrewMember> getCrewMembers() {
		return crewMembers;
	}
	public void setCrewMembers(List<CrewMember> crewMembers) {
		this.crewMembers = crewMembers;
	}
	public List<Cargo> getCargos() {
		return cargos;
	}
	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}
	
	
	
	
}
