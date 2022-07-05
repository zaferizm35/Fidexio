package com.fidexio.pages;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadExcel {
    public static void main(String[] args) throws IOException {

            String path="sample.xlsx";
           //File file = new File(path);
            FileInputStream in = new FileInputStream(path);
            XSSFWorkbook workbook = new XSSFWorkbook(in);
            XSSFSheet sheet= workbook.getSheet("data");
            System.out.println(sheet.getRow(1).getCell(1).toString());


    }

}
