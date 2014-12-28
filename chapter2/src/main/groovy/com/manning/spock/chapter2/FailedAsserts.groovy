package com.manning.spock.chapter2

//Uncommend each assert statent one by one to see how Groovy handles asserts

//assert (4 * 15) - (24 / 3) == ( 2 * 30 ) - 9

//String quote = "Please scan Abbut. Report to me his thoughts at present"
//assert quote =="Please scan Abut. Report to me his thoughts at present"

List<String> all = ["Vorlon", "Shadows", "Minbari", "Humans", "Drazi"]
List<String> firstOnes = ["Vorlon", "Shadows"]

//assert all.subList(0, all.indexOf("Humans")) == firstOnes

String text = "They are alone. They are a dying race."
WordDetector wordDetector = new WordDetector()


//assert wordDetector.feedText(text).duplicatesFound().size() == 5

