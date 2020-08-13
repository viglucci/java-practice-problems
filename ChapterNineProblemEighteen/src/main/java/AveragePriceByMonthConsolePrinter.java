package main.java;

import java.text.DecimalFormat;
import java.util.List;

public class AveragePriceByMonthConsolePrinter {
	private static DecimalFormat twoPlacesValueFormatter = new DecimalFormat("#,##0.00");

	public static void printTable(List<MonthAveragePrice> averagePrices) {
		System.out.println("\nAverage prices by month:\n");
		printDivider();
		printHeader();
		printDivider();
		averagePrices.forEach(AveragePriceByMonthConsolePrinter::printRow);
	}

	public static void printHeader () {
		String header = String.format("%14s %10s %20s", "Month", "|", "Average($)");
		System.out.println(header);
	}

	public static void printDivider() {
		String divider = String.format("%s", "---------------------------------------------------------");
		System.out.println(divider);
	}

	public static void printRow(MonthAveragePrice data) {
		String formattedMonth = String.format("%02d", data.getMonth());
		String formattedValue = twoPlacesValueFormatter.format(data.getAverage());
		String header = String.format("%12s %12s %17s", formattedMonth, "|", formattedValue);
		System.out.println(header);
	}
}
