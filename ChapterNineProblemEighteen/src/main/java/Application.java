package main.java;

import main.java.calculator.AveragePricePerMonthCalculator;
import main.java.calculator.AveragePricePerYearCalculator;
import main.java.mapper.DataFileMapper;
import main.java.model.DatePricePair;
import main.java.model.MonthAveragePrice;
import main.java.model.YearAveragePrice;
import main.java.printer.AveragePriceByMonthConsolePrinter;
import main.java.printer.AveragePriceByYearConsolePrinter;

import java.io.IOException;
import java.util.List;

public class Application {

	public void run() throws IOException {
		String dataFilePath = "ChapterNineProblemEighteen/src/main/resources/gas-prices.dat";
		List<DatePricePair> allDatePricePairs = DataFileMapper.mapFileToDataPairs(dataFilePath);

		List<YearAveragePrice> averagePricesByYear = AveragePricePerYearCalculator.calculate(allDatePricePairs);
		List<MonthAveragePrice> averagePricesByMonth = AveragePricePerMonthCalculator.calculate(allDatePricePairs);

		AveragePriceByYearConsolePrinter.printTable(averagePricesByYear);
		AveragePriceByMonthConsolePrinter.printTable(averagePricesByMonth);
	}
}
