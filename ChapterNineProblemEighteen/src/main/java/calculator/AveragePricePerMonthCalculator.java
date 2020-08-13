package main.java.calculator;

import main.java.model.DatePricePair;
import main.java.model.MonthAveragePrice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AveragePricePerMonthCalculator {
	public static List<MonthAveragePrice> calculate(List<DatePricePair> pairs) {
		List<MonthAveragePrice> averagePrices = new ArrayList<>();
		Map<Integer, List<Double>> pricesByMonth = new HashMap<>();

		pairs.forEach((pair) -> {
			int month = pair.getDate().getMonth().getValue();
			double price = pair.getPrice();
			List<Double> pricesForMonth = pricesByMonth.getOrDefault(month, new ArrayList<>());
			pricesForMonth.add(price);
			pricesByMonth.put(month, pricesForMonth);
		});

		for (Map.Entry<Integer, List<Double>> entry : pricesByMonth.entrySet()) {
			int month = entry.getKey();
			List<Double> prices = entry.getValue();
			int numberOfPrices = prices.size();
			Double accumulator = 0.0;
			for (Double price : prices) {
				accumulator += price;
			}
			Double average = accumulator / numberOfPrices;
			averagePrices.add(new MonthAveragePrice(month, average));
		}

		return averagePrices;
	}
}
