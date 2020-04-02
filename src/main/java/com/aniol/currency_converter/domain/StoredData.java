package com.aniol.currency_converter.domain;
import javax.persistence.*;

@Entity
public class StoredData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	

	private String toChanges;
	

	private String afterChange;
	

	private double howMany;
	

	private  double score;
	
	public StoredData() {
	}
	
	public StoredData(String toChanges, String afterChange, double howMany, double score) {
		this.toChanges = toChanges;
		this.afterChange = afterChange;
		this.howMany = howMany;
		this.score = score;
	}
	
	public Long getId() {
		return Id;
	}
	
	public void setId(Long id) {
		Id = id;
	}
	
	public String getToChanges() {
		return toChanges;
	}
	
	public void setToChanges(String toChanges) {
		this.toChanges = toChanges;
	}
	
	public String getAfterChange() {
		return afterChange;
	}
	
	public void setAfterChange(String afterChange) {
		this.afterChange = afterChange;
	}
	
	public double getHowMany() {
		return howMany;
	}
	
	public void setHowMany(double howMany) {
		this.howMany = howMany;
	}
	
	public double getScore() {
		return score;
	}
	
	public void setScore(double score) {
		this.score = score;
	}
}
