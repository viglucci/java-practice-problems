package main.java;

import java.text.DecimalFormat;
import java.util.List;

public class AveragePriceByYearConsolePrinter {

	private static DecimalFormat twoPlacesDecimalFormatter = new DecimalFormat("#,##0.00");

	public static void printTable(List<YearAveragePrice> averagePrices) {
		System.out.println("\nAverage prices by year:\n");
		printDivider();
		printHeader();
		printDivider();
		averagePrices.forEach(AveragePriceByYearConsolePrinter::printRow);
	}

	public static void printHeader () {
		String header = String.format("%14s %10s %20s", "Year", "|", "Average($)");
		System.out.println(header);
	}

	public static void printDivider() {
		String divider = String.format("%s", "---------------------------------------------------------");
		System.out.println(divider);
	}

	public static void printRow(YearAveragePrice data) {
		String formattedValue = twoPlacesDecimalFormatter.format(data.getAverage());
		String header = String.format("%14d %10s %17s", data.getYear(), "|", formattedValue);
		System.out.println(header);
	}
}
