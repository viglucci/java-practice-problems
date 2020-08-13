package main.java.printer;

import main.java.model.YearSynopsis;

import java.text.DecimalFormat;
import java.util.List;

public class YearlySynopsisConsolePrinter {

	private static DecimalFormat twoPlacesDecimalFormatter = new DecimalFormat("#,##0.00");

	public static void printTable(List<YearSynopsis> yearSynopses) {
		System.out.println("\nSynopsis by year:\n");
		printDivider();
		printHeader();
		printDivider();
		yearSynopses.forEach(YearlySynopsisConsolePrinter::printRow);
	}

	public static void printHeader () {
		String header = String.format("%14s %10s %20s %10s %17s %10s %16s", "Year", "|", "Average($)", "|", "Low($)", "|", "High($)");
		System.out.println(header);
	}

	public static void printDivider() {
		String divider = String.format("%s", "------------------------------------------------------------------------------------------------------------------");
		System.out.println(divider);
	}

	public static void printRow(YearSynopsis data) {
		String formattedAverage = twoPlacesDecimalFormatter.format(data.getAverage());
		String formattedLow = twoPlacesDecimalFormatter.format(data.getLow());
		String formattedHigh = twoPlacesDecimalFormatter.format(data.getHigh());
		String header = String.format(
				"%14d %10s %17s %13s %16s %11s %15s",
				data.getYear(), "|",
				formattedAverage, "|",
				formattedLow, "|",
				formattedHigh);
		System.out.println(header);
	}
}
