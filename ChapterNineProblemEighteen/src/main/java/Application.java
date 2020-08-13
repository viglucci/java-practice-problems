package main.java;

import main.java.calculator.AveragePricePerMonthCalculator;
import main.java.calculator.YearSynopsisCalculator;
import main.java.mapper.DataFileMapper;
import main.java.model.DatePricePair;
import main.java.model.MonthAveragePrice;
import main.java.model.YearSynopsis;
import main.java.printer.AveragePriceByMonthConsolePrinter;
import main.java.printer.YearlySynopsisConsolePrinter;

import java.io.IOException;
import java.util.List;

public class Application {

	public void run() throws IOException {
		String dataFilePath = "ChapterNineProblemEighteen/src/main/resources/gas-prices.dat";
		List<DatePricePair> allDatePricePairs = DataFileMapper.mapFileToDataPairs(dataFilePath);

		List<YearSynopsis> yearlySynopsisByYear = YearSynopsisCalculator.calculate(allDatePricePairs);
		List<MonthAveragePrice> averagePricesByMonth = AveragePricePerMonthCalculator.calculate(allDatePricePairs);

		YearlySynopsisConsolePrinter.printTable(yearlySynopsisByYear);
		AveragePriceByMonthConsolePrinter.printTable(averagePricesByMonth);
	}
}
