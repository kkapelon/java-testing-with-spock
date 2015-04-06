package com.manning.spock.chapter5.intro;

import java.util.Locale;

public class ImageNameValidator {

	public boolean isValidImageExtension(String fileName)
	{
		String lowerCase = fileName.toLowerCase(Locale.ENGLISH);
		return lowerCase.endsWith(".jpeg") || lowerCase.endsWith(".jpg") || lowerCase.endsWith(".png");
	}
	
}
