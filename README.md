# Java Testing with Spock

Current build status: [![Build Status](https://drone.io/github.com/kkapelon/java-testing-with-spock/status.png)](https://drone.io/github.com/kkapelon/java-testing-with-spock/latest)


<img src="http://codepipes.com/book/java-testing-with-spock-meap.jpg" alt="Drawing" width="300" height="375"/>

## Description

This GIT repository contains all source code for the book [Java Testing With Spock](http://manning.com/kapelonis/) published by Manning.
Each chapter is offered as an independent Maven project. 

## Free chapter
You can get an overview of Spock and read a brief discussion on its features in the first
chapter of the book. This chapter is [freely available](http://manning.com/kapelonis/JTwSpock_MEAP_ch1.pdf) in PDF format.

## Requirements
To use the code samples you need the following:
* Java Development Kit version 7+
* Maven installed (**mvn** should be available in the command line)
* Internet access (for fetching library dependencies)


## Usage

You can checkout/run any chapter on its own. You can either [work directly on Github](https://help.github.com/) or
[download the code as a ZIP file](https://github.com/kkapelon/java-testing-with-spock/archive/master.zip) For each chapter entering the command
**mvn test** will compile and run all JUnit/Spock tests. You can also import a chapter (as a Maven project)
in your favourite IDE. To gain syntax highlighting you also need to install Groovy support in your IDE.

## Code listings

### Chapter 1
- [Listing 1.1 Sample Spock test](https://github.com/kkapelon/java-testing-with-spock)  FIXME
- [Listing 1.2 Java class under test](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter1/src/main/java/com/manning/spock/chapter1/Adder.java)
- [Listing 1.2 JUnit test](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter1/src/test/java/com/manning/spock/chapter1/AdderTest.java)
- [Listing 1.3 Spock test for the Adder Java class](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter1/src/test/groovy/com/manning/spock/chapter1/AdderSpec.groovy)
- [Listing 1.4 JUnit test for two Java classes](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter1/src/test/java/com/manning/spock/chapter1/MultiplierTest.java)
- [Listing 1.5 Spock test for two Java classes](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter1/src/test/groovy/com/manning/spock/chapter1/MultiplierSpec.groovy)
- [Listing 1.6 Introducing an artificial bug in the Java class under test](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter1/src/main/java/com/manning/spock/chapter1/Multiplier.java)
- [Listing 1.7 A JUnit test where method names are unrelated to business value](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter1/src/test/java/com/manning/spock/chapter1/BadTest.java)
- [Listing 1.8 A Spock test where methods explain the business requirements](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter1/src/test/groovy/com/manning/spock/chapter1/BetterSpec.groovy)

###Chapter 2
- [Listing 2.1 Groovy class conventions](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter2/src/main/groovy/com/manning/spock/chapter2/Person.groovy)
- [Listing 2.1 Groovy class conventions](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter2/src/main/groovy/com/manning/spock/chapter2/GettersSettersDemo.groovy)
- [Listing 2.2 Groovy field conventions](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter2/src/main/groovy/com/manning/spock/chapter2/GettersSettersDemo2.groovy)
- [Listing 2.3 A complete Groovy script](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter2/src/main/groovy/com/manning/spock/chapter2/GettersSettersDemo3.groovy)
- [Listing 2.4 A Spock test using concise Groovy code](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter2/src/test/groovy/com/manning/spock/chapter2/PersonSpec.groovy)
- [Listing 2.5 Creating and using a Java class from Groovy](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter2/src/main/java/com/manning/spock/chapter2/MilitaryPerson.java)
- [Listing 2.5 Creating and using a Java class from Groovy](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter2/src/test/groovy/com/manning/spock/chapter2/MilitaryPersonSpec.groovy)
- [Listing 2.6 Groovy optional typing in variables](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter2/src/main/groovy/com/manning/spock/chapter2/DefDemo.groovy)
- [Listing 2.7 Groovy optional typing in methods](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter2/src/main/groovy/com/manning/spock/chapter2/DefDemo2.groovy)
- [Listing 2.8 Using dynamic typing in Spock methods](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter2/src/test/groovy/com/manning/spock/chapter2/DefDemoSpec.groovy)
- [Listing 2.9 Groovy can convert everything to a boolean](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter2/src/main/groovy/com/manning/spock/chapter2/GroovyTruth.groovy)
- [Listing 2.10 Groovy truth used in Spock tests](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter2/src/test/groovy/com/manning/spock/chapter2/GroovyTruthSpec.groovy)
- [Listing 2.11 JUnit test with multiple object creation statements](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter2/src/test/java/com/manning/spock/chapter2/ObjectCreationTest.java)
- [Listing 2.12 Spock test with map-based constructors](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter2/src/test/groovy/com/manning/spock/chapter2/ObjectCreationSpec.groovy)
- [Listing 2.13 Groovy versus Java maps](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter2/src/main/groovy/com/manning/spock/chapter2/GroovyCollections.groovy)
- [Listing 2.14 Groovy maps with non-scalar keys and values](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter2/src/main/groovy/com/manning/spock/chapter2/GroovyCollections.groovy)
- [Listing 2.15 Groovy versus Java lists](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter2/src/main/groovy/com/manning/spock/chapter2/GroovyCollections.groovy)
- [Listing 2.16 Creating Groovy lists and maps in test code](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter2/src/test/groovy/com/manning/spock/chapter2/ObjectCreationSpec.groovy)
- [Listing 2.17 Using Groovy lists](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter2/src/main/groovy/com/manning/spock/chapter2/GroovyCollections.groovy)
- [Listing 2.18 Using Groovy maps](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter2/src/main/groovy/com/manning/spock/chapter2/GroovyCollections.groovy)
- [Listing 2.19 Using Groovy String](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter2/src/main/groovy/com/manning/spock/chapter2/GroovyStrings.groovy)
- [Listing 2.20 Using Groovy multiline strings](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter2/src/test/groovy/com/manning/spock/chapter2/GroovyTruthSpec.groovy)
- [Listing 2.21 Reading test data from a file in a Spock test](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter2/src/test/groovy/com/manning/spock/chapter2/GroovyFilesSpec.groovy)
- [Listing 2.22 Reading XML in Groovy](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter2/src/main/groovy/com/manning/spock/chapter2/XmlReading.groovy)
- [Listing 2.23 Reading JSON in Groovy](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter2/src/main/groovy/com/manning/spock/chapter2/JsonReading.groovy)
- [Listing 2.24 Groovy closures](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter2/src/main/groovy/com/manning/spock/chapter2/GroovyClosure.groovy)
- [Listing 2.25 Using Groovy closures in Spock tests](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter2/src/test/groovy/com/manning/spock/chapter2/GroovyClosureSpec.groovy)
- [Listing 2.26 Domain classes in Java](https://github.com/kkapelon/java-testing-with-spock/tree/master/chapter2/src/main/java/com/manning/spock/chapter2/assets)
- [Listing 2.27 Using a Groovy builder for quick object creation](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter2/src/main/groovy/com/manning/spock/chapter2/assets/GraphBuilderDemo.groovy)
- [Listing 2.28 Using Expandos to mock interfaces](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter2/src/test/groovy/com/manning/spock/chapter2/ExpandoDemoSpec.groovy)
- [Listing 2.29 Using a Groovy Expando as test data generator](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter2/src/main/groovy/com/manning/spock/chapter2/ExpandoDemo.groovy)


###Chapter 3
- [Listing 3.1 A fire control system in Java](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter3/src/main/java/com/manning/spock/chapter3/fire/FireEarlyWarning.java) 
- [Listing 3.1 A fire control system in Java](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter3/src/main/java/com/manning/spock/chapter3/fire/WarningStatus.java)  
- [Listing 3.2 A JUnit test for the fire control system](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter3/src/test/java/com/manning/spock/chapter3/fire/FireSensorTest.java)  
- [Listing 3.3 JUnit test with complex structure (real example)](https://github.com/xetorthio/jedis/blob/master/src/test/java/redis/clients/jedis/tests/JedisSentinelTest.java)  
- [Listing 3.4 JUnit test that tests two things - DO NOT DO THIS](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter3/src/test/java/com/manning/spock/chapter3/fire/FireSensorTest.java)  
- [Listing 3.5 The full Spock test for the fire control system](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter3/src/test/groovy/com/manning/spock/chapter3/fire/FireSensorSpec.groovy)  
- [Listing 3.6 Testing the nuclear reactor scenarios with JUnit](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter3/src/test/java/com/manning/spock/chapter3/nuclear/NuclearReactorTest.java)  
- [Listing 3.7 Testing the nuclear reactor scenarios with Spock](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter3/src/test/groovy/com/manning/spock/chapter3/nuclear/NuclearReactorSpec.groovy)  
- [Listing 3.8 Java classes for the temperature monitor and reader](https://github.com/kkapelon/java-testing-with-spock/tree/master/chapter3/src/main/java/com/manning/spock/chapter3/coolant)  
- [Listing 3.9 Stubbing with Spock)](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter3/src/test/groovy/com/manning/spock/chapter3/coolant/CoolantSensorSpec.groovy)  
- [Listing 3.10 Java classes for the temperature monitor, reader and reactor control](https://github.com/kkapelon/java-testing-with-spock/tree/master/chapter3/src/main/java/com/manning/spock/chapter3/coolant2)  
- [Listing 3.11 Mocking and Stubbing with Spock](https://github.com/kkapelon/java-testing-with-spock/tree/master/chapter3/src/test/groovy/com/manning/spock/chapter3/coolant2)  
- [Listing 3.12 Mocking and Stubbing with JUnit and Mockito](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter3/src/test/java/com/manning/spock/chapter3/coolant/CoolantSensorTest.java)  
- [Listing 3.13 Mocking/Stubbing in a Spock parameterized test](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter3/src/test/groovy/com/manning/spock/chapter3/coolant2/ImprovedCoolantSensorSpec.groovy)  

## Issues with the code.

If you find a problem with the code feel free to open an [issue](https://github.com/kkapelon/java-testing-with-spock/issues). If you feel
like contributing you can even create a pull request!

## Issues with the book
If you have comments and suggestions for the book please use the [Manning forum](https://forums.manning.com/forums/java-testing-with-spock).
I monitor it regularly and it is helpful if other readers can see and respond to your comments.

Enjoy!



