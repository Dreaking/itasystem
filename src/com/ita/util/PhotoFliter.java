package com.ita.util;

public class PhotoFliter {
	public static boolean isPhoto(String fileName){
		if(fileName.trim().toLowerCase().endsWith(".jpg"))
			return true;
		else if(fileName.trim().toLowerCase().endsWith(".bmp"))
			return true;
		else
			return false;
	}
}
