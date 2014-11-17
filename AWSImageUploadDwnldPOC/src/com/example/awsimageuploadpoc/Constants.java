package com.example.awsimageuploadpoc;

import java.util.Locale;

public class Constants {
	public static final String ACCESS_KEY_ID = "";
	public static final String SECRET_KEY = "";
	
	public static final String PICTURE_BUCKET = "eventimagebucket";
	public static final String PICTURE_NAME = "iqbal";
	
	
	public static String getPictureBucket() {
		return ("my-unique-name" + ACCESS_KEY_ID + PICTURE_BUCKET).toLowerCase(Locale.US);
	}
	
}
