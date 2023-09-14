package com.nissan.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.InvalidNameException;

import org.springframework.stereotype.Component;

@Component
public class Validation {

	// name validation
	public boolean isNameValid(String name) {
		boolean bool = false;
		try {
			Pattern namePattern = Pattern.compile("[^A-Za-z]");
			Matcher nameMatcher = namePattern.matcher(name);
			if (nameMatcher.find()) {
				throw new InvalidNameException("Hey! Invalid Name");
			} else if (name.length() > 30)
				throw new InvalidNameException("Hey! name should be within 30 characters");
			else {
				bool = true;
			}
		} catch (InvalidNameException e) {
			e.getMessage();
		}
		return bool;

	}

	// name validation
	public boolean isNumberValid(long mobileNumber) {
			boolean bool = false;
			String number=Long.toString(mobileNumber);
			Pattern numberPattern = Pattern.compile("[^0-9]");
			Matcher numberMatcher = numberPattern.matcher(number);
			try {
			if(numberMatcher.find()) {
				throw new Exception("Hey! Invalid Number");
			}
			else if(number.length()!=10) { 
				throw new Exception("Hey! mobile Numeber should be 10 characters");
			}
			else{
				bool = true;
			}
			}
			catch(Exception e)
			{
				e.getMessage();
			}
			return bool;
			
		}
}
