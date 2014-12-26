package com.manning.spock.chapter2

//This script should run without errors because all asserts evaluate to true



String stringComingFromDb = "Susan"
assert stringComingFromDb

stringComingFromDb = "true"
assert stringComingFromDb.toBoolean()

stringComingFromDb = "1"
assert stringComingFromDb.toBoolean()

stringComingFromDb = "0"
assert !stringComingFromDb.toBoolean()

stringComingFromDb = "someThingElse"
assert !stringComingFromDb.toBoolean()

