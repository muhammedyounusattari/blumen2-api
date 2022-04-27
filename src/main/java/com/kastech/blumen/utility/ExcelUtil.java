package com.kastech.blumen.utility;

import com.kastech.blumen.model.admin.home.PullType;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.IntStream;

public class ExcelUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExcelUtil.class);
    private static final String YES ="Yes";
    private static final String NO = "No";

    public Sheet getSheet(String headerName) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet(headerName);
        return sheet;
    }

    public void createHeaders(Sheet sheet, List<String> headerNames) {

        CellStyle headerStyle = sheet.getWorkbook().createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        Row headerRow = sheet.createRow(0);
        IntStream.range(0, headerNames.size()).forEach(index -> {
            Cell headerCell = headerRow.createCell(index);
            headerCell.setCellValue(headerNames.get(index));
            headerCell.setCellStyle(headerStyle);
        });
    }

    public void generatePullTypeExcelReport(Sheet sheet, List<PullType> pullTypes) {
        CellStyle style = sheet.getWorkbook().createCellStyle();
        //style.setWrapText(true);
        if (!CollectionUtils.isEmpty(pullTypes)) {
            IntStream.range(0, pullTypes.size()).forEach(index -> {
                Row row = sheet.createRow(index + 1);
                int columnNumber = 0;
                PullType pullType = pullTypes.get(index);
                createCell(row, columnNumber, style, pullType.getPullDesc());
                createCell(row, ++columnNumber, style, pullType.getPullType());
                createCell(row, ++columnNumber, style, pullType.getNumeric());
                createCell(row, ++columnNumber, style, pullType.getApr() ? YES : NO);
                createCell(row, ++columnNumber, style, pullType.getNoEdit());
                createCell(row, ++columnNumber, style, pullType.getDataFields());
                createCell(row, ++columnNumber, style, pullType.getSerType());
                createCell(row, ++columnNumber, style, pullType.getProjType());
                createCell(row, ++columnNumber, style, pullType.getSortOrder());
                createCell(row, ++columnNumber, style, pullType.getQuickEditDesc());
                createCell(row, ++columnNumber, style, pullType.getPrimary());
            });



        }

    }

    public ByteArrayOutputStream getByteArrayOutputStream(Sheet sheet){
        ByteArrayOutputStream  bos = new ByteArrayOutputStream();
        try {
            sheet.getWorkbook().write(bos);
            sheet.getWorkbook().close();
        } catch (IOException e) {
            LOGGER.error(e.toString(), e);
        }

        return bos;

    }
    private void createCell(Row row, int index, CellStyle style, String value) {
        Cell pullDescCell = row.createCell(index);
        pullDescCell.setCellValue(value);
        pullDescCell.setCellStyle(style);
    }

    private void createCell(Row row, int index, CellStyle style, Boolean value) {
        Cell pullDescCell = row.createCell(index);
        pullDescCell.setCellValue(value);
        pullDescCell.setCellStyle(style);
    }

    private void createCell(Row row, int index, CellStyle style, Long value) {
        Cell pullDescCell = row.createCell(index);
        pullDescCell.setCellValue(value);
        pullDescCell.setCellStyle(style);
    }
}



