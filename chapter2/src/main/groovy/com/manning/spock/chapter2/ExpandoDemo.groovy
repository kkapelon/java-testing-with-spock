package com.manning.spock.chapter2

Expando smartIterator = new Expando()
smartIterator.counter = 0;
smartIterator.limit = 4;
smartIterator.hasNext = { return counter < limit}
smartIterator.next = {return counter++}
smartIterator.restartFrom = {from->counter = from}

for(Integer number:smartIterator as Iterator<Integer>)
{
	println "Next number is $number"
}

println "Reset smart iterator"
smartIterator.restartFrom(2)

for(Integer number:smartIterator as Iterator<Integer>)
{
	println "Next number is $number"
}