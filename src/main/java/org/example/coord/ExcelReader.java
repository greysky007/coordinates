package org.example.coord;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.net.URISyntaxException;
import java.security.CodeSource;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {

    private final int X = 1;
    private final int Y = 3;
    private final int Z = 7;

    public String reader() throws URISyntaxException {
        CodeSource codeSource = Main.class.getProtectionDomain().getCodeSource();
        File jarFile = new File(codeSource.getLocation().toURI().getPath());
        String jarDir = jarFile.getParentFile().getPath();
        return jarDir;
    }

    FileInputStream file;

    {
        try {
            file = new FileInputStream(new File(reader() + "./XY Plot 1.xlsx"));
        } catch (FileNotFoundException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public Sheet readTargetSheet() {
        {
            try {
                file = new FileInputStream(new File(reader() + "./XY Plot 1.xlsx"));
            } catch (FileNotFoundException | URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }

        XSSFWorkbook workbook = null;


        try {
            workbook = new XSSFWorkbook(file);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        int number = workbook.getSheetIndex("Plot Data");
        Sheet target = workbook.getSheetAt(number);
        return target;
    }

    public List<Double> readXCoordinate() {

        List<Double> values = new ArrayList<Double>();

        for (Row r : readTargetSheet()) {
            Cell c = r.getCell(X);
            if (c != null) {
                if (c.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                    values.add(c.getNumericCellValue());
                }
            }
        }


        return values;
    }

    public List<Double> readYCoordinate() {

        List<Double> values = new ArrayList<Double>();

        for (Row r : readTargetSheet()) {
            Cell c = r.getCell(Y);
            if (c != null) {
                if (c.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                    values.add(c.getNumericCellValue());
                }
            }
        }


        return values;
    }

    public List<Double> readZCoordinate() {

        List<Double> values = new ArrayList<Double>();

        for (Row r : readTargetSheet()) {
            Cell c = r.getCell(Z);
            if (c != null) {
                if (c.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                    values.add(c.getNumericCellValue());
                }
            }
        }


        return values;
    }



    /*public void getMaxBEH (){
        XSSFWorkbook workbook = null;
        try {
            workbook = new XSSFWorkbook(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Sheet target =  workbook.getSheetAt(4);
        List<Double> values = new ArrayList<Double>();

        for(Row r : target) {
            Cell c = r.getCell(3);
            if(c != null) {
                if(c.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                    values.add(c.getNumericCellValue());
                } else if(c.getCellType() == Cell.CELL_TYPE_FORMULA && c.getCachedFormulaResultType() == Cell.CELL_TYPE_NUMERIC) {
                    values.add(c.getNumericCellValue());
                }
            }
        }
        System.out.println(values);
    }*/

}

