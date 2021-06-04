package com.LL.springApp.model;

public class AggregationC {
	private String id;
	private String opData;
	
	public AggregationC() {};
	
	public AggregationC(String id, String opData) {
		this.id = id;
		this.opData = opData;
	}
	
	public String getID() {
		return this.id;
	}
	
	public String getOpData() {
		return this.opData;
	}
	

}
