package com.accessibility;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApplicationProperties {

	Properties properties;

	public ApplicationProperties(String fileName) throws IOException {
		this.properties = readFile(fileName);
	}

	public Properties readFile(String fileName) throws IOException {
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
		if (inputStream != null) {
			Properties properties = new Properties();
			properties.load(inputStream);
			inputStream.close();
			return properties;
		} else {
			throw new FileNotFoundException("property file '" + fileName + "' not found in the classpath");
		}
	}

	public String getProperty(String property) {
		return this.properties.getProperty(property);
	}

}