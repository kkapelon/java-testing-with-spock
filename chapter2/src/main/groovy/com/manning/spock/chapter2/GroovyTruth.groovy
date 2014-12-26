package com.manning.spock.chapter2

//This script should run without errors because all asserts evaluate to true


assert true
assert !false

assert true || false 
assert true && !false

String firstName = "Susan"
assert firstName

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

def closure = { number -> number+2 }
assert closure

println "Script has finished because all asserts pass"

boolean flag = -42
assert flag




