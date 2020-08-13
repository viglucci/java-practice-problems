package main.java;

import java.io.IOException;
import java.util.List;

public class Application {

	private final String dataFilePath = "ChapterNineProblemEighteen/src/main/resources/gas-prices.dat";

	public void run() throws IOException {
		List<DatePricePair> allDatePricePairs = DataFileMapper.mapFileToDataPairs(this.dataFilePath);

		List<YearAveragePrice> averagePricesByYear = AveragePricePerYearCalculator.calculate(allDatePricePairs);
		List<MonthAveragePrice> averagePricesByMonth = AveragePricePerMonthCalculator.calculate(allDatePricePairs);

		AveragePriceByYearConsolePrinter.printTable(averagePricesByYear);
		AveragePriceByMonthConsolePrinter.printTable(averagePricesByMonth);
	}
}
