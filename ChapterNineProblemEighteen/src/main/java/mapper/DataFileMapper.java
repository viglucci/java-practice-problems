package main.java.mapper;

import main.java.model.DatePricePair;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DataFileMapper {
	public static List<DatePricePair> mapFileToDataPairs(String dataFilePath) throws IOException {
		List<DatePricePair> allDatePricePairs = new ArrayList<>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");

		Path filePath = Paths.get(dataFilePath);
		Files.lines(filePath).forEachOrdered((line) -> {
			String[] content = line.split(":");
			LocalDate date = LocalDate.parse(content[0], formatter);
			double price = Double.parseDouble(content[1]);
			DatePricePair dataPair = new DatePricePair(date, price);
			allDatePricePairs.add(dataPair);
		});

		return allDatePricePairs;
	}
}
