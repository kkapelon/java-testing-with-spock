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

You can checkout/run any chapter on its own. For each chapter entering the command
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

###Chapter 3

## Issues with the code.

If you find a problem with the code feel free to open an [issue](https://github.com/kkapelon/java-testing-with-spock/issues). If you feel
like contributing you can even create a pull request!

## Issues with the book
If you have comments and suggestions for the book please use the [Manning forum](https://forums.manning.com/forums/java-testing-with-spock).
I monitor it regularly and it is helpful if other readers can see and respond your comments.

Enjoy!



