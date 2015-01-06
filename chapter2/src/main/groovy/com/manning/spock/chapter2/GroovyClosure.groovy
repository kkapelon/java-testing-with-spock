package com.manning.spock.chapter2

import groovy.json.JsonSlurper

Closure simple = { int x -> return x * 2}
assert simple(3) == 6

def simpler = { x -> x * 2}
assert simpler(3) == 6

def twoArguments = { x,y -> x + y}
assert twoArguments(3,5) ==8

