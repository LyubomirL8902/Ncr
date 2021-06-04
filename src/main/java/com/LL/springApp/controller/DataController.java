package com.LL.springApp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.LL.springApp.beans.Average;
import com.LL.springApp.beans.Maximum;
import com.LL.springApp.beans.Minimum;
import com.LL.springApp.beans.Sum;
import com.LL.springApp.model.*;
import com.LL.springApp.repository.*;



@RestController
@RequestMapping("/api")
public class DataController {

		@Autowired
		DataRepository dataRepository;
		
		@Autowired
		private Sum sumService;
		
		@Autowired
		private Average avgService;
		
		@Autowired
		private Minimum minService;
		
		@Autowired
		private Maximum maxService;
		
		@PostMapping("/dataR")
		public long createEntity(@RequestBody Data data) {
			try {

					System.out.println("Id to be inserted " + data.getID());
					System.out.println("Date to be inserted " + data.getInsertionD());					
				  dataRepository.save(new Data(data.getInsertionD()));
				return dataRepository.getInsertedId();
			} catch (Exception e) {
				System.err.println("ERRORO in data repository controller");
				System.out.println(e.getMessage());
				return 0L;
			}
			
		}
		
		@GetMapping("/operations")
		public double OperationResult(@RequestBody AggregationC aggrC) {
			double result = 0.0;
			switch(aggrC.getOpData()) {
				case "SUM":
					result = sumService.performAggr(dataRepository, aggrC.getOpData(), aggrC.getID());
					break;
				case "AVG":
					System.out.println("In AVG service");
					result = avgService.performAggr(dataRepository, aggrC.getOpData(), aggrC.getID());
					break;
				case "MIN":
					result = minService.performAggr(dataRepository, aggrC.getOpData(), aggrC.getID());
					break;
				case "MAX":
					result = maxService.performAggr(dataRepository, aggrC.getOpData(), aggrC.getID());
					break;
				default:
					result = 0.0;
			}
			return result;
		}

}
