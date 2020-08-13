package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AveragePricePerYearCalculator {
	static List<YearAveragePrice> calculate(List<DatePricePair> pairs) {
		List<YearAveragePrice> averagePrices = new ArrayList<>();
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
			for (Double price : prices) {
				accumulator += price;
			}
			Double average = accumulator / numberOfPrices;
			averagePrices.add(new YearAveragePrice(year, average));
		}

		return averagePrices;
	}
}