package entelgyPracticasBack.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import entelgyPracticasBack.controller.WeatherRestController;
import entelgyPracticasBack.model.WeatherSelect;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


public class WeatherExcelWriter {

	private static String[] columns = { "Country", "City", "Observation Time", "Temperature", "Wind Speed(km/h)",
			"Wind Direction", "Precipitation", "Humidity", "Local Time" };

	private static final Logger logger = LogManager.getLogger(WeatherExcelWriter.class);

	/**
	 * Method that creates an excel workbook with the list received.
	 * @param weatherList. List of instances of the weather conditions in bilbao.
	 * @return ByteArrayInputStream containing the data for the creation of the xlsx.
	 * @throws IOException
	 * @throws InvalidFormatException
	 */
	public static ByteArrayInputStream createWeatherExcel(List<WeatherSelect> weatherList)
			throws IOException, InvalidFormatException {
		logger.info("Creating Excel.");

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		// Create a Workbook
		Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

		// Create a Sheet
		Sheet sheet = workbook.createSheet("Weather Bilbao");

		// Create a Font for styling header cells
		Font headerFont = workbook.createFont();
		headerFont.setBold(true);
		headerFont.setFontHeightInPoints((short) 14);

		// Create a CellStyle with the font
		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);

		// Create a Row
		Row headerRow = sheet.createRow(0);

		// Create cells
		for (int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
			cell.setCellStyle(headerCellStyle);
		}

		// Create Other rows and cells with employees data
		int rowNum = 1;
		for (WeatherSelect weather : weatherList) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(weather.getCountry());
			row.createCell(1).setCellValue(weather.getName());
			row.createCell(2).setCellValue(weather.getObservation_time());
			row.createCell(3).setCellValue(weather.getTemperature());
			row.createCell(4).setCellValue(weather.getWind_speed());
			row.createCell(5).setCellValue(weather.getWind_dir());
			row.createCell(6).setCellValue(weather.getPrecip());
			row.createCell(7).setCellValue(weather.getHumidity());
			row.createCell(8).setCellValue(weather.getLocaltimeC());
		}

		// Resize all columns to fit the content size
		for (int i = 0; i < columns.length; i++) {
			sheet.autoSizeColumn(i);
		}

		workbook.write(out);
		logger.info("Excel created.");
		return new ByteArrayInputStream(out.toByteArray());
	}

	/**
	 * Method that creates an excel workbook with the list received and saves the file.
	 * @param weatherList. List of instances of the weather conditions in bilbao.
	 * @throws IOException
	 * @throws InvalidFormatException
	 */
	public static void createWeatherFileExcel(List<WeatherSelect> weatherList) throws IOException, InvalidFormatException {
		logger.info("Creating Excel.");

		// Create a Workbook
		Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

		// Create a Sheet
		Sheet sheet = workbook.createSheet("Weather Bilbao");

		// Create a Font for styling header cells
		Font headerFont = workbook.createFont();
		headerFont.setBold(true);
		headerFont.setFontHeightInPoints((short) 14);

		// Create a CellStyle with the font
		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);

		// Create a Row
		Row headerRow = sheet.createRow(0);

		// Create cells
		for (int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
			cell.setCellStyle(headerCellStyle);
		}

		// Create Other rows and cells with employees data
		int rowNum = 1;
		for (WeatherSelect weather : weatherList) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(weather.getCountry());
			row.createCell(1).setCellValue(weather.getName());
			row.createCell(2).setCellValue(weather.getObservation_time());
			row.createCell(3).setCellValue(weather.getTemperature());
			row.createCell(4).setCellValue(weather.getWind_speed());
			row.createCell(5).setCellValue(weather.getWind_dir());
			row.createCell(6).setCellValue(weather.getPrecip());
			row.createCell(7).setCellValue(weather.getHumidity());
			row.createCell(8).setCellValue(weather.getLocaltimeC());
		}

		// Resize all columns to fit the content size
		for (int i = 0; i < columns.length; i++) {
			sheet.autoSizeColumn(i);
		}
		// Write the output to a file
		FileOutputStream fileOut = new FileOutputStream("weather_bilbao.xlsx");
		workbook.write(fileOut);
		fileOut.close();
		
		// Closing the workbook
		workbook.close();
		logger.info("Excel created.");

	}
}
