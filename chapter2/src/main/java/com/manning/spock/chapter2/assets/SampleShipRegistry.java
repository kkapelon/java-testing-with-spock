package com.manning.spock.chapter2.assets;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class SampleShipRegistry {

	public static void main(String[] args) {
		
		
		
		Ship ship1 = new Ship();
		ship1.setName("Sea Spirit");
		ship1.setDestination("Chiba");
		
		CrewMember crew11 = new CrewMember();
		crew11.setFirstName("Michael");
		crew11.setLastName("Curiel");
		crew11.setAge(43);
		
		CrewMember crew12 = new CrewMember();
		crew12.setFirstName("Sean");
		crew12.setLastName("Parker");
		crew12.setAge(28);
		
		CrewMember crew13 = new CrewMember();
		crew13.setFirstName("Lillian");
		crew13.setLastName("Zimmerman");
		crew13.setAge(32);
		
		List<CrewMember> crew1 = Arrays.asList(crew11,crew12,crew13);
		ship1.setCrewMembers(crew1);
		
		CargoOrder order11 = new CargoOrder();
		order11.setBuyer("Rei Hosokawa");
		order11.setCity("Yokohama");
		order11.setPrice(new BigDecimal(34000));
		
		Cargo cargo11 = new Cargo();
		cargo11.setCargoOrder(order11);
		cargo11.setTons(5.4f);
		cargo11.setType("Cotton");
		
		CargoOrder order12 = new CargoOrder();
		order12.setBuyer("Hirokumi Kasaya");
		order12.setCity("Kobe");
		order12.setPrice(new BigDecimal(27000));
		
		Cargo cargo12 = new Cargo();
		cargo12.setCargoOrder(order12);
		cargo12.setTons(3.0f);
		cargo12.setType("Olive Oil");
		
		List<Cargo> cargo1 = Arrays.asList(cargo11,cargo12);
		ship1.setCargos(cargo1);
		
		Ship ship2 = new Ship();
		ship2.setName("Calypso I");
		ship2.setDestination("Bristol");
		
		CrewMember crew21 = new CrewMember();
		crew21.setFirstName("Eric");
		crew21.setLastName("Folkes");
		crew21.setAge(35);
		
		CrewMember crew22 = new CrewMember();
		crew22.setFirstName("Louis");
		crew22.setLastName("Lessard");
		crew22.setAge(22);
		
		List<CrewMember> crew2 = Arrays.asList(crew21,crew22);
		ship2.setCrewMembers(crew2);
		
		CargoOrder order21 = new CargoOrder();
		order21.setBuyer("Gregory Schmidt");
		order21.setCity("Manchester");
		order21.setPrice(new BigDecimal(62000));
		
		Cargo cargo21 = new Cargo();
		cargo21.setCargoOrder(order21);
		cargo21.setTons(2.4f);
		cargo21.setType("Oranges");
		
		List<Cargo> cargo2 = Arrays.asList(cargo21);
		ship2.setCargos(cargo2);
		
		
		Ship ship3 = new Ship();
		ship3.setName("Desert Glory");
		ship3.setDestination("Los Angeles");
		
		CrewMember crew31 = new CrewMember();
		crew31.setFirstName("Michelle");
		crew31.setLastName("Kindred");
		crew31.setAge(38);
		
		CrewMember crew32 = new CrewMember();
		crew32.setFirstName("Kathy");
		crew32.setLastName("Parker");
		crew32.setAge(21);
		
		List<CrewMember> crew3 = Arrays.asList(crew31,crew32);
		ship3.setCrewMembers(crew3);
		
		CargoOrder order31 = new CargoOrder();
		order31.setBuyer("Carolyn Cox");
		order31.setCity("Sacramento");
		order31.setPrice(new BigDecimal(18000));
		
		Cargo cargo31 = new Cargo();
		cargo31.setCargoOrder(order31);
		cargo31.setTons(4.8f);
		cargo31.setType("Timber");
		
		List<Cargo> cargo3 = Arrays.asList(cargo31);
		ship3.setCargos(cargo3);
		
		List<Ship> ships = Arrays.asList(ship1, ship2, ship3);
		
		AssetInventory shipRegistry = new AssetInventory();
		shipRegistry.setShips(ships);
		
		System.out.println(shipRegistry.getShips().size()); 
		System.out.println(shipRegistry.getShips().get(0).getName());
		System.out.println( shipRegistry.getShips().get(1).getCrewMembers().size());
		System.out.println( shipRegistry.getShips().get(1).getCrewMembers().get(0).getFirstName());
		System.out.println( shipRegistry.getShips().get(2).getCargos().get(0).getType());
		System.out.println(shipRegistry.getShips().get(2).getCargos().get(0).getCargoOrder().getCity());
	}
}
