package com.manning.spock.chapter2

import java.util.regex.Pattern
//This script should run without errors because all asserts evaluate to true


assert true
assert !false

assert true || false 
assert true && !false

String firstName = "Susan"
assert firstName

def lastName = "Ivanova"
assert lastName

String empty = ""
assert !empty 

Person person = new Person()
assert person;

Person nullReference = null
assert !nullReference;

int answerToEverything = 42
assert answerToEverything

int zero=0
assert !zero

Object[] array= new Object[3];
assert array 

Object[] emptyArray= new Object[0];
assert !emptyArray 

Pattern myRegex = ~/needle/
assert myRegex.matcher("needle in haystack")
assert !myRegex.matcher("Wrong haystack")

def closure = { number -> number+2 }
assert closure

println "Script has finished because all asserts pass"

boolean flag = -42
assert flag




