package util;

public class Util {

	public static String getStringWithSize(int size){
		StringBuilder stringBuilder = new StringBuilder();
		for(int i = 0 ; i < size ; i++){
			stringBuilder.append("a");
		}
		return stringBuilder.toString();
	}
	
}
