package com.anshu.basic.validation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
	static Boolean msg;
	public static Boolean checkNameLength(String name)
	{
		if(name.length()<15)
		{
			msg = true;
		}
		else
		{
			msg = false;
		}
		return msg;
	}

public static Boolean validateString(String name)
	{
		Boolean result=null;
		char arr[] = name.toCharArray();
		for(int i=0;i<arr.length;i++)
		{
			if((arr[i]>=65 && arr[i]<=90)|(arr[i]>=97 && arr[i]<=122)|arr[i]==' ')
			{
				result = true;
			}
			else{
				result=false;
				break;
			}
		}
		return result;
	}
@SuppressWarnings("deprecation")
public static Boolean checkDate(String targetDate,Date currentDate)
{
	SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
				
	
	Date newDate = new Date(formatter.format(currentDate));
	Date tDate = new Date(formatter.format(new Date(targetDate)));
		
	if(tDate.after(newDate)==false)
		return true;
	else	
		return false;
}
public static boolean checkEmail(String email)
{
	String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
            			"[a-zA-Z0-9_+&*-]+)*@" +
            			"(?:[a-zA-Z0-9-]+\\.)+[a-z" +
            			"A-Z]{2,7}$";                          
    Pattern pat = Pattern.compile(emailRegex);
    if (email == null)
        return false;
    return pat.matcher(email).matches();


}
public  static Boolean checkGender(String gender)
{
	  String regex = "Male|male|Female|female|Other";
      Pattern p = Pattern.compile(regex);
      Matcher m = p.matcher(gender);
      Boolean result=true;
      if(m.matches()) {
         result= true;
      }
      else {
    	  result=false;
      }
	return result;
      
}      
public static boolean checkMobileNumber(String s)
{

    Pattern p = Pattern.compile(
        "^(\\+\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{3,4}[- .]?\\d{4}$");

    
    Matcher m = p.matcher(s);

    return (m.matches());
}

}
