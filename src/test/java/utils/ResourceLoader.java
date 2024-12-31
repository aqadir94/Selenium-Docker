package utils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResourceLoader {

	private static final Logger log=LoggerFactory.getLogger(ResourceLoader.class);
	

	
	public static InputStream getResource(String path) throws IOException {
		
		log.info("Reading resource from path {}",path);
		//InputStream stream=ResourceLoader.class.getResourceAsStream(path); - this didn't work
		InputStream stream = ResourceLoader.class.getClassLoader().getResourceAsStream(path);//Attempts to load the resource from the classpath using getResourceAsStream
		if(Objects.nonNull(stream)) {
			
			return stream;
		}
		
		return Files.newInputStream(Path.of(path)); //If the resource is not found in the classpath (stream is null), it tries to load the file directly from the file system.
		
	}

}
