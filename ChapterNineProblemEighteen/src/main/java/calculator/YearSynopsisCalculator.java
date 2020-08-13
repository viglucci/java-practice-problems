package main.java.calculator;

import main.java.model.DatePricePair;
import main.java.model.YearSynopsis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class YearSynopsisCalculator {
	public static List<YearSynopsis> calculate(List<DatePricePair> pairs) {
		List<YearSynopsis> synopsis = new ArrayList<>();
		Map<Integer, List<Double>> pricesByYear = new HashMap<>();

		pairs.forEach((pair) -> {
			int year = pair.getDate().getYear();
			double price = pair.getPrice();
			List<Double> pricesForYear = pricesByYear.getOrDefault(year, new ArrayList<>());
			pricesForYear.add(price);
			pricesByYear.put(year, pricesForYear);
		});

		for (Map.Entry<Integer, List<Double>> entry : pricesByYear.entrySet()) {
			int year = entry.getKey();
			List<Double> prices = entry.getValue();
			int numberOfPrices = prices.size();
			Double accumulator = 0.0;
			Double low = null;
			Double high = 0.0;
			for (Double price : prices) {
				accumulator += price;
				if (low == null) {
					low = price;
				}
				if (price > high) {
					high = price;
				} else if (price < low) {
					low = price;
				}
			}
			Double average = accumulator / numberOfPrices;
			synopsis.add(new YearSynopsis(year, average, low, high));
		}

		return synopsis;
	}
}