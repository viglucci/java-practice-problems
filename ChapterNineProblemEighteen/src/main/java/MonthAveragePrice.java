package main.java;

public class MonthAveragePrice {
	private final Double average;
	private final int month;

	public MonthAveragePrice(int month, Double average) {
		this.month = month;
		this.average = average;
	}

	public Double getAverage() {
		return average;
	}

	public int getMonth() {
		return month;
	}
}

