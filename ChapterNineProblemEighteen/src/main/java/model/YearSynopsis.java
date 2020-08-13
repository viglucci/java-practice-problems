package main.java.model;

public class YearSynopsis {
	private final Double average;
	private final int year;
	private final Double low;
	private final Double high;

	public YearSynopsis(int year, Double average, Double low, Double high) {
		this.year = year;
		this.average = average;
		this.low = low;
		this.high = high;
	}

	public Double getAverage() {
		return average;
	}

	public int getYear() {
		return year;
	}

	public Double getLow() {
		return low;
	}

	public Double getHigh() {
		return high;
	}
}
