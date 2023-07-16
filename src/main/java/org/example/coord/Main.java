package org.example.coord;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.List;


public class Main {


    public static void main(String[] args) {

        ExcelReader table = new ExcelReader();
        DecimalFormat dF = new DecimalFormat( "#.###################" );

        List<Double> exmes = table.readXCoordinate();
        List<Double> Y = table.readYCoordinate();
        List<Double> Z = table.readZCoordinate();
        Double maxX = Collections.max(exmes);
        Double maxY = Collections.max(Y);
        Double maxZ = Collections.max(Z);
        String maxXformatted = dF.format(maxX);
        String maxYformatted = dF.format(maxY);
        String maxZformatted = dF.format(maxZ);
        JOptionPane.showMessageDialog(null,
                "<html><h1>X maximum = " + maxXformatted + "<br>" + "Y maximum = " + maxYformatted + "<br>" + "Z maximum = " + maxZformatted + "<html><h1>",
                "XYZ result",
                JOptionPane.INFORMATION_MESSAGE);
    }

}


