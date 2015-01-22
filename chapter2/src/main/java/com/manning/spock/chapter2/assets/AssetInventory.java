package com.manning.spock.chapter2.assets;

import java.util.ArrayList;
import java.util.List;

public class AssetInventory {
	private List<Ship> ships = new ArrayList<>();

	public List<Ship> getShips() {
		return ships;
	}

	public void setShips(List<Ship> ships) {
		this.ships = ships;
	}
}
