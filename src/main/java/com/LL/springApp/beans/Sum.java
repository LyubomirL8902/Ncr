package com.LL.springApp.beans;
import java.util.ArrayList;
import java.util.Optional;

import com.LL.springApp.bussiness.AggrTemplate;
import com.LL.springApp.repository.DataRepository;
import com.LL.springApp.model.Data;

public class Sum implements AggrTemplate {


	
	public double performAggr(DataRepository drp,String operation,String id) {

		StringBuilder concatenatedNumbers = new StringBuilder();
		double sum = 0;
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
				return 0L;
			}
			
			for(Data d:dataEntries) {
				concatenatedNumbers.append(d.getInsertionD() + ",");
				System.out.println(concatenatedNumbers);
			}
			
			numbers = CommonMethods.prepareStringData(concatenatedNumbers);

			
		}else {

			Optional<Data> data1 = drp.findById(rowID);
			if(data1.isPresent()) {
				concatenatedNumbers.append(data1.get().getInsertionD()) ;

			}
			numbers = CommonMethods.prepareStringData(concatenatedNumbers);
		}
		
		for(Integer i:numbers) {
			sum += i;
		}

		return sum;
	}
	

}
