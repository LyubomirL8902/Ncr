package com.LL.springApp.beans;

import java.util.ArrayList;

 class CommonMethods {
	CommonMethods(){}
    protected   static ArrayList<Integer> prepareStringData(StringBuilder concatenatedNumbers) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		long sum1 =0;
		for(String s1:concatenatedNumbers.toString().split(",")) {
			
			
			Integer val;
			try{
					val = Integer.parseInt(s1);
					numbers.add(val);

				} catch(NumberFormatException  ex) {
					continue;
				}

		}
		return numbers;
	}

}
