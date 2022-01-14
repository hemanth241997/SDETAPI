package com.genericUtils;

import java.util.Date;
import java.util.Random;
/**
 * This method will generate a random Number within 1000 range
 * @author Chan
 *
 */
public class JavaUtility {
	
	public int randomNumber()
	{
		Random random = new Random();
		int randomNumber = random.nextInt(1000);
		return randomNumber;
	}
/**
 * This method will return System time and Date
 * @return
 */
	
	public String getSystemDateAndTime()
	{
		Date date = new Date();
		String systemDateAndTime = date.toString();
		return systemDateAndTime;
	}

}
