package com.manning.spock.chapter2

import java.util.ArrayList;
import java.util.List;

String first = "first";
String second = "Second";

List<String> sample = new ArrayList<>();
sample.add(first);
sample.add(second);

List<String> sample2 = new ArrayList<>(sample);

System.out.println("We have "+ (sample == sample2));
