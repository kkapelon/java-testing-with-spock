package com.manning.spock.chapter5.custom;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InvalidNamesGen implements Iterator<String>{

	private List<String> invalidNames;
	private int counter =0;

	public InvalidNamesGen() {
		invalidNames = new ArrayList<>();
		parse();
	}

	private void parse() {
		try {

			BufferedReader br = new BufferedReader(new FileReader(
					"src/test/resources/invalidImageNames.txt"));

			String line = null;
			while ((line = br.readLine()) != null) {
				if(line.isEmpty() || line.startsWith("#"))
				{
					continue;
				}
				invalidNames.add(line.trim());
			}

			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean hasNext() {
		return counter< invalidNames.size();
	}

	@Override
	public String next() {
		String result = invalidNames.get(counter);
		counter++;
		return result;
	}

	@Override
	public void remove() {
		// not needed for this test
		
	}
}
