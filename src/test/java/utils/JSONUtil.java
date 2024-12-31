package utils;

import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.VendorPortalTestData;

public class JSONUtil {

	private static final Logger log = LoggerFactory.getLogger(JSONUtil.class);
	private static ObjectMapper mapper=new ObjectMapper();

	public static <T>T getTestData(String path,Class<T> type) {

		try (InputStream stream = ResourceLoader.getResource(path)) {

			return mapper.readValue(stream,type );
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Unable to find file {}", path);
		}
		return null;
	}

}
