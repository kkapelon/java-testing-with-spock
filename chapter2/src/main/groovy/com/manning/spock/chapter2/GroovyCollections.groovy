package com.manning.spock.chapter2

//Creating a map in Java


Map<String,Integer> wordCounts = new HashMap<>();
wordCounts.put("Hello",1);
wordCounts.put("Java",1);
wordCounts.put("World",2);

//Creating a map in Groovy

Map<String,Integer> wordCounts2 = ["Hello":1,"Groovy":1,"World":2]


//Creating a map with objects
Employee person1 = new Employee(firstName:"Alice",lastName:"Olson",age:30)
Employee person2 = new Employee(firstName:"Jones",lastName:"Corwin",age:45)

Address address1 = new Address(street:"Marley",number:25)
Address address2 = new Address(street:"Barnam",number:7)

Map<Employee,Address> staffAddresses = new HashMap<>();
staffAddresses.put(person1, address1);
staffAddresses.put(person2, address2);

Map<Employee,Address> staffAddresses2 = [(person1):address1,(person2):address2]

assert staffAddresses[person2].street == "Barnam"


List<String> races = Arrays.asList("Drazi", "Minbari", "Humans")

List<String> races2 = ["Drazi", "Minbari", "Humans"]

assert races == races2

String[] racesArray = ["Drazi", "Minbari", "Humans"]

assert racesArray[0] == "Drazi"
assert races[0] == "Drazi"
assert racesArray.size() == races2.size()