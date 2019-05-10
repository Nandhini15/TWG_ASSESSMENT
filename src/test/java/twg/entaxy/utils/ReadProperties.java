package twg.entaxy.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadProperties {
	Properties prop;

	public ReadProperties(String filePath)
	{
		try
		{
		prop = new Properties();
		FileInputStream fis = new FileInputStream(filePath);
		prop.load(fis);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public String getPropertyValue(String key)
	{
		String property = prop.getProperty(key);
		return property;
	}
}
