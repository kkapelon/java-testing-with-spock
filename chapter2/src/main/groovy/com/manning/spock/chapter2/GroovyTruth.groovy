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

//Regular expression shortcut with the =~ operator
assert "needle in haystack" =~/needle/
assert !("Wrong haystack" =~/needle/)

//All closures are assumed to be "true"
def closure = { number -> number+2 }
assert closure

println "Script has finished because all asserts pass"

/*
 * Fun with Groovy truth 
 * 
 * This is valid Groovy code: boolean flag = -45. 
 * Even though this line does not even compile in Java, 
 * in Groovy the number -45 is a non-zero number and therefore 
 * the variable flag is now true. Isn't that fun?
 */
boolean flag = -42
assert flag




