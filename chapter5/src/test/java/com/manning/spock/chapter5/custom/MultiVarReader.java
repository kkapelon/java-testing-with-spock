package com.manning.spock.chapter5.custom;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MultiVarReader implements Iterator<Object[]>{

	private List<String> fileNames;
	private List<Boolean> validFlag;
	private int counter =0;

	public MultiVarReader() {
		fileNames = new ArrayList<>();
		validFlag = new ArrayList<>();
		parse();
	}

	private void parse() {
		try {

			BufferedReader br = new BufferedReader(new FileReader(
					"src/test/resources/imageNames.txt"));

			String line = null;
			while ((line = br.readLine()) != null) {
				if(line.isEmpty() || line.startsWith("#"))
				{
					continue;
				}
				String[] tokens= line.trim().split(" ");
				fileNames.add(tokens[0]);
				validFlag.add(tokens[1].toLowerCase().startsWith("pass"));
			}

			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean hasNext() {
		return counter< fileNames.size();
	}

	@Override
	public Object[] next() {
		Object[] result = new Object[2];
		result[0] = fileNames.get(counter);
		result[1] = validFlag.get(counter);
		counter++;
		return result;
	}

	@Override
	public void remove() {
		// not needed for this test
		
	}
}
