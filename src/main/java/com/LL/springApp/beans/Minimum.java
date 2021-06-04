package com.LL.springApp.beans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import com.LL.springApp.bussiness.AggrTemplate;
import com.LL.springApp.model.Data;
import com.LL.springApp.repository.DataRepository;

public class Minimum implements AggrTemplate {


	
	public double performAggr(DataRepository drp,String operation,String id) {

		StringBuilder concatenatedNumbers = new StringBuilder();
		ArrayList<Data> dataEntries = new ArrayList<Data>();
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		long rowID;
		try {
			 rowID = Long.parseLong(id);			
		} catch(NumberFormatException  ex) {
			rowID = 0;
		}

		if(rowID == 0) {

			drp.findAll().forEach(dataEntries::add);
			if(dataEntries.isEmpty()) {
				return 0.0;
			}
			
			for(Data d:dataEntries) {
				concatenatedNumbers.append(d.getInsertionD() + ",");
			}
			
			numbers = CommonMethods.prepareStringData(concatenatedNumbers);

			
		}else {

			Optional<Data> data1 = drp.findById(rowID);
			if(data1.isPresent()) {
				concatenatedNumbers.append(data1.get().getInsertionD()) ;

			}else{
				return 0.0;
			}
			numbers = CommonMethods.prepareStringData(concatenatedNumbers);
		}
		if(numbers.size() == 0) {
			return 0.0;
		}
		return (double) Collections.min(numbers);
	}
	
}