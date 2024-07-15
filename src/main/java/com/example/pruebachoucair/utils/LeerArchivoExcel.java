package com.example.pruebachoucair.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class LeerArchivoExcel {

	private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#");
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	public LeerArchivoExcel() {
		// TODO Auto-generated constructor stub
	}
	public String getCellValue(String filePath, String sheetName, int rowNumber, int cellNumber) throws IOException {
		try (FileInputStream fileInputStream = new FileInputStream(filePath);
			 Workbook workbook = new XSSFWorkbook(fileInputStream)) {

			Sheet sheet = workbook.getSheet(sheetName);
			Row row = sheet.getRow(rowNumber);
			Cell cell = row.getCell(cellNumber);

			return getCellValueAsString(cell);
		}
	}

	private String getCellValueAsString(Cell cell) {
		if (cell == null) {
			return "";
		}
		switch (cell.getCellType()) {
			case STRING:
				return cell.getStringCellValue();

			case NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
					return DATE_FORMAT.format(cell.getDateCellValue());
				} else {
					return DECIMAL_FORMAT.format(cell.getNumericCellValue());
				}
			case BOOLEAN:
				return String.valueOf(cell.getBooleanCellValue());
			case FORMULA:
				if (cell.getCachedFormulaResultType() == CellType.STRING) {
					return cell.getRichStringCellValue().getString();
				} else if (cell.getCachedFormulaResultType() == CellType.NUMERIC) {
					return String.valueOf(cell.getNumericCellValue());
				} else if (cell.getCachedFormulaResultType() == CellType.BOOLEAN) {
					return String.valueOf(cell.getBooleanCellValue());
				} else {
					// If the formula result type is not supported, return an empty string
					return "";
				}
			default:
				return "";
		}
	}
}
