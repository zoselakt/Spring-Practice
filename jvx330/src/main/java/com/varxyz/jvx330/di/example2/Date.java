package com.varxyz.jvx330.di.example2;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Date {
	private int year;
	private int month;
	private int day;
	
	@Override
	public String toString() {
		return year + "-" + month + "-" + day;
	}
	
	@Override
	public int hashCode() {
		return (day ^ month ^ year);
	}
}
