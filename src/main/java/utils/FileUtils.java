package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import constants.FileConstants;

public class FileUtils {
	
	
	public static String readPropertiesFile(String path, String key) throws IOException {
		File f = new File(path);
		FileReader fr = new FileReader(f);
		Properties p = new Properties();
		p.load(fr);
		return p.getProperty(key);
	}
	
	public static String readUserMenuTestData(String sKey) throws IOException {
		String sValue = "";
		FileInputStream fis = new FileInputStream(new File(FileConstants.USER_MENU_TEST_DATA_FILE_PATH));
		Properties p = new Properties();
		p.load(fis);
		sValue = p.getProperty(sKey);
		return sValue;
	}

}
