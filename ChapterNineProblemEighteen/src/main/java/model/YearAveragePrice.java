package main.java.model;

public class YearAveragePrice {
	private final Double average;
	private final int year;

	public YearAveragePrice(int year, Double average) {
		this.year = year;
		this.average = average;
	}

	public Double getAverage() {
		return average;
	}

	public int getYear() {
		return year;
	}
}
