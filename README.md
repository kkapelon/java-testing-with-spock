# Java Testing with Spock

Current build status: [![Build Status](https://semaphoreci.com/api/v1/codepipes/java-testing-with-spock/branches/master/badge.svg)](https://semaphoreci.com/codepipes/java-testing-with-spock)


<img src="http://codepipes.com/book/java-testing-with-spock-book.jpg" alt="Java Testing with book cover" width="297" height="375"/>

## Description

This GIT repository contains all source code for the book [Java Testing With Spock](https://www.manning.com/books/java-testing-with-spock) published by Manning.
Each chapter is offered as an independent Maven project. 

## Free chapter 1 - (intro to testing)
You can get an overview of Spock and read a brief discussion on its features in the first
chapter of the book. This chapter is [freely available](https://manning-content.s3.amazonaws.com/download/e/82672af-9245-44a7-9542-a9855972700c/SampleChapter-01.pdf) in PDF format.

## Free chapter 3 - (comparison with JUnit)
The book contains a comparison of JUnit and Spock using semi-real world code examples. If you are a die-hard JUnit believer, you will find this part of the book very interesting. This chapter is also [freely available](https://manning-content.s3.amazonaws.com/download/3/d90f946-9baf-46eb-859c-fb7a56608320/SampleChapter-03.pdf) in PDF format.

## Requirements
To use the code samples you need the following:
* Java Development Kit version 7+
* Maven installed (**mvn** should be available in the command line)
* Internet access (for fetching library dependencies)


## Usage

You can checkout/run any chapter on its own. You can either [work directly on Github](https://help.github.com/) or
[download the code as a ZIP file](https://github.com/kkapelon/java-testing-with-spock/archive/master.zip) For each chapter entering the command
**mvn test** will compile and run all JUnit/Spock tests. 

## IDE support
Each chapter is self-contained. There is no super POM file. This repository is NOT a multimodule project.
If you use Eclipse just import any chapter as a Maven project. If you use IntelliJ make sure that
you import each chapter on its own project (and not as modules in a single project).
To gain syntax highlighting you also need to install Groovy support in your IDE. This is optional
because the build is fully automated via Maven.

## Gradle Support
There are also build.gradle files along side each maven pom.xml file in each chapter if you would like to see what an analogous gradle build file looks like. You also do not have to download and install Gradle either as the gradle wrapper files are also included in this repository. Simply type **./gradlew clean test** at the project root and Gradle will build the project and run the tests. 

You can also import the build.gradle files into Eclipse if you have the [Gradle Buildship plugin](https://gradle.org/eclipse/) installed. If you are using Intellij IDEA, you can also import each chapter on its own similar to how Maven projects are imported. The idea and eclipse plugins are also configured in each build.gradle file if you want to generate the metadata files for Eclipse and IDEA projects. 

Note that Gradle support was contributed by [Mike Smithson] (https://github.com/mikesmithson) and is considered a bonus feature. I will provide no support for Gradle and any related issues, i.e., **you are on your own**.

## Code listings

### Chapter 1
- [Listing 1.1 Sample Spock test](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter1/src/test/groovy/com/manning/spock/chapter1/invoice/InvoiceMailingSpec.groovy)  
- [Listing 1.2 Java class under test](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter1/src/main/java/com/manning/spock/chapter1/Adder.java)
- [Listing 1.2 JUnit test](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter1/src/test/java/com/manning/spock/chapter1/AdderTest.java)
- [Listing 1.3 Spock test for the Adder Java class](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter1/src/test/groovy/com/manning/spock/chapter1/AdderSpec.groovy)
- [Listing 1.4 JUnit test for two Java classes](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter1/src/test/java/com/manning/spock/chapter1/MultiplierTest.java)
- [Listing 1.5 Spock test for two Java classes](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter1/src/test/groovy/com/manning/spock/chapter1/MultiplierSpec.groovy)
- [Listing 1.6 Introducing an artificial bug in the Java class under test](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter1/src/main/java/com/manning/spock/chapter1/Multiplier.java)
- [Listing 1.7 A JUnit test where method names are unrelated to business value](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter1/src/test/java/com/manning/spock/chapter1/BadTest.java)
- [Listing 1.8 A Spock test where methods explain the business requirements](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter1/src/test/groovy/com/manning/spock/chapter1/BetterSpec.groovy)

### Chapter 2
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
- [Bonus listing -  Complex object creation in Java](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter2/src/main/java/com/manning/spock/chapter2/assets/SampleShipRegistry.java)
- [Listing 2.28 Using Expandos to mock interfaces](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter2/src/test/groovy/com/manning/spock/chapter2/ExpandoDemoSpec.groovy)
- [Listing 2.29 Using a Groovy Expando as test data generator](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter2/src/main/groovy/com/manning/spock/chapter2/ExpandoDemo.groovy)


### Chapter 3
- [Listing 3.1 A fire control system in Java](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter3/src/main/java/com/manning/spock/chapter3/fire/FireEarlyWarning.java) 
- [Listing 3.1 A fire control system in Java](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter3/src/main/java/com/manning/spock/chapter3/fire/WarningStatus.java)  
- [Listing 3.2 A JUnit test for the fire control system](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter3/src/test/java/com/manning/spock/chapter3/fire/FireSensorTest.java)  
- [Listing 3.3 JUnit test with complex structure (real example)](https://github.com/xetorthio/jedis/blob/master/src/test/java/redis/clients/jedis/tests/JedisSentinelTest.java)  
- [Listing 3.4 JUnit test that tests two things - DO NOT DO THIS](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter3/src/test/java/com/manning/spock/chapter3/fire/FireSensorTest.java)  
- [Listing 3.5 The full Spock test for the fire control system](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter3/src/test/groovy/com/manning/spock/chapter3/fire/FireSensorSpec.groovy)  
- [Listing 3.6 Testing the nuclear reactor scenarios with JUnit](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter3/src/test/java/com/manning/spock/chapter3/nuclear/NuclearReactorTest.java)  
- [Listing 3.7 Testing the nuclear reactor scenarios with Spock](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter3/src/test/groovy/com/manning/spock/chapter3/nuclear/NuclearReactorSpec.groovy)  
- [Listing 3.8 Java classes for the temperature monitor and reader](https://github.com/kkapelon/java-testing-with-spock/tree/master/chapter3/src/main/java/com/manning/spock/chapter3/coolant)  
- [Listing 3.9 Stubbing with Spock](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter3/src/test/groovy/com/manning/spock/chapter3/coolant/CoolantSensorSpec.groovy)  
- [Listing 3.10 Java classes for the temperature monitor, reader and reactor control](https://github.com/kkapelon/java-testing-with-spock/tree/master/chapter3/src/main/java/com/manning/spock/chapter3/coolant2)  
- [Listing 3.11 Mocking and Stubbing with Spock](https://github.com/kkapelon/java-testing-with-spock/tree/master/chapter3/src/test/groovy/com/manning/spock/chapter3/coolant2)  
- [Bonus Listing -  Mocking and Stubbing with JUnit and Mockito](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter3/src/test/java/com/manning/spock/chapter3/coolant/CoolantSensorTest.java)  
- [Listing 3.12 Mocking/Stubbing in a Spock parameterized test](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter3/src/test/groovy/com/manning/spock/chapter3/coolant2/ImprovedCoolantSensorSpec.groovy)  

### Chapter 4
- [Listing 4.1 Spock blocks inside a test method](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter4/src/test/groovy/com/manning/spock/chapter4/blocks/BasicBlocksSpec.groovy) 
- [Listing 4.2 Java skeleton for an electronic basket](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter4/src/main/java/com/manning/spock/chapter4/Basket.java)  
- [Listing 4.2 Java skeleton for an electronic basket](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter4/src/main/java/com/manning/spock/chapter4/Product.java)  
- [Listing 4.3 The given-when-then triad](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter4/src/test/groovy/com/manning/spock/chapter4/blocks/BasketWeightSpec.groovy)  
- [Listing 4.4 Using the setup alias](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter4/src/test/groovy/com/manning/spock/chapter4/blocks/SetupBlockSpec.groovy)  
- [Listing 4.5 A non-trivial when: block - DO NOT DO THIS](https://github.com/rusperstinsky/puntov/blob/master/core/src/test/groovy/mx/lux/pos/model/ArticuloSunglassDescriptorTest.groovy)  
- [Listing 4.6 Descriptive when: blocks](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter4/src/test/groovy/com/manning/spock/chapter4/blocks/BasketWeightSpec.groovy)  
- [Listing 4.7 Invalid then: block](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter4/src/test/groovy/com/manning/spock/chapter4/blocks/BasketWeightSpec.groovy)  
- [Listing 4.8 - Using and: to split the given: block](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter4/src/test/groovy/com/manning/spock/chapter4/blocks/AndBlockSpec.groovy)  
- [Listing 4.9  Using and: to split the when: block](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter4/src/test/groovy/com/manning/spock/chapter4/blocks/AndBlockSpec.groovy)  
- [Listing 4.10  Using and: as an extension to a then: block](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter4/src/test/groovy/com/manning/spock/chapter4/blocks/AndBlockSpec.groovy)  
- [Listing 4.11 Trivial tests with the expect: block](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter4/src/test/groovy/com/manning/spock/chapter4/blocks/ExpectBlockSpec.groovy)  
- [Listing 4.12 Expect block replaces when: and then:](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter4/src/test/groovy/com/manning/spock/chapter4/blocks/ExpectBlockSpec.groovy)  
- [Listing 4.13 Using expect: for pre-conditions](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter4/src/test/groovy/com/manning/spock/chapter4/blocks/ExpectBlockSpec.groovy) 
- [Listing 4.14 Using cleanup: to release resources even if test fails](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter4/src/test/groovy/com/manning/spock/chapter4/blocks/CleanupBlockSpec.groovy) 
- [Listing 4.15 test method describes exactly what is being tested.](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter4/src/test/groovy/com/manning/spock/chapter4/blocks/BasketWeightSpec.groovy) 
- [Listing 4.16 Marking the class under test](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter4/src/test/groovy/com/manning/spock/chapter4/specification/BasketWeightSpec.groovy) 
- [Listing 4.17 Writing a Spock specification](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter4/src/test/groovy/com/manning/spock/chapter4/specification/BasketWeightSpec.groovy) 
- [Listing 4.18 Writing a full Spock specification](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter4/src/test/groovy/com/manning/spock/chapter4/specification/BasketWeightDetailedSpec.groovy) 
- [Listing 4.19 Extracting common initialization code](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter4/src/test/groovy/com/manning/spock/chapter4/lifecycle/CommonSetupSpec.groovy) 
- [Listing 4.20 Extracting common pre/post conditions](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter4/src/test/groovy/com/manning/spock/chapter4/lifecycle/CommonCleanupSpec.groovy) 
- [Listing 4.21 All Spock lifecycle methods](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter4/src/test/groovy/com/manning/spock/chapter4/lifecycle/LifecycleSpec.groovy) 
- [Listing 4.22 Using the @Shared annotation](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter4/src/test/groovy/com/manning/spock/chapter4/lifecycle/SharedSpec.groovy) 
- [Listing 4.23 Asserting with the old() method](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter4/src/test/groovy/com/manning/spock/chapter4/lifecycle/OldMethodSpec.groovy) 
- [Listing 4.24 Multiple when-then blocks](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter4/src/test/groovy/com/manning/spock/chapter4/structure/DoubleThenSpec.groovy) 
- [Listing 4.25 Missing block descriptions - DO NOT DO THIS ](https://github.com/rusperstinsky/puntov/blob/master/core/src/test/groovy/mx/lux/pos/util/FileFilterTest.groovy) 
- [Listing 4.26 Adding a product twice in the basket](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter4/src/test/groovy/com/manning/spock/chapter4/structure/FailureRenderingSpec.groovy) 
- [Listing 4.27 Helping failure rendering in the toString() method](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter4/src/main/java/com/manning/spock/chapter4/structure/ProblematicBasket.java) 
- [Listing 4.28 Spock support for Hamcrest matchers](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter4/src/test/groovy/com/manning/spock/chapter4/structure/HamcrestMatchersSpec.groovy) 
- [Listing 4.29 Alternative Spock support for Hamcrest matchers](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter4/src/test/groovy/com/manning/spock/chapter4/structure/HamcrestMatchersSpec.groovy) 
- [Listing 4.30 Using Groovy closures in Spock assertions](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter4/src/test/groovy/com/manning/spock/chapter4/structure/HamcrestMatchersSpec.groovy) 
- [Listing 4.31 An imaginary  warehouse](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter4/src/main/java/com/manning/spock/chapter4/structure/WarehouseInventory.java) 
- [Listing 4.32 An enterprisy basket ](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter4/src/main/java/com/manning/spock/chapter4/structure/EnterprisyBasket.java) 
- [Listing 4.33 Assertions and setup on the same object ](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter4/src/test/groovy/com/manning/spock/chapter4/structure/GroupingAssertionsSpec.groovy) 
- [Listing 4.34 Grouping similar code with Groovy and Spock ](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter4/src/test/groovy/com/manning/spock/chapter4/structure/GroupingAssertionsSpec.groovy) 


### Chapter 5
- [Listing 5.1 Duplicate tests - DO NOT DO THIS](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter5/src/test/groovy/com/manning/spock/chapter5/intro/NaiveImageNameValidatorSpec.groovy) 
- [Listing 5.2 Simple Spock parameterized test](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter5/src/test/groovy/com/manning/spock/chapter5/intro/ImageNameValidatorSpec.groovy) 
- [Listing 5.3 The given-when-then-where structure](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter5/src/test/groovy/com/manning/spock/chapter5/intro/ImageNameValidatorSpec.groovy) 
- [Listing 5.4 Using data tables in Spock](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter5/src/test/groovy/com/manning/spock/chapter5/tables/SimpleTabularSpec.groovy) 
- [Listing 5.5 Using data tables in Spock with typed parameters](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter5/src/test/groovy/com/manning/spock/chapter5/tables/SimpleTabularSpec.groovy) 
- [Listing 5.6 Data tables with one column](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter5/src/test/groovy/com/manning/spock/chapter5/tables/SingleColumnSpec.groovy) 
- [Listing 5.7 Capturing business needs in data tables](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter5/src/test/groovy/com/manning/spock/chapter5/discount/DiscountSpec.groovy) 
- [Listing 5.8 Lifecycle of parameterized tests](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter5/src/test/groovy/com/manning/spock/chapter5/tables/LifecycleDataSpec.groovy) 
- [Listing 5.9 Unrolling parameterized scenarios](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter5/src/test/groovy/com/manning/spock/chapter5/tables/UnrollDataSpec.groovy) 
- [Listing 5.10 Printing parameters of each scenario](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter5/src/test/groovy/com/manning/spock/chapter5/tables/UnrollDataSpec.groovy) 
- [Listing 5.11 Parameter rendering on the test method](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter5/src/test/groovy/com/manning/spock/chapter5/tables/UnrollDataSpec.groovy) 
- [Listing 5.12 Custom expressions in data tables](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter5/src/test/groovy/com/manning/spock/chapter5/expressions/ExpressionInTableSpec.groovy) 
- [Listing 5.13 Trivial example of data pipes](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter5/src/test/groovy/com/manning/spock/chapter5/pipes/BasicPipesSpec.groovy) 
- [Listing 5.14 Using Groovy ranges as data generators](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter5/src/test/groovy/com/manning/spock/chapter5/pipes/BasicPipesSpec.groovy) 
- [Listing 5.15 Using Groovy combinations](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter5/src/test/groovy/com/manning/spock/chapter5/pipes/BasicPipesSpec.groovy) 
- [Listing 5.16 Constant parameters in Spock tests](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter5/src/test/groovy/com/manning/spock/chapter5/pipes/DerivedValuesSpec.groovy) 
- [Listing 5.17 Derived parameters in Spock tests](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter5/src/test/groovy/com/manning/spock/chapter5/pipes/DerivedValuesSpec.groovy) 
- [Data file validImageNames.txt](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter5/src/test/resources/validImageNames.txt) 
- [Listing 5.18 Using existing data generators](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter5/src/test/groovy/com/manning/spock/chapter5/pipes/FileReadingSpec.groovy) 
- [Data file invalidImageNames.txt](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter5/src/test/resources/invalidImageNames.txt) 
- [Listing 5.19 Java iterator that processes invalidImageNames.txt](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter5/src/test/java/com/manning/spock/chapter5/custom/InvalidNamesGen.java) 
- [Listing 5.20 Using Java iterators in Spock](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter5/src/test/groovy/com/manning/spock/chapter5/custom/DataIteratorsSpec.groovy) 
- [Data file imageNames.txt](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter5/src/test/resources/imageNames.txt) 
- [Listing 5.21 Java multi-valued iterator](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter5/src/test/java/com/manning/spock/chapter5/custom/MultiVarReader.java) 
- [Listing 5.22 Using multi-valued iterators in Spock](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter5/src/test/groovy/com/manning/spock/chapter5/custom/MultipleVarGenSpec.groovy) 
- [Listing 5.23 Using multi-valued assignments in Spock](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter5/src/test/groovy/com/manning/spock/chapter5/custom/MultipleVarGenSpec.groovy) 

### Chapter 6
- [Listing 6.1 Java skeleton code for the eshop](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter6/src/main/java/com/manning/spock/chapter6/Product.java) 
- [Listing 6.1 Java skeleton code for the eshop](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter6/src/main/java/com/manning/spock/chapter6/stubs/WarehouseInventory.java) 
- [Listing 6.1 Java skeleton code for the eshop](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter6/src/main/java/com/manning/spock/chapter6/Basket.java) 
- [Listing 6.2  Creating a Simple Stub with Spock](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter6/src/test/groovy/com/manning/spock/chapter6/stubs/SimpleStubbingSpec.groovy) 
- [Listing 6.3 Stubbing specific arguments](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter6/src/test/groovy/com/manning/spock/chapter6/stubs/SimpleStubbingSpec.groovy) 
- [Listing 6.4 Argument based stub differentiation](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter6/src/test/groovy/com/manning/spock/chapter6/stubs/SimpleStubbingSpec.groovy) 
- [Listing 6.5 Grouping all stubbed methods](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter6/src/test/groovy/com/manning/spock/chapter6/stubs/SimpleStubbingSpec.groovy) 
- [Listing 6.6 Using argument matchers in stubs](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter6/src/test/groovy/com/manning/spock/chapter6/stubs/ArgumentStubbingSpec.groovy) 
- [Listing 6.7 Ignoring all arguments of a stubbed method when returning a response](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter6/src/test/groovy/com/manning/spock/chapter6/stubs/ArgumentStubbingSpec.groovy) 
- [Listing 6.8 Stubbing subsequent method calls](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter6/src/test/groovy/com/manning/spock/chapter6/stubs/SequenceStubbingSpec.groovy) 
- [Listing 6.9 Instructing stubs to throw exceptions](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter6/src/test/groovy/com/manning/spock/chapter6/stubs/ExceptionStubbingSpec.groovy) 
- [Listing 6.10 Stubs that respond according to arguments](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter6/src/test/groovy/com/manning/spock/chapter6/stubs/DynamicStubbingSpec.groovy) 
- [Listing 6.11 A smart stub that looks at both its arguments](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter6/src/test/groovy/com/manning/spock/chapter6/stubs/DynamicStubbingSpec.groovy) 
- [Listing 6.12 Stubbing responses with other stubs](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter6/src/test/groovy/com/manning/spock/chapter6/stubs/StubsInStubsSpec.groovy) 
- [Listing 6.13  Mocks can be stubbed too](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter6/src/test/groovy/com/manning/spock/chapter6/mocks/SimpleMockingSpec.groovy) 
- [Listing 6.14 Java skeleton for credit card charging](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter6/src/main/java/com/manning/spock/chapter6/mocks/Customer.java) 
- [Listing 6.14 Java skeleton for credit card charging](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter6/src/main/java/com/manning/spock/chapter6/mocks/CreditCardResult.java) 
- [Listing 6.14 Java skeleton for credit card charging](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter6/src/main/java/com/manning/spock/chapter6/mocks/CreditCardProcessor.java) 
- [Listing 6.14 Java skeleton for credit card charging](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter6/src/main/java/com/manning/spock/chapter6/mocks/BillableBasket.java) 
- [Listing 6.15 Verification of a mocked method](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter6/src/test/groovy/com/manning/spock/chapter6/mocks/SimpleMockingSpec.groovy) 
- [Listing 6.16 Verification of a specific order of mocked methods](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter6/src/test/groovy/com/manning/spock/chapter6/mocks/OrderMockingSpec.groovy) 
- [Listing 6.17 Explicit declaration of interactions](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter6/src/test/groovy/com/manning/spock/chapter6/mocks/CardinalityMockingSpec.groovy) 
- [Listing 6.18 Verifying interactions for all methods of a class](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter6/src/test/groovy/com/manning/spock/chapter6/mocks/CardinalityMockingSpec.groovy) 
- [Listing 6.19 Verifying non-interactions for all mocks](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter6/src/test/groovy/com/manning/spock/chapter6/mocks/CardinalityMockingSpec.groovy) 
- [Listing 6.20 Verifying that arguments were not null when a mocked method is called](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter6/src/test/groovy/com/manning/spock/chapter6/mocks/ArgumentTypeVerificationSpec.groovy) 
- [Listing 6.21 Verifying the type of arguments](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter6/src/test/groovy/com/manning/spock/chapter6/mocks/ArgumentTypeVerificationSpec.groovy) 
- [Listing 6.22 Verifying exact arguments of a mocked method](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter6/src/test/groovy/com/manning/spock/chapter6/mocks/ArgumentVerificationSpec.groovy) 
- [Listing 6.23 Verifying part of a object instance used as a mock argument](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter6/src/test/groovy/com/manning/spock/chapter6/mocks/ArgumentVerificationSpec.groovy) 
- [Listing 6.24 Using full Groovy closures for argument verification](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter6/src/test/groovy/com/manning/spock/chapter6/mocks/ArgumentVerificationSpec.groovy) 
- [Listing 6.25 Using Mocks and Stubs in the same test](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter6/src/test/groovy/com/manning/spock/chapter6/mocks/ComplexMockingSpec.groovy) 
- [Listing 6.26 Verifying a sequence of events with interconnected method calls](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter6/src/test/groovy/com/manning/spock/chapter6/mocks/ComplexMockingSpec.groovy) 
- [Solution to exercise](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter6/src/test/groovy/com/manning/spock/chapter6/mocks/ReaderExerciseSpec.groovy) 


### Chapter 7
- [Listing 7.1 Access Spring context from a Spock test](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter7/spring-standalone-swing/src/test/groovy/com/manning/spock/warehouse/product/RealDatabaseSpec.groovy) 
- [Listing 7.2 Rolling back database changes automatically](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter7/spring-standalone-swing/src/test/groovy/com/manning/spock/warehouse/product/RealDatabaseRollbackSpec.groovy) 
- [Listing 7.3 Using a reduced Spring context for unit testing](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter7/spring-standalone-swing/src/test/groovy/com/manning/spock/warehouse/product/DummyDatabaseSpec.groovy) 
- [Listing 7.4 Using Groovy SQL to prepare the DB in a Spock test](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter7/spring-standalone-swing/src/test/groovy/com/manning/spock/warehouse/product/DummyDatabaseGroovySqlWriteSpec.groovy) 
- [Listing 7.5 Using Groovy SQL to prepare the DB in a Spock test - improved](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter7/spring-standalone-swing/src/test/groovy/com/manning/spock/warehouse/product/DummyDatabaseGroovySqlWriteSpec.groovy)
- [Listing 7.6 Manual Spring context creation](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter7/spring-standalone-swing/src/test/groovy/com/manning/spock/warehouse/product/ManualInjectionSpec.groovy)
- [Listing 7.7 Testing REST services with Spock and Spring RestTemplate](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter7/rest-service-example/src/test/groovy/com/manning/spock/SpringRestSpec.groovy)
- [Listing 7.8 Running multiple test methods in order](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter7/rest-service-example/src/test/groovy/com/manning/spock/SpringRestSpec.groovy)
- [Listing 7.9 Using Groovy Rest Client in a Spock test](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter7/rest-service-example/src/test/groovy/com/manning/spock/GroovyRestClientSpec.groovy)
- [Listing 7.10 Using Geb and Spock together](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter7/web-ui-example/src/test/groovy/com/manning/spock/HomePageSpec.groovy)
- [Listing 7.11 Using Geb to access page content](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter7/web-ui-example/src/test/groovy/com/manning/spock/HomePageSpec.groovy)
- [Listing 7.12 Using Geb to submit HTML forms](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter7/web-ui-example/src/test/groovy/com/manning/spock/AddProductGebSpec.groovy)
- [Listing 7.13 Running Spock functional tests on a Tomcat instance](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter7/web-ui-example/pom.xml)
- [Listing 7.14 Using JaCoCo with Spock](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter7/spring-standalone-swing/pom.xml)

### Chapter 8
- [Listing 8.1 Expecting an exception in a Spock test](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter8/src/test/groovy/com/manning/spock/chapter8/extras/ExceptionControlSpec.groovy) 
- [Listing 8.2 Detailed examination of an expected exception](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter8/src/test/groovy/com/manning/spock/chapter8/extras/ExceptionControlSpec.groovy) 
- [Listing 8.3 Explicit declaration that an exception should not happen](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter8/src/test/groovy/com/manning/spock/chapter8/extras/ExceptionControlSpec.groovy) 
- [Listing 8.4 Marking a test method with the issue it solves](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter8/src/test/groovy/com/manning/spock/chapter8/extras/IssueDocumentationSpec.groovy) 
- [Listing 8.5 Using the URL of an issue solved by a Spock test](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter8/src/test/groovy/com/manning/spock/chapter8/extras/IssueDocumentationSpec.groovy) 
- [Listing 8.6 Marking a Spock test with multiple issues](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter8/src/test/groovy/com/manning/spock/chapter8/extras/IssueDocumentationSpec.groovy) 
- [Listing 8.7 Declaring a test timeout](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter8/src/test/groovy/com/manning/spock/chapter8/extras/TimeoutLimitSpec.groovy) 
- [Listing 8.8 Declaring a test timeout - custom unit](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter8/src/test/groovy/com/manning/spock/chapter8/extras/TimeoutLimitSpec.groovy) 
- [Listing 8.9 Ignoring a single test](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter8/src/test/groovy/com/manning/spock/chapter8/extras/SimpleIgnoreSpec.groovy) 
- [Listing 8.10 Ignoring all tests apart from one](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter8/src/test/groovy/com/manning/spock/chapter8/extras/KeepOneSpec.groovy) 
- [Listing 8.11 Skipping Spock tests according to the environment](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter8/src/test/groovy/com/manning/spock/chapter8/extras/SimpleConditionalSpec.groovy) 
- [Listing 8.12 Skipping a Spock test based on a dynamic precondition](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter8/src/test/groovy/com/manning/spock/chapter8/extras/SmartIgnoreSpec.groovy) 
- [Listing 8.13 Requires is the opposite of IgnoreIf](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter8/src/test/groovy/com/manning/spock/chapter8/extras/RunIfSpec.groovy) 
- [Listing 8.14 Release resources with AutoCleanup](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter8/src/test/groovy/com/manning/spock/chapter8/extras/AutoCloseSpec.groovy) 
- [Listing 8.15 A Spock test with very long setup - DO NOT DO THIS](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter8/src/test/groovy/com/manning/spock/chapter8/helper/HelperMethodsSpec.groovy) 
- [Listing 8.16 Spock test with helper methods](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter8/src/test/groovy/com/manning/spock/chapter8/helper/HelperMethodsSpec.groovy) 
- [Listing 8.17 Using arguments that imply their importance in the test](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter8/src/test/groovy/com/manning/spock/chapter8/helper/HelperMethodsSpec.groovy) 
- [Listing 8.18 Spock test with dubious then: block](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter8/src/test/groovy/com/manning/spock/chapter8/helper/HelperMethodsAssertSpec.groovy) 
- [Listing 8.19 Improved Spock test with clear separation of checks](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter8/src/test/groovy/com/manning/spock/chapter8/helper/HelperMethodsAssertSpec.groovy) 
- [Listing 8.20 Using helper methods for assertions](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter8/src/test/groovy/com/manning/spock/chapter8/helper/HelperMethodsAssertSpec.groovy) 
- [Listing 8.21 Spock tests with questionable then: block](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter8/src/test/groovy/com/manning/spock/chapter8/helper/HelperMethodsInteractSpec.groovy) 
- [Listing 8.22 Helper methods with interactions need to be declared explicitly](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter8/src/test/groovy/com/manning/spock/chapter8/helper/HelperMethodsInteractSpec.groovy) 
- [Listing 8.23 Java code with questionable design](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter8/src/main/java/com/manning/spock/chapter8/nuker/CameraFeed.java) 
- [Listing 8.23 Java code with questionable design](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter8/src/main/java/com/manning/spock/chapter8/nuker/HardDriveNuker.java) 
- [Listing 8.23 Java code with questionable design](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter8/src/main/java/com/manning/spock/chapter8/nuker/SmartHardDriveNuker.java) 
- [Listing 8.24 Creating a spy with Spock](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter8/src/test/groovy/com/manning/spock/chapter8/spies/SimpleSpySpec.groovy) 
- [Listing 8.25 Refactoring Java code to avoid spies](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter8/src/main/java/com/manning/spock/chapter8/nuker2/SmartHardDriveNuker.java) 
- [Listing 8.26 Using a mock instead of a spy](https://github.com/kkapelon/java-testing-with-spock/blob/master/chapter8/src/test/groovy/com/manning/spock/chapter8/spies/NoSpySpec.groovy) 


## Issues with the code.

If you find a problem with the code feel free to open an [issue](https://github.com/kkapelon/java-testing-with-spock/issues). If you feel
like contributing you can even create a pull request!

## Issues with the book
If you have comments and suggestions for the book please use the [Manning forum](https://forums.manning.com/forums/java-testing-with-spock).
I monitor it regularly and it is helpful if other readers can see and respond to your comments.

Enjoy!



