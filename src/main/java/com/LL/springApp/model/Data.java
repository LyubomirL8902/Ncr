package com.LL.springApp.model;

import javax.persistence.*;


@Entity
@Table(name="data")
public class Data {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator= "data_generator")
	@SequenceGenerator(name = "data_generator",initialValue=1, allocationSize=1,sequenceName="seq_data")
	private Long id;
	
	@Column(name= "data_string" )
	private String insertionD;
	
	
	public Data() {
		
	}
	
	public Data(String dataStr) {
		this.insertionD = dataStr;

	}
	
	
	public Long getID() {
		return this.id;
	}
	public String getInsertionD() {
		return this.insertionD;
	}
	
	public void setData(String dataStr) {
		this.insertionD = dataStr;
	}
	
	
	

}
