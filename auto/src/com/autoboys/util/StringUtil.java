package com.autoboys.util;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class StringUtil {
	 public StringUtil() {
	  }
	  public static boolean validateMobilePhone(String str) {
		  Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");  
		  Matcher m = p.matcher(str);  
		  return m.matches(); 
	    }
	  public static boolean validateNickName(String str) {
		  //昵称只能是数字、字母、下划线或中文
		  Pattern p = Pattern.compile("^[a-zA-Z0-9_\u4e00-\u9fa5]+$");  
		  Matcher m = p.matcher(str);  
		  return m.matches(); 
	    }
	  
	  public static String fiterSQLParam(String str) {
		  return str.replace("'", "''");
	  }

}
