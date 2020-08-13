package main.java;

import java.time.LocalDate;

public class DatePricePair {
	private final double price;
	private final LocalDate date;

	public DatePricePair(LocalDate date, double price) {
		this.date = date;
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public LocalDate getDate() {
		return date;
	}
}
