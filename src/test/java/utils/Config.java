package utils;

import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Config {

	private static final Logger log = LoggerFactory.getLogger(Config.class);
	private static final String DEFAULT_PROPERTIES = "config/default.properties";
	private static Properties properties;

	public static void initialize() {

		properties = loadProperties();

		for (String key : properties.stringPropertyNames()) {

			if (System.getProperties().containsKey(key)) {

				properties.setProperty(key, System.getProperty(key));
			}

		}
		
		log.info("---------------------");

		log.info("Test properties");

		for (String key : properties.stringPropertyNames()) {

			log.info("{}={}", key, properties.get(key));

		}
		
		log.info("---------------------");

	}

	public static String get(String property) {

		return properties.getProperty(property);
	}

	public static Properties loadProperties() {

		Properties properties = new Properties();

		try (InputStream stream = ResourceLoader.getResource(DEFAULT_PROPERTIES)) {

			properties.load(stream);
		} catch (Exception e) {
			log.error("Unable to read the property file {}", DEFAULT_PROPERTIES, e);
		}

		return properties;
	}
}
